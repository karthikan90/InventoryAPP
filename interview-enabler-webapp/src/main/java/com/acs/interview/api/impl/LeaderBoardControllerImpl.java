package com.acs.interview.api.impl;

import com.acs.interview.api.LeaderBoardController;
import com.acs.interview.response.LeaderBoardDto;
import com.acs.interview.response.LeaderBoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LeaderBoardControllerImpl implements LeaderBoardController {


    @Override
    public ResponseEntity<List<LeaderBoardDto>> getLeaders(LeaderBoardRequestDto leaderBoardRequestDto) {
        return ResponseEntity.ok(getAllLeaders());
    }

    private List<LeaderBoardDto> getAllLeaders() {
        return List.of(
                getLeader("John Doe", 100, 1, 250),
                getLeader("John Doe", 100, 2, 245),
                getLeader("John Doe", 100, 3, 240),
                getLeader("John Doe", 100, 3, 240)
        );
    }

    private LeaderBoardDto getLeader(String name, Integer userId, Integer rank, Integer totalPoints) {
        return LeaderBoardDto.builder()
                .name(name)
                .rank(rank)
                .totalPoints(totalPoints)
                .userId(userId)
                .email(name + "@acsicorp.com")
                .location("GAR")
                .imageUrl("")
                .build();
    }
}
