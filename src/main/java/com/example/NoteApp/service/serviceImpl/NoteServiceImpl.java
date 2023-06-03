package com.example.NoteApp.service.serviceImpl;

import com.example.NoteApp.dto.NoteRequest;
import com.example.NoteApp.dto.NoteResponse;
import com.example.NoteApp.mapper.NoteMapper;
import com.example.NoteApp.model.Note;
import com.example.NoteApp.repository.NoteRepo;
import com.example.NoteApp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteRepo noteRepository;

    @Override
    public List<NoteResponse> getAllNote() {
        return NoteMapper.MAPPER.listNoteToNoteResponse(noteRepository.findAll());
    }

    ///Lỏ ở đây
    @Override
    public Optional<NoteResponse> getNote(String id) {
        Optional<Note> noteOptional = noteRepository.findById(id);
        Note note = noteOptional.orElse(null); // hoặc noteOptional.orElseThrow()
        return Optional.ofNullable(NoteMapper.MAPPER.noteToNoteResponse(note));
    }

    @Override
    public NoteResponse addNote(NoteRequest noteRequest) {
        Note note = NoteMapper.MAPPER.noteRequestToNote(noteRequest);
        note.setDate(LocalDate.now());
        return NoteMapper.MAPPER.noteToNoteResponse(noteRepository.save(note));
    }

    @Override
    public NoteResponse updateNote(String id, NoteRequest noteRequest) {
        Note note = noteRepository.findById(id).orElse(null);
        Note noteupdate = NoteMapper.MAPPER.noteRequestToNote(noteRequest);
        noteupdate.setUuid(id);
        noteupdate.setDate(note.getDate());
        return NoteMapper.MAPPER.noteToNoteResponse(noteRepository.save(noteupdate));
    }

    @Override
    public boolean deleteNote(String id) {
        Note note = noteRepository.findById(id).orElse(null);
        noteRepository.deleteById(id);
        return true;
    }
}
