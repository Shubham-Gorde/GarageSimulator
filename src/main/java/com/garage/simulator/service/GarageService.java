package com.garage.simulator.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garage.simulator.dto.Bill;
import com.garage.simulator.dto.JobSheet;
import com.garage.simulator.dto.JobToPart;
import com.garage.simulator.dto.JobToPartMapId;
import com.garage.simulator.dto.RateCard;
import com.garage.simulator.dto.ServiceLog;
import com.garage.simulator.model.MotorCycle;
import com.garage.simulator.repository.BillRepository;
import com.garage.simulator.repository.JobSheetRepository;
import com.garage.simulator.repository.JobToPartRepository;
import com.garage.simulator.repository.RateCardRepository;
import com.garage.simulator.repository.ServiceLogRepository;

@Service
public class GarageService {

	@Autowired
	private ServiceLogRepository serviceLogRepository;

	@Autowired
	private JobSheetRepository jobSheetRepository;

	@Autowired
	private JobToPartRepository jobToPartRepository;

	@Autowired
	private RateCardRepository rateCardRepository;

	@Autowired
	private BillRepository billRepository;

	public ServiceLog checkinMotorCycle(MotorCycle motorCycle) {
		if (motorCycle != null) {
			ServiceLog serviceLog = new ServiceLog();
			serviceLog.setMotorCycleModel(motorCycle.getMotorCycleModel());
			serviceLog.setNumberPlate(motorCycle.getNumberPlate());
			serviceLog.setKmTravelled(motorCycle.getKmTravelled());
			serviceLog.setCheckedInTime(LocalDateTime.now());
			return serviceLogRepository.save(serviceLog);
		}
		return null;
	}

	public JobSheet createJobSheet(long serviceEntryId, List<String> parts) {
		ServiceLog serviceLog = getServiceLog(serviceEntryId);
		if (serviceLog != null) {
			JobSheet jobSheet = new JobSheet();
			List<JobToPart> jobToParts = new ArrayList<>();

			for (String part : parts) {
				JobToPart jobToPart = new JobToPart();

				JobToPartMapId jobToPartMapId = new JobToPartMapId();
				jobToPartMapId.setJobSheet(jobSheet);
				jobToPartMapId.setPartName(part);

				jobToPart.setJobToPartMapId(jobToPartMapId);
				jobToParts.add(jobToPart);
			}
			jobSheet.setJobToParts(jobToParts);
			jobSheet.setServiceLog(serviceLog);

			serviceLog.setJobSheet(jobSheet);

			return jobSheetRepository.save(jobSheet);
		}
		return null;
	}

	private ServiceLog getServiceLog(long serviceEntryId) {

		Optional<ServiceLog> optionalServiceLog = serviceLogRepository.findById(serviceEntryId);
		if (optionalServiceLog.isPresent()) {
			return optionalServiceLog.get();
		}
		return null;
	}

	public Bill checkoutMotorCycle(long serviceEntryId) {
		ServiceLog serviceLog = getServiceLog(serviceEntryId);
		if (serviceLog != null) {
			JobSheet jobSheet = serviceLog.getJobSheet();
			List<String> jobParts = jobToPartRepository.getJobParts(jobSheet.getJobEntryId());
			List<RateCard> rateCardList = new ArrayList<>();

			for (String part : jobParts) {
				RateCard rateCard = rateCardRepository.findByMotorCycleModelAndPartName(serviceLog.getMotorCycleModel(),
						part);

				if (rateCard != null) {
					rateCardList.add(rateCard);
				}
			}

			Bill bill = new Bill();
			bill.setRateCardList(rateCardList);
			bill.setTotalCost(calculateTotalCost(rateCardList));

			System.out.println(bill);
			return billRepository.save(bill);
		}
		return null;
	}

	private int calculateTotalCost(List<RateCard> rateCardList) {
		int totalCost = 0;
		for (RateCard card : rateCardList) {
			totalCost += card.getCost();
		}
		return totalCost;
	}
}
