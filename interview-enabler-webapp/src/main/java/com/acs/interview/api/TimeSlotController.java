package com.acs.interview.api;

import com.acs.interview.request.TimeSlotRequest;
import com.acs.interview.response.TimeSlotResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/timeslot")
public interface TimeSlotController {
    @ApiOperation(value = "View a list of available timeslots", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping
    ResponseEntity<List<TimeSlotResponse>> get();

    @ApiOperation(value = "View a available timeslot by employee id", response = TimeSlotResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/{id}")
    ResponseEntity<TimeSlotResponse> getByEmpId(@PathVariable final Long id);


    @ApiOperation(value = "To save the timeslot for specific employee", response = TimeSlotResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully Created"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PostMapping
    ResponseEntity<TimeSlotResponse> save(@RequestBody final TimeSlotRequest timeSlotRequest);


    @ApiOperation(value = "To update the timeslot for specific employee", response = TimeSlotResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully Created"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PutMapping
    ResponseEntity<TimeSlotResponse> update(@RequestParam final Long empId, @RequestBody final TimeSlotRequest timeSlotRequest);
}
