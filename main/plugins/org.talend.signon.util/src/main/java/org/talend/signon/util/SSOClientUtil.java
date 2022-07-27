// ============================================================================
//
// Copyright (C) 2006-2021 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.signon.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.talend.signon.util.listener.LoginEventListener;

public class SSOClientUtil {

    private static Logger LOGGER = Logger.getLogger(SSOClientUtil.class);

    private static final String STUDIO_CLIENT_ID = "0c51933d-c542-4918-9baf-86ef709af5d8";

    private static final String CLIENT_FILE_PATH_PROPERTY = "talend.studio.signon.client.path";

    private static final String CLIENT_FILE_NAME_ON_WINDOWS = "Talend_Sign_On_Tool_win-x86_64.exe";

    private static final String CLIENT_FILE_NAME_ON_LINUX_X86 = "Talend_Sign_On_Tool_linux_gtk_x86_64";

    private static final String CLIENT_FILE_NAME_ON_LINUX_AARCH64 = "Talend_Sign_On_Tool_linux_gtk_aarch64";

    private static final String CLIENT_FILE_NAME_ON_MAC_X86 = "Talend_Sign_On_Tool.app";

    private static final String CLIENT_FILE_NAME_ON_MAC_AARCH64 = "Talend_Sign_On_Tool_aarch64.app";

    private static final String CLIENT_FOLDER_NAME = "studio_sso_client";

    private static final String DATA_CENTER_KEY = "talend.tmc.datacenter";

    private static final SSOClientUtil instance = new SSOClientUtil();

    private SSOClientExec signOnClientExec;

    private SSOClientUtil() {
        if (SSOClientInstaller.getInstance().isNeedInstall()) {
            try {
                SSOClientInstaller.getInstance().install();
            } catch (Exception e) {
                LOGGER.error(e);
            }
        }
    }

    public String getClientID() throws IOException {
        return STUDIO_CLIENT_ID;
    }

    public File getSSOClientAppFile() throws Exception {
        if (System.getProperty(CLIENT_FILE_PATH_PROPERTY) != null) {
            return new File(System.getProperty(CLIENT_FILE_PATH_PROPERTY));
        }
        File folder = getSSOClientFolder();
        if (EnvironmentUtils.isWindowsSystem()) {
            return new File(folder, CLIENT_FILE_NAME_ON_WINDOWS);
        } else if (EnvironmentUtils.isLinuxUnixSystem()) {
            if (EnvironmentUtils.isX86_64()) {
                return new File(folder, CLIENT_FILE_NAME_ON_LINUX_X86);
            } else if (EnvironmentUtils.isAarch64()) {
                return new File(folder, CLIENT_FILE_NAME_ON_LINUX_AARCH64);
            }
        } else if (EnvironmentUtils.isMacOsSytem()) {
            File appFolder = null;
            if (EnvironmentUtils.isX86_64()) {
                appFolder = new File(folder, CLIENT_FILE_NAME_ON_MAC_X86);
            } else if (EnvironmentUtils.isAarch64()) {
                appFolder = new File(folder, CLIENT_FILE_NAME_ON_MAC_AARCH64);
            }
            if (appFolder != null) {
                return new File(appFolder, "Contents/MacOS/Talend_Sign_On_Tool");
            }
        }
        throw new Exception("Unsupported OS");
    }

    public static File getSSOClientFolder() {
        File configFolder = getConfigurationFolder();
        File signClientFolder = new File(configFolder, CLIENT_FOLDER_NAME);
        return signClientFolder;
    }

    private synchronized void startSignOnClient(LoginEventListener listener) throws Exception {
        if (signOnClientExec != null) {
            signOnClientExec.stop();
        }
        String clientId = getClientID();
        File execFile = getSSOClientAppFile();
        String codeChallenge = listener.getCodeChallenge();
        LOGGER.info("Prepare to start sso client monitor");
        SSOClientMonitor signOnClientListener = SSOClientMonitor.getInscance();
        signOnClientListener.addLoginEventListener(listener);
        new Thread(signOnClientListener).start();
        LOGGER.info("Login sso monitor started.");
        while (!SSOClientMonitor.isRunning()) {
            TimeUnit.MILLISECONDS.sleep(100);
        }
        if (signOnClientListener.getListenPort() < 0) {
            throw new Exception("Login sso monitor start failed.");
        }
        LOGGER.info("Prepare to start sso client on " + signOnClientListener.getListenPort());
        signOnClientExec = new SSOClientExec(execFile, clientId, codeChallenge, signOnClientListener.getListenPort());
        new Thread(signOnClientExec).start();
        LOGGER.info("Login sso started.");
    }

    public static SSOClientUtil getInstance() {
        return instance;
    }

    public void signOnCloud(LoginEventListener listener) throws Exception {
        SSOClientUtil.getInstance().startSignOnClient(listener);
    }

    public String getSignOnURL(String clientID, String codeChallenge, String state) {
        StringBuffer urlSB = new StringBuffer();
        urlSB.append(getBaseLoginURL(null)).append("?");
        urlSB.append("client_id=").append(clientID).append("&");
        urlSB.append("code_challenge=").append(codeChallenge).append("&");
        urlSB.append("state=").append(state);
        return urlSB.toString();
    }

    public static File getConfigurationFolder() {
        BundleContext configuratorBundleContext = getCurrentBundleContext();
        final URL url = EquinoxUtils.getConfigLocation(configuratorBundleContext).getURL();
        try {
            return URIUtil.toFile(URIUtil.toURI(url));
        } catch (URISyntaxException e) {
            //
        }
        return null;
    }

    // always return a valid bundlesContext or throw a runtimeException
    public static BundleContext getCurrentBundleContext() {
        Bundle bundle = FrameworkUtil.getBundle(SSOClientUtil.class);
        if (bundle != null) {
            BundleContext bundleContext = bundle.getBundleContext();
            if (bundleContext != null) {
                return bundleContext;
            } else {
                throw new RuntimeException(
                        "could not find current BundleContext, this should never happen, check that the bunlde is activated when this class is accessed");
            }
        } else {
            throw new RuntimeException(
                    "could not find current Bundle, this should never happen, check that the bunlde is activated when this class is accessed");
        }
    }

    public static String getDefaultDataCenter() {
        String defaultDataCenter = "int";
        if (System.getProperty(DATA_CENTER_KEY) != null) {
            defaultDataCenter = System.getProperty(DATA_CENTER_KEY);
        }
        return defaultDataCenter;
    }

    public static String getBaseLoginURL(String dataCenter) {
        if (dataCenter == null) {
            dataCenter = getDefaultDataCenter();
        }
        return "https://iam." + dataCenter + ".cloud.talend.com/oidc/idp/authorize";
    }

    public static String getCloudAdminURL(String dataCenter) {
        return "https://tmc." + dataCenter + ".cloud.talend.com/studio_cloud_connection";
    }
}
