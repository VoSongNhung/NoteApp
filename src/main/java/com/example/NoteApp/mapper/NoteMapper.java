package com.example.NoteApp.mapper;

import com.example.NoteApp.dto.NoteResponse;
import com.example.NoteApp.dto.NoteRequest;
import com.example.NoteApp.model.Note;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NoteMapper {
    NoteMapper MAPPER = Mappers.getMapper(NoteMapper.class);
    Note noteRequestToNote(NoteRequest noteRequest);
    NoteResponse noteToNoteResponse(Note note);
    List<NoteResponse> listNoteToNoteResponse(List<Note> notes);
}
