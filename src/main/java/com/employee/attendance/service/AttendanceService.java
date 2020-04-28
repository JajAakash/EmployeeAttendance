package com.employee.attendance.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.attendance.Entity.Attendance;
import com.employee.attendance.dto.AttendanceDTO;
import com.employee.attendance.dto.AttendanceUpdateDTO;
import com.employee.attendance.repository.AttendanceRepository;


@Service
@Transactional(readOnly=false)

public class AttendanceService {
	
	@Autowired 
	AttendanceRepository attendanceRepository;
	
	public int attendance(int empId, boolean request) {
		Attendance attendanceData= new AttendanceDTO().attendanceEntity(empId,request);
		int id = attendanceRepository.save(attendanceData).getAttendanceId();;
		return id;
	}
	
	public int attendanceUpdate(AttendanceUpdateDTO updatedAttendanceDTO, int empId) {
		
		return attendanceRepository.attendanceUpdate(updatedAttendanceDTO.getAvailabilty(),updatedAttendanceDTO.getDate(), empId);
		
		
	}
	
	public void removeEmployeeAttendance(int empId) {
		attendanceRepository.deleteByempId(empId);
	}
	
	public List<AttendanceDTO> getAttendance(int empId){
		
		List<Attendance> attendanceDetails=attendanceRepository.findByEmpId(empId);;
		if(attendanceDetails.size()==0) {return null;} 
		else {
			List<AttendanceDTO> attendanceData = new ArrayList();
			
			for(Attendance attendance : attendanceDetails) {
				attendanceData.add(new AttendanceDTO().attendanceModel(attendance));
				}
			return attendanceData;
			}
	}
}
