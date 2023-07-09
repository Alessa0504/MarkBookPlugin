package com.example.plugin.data;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.List;

public class DataCenter {
    public static String SELECT_TEXT;
    public static String FILE_NAME;
    public static List<NoteData> NOTE_LIST = new LinkedList<>();

    public static String[] HEADERS = {"Title", "Mark", "FileName", "Code"};  //表头
    public static DefaultTableModel TABLE_MODEL = new DefaultTableModel(null, HEADERS);

    public static void reset() {
        NOTE_LIST.clear();
        TABLE_MODEL.setDataVector(null, HEADERS);
    }
}
