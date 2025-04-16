package com.insureplans.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insureplans.entity.PlanCategory;

public interface PlanCategoryRepo extends JpaRepository<PlanCategory, Integer>{

}
