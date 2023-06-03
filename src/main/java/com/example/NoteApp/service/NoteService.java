package com.example.NoteApp.service;

import com.example.NoteApp.dto.NoteRequest;
import com.example.NoteApp.dto.NoteResponse;
import com.example.NoteApp.model.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    List<NoteResponse> getAllNote();
    Optional<NoteResponse> getNote(String id);
    NoteResponse addNote(NoteRequest noteRequest);
    NoteResponse updateNote(String id,NoteRequest noteRequest);
    boolean deleteNote(String id);
}
