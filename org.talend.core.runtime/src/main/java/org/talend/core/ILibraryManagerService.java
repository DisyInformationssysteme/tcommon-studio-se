// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.core;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.talend.core.model.components.IComponent;
import org.talend.core.model.general.ModuleNeeded;

/**
 * DOC ycbai class global comment. Detailled comment
 */
public interface ILibraryManagerService extends IService {

    /**
     * DOC ycbai Comment method "isInitialized".
     * 
     * Check whether the OBR has been initialized.
     * 
     * @param monitorWrap
     * @return
     */
    public boolean isInitialized();

    public void setInitialized();

    public void deploy(Set<IComponent> componentList, IProgressMonitor... monitorWrap);

    public void deploy(List<ModuleNeeded> modules, IProgressMonitor... monitorWrap);

    /**
     * DOC ycbai Comment method "deploy".
     * 
     * Deploy jar file to OBR.
     * 
     * @param jarFileUri
     * @param monitorWrap
     */
    public void deploy(URI jarFileUri, IProgressMonitor... monitorWrap);

    public void deploy(Collection<URI> jarFileUris, IProgressMonitor... monitorWrap);

    /**
     * DOC ycbai Comment method "retrieve".
     * 
     * Retrieve jar file from OBR.
     * 
     * @param jarNeeded
     * @param pathToStore
     * @param monitorWrap
     * @return
     */
    public boolean retrieve(String jarNeeded, String pathToStore, IProgressMonitor... monitorWrap);

    public boolean retrieve(Collection<String> jarsNeeded, String pathToStore, IProgressMonitor... monitorWrap);

    public boolean retrieve(Collection<String> jarsNeeded, String pathToStore, boolean showDialog,
            IProgressMonitor... monitorWrap);

    /**
     * List all the jars (or other files) available.
     * 
     * @param monitorWrap
     * @return
     */
    public Set<String> list(IProgressMonitor... monitorWrap);

    /**
     * 
     * List all .dll files
     * 
     * @return
     */
    public Set<String> listAllDllFiles();

    public boolean delete(String jarName);

    public boolean contains(String jarName);

    public void clearCache();
}
