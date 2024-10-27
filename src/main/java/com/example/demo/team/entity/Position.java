package com.example.demo.team.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Position {

    TOP("탑"),
    JUNGLE("정글"),
    MID("미드"),
    ADC("원딜"),
    SUPPORT("서폿");

    private final String key;
}
