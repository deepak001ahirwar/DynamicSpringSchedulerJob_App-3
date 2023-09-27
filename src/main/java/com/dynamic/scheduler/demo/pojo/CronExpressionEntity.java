package com.dynamic.scheduler.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cron_expression")
public class CronExpressionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cronExpression;

	public CronExpressionEntity() {
	}

	public CronExpressionEntity(Long id, String cronExpression) {
		this.id = id;
		this.cronExpression = cronExpression;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	@Override
	public String toString() {
		return "CronExpressionEntity [id=" + id + ", cronExpression=" + cronExpression + "]";
	}

}
