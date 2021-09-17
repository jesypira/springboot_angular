package com.pira.springboot_angular.service;

import com.pira.springboot_angular.model.entity.Attendance;
import com.pira.springboot_angular.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance save(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> findByClientNameAndMonth(String clientName, Integer month) {
        return attendanceRepository.findByClientNameAndMonth("%"+clientName+"%", month);
    }
}
