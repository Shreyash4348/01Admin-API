package com.insureplans.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insureplans.entity.PlanModel;

public interface PlanRepo extends JpaRepository<PlanModel, Integer>{

}
