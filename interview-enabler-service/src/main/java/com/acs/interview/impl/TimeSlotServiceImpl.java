package com.acs.interview.impl;

import com.acs.interview.TimeSlotService;
import com.acs.interview.entity.AvailableSlot;
import com.acs.interview.entity.TimeSlot;
import com.acs.interview.mapper.AvailableSlotMapper;
import com.acs.interview.mapper.TimeSlotMapper;
import com.acs.interview.repo.TimeSlotRepository;
import com.acs.interview.request.TimeSlotRequest;
import com.acs.interview.response.TimeSlotResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimeSlotServiceImpl implements TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;
    private final TimeSlotMapper timeSlotMapper;
    private final AvailableSlotMapper availableSlotMapper;

    @Override
    public List<TimeSlotResponse> get() {
        final List<TimeSlot> timeSlots = timeSlotRepository.findAll();
        return timeSlots.stream().map(timeSlotMapper).collect(Collectors.toList());
    }

    @Override
    public TimeSlotResponse getByEmployeeId(final Long id) {
        final TimeSlot timeSlot = timeSlotRepository.findByEmpId(id);
        return timeSlotMapper.apply(timeSlot);
    }

    @Override
    public TimeSlotResponse update(final Long id, final TimeSlotRequest timeSlotRequest) {
        final Optional<TimeSlot> timeSlotOptional = timeSlotRepository.findById(id);
        if(timeSlotOptional.isEmpty())
            throw new RuntimeException(String.format("Id %s not found", id));
        return timeSlotMapper.apply(getTimeSlot(id, timeSlotRequest));
    }

    @Override
    public TimeSlotResponse save(final TimeSlotRequest timeSlotRequest) {
        return timeSlotMapper.apply(getTimeSlot(null, timeSlotRequest));
    }

    private TimeSlot getTimeSlot(final Long id, final TimeSlotRequest timeSlotRequest) {
        //Date should be current calendar month
        validateDate(timeSlotRequest.getDate());
        final List<Integer> availableTimes = timeSlotRequest.getAvailableTimes();
        final List<AvailableSlot> availableSlots = availableTimes.stream()
                .map(availableTime -> availableSlotMapper.apply(availableTime, timeSlotRequest.getDuration()))
                .collect(Collectors.toList());
        final TimeSlot timeSlot = TimeSlot.builder()
                .id(id)
                .empId(timeSlotRequest.getEmpId())
                .date(timeSlotRequest.getDate())
                .availableSlots(availableSlots).build();
        return timeSlotRepository.save(timeSlot);
    }

    private void validateDate(final Date date) {
        final int providedMonth = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate().getMonthValue();
        final int currentMonth = LocalDate.now().getMonthValue();
        if(providedMonth != currentMonth)
            throw new RuntimeException("Given Date should be current calendar month");
    }
}
