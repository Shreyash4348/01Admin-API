package com.insureplans.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insureplans.Repo.PlanCategoryRepo;
import com.insureplans.Repo.PlanRepo;
import com.insureplans.entity.PlanCategory;
import com.insureplans.entity.PlanModel;

@Service
public class PlanServiceImpl implements IPlanServices {
	@Autowired
	private PlanRepo planRepo;

	@Autowired
	private PlanCategoryRepo planCategoryReop;

	/*
	 * @Override public Map<Integer, String> planCategories() {
	 * 
	 * List<PlanCategory> categories = planCategoryReop.findAll(); Map<Integer,
	 * String> categoryMap = new HashMap<>();
	 * 
	 * categories.forEach(category -> categoryMap.put(category.getCategoryId(),
	 * category.getCategoryName()));
	 * 
	 * return categoryMap; }
	 */
	@Override
	public Map<Integer, String> planCategories() {
	    List<PlanCategory> categories = planCategoryReop.findAll();
	    Map<Integer, String> categoryMap = new HashMap<>();

	    categories.forEach(category -> {
	        System.out.println("Category Found: " + category.getCategoryId() + " - " + category.getCategoryName());
	        categoryMap.put(category.getCategoryId(), category.getCategoryName());
	    });

	    return categoryMap;
	}


	@Override
	public boolean savePlan(PlanModel plan) {

		PlanModel saved = planRepo.save(plan);

		return saved.getPlanId() != null ? true : false;

		// return saved.getPlanId != null; if plan id not equal to null, condition
		// satisfied return true or else return false
	}

	@Override
	public List<PlanModel> getAllPlans() {

//		List<PlanModel> plans = planRepo.findAll();

		return planRepo.findAll();
	}

	@Override
	public PlanModel getPlanById(Integer id) {

		Optional<PlanModel> findById = planRepo.findById(id);

		if (findById.isPresent()) {
			return findById.get();
		} else {
			return null;
		}
	}

	@Override
	public boolean updatePlan(PlanModel plan) {

		PlanModel save = planRepo.save(plan);

		return save.getPlanId() != null ? true : false;
	}

	@Override
	public boolean deletePlanById(Integer planId) {

		boolean status = false;
		try {
			planRepo.deleteById(planId);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {

		Optional<PlanModel> byId = planRepo.findById(planId);
		if (byId.isPresent()) {
			PlanModel plan = byId.get();
			plan.setActiveSw(status);
			planRepo.save(plan);
			return true;
		}
		return false;
	}

}
