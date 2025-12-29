package com.blogapp.backend.controller;

import com.blogapp.backend.service.SupabaseStorageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
@CrossOrigin("*")
public class UploadController {

    private final SupabaseStorageService service;

    public UploadController(SupabaseStorageService service) {
        this.service = service;
    }

    @PostMapping("/image")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        return service.uploadFile(file);
    }
}
