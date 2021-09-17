package com.pira.springboot_angular.repository;

import com.pira.springboot_angular.model.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AttendanceRepository extends JpaRepository<Attendance, Long>{

    @Query( "select attendance from Attendance attendance " +
            " join attendance.client client " +
            " where upper(client.name) like upper(:name) " +
            " and MONTH(attendance.date) = :month ")
    List<Attendance> findByClientNameAndMonth(@Param("name") String clientName,
                                              @Param("month") Integer month);

}
