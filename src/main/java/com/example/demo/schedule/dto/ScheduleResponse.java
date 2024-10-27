package com.example.demo.schedule.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ScheduleResponse {

    private String date;
    private String time;
    private String blueTeam;
    private String redTeam;
    private String blueTeamLogo;
    private String redTeamLogo;
}
