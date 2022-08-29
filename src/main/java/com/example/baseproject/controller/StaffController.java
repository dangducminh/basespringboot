package com.example.baseproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.baseproject.model.Staff;
import com.example.baseproject.model.StaffDAO;
import com.example.baseproject.service.StaffService;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class StaffController {

	private static final Logger log = LoggerFactory.getLogger(StaffController.class);

	 @Autowired
	 StaffService staffService;

	 @GetMapping(value = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
	 @CrossOrigin
	 public ResponseEntity<List<Staff>> getAllStaff(){
	 	return new ResponseEntity<>(staffService.getAllStaff(), HttpStatus.OK);
	 }

	@GetMapping(value = "/trigger/log")
	public String log(){
		List<String> list = new ArrayList<>();
		list.add("sa");
		list.add("b");
		list.add("s");
		list.add("ca");
		list.add("da");

		log.info(
			"KMB Collector: processes retrieveEta routes success count ( " +
			list.stream()
					.filter( c -> c.contains("s"))
					.count() +
				" / {} )",list.size()
		);

		log.info("KMB Collector: processes retrieveEta routes success count ({}/{})",2,5);
		return "hello";
	}

 	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
 	@CrossOrigin
 	public ResponseEntity<Staff> createStaff(@RequestBody StaffDAO staffDAO){
 		return new ResponseEntity<>(staffService.CreateStaff(staffDAO),HttpStatus.CREATED);
 	}

 	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
 	@CrossOrigin("http://localhost:63342")
 	public ResponseEntity<Boolean> deleteStaff(@PathVariable(name = "id") Integer id) {
 		try {
 			return new ResponseEntity<>(staffService.deleteUser(id), HttpStatus.OK);
 		} catch (Exception e) {
 			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
 		}
 	}
}