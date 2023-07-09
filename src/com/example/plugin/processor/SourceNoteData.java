package com.example.plugin.processor;

import com.example.plugin.data.NoteData;

import java.util.List;

public interface SourceNoteData {
     String getFileFullName();
     String getTopic();
     List<NoteData> getNoteList();
}
