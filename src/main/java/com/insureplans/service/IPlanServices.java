package com.insureplans.service;

import java.util.List;
import java.util.Map;

import com.insureplans.entity.PlanModel;

public interface IPlanServices {

	public Map<Integer,String> planCategories();
	public boolean savePlan(PlanModel plan);
	
	public List<PlanModel> getAllPlans(); 
	
	public PlanModel getPlanById(Integer id);
	public boolean updatePlan(PlanModel plan);
	
	public boolean deletePlanById(Integer planId);
	
	public boolean planStatusChange(Integer planId, String status);
	
}
