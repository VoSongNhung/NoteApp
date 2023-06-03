package com.example.NoteApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteResponse {
    private String uuid;
    private String content;
    private LocalDate date;
}
