package com.pira.springboot_angular.rest;

import com.pira.springboot_angular.model.entity.Attendance;
import com.pira.springboot_angular.model.entity.Client;
import com.pira.springboot_angular.rest.dto.AttendanceDTO;
import com.pira.springboot_angular.service.AttendanceService;
import com.pira.springboot_angular.service.ClientService;
import com.pira.springboot_angular.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
@Validated
public class AttendanceController {

    private final ClientService clientService;
    private final AttendanceService attendanceService;
    private final BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Attendance save(@RequestBody @Valid AttendanceDTO attendanceDTO){
        Long clientId = attendanceDTO.getClientId();
        Client client = clientService.findById(clientId);

        Attendance attendance = Attendance.builder()
                .description(attendanceDTO.getDescription())
                .date(LocalDateTime.parse(attendanceDTO.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                .client(client)
                .value(bigDecimalConverter.convert(attendanceDTO.getValue()))
                .build();

        return attendanceService.save(attendance);
    }

    @GetMapping
    public List<Attendance> findByParams(@RequestParam(value="clientName", required = false, defaultValue = "") String clientName,
                                         @RequestParam(value="month") @Min(value=1, message = "The field Month is required.") Integer month){
        return attendanceService.findByClientNameAndMonth(clientName, month);
    }
}
