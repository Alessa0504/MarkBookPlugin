package com.example.plugin.dialog;

import com.example.plugin.data.DataCenter;
import com.example.plugin.data.DataConvert;
import com.example.plugin.data.NoteData;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class AddNoteDialog extends DialogWrapper {
    private EditorTextField tfTitle;
    private EditorTextField tfContent;

    public AddNoteDialog() {
        super(true);
        setTitle("Add Note");
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        //创建对话框面板
        JPanel panel = new JPanel(new BorderLayout());  //JPanel添加边界布局 BorderLayout-划分区域东南西北中
        tfTitle = new EditorTextField("Note title");
        tfContent = new EditorTextField("Note content");
        tfContent.setPreferredSize(new Dimension(200, 100));  //设置内容区域大小
        panel.add(tfTitle, BorderLayout.NORTH);  //标题放在上方(北边)
        panel.add(tfContent, BorderLayout.CENTER);   //内容放在中间
        return panel;
    }

    /**
     * 对话框下边(南边)按钮
     * @return
     */
    @Override
    protected JComponent createSouthPanel() {
        JPanel panel = new JPanel();
        JButton button = new JButton("Add note to list");
        button.addActionListener(e -> {
            String title = tfTitle.getText();
            String contentMark = tfContent.getText();
            System.out.println("title ="+title + "content ="+contentMark);
            String fileType = DataCenter.FILE_NAME.substring(DataCenter.FILE_NAME.lastIndexOf(".") + 1);
            NoteData noteData = new NoteData(title, contentMark, DataCenter.SELECT_TEXT, DataCenter.FILE_NAME, fileType);
            DataCenter.NOTE_LIST.add(noteData);
            //将数据添加至tableModel，添加一行
            DataCenter.TABLE_MODEL.addRow(DataConvert.convert(noteData));
            System.out.println("noteList ="+DataCenter.NOTE_LIST);
        });
        panel.add(button);
        return panel;
    }
}
