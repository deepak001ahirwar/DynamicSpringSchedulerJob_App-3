package com.dynamic.scheduler.demo.repo;

import com.dynamic.scheduler.demo.pojo.CronExpressionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CronExpressionRepository extends JpaRepository<CronExpressionEntity, Long> {

	
    @Query(value = "SELECT cron_expression FROM cron_expression ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String findLatestCronExpression();

}
