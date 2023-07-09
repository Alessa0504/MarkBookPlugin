package com.example.plugin.action;

import com.example.plugin.data.DataCenter;
import com.example.plugin.dialog.AddNoteDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

public class PopupAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);  //获取编辑器对象
        SelectionModel selectionModel = editor.getSelectionModel();
        String selectedText = selectionModel.getSelectedText();  //获取选择的文本
        System.out.println("添加笔记的操作: " + selectedText);
        DataCenter.SELECT_TEXT = selectedText;
        //获取文件名：在哪个文件中选择文本
        String fileName = e.getRequiredData(CommonDataKeys.PSI_FILE).getViewProvider().getVirtualFile().getName();
        DataCenter.FILE_NAME = fileName;

        //PopupAction点击之后弹出dialog
        AddNoteDialog dialog = new AddNoteDialog();
        dialog.show();
    }
}
