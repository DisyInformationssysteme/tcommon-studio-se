// ============================================================================
//
// Copyright (C) 2006-2022 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.commons.ui.runtime.custom;

import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.talend.commons.exception.ExceptionHandler;

/**
 * DOC cmeng  class global comment. Detailled comment
 */
public class MessageDialogCustomUI extends AbstractCustomUI<IMessageDialogResult> implements IMessageDialogResult {

    private static final String UI_KEY = "MessageDialog";

    private int dialogType = MessageDialog.NONE;

    private String title;

    private String message;

    private Object openResult;

    public MessageDialogCustomUI(int dialogType, String title, String message) {
        super(UI_KEY, true);
        this.dialogType = dialogType;
        this.title = title;
        this.message = message;
    }

    @Override
    protected IUIEvent createOpenEvent() {
        IUIEvent openEvent = super.createOpenEvent();
        Map<String, Object> params = openEvent.getParams();
        params.put(BuiltinParams.title.name(), this.title);
        params.put(BuiltinParams.message.name(), this.message);
        params.put("dialogType", dialogType);
        return openEvent;
    }

    @Override
    protected IMessageDialogResult collectDialogData() {
        DefaultUIData uiData = createUIDataEvent("openResult");
        try {
            openResult = requestUIData(uiData).get();
        } catch (Exception e) {
            ExceptionHandler.process(e);
        }
        return this;
    }

    @Override
    public IMessageDialogResult getModel() {
        return this;
    }

    @Override
    public Object getOpenResult() {
        return openResult;
    }

}
