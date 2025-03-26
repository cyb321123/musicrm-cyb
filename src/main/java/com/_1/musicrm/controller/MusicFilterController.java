package com._1.musicrm.controller;

import org.springframework.web.bind.annotation.*;

import com._1.musicrm.Repository.MusicFilterRepository;
import com._1.musicrm.model.MusicFile;

import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/music")
public class MusicFilterController {

    private final MusicFilterRepository repository;

    public MusicFilterController(MusicFilterRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/filter")
    public ResponseEntity<List<MusicFile>> filterMusic(
        @RequestParam(required = false) Long categoryId,
        @RequestParam(required = false) List<Long> tagIds
    ) {
        List<MusicFile> result = repository.filterBy(categoryId, tagIds);
        return ResponseEntity.ok(result);
    }
}