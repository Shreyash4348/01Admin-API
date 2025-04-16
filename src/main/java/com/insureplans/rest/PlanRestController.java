package com.insureplans.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insureplans.entity.PlanModel;
import com.insureplans.service.IPlanServices;

@RestController
public class PlanRestController {

	@Autowired
	private IPlanServices service;

	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> getPlanCategories() {
		Map<Integer, String> planCategories = service.planCategories();

		return new ResponseEntity<>(planCategories, HttpStatus.OK);
	}

	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody PlanModel model) {
		boolean savePlan = service.savePlan(model);

		String responseMsg = "";
		if (savePlan) {
			responseMsg = "Plan saved Successfully..!";
		} else {
			responseMsg = "Plan not saved";
		}
		return new ResponseEntity<>(responseMsg, HttpStatus.CREATED);
	}

	@GetMapping("/plans")
	public ResponseEntity<List<PlanModel>> getAllPlans() {
		List<PlanModel> allPlans = service.getAllPlans();
		return new ResponseEntity<>(allPlans, HttpStatus.OK);
	}

	@GetMapping("/plan/{planId}")
	public ResponseEntity<PlanModel> editPlan(@PathVariable Integer planId) {
		PlanModel plan = service.getPlanById(planId);
		return new ResponseEntity<>(plan, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updatePlan(@RequestBody PlanModel plan) {
		boolean isUpdated = service.updatePlan(plan);
		String msg = "";
		if (isUpdated) {
			msg = "Plan Updated";
		} else {
			msg = "Plan not updated";
		}
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}

	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> planStatusChange(@PathVariable Integer planId, @PathVariable String status) {
		boolean isStatusChanged = service.planStatusChange(planId, status);
		String msg = "";
		if (isStatusChanged) {
			msg = "Status got changed";
		} else {
			msg = "Status not changed";
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
		boolean isDeleted = service.deletePlanById(planId);
		String deleteResult = "";
		if (isDeleted) {
			deleteResult = "Plan got Deleted";
		} else {
			deleteResult = "Plan not Deleted";
		}
		return new ResponseEntity<>(deleteResult, HttpStatus.OK);
	}
}
