package com.employee.attendance.dto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.employee.attendance.Entity.Attendance;

public class AttendanceDTO {
	
	private LocalTime inTime;
	private LocalTime outTime;
	private DayOfWeek day;
	private int empId;
	private String availabilty;
	private int attendanceId;
	private LocalDate  date;
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
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
	public void setDay(DayOfWeek dayOfWeek) {
		this.day = dayOfWeek;
	}
	public String getAvailabilty() {
		return availabilty;
	}
	public void setAvailabilty(String availabilty) {
		this.availabilty = availabilty;
	}
	
	public Attendance attendanceEntity(int empId,boolean req) {
		
		this.setInTime(java.time.LocalTime.now());
		this.setOutTime(java.time.LocalTime.now());
		this.setDay(LocalDate.now().getDayOfWeek());
		this.setDate(LocalDate.now());
		this.setAvailabilty("Present");
		this.setEmpId(empId);
   
		Attendance entity = new Attendance();
		
		entity.setAvailabilty(this.getAvailabilty());
		entity.setDay(this.getDay());
		entity.setDate(this.getDate());
		if(req) {entity.setInTime(this.getInTime());}
		if(!req) {entity.setOutTime(this.getOutTime());}
		entity.setEmpId(this.getEmpId());
		return entity;
		
	}
	
	public AttendanceDTO attendanceModel(Attendance attendance) {
		
		AttendanceDTO attendanceDTO = new AttendanceDTO();
		attendanceDTO.setAttendanceId(attendance.getAttendanceId());
		attendanceDTO.setAvailabilty(attendance.getAvailabilty());
		attendanceDTO.setDate(attendance.getDate());
		attendanceDTO.setDay(attendance.getDay());
		attendanceDTO.setInTime(attendance.getInTime());
		attendanceDTO.setOutTime(attendance.getOutTime());
		attendanceDTO.setEmpId(attendance.getEmpId());
		return attendanceDTO;
	}
}
