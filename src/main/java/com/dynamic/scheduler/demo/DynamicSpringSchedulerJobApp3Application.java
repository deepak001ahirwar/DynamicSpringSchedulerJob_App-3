package com.dynamic.scheduler.demo;

import com.dynamic.scheduler.demo.pojo.CronExpressionEntity;
import com.dynamic.scheduler.demo.repo.CronExpressionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DynamicSpringSchedulerJobApp3Application {
	Logger LOGGER = LoggerFactory.getLogger(DynamicSpringSchedulerJobApp3Application.class);

	public static void main(String[] args) {
		SpringApplication.run(DynamicSpringSchedulerJobApp3Application.class, args);
	}



//	@Autowired
//	public CronExpressionRepository cronExpressRepo;
//
//	@Bean
//	public String getDynamicCronExpression() {
//		CronExpressionEntity cronstr = cronExpressRepo.findAll(Sort.by(Sort.Direction.DESC, "id")).get(0);
//		LOGGER.info("getCronExpression : " + cronstr.getCronExpression());
//		System.out.println("getCronExpression : " + cronstr.getCronExpression());
//		return cronstr.getCronExpression();
//	}

}
