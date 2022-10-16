package com.garage.simulator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garage.simulator.dto.Bill;
import com.garage.simulator.dto.JobSheet;
import com.garage.simulator.dto.ServiceLog;
import com.garage.simulator.model.JobModel;
import com.garage.simulator.model.MotorCycle;
import com.garage.simulator.service.GarageService;

@RestController
@RequestMapping("/garage/motor-cyle")
public class GarageController {

	@Autowired
	private GarageService garageService;

	@PostMapping("/checkin")
	public ResponseEntity<ServiceLog> checkinMotorCycle(@RequestBody MotorCycle motorCycle) {
		ServiceLog serviceLog = garageService.checkinMotorCycle(motorCycle);

		if (serviceLog == null) {
			return new ResponseEntity<>(serviceLog, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(serviceLog, HttpStatus.CREATED);
	}

	@PostMapping("/jobSheet/{serviceEntryId}")
	public ResponseEntity<JobModel> createJobSheet(@PathVariable long serviceEntryId, @RequestBody List<String> parts) {

		JobSheet jobSheet = garageService.createJobSheet(serviceEntryId, parts);
		JobModel jobModel = null;
		if (jobSheet == null) {
			return new ResponseEntity<>(jobModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		jobModel = new JobModel();
		jobModel.setJobEntryId(jobSheet.getJobEntryId());
		jobModel.setPartList(parts);
		return new ResponseEntity<>(jobModel, HttpStatus.CREATED);
	}

	@PostMapping("/checkout/{serviceEntryId}")
	public ResponseEntity<Bill> checkoutMotorCycle(@PathVariable long serviceEntryId) {
		Bill generatedBill = garageService.checkoutMotorCycle(serviceEntryId);
		if (generatedBill == null) {
			return new ResponseEntity<>(generatedBill, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(generatedBill, HttpStatus.CREATED);
	}
}
