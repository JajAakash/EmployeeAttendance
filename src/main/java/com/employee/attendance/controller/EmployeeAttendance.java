package com.employee.attendance.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.attendance.dto.AttendanceDTO;
import com.employee.attendance.dto.AttendanceUpdateDTO;
import com.employee.attendance.service.AttendanceService;

@RestController
@CrossOrigin
public class EmployeeAttendance {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired AttendanceService attendanceService;
	
	@RequestMapping(value = "/availablity/{empId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public int attendanceRecord(@PathVariable int empId) {
		boolean loginReq=true;
		logger.info("Attendance recording for Employee {} with EMPLOYEEID {}",empId);
		
		return attendanceService.attendance(empId,loginReq);
		
		
	}
	
	@RequestMapping(value = "/logout/{empId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public int logoutattendanceRecord(@PathVariable int empId) {
		boolean logoutReq=false;
		logger.info("LOGOUT Attendance recording for Employee {} with EMPLOYEEID {}",empId);
		
		return attendanceService.attendance(empId,logoutReq);
		
		
	}
	
	@RequestMapping(value="/remove/{empId}/attendance",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	
	public void removeEmployee(@PathVariable int empId ) throws Exception {
		
		logger.info("deletion Req request for Employee Attendance " +empId);
		
		attendanceService.removeEmployeeAttendance(empId);
		
		
		
	}
	
	@RequestMapping(value="/update/attendance/{empId}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)


	public void updateEmployeeAttendance(@RequestBody AttendanceUpdateDTO updatedAttendance,@PathVariable int empId) throws Exception {
		
		logger.info("UPDATE Req request for Employee " +empId);
		
		attendanceService.attendanceUpdate(updatedAttendance, empId);
		
	}
	
	@RequestMapping(value="attendance/details/{empId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AttendanceDTO> getuserProductDetails(@PathVariable int empId)  {
		logger.info(" fetching ATTENDANCE request for Employee {}", empId);
		List <AttendanceDTO> attendanceDetails=attendanceService.getAttendance(empId);
		return attendanceDetails;
	}


}
