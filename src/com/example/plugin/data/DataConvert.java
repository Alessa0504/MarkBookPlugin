package com.example.plugin.data;

public class DataConvert {
    public static String[] convert(NoteData noteData) {
        String[] raw = new String[4];
        raw[0] = noteData.getTitle();
        raw[1] = noteData.getMark();
        raw[2] = noteData.getFileName();
        raw[3] = noteData.getCodeContent();
        return raw;
    }
}
