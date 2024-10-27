package com.example.demo.post.controller;

import com.example.demo.global.response.response.ApiResponse;
import com.example.demo.post.dto.UploadPostRequest;
import com.example.demo.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    public final PostService postService;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> uploadPost(UploadPostRequest uploadPostRequest) {

        return ResponseEntity.ok(ApiResponse.success("Upload post success"));
    }
}
