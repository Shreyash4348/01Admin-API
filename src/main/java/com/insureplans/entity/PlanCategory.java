package com.insureplans.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PLAN_CATEGORY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanCategory {

	@Id
	@GeneratedValue
	private Integer categoryId;
	private String categoryName;

	private String activesw;
	private String createdBy;
	private String updatedBy;

	@Column(name="CREATEDATE", updatable = false)
	@CreationTimestamp
	private LocalDate createDate;
	
	@Column(name="UPDATEDATE", insertable = false)
	@UpdateTimestamp
	private LocalDate updateDate;
}
