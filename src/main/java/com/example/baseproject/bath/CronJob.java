// package com.example.baseproject.bath;

// import org.quartz.DisallowConcurrentExecution;
// import org.quartz.JobExecutionContext;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.scheduling.quartz.QuartzJobBean;

// import com.example.baseproject.service.StaffService;

// import lombok.extern.slf4j.Slf4j;

// @Slf4j
// @DisallowConcurrentExecution
// public class CronJob extends QuartzJobBean{
    
//     @Autowired
//     private StaffService staffService;

//     protected void executeInternal(JobExecutionContext context){
 
//             log.info("run task for {} at {}", context.getScheduledFireTime(), context.getFireTime());
//             staffService.printf();
        
//     }
    
// }