package com.example.NoteApp.controller;

import com.example.NoteApp.dto.NoteRequest;
import com.example.NoteApp.dto.NoteResponse;
import com.example.NoteApp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/note")
public class NoteController {
    @Autowired
    NoteService noteService;
    @GetMapping("/get-all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<NoteResponse>> getAllNote() {
        List<NoteResponse> noteResponseList = noteService.getAllNote();
//        return ResponseEntity.ok(noteResponseList);
        return ResponseEntity.status(HttpStatus.OK).body(noteResponseList);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<NoteResponse>> getNote(@PathVariable String id){
//        return ResponseEntity.ok(noteResponseList);
        return ResponseEntity.status(HttpStatus.OK).body(noteService.getNote(id));
    }
    @PostMapping("/add")
    public ResponseEntity<NoteResponse> addNote(@RequestBody NoteRequest noteRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(noteService.addNote(noteRequest));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<NoteResponse> updateNote(@PathVariable String id,@RequestBody NoteRequest noteRequest){
        return ResponseEntity.status(HttpStatus.OK).body(noteService.updateNote(id,noteRequest));
//        return ResponseEntity.ok(noteService.updateNote(id,noteRequest));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable String id){
        return ResponseEntity.ok(noteService.deleteNote(id));
    }
}
