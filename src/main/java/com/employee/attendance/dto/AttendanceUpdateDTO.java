package com.employee.attendance.dto;

import java.time.LocalDate;

public class AttendanceUpdateDTO {
	
	private String availabilty;
	private LocalDate  date;
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
