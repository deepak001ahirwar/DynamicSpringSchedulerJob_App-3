package com.dynamic.scheduler.demo.controller;

import com.dynamic.scheduler.demo.pojo.CronExpressionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dynamic.scheduler.demo.service.CronExpressInterface;

@RestController
@RequestMapping("/scheduler")
public class SchedulerController {

	@Autowired
	private CronExpressInterface cronExpressInterface;

	@PostMapping("/updateCron")
	public ResponseEntity<CronExpressionEntity> updateSchedulerCron(@RequestParam String cronValue) {
		CronExpressionEntity newone = cronExpressInterface.addExpression(cronValue);
		return new ResponseEntity<CronExpressionEntity>(newone, HttpStatus.CREATED);

	}

}
