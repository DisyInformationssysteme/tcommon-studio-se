// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006 Talend - www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package org.talend.core.prefs.ui;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.talend.commons.ui.swt.colorstyledtext.ColorManager;
import org.talend.commons.ui.swt.colorstyledtext.prefs.BooleanColorFieldEditor;
import org.talend.core.CorePlugin;
import org.talend.core.i18n.Messages;

/**
 * Preference for the colors of the code view.
 * 
 * $Id$
 * 
 */
public class ColorsCodeViewerPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    public ColorsCodeViewerPreferencePage() {
        super(FieldEditorPreferencePage.GRID);
        setPreferenceStore(CorePlugin.getDefault().getPreferenceStore());
    }

    protected void createFieldEditors() {
        Composite p = getFieldEditorParent();
        String b = Messages.getString("ColorsCodeViewerPreferencePage.fieldTip"); //$NON-NLS-1$
        addField(new BooleanColorFieldEditor(ColorManager.NULL_COLOR, Messages.getString("ColorsCodeViewerPreferencePage.defaultColor"), ColorManager.NULL_COLOR //$NON-NLS-1$
                + ColorManager.BOLD_SUFFIX, b, p));
        addField(new BooleanColorFieldEditor(ColorManager.KEYWORD1_COLOR, Messages.getString("ColorsCodeViewerPreferencePage.keyword1Color"), ColorManager.KEYWORD1_COLOR //$NON-NLS-1$
                + ColorManager.BOLD_SUFFIX, b, p));
        addField(new BooleanColorFieldEditor(ColorManager.KEYWORD2_COLOR, Messages.getString("ColorsCodeViewerPreferencePage.keyword2Color"), ColorManager.KEYWORD2_COLOR //$NON-NLS-1$
                + ColorManager.BOLD_SUFFIX, b, p));
        addField(new BooleanColorFieldEditor(ColorManager.KEYWORD3_COLOR, Messages.getString("ColorsCodeViewerPreferencePage.keyword3Color"), ColorManager.KEYWORD3_COLOR //$NON-NLS-1$
                + ColorManager.BOLD_SUFFIX, b, p));
        addField(new BooleanColorFieldEditor(ColorManager.COMMENT1_COLOR, Messages.getString("ColorsCodeViewerPreferencePage.Comment1Color"), ColorManager.COMMENT1_COLOR //$NON-NLS-1$
                + ColorManager.BOLD_SUFFIX, b, p));
        addField(new BooleanColorFieldEditor(ColorManager.COMMENT2_COLOR, Messages.getString("ColorsCodeViewerPreferencePage.Comment2Color"), ColorManager.COMMENT2_COLOR //$NON-NLS-1$
                + ColorManager.BOLD_SUFFIX, b, p));
        addField(new BooleanColorFieldEditor(ColorManager.LITERAL1_COLOR, Messages.getString("ColorsCodeViewerPreferencePage.Literal1Color"), ColorManager.LITERAL1_COLOR //$NON-NLS-1$
                + ColorManager.BOLD_SUFFIX, b, p));
        addField(new BooleanColorFieldEditor(ColorManager.LITERAL2_COLOR, Messages.getString("ColorsCodeViewerPreferencePage.Literal2Color"), ColorManager.LITERAL2_COLOR //$NON-NLS-1$
                + ColorManager.BOLD_SUFFIX, b, p));
        addField(new BooleanColorFieldEditor(ColorManager.LABEL_COLOR, Messages.getString("ColorsCodeViewerPreferencePage.LabelColor"), ColorManager.LABEL_COLOR //$NON-NLS-1$
                + ColorManager.BOLD_SUFFIX, b, p));
        addField(new BooleanColorFieldEditor(ColorManager.FUNCTION_COLOR, Messages.getString("ColorsCodeViewerPreferencePage.FunctionColor"), ColorManager.FUNCTION_COLOR //$NON-NLS-1$
                + ColorManager.BOLD_SUFFIX, b, p));
        addField(new BooleanColorFieldEditor(ColorManager.MARKUP_COLOR, Messages.getString("ColorsCodeViewerPreferencePage.MarkupColor"), ColorManager.MARKUP_COLOR //$NON-NLS-1$
                + ColorManager.BOLD_SUFFIX, b, p));
        addField(new BooleanColorFieldEditor(ColorManager.OPERATOR_COLOR, Messages.getString("ColorsCodeViewerPreferencePage.OperatorColor"), ColorManager.OPERATOR_COLOR //$NON-NLS-1$
                + ColorManager.BOLD_SUFFIX, b, p));
        addField(new BooleanColorFieldEditor(ColorManager.DIGIT_COLOR, Messages.getString("ColorsCodeViewerPreferencePage.DigitColor"), ColorManager.DIGIT_COLOR //$NON-NLS-1$
                + ColorManager.BOLD_SUFFIX, b, p));
        addField(new BooleanColorFieldEditor(ColorManager.INVALID_COLOR, Messages.getString("ColorsCodeViewerPreferencePage.InvalidColor"), ColorManager.INVALID_COLOR //$NON-NLS-1$
                + ColorManager.BOLD_SUFFIX, b, p));
    }

    public void init(IWorkbench workbench) {
    }

}
