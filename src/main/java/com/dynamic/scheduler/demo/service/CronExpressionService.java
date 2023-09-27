package com.dynamic.scheduler.demo.service;

import com.dynamic.scheduler.demo.pojo.CronExpressionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dynamic.scheduler.demo.repo.CronExpressionRepository;

@Service
public class CronExpressionService implements CronExpressInterface {

	

	@Autowired
	private CronExpressionRepository cronExpressRepo;

	
	/*
	 * sort by base on id desc and fetch latesone cron value
	 */
	
	public String getDynamicCronExpression() {
//		CronExpressionEntity cronstr = cronExpressRepo.findAll(Sort.by(Sort.Direction.DESC, "id")).get(0);
//		System.out.println("cronstr.getCronExpression: "+cronstr.getCronExpression() );
//		return cronstr.getCronExpression();
		String cronstr =cronExpressRepo.findLatestCronExpression();
		System.out.println("cronstr: "+cronstr);
		return cronstr;
	}


	@Override
	public CronExpressionEntity addExpression(String express) {
		CronExpressionEntity cronObj = new CronExpressionEntity();
		cronObj.setCronExpression(express);
		CronExpressionEntity updatedcronObj = cronExpressRepo.save(cronObj);
		return updatedcronObj;
	}
}
