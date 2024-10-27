package com.example.demo.post.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class UploadPostRequest {

    private String title;
    private String content;
    private String username;
    private Integer status;
}
