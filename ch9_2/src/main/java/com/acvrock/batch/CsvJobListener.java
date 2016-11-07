package com.acvrock.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class CsvJobListener implements JobExecutionListener{ 

    long startTime;
    long endTime;
    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = System.currentTimeMillis();
        System.out.println("任务"+jobExecution.getJobConfigurationName()+"处理开始");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        endTime = System.currentTimeMillis();
        System.out.println("任务"+jobExecution.getJobConfigurationName()+"处理结束");
        System.out.println("耗时:" + (endTime - startTime)/1000.0 + "秒");
    }

}
