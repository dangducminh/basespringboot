package com.example.baseproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.baseproject.model.Staff;
import com.example.baseproject.model.StaffDAO;
import com.example.baseproject.repository.StaffRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Service
public class StaffService {

	@Autowired
	 private StaffRepository staffRepository;

	 public List<Staff> getAllStaff() {
	 	List<Staff> staff = null;
	 	 return staff == null ? new ArrayList<>() : staff;
	 }

	 public Staff CreateStaff(StaffDAO staffDAO){
	 	Staff staff = new Staff();
	 	staff.setName(staffDAO.getName());
	 	staff.setBirthDate(staffDAO.getBirthDate());
	 	staff.setSex(staffDAO.getSex());

	 	staffRepository.save(staff);
	 	return staff;
	 }

	 public Boolean deleteUser(Integer id) {
	 	staffRepository.deleteById(id);
	 	return true;
	 }
    
    public void printf(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
    }
}