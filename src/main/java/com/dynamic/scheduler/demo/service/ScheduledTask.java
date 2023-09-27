package com.dynamic.scheduler.demo.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.dynamic.scheduler.demo.pojo.CronExpressionEntity;
import com.dynamic.scheduler.demo.repo.CronExpressionRepository;

//@Component
@Service
@Configuration
public class ScheduledTask {

	Logger LOGGER = LoggerFactory.getLogger(ScheduledTask.class);

//	@Autowired
//	public CronExpressionRepository cronExpressRepo;

//	private final CronExpressionService cronExpressionService;
//
//	@Autowired
//	public ScheduledTask(CronExpressionService cronExpressionService) {
//		this.cronExpressionService = cronExpressionService;
//	}

//	@Bean
//	public String getDynamicCronExpression() {
////		CronExpressionEntity cronstr = cronExpressRepo.findAll(Sort.by(Sort.Direction.DESC, "id")).get(0);
////		LOGGER.info("getCronExpression : " + cronstr.getCronExpression());
////		System.out.println("getCronExpression : " + cronstr.getCronExpression());
////		return cronstr.getCronExpression();
//		String cronstr =cronExpressRepo.findLatestCronExpression();
//		System.out.println("cronstr: "+cronstr);
//		return cronstr;
//	}

	/*
	 * Make it dynamic to fetch cron value from DB at runtime
	 * 
	 */

//	@Scheduled(cron = "#{getDynamicCronExpression}")
////	@Scheduled(cron = "#{@getDynamicCronExpression}")
//	public void dynamicScheduledTask() throws InterruptedException {
//
//		System.out.println("\n **************  \n");
//		System.out.println("Start  dynamicScheduledTask at " + new Date());
//		System.out.println("Greeting Message: Hello dynamicScheduledTask");
////		LOGGER.info("Scheduled Task Executed with Cron: " + cronExpressionService.getDynamicCronExpression());
//		Thread.sleep(2000);
//		System.out.println("End  dynamicScheduledTask at " + new Date());
//		System.out.println("Greeting Message: Good by dynamicScheduledTask");
//		System.out.println("\n **************  \n");
//
//	}

}
