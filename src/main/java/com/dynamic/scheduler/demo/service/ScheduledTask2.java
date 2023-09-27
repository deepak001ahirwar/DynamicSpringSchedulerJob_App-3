package com.dynamic.scheduler.demo.service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.quartz.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Service;

@Configuration
@Service
public class ScheduledTask2 implements SchedulingConfigurer {

	private final CronExpressionService cronExpressionService;

	@Autowired
	public ScheduledTask2(CronExpressionService cronExpressionService) {
		this.cronExpressionService = cronExpressionService;
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.addTriggerTask(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("calling dynamicScheduledTask " + new Date());
					dynamicScheduledTask();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, new Trigger() {
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				Calendar nextExTime = new GregorianCalendar();
				Date lastActualExecutionTime = triggerContext.lastActualExecutionTime();
				System.out.println("lastActualExecutionTime: " + lastActualExecutionTime);
				nextExTime.setTime(lastActualExecutionTime != null ? lastActualExecutionTime : new Date());
				// nextExTime.add(Calendar.MILLISECOND, getNewExecutionTime());
				nextExTime.setTime(getNewExecutionTime());
				return nextExTime.getTime();
			}
		});
	}

	private Date getNewExecutionTime() {
		// Load Your execution time from database
		String time = cronExpressionService.getDynamicCronExpression();
		System.out.println("time :" + time);
//		if (time != null) {
//			return Integer.valueOf(time);
//		}
		// cron expression
		try {
			CronExpression cron = new CronExpression(time);
			// Calculate the next execution time
			Date nextvaliddate = cron.getNextValidTimeAfter(new Date());
			System.out.println("nextvaliddate: " + nextvaliddate);
			return nextvaliddate;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void dynamicScheduledTask() throws InterruptedException {
		System.out.println("\n start**************  \n");
		System.out.println("Start  dynamicScheduledTask at " + new Date());
		System.out.println("Greeting Message: Hello dynamicScheduledTask");
//		LOGGER.info("Scheduled Task Executed with Cron: " + cronExpressionService.getDynamicCronExpression());
		Thread.sleep(2000);
		System.out.println("End  dynamicScheduledTask at " + new Date());
		System.out.println("Greeting Message: Good by dynamicScheduledTask");
		System.out.println("\n **************end   \n");
	}

}
