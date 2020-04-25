package com.employee.attendance.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.employee.attendance.Entity.Attendance;

public interface  AttendanceRepository extends JpaRepository<Attendance, Integer> {
	
	Attendance save(Attendance attendance);

	void deleteByempId(int empId);
	
	
	@Modifying
	@Query("update Attendance at set at.availabilty = ?1 where at.date=?2 and at.empId = ?3")
	
	public int attendanceUpdate(String availabilty, LocalDate date, int empId);
}
