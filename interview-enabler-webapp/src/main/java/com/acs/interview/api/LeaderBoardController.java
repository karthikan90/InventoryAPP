package com.acs.interview.api;

import com.acs.interview.response.LeaderBoardDto;
import com.acs.interview.response.LeaderBoardRequestDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/leaders")
public interface LeaderBoardController {

    @ApiOperation(value = "View a employee by id", response = LeaderBoardDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Employee by Id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PostMapping
    ResponseEntity<List<LeaderBoardDto>> getLeaders(@RequestBody LeaderBoardRequestDto leaderBoardRequestDto);
}
