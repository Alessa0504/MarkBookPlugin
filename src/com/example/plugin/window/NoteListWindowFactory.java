package com.example.plugin.window;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class NoteListWindowFactory implements ToolWindowFactory  {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        //创建出NoteListWindow对象
        NoteListWindow noteListWindow = new NoteListWindow(project, toolWindow);
        //获取内容工厂的实例
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        //获取用于toolWindow显示的内容 -noteListWindow.getContentPanel()是panel根布局
        Content content = contentFactory.createContent(noteListWindow.getContentPanel(), "", false);
        //通过内容管理器给toolWindow添加内容
        toolWindow.getContentManager().addContent(content);
    }
}
