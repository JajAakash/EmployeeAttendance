package com.employee.attendance.Entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "attendance")


@SequenceGenerator(name="atseq", initialValue = 2111, allocationSize = 1)
public class Attendance {
	
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "atseq")
	@Id
	@Column(name = "attendanceId", updatable = false, nullable = false)
	private int attendanceId;
	
	@Column(nullable = false)
	private LocalTime inTime;
	
	@Column(nullable = false)
	private LocalTime outTime;
	
	@Column(nullable = false)
	private DayOfWeek day;
	
	@Column(name="employeeId", nullable = false)
	private int empId;
	
	@Column(nullable = false)
	private LocalDate date;
	
	@Column(nullable = false)
	private String availabilty;

	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	public LocalTime getInTime() {
		return inTime;
	}

	public void setInTime(LocalTime inTime) {
		this.inTime = inTime;
	}

	public LocalTime getOutTime() {
		return outTime;
	}

	public void setOutTime(LocalTime outTime) {
		this.outTime = outTime;
	}

	public DayOfWeek getDay() {
		return day;
	}

	public void setDay(DayOfWeek day) {
		this.day = day;
	}
	
	


	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getAvailabilty() {
		return availabilty;
	}

	public void setAvailabilty(String availabilty) {
		this.availabilty = availabilty;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


	
	
	

}
