package com.example.demo.member.controller;

import com.example.demo.global.response.response.ApiResponse;
import com.example.demo.member.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/player")
public class PlayerController {

    private final PlayerService playerService;
}
