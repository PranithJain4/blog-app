package com.blogapp.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SupabaseStorageService {

    @Value("${supabase.url}")
    private String supabaseUrl;

    @Value("${supabase.service-role-key}")
    private String key;

    @Value("${supabase.bucket}")
    private String bucket;

    private final RestTemplate rest = new RestTemplate();

    public String uploadFile(MultipartFile file) throws Exception {
        String name = System.currentTimeMillis() + "-" + file.getOriginalFilename();
        String url = supabaseUrl + "/storage/v1/object/" + bucket + "/" + name;

        HttpHeaders h = new HttpHeaders();
        h.setContentType(MediaType.parseMediaType(file.getContentType()));
        h.set("Authorization", "Bearer " + key);
        h.set("x-upsert", "true");

        rest.exchange(url, HttpMethod.POST, new HttpEntity<>(file.getBytes(), h), String.class);

        return supabaseUrl + "/storage/v1/object/public/" + bucket + "/" + name;
    }
}
