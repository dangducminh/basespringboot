// package com.example.baseproject.bath;

// import org.quartz.CronTrigger;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.context.event.ApplicationReadyEvent;
// import org.springframework.context.ApplicationListener;
// import org.springframework.stereotype.Component;

// import lombok.extern.slf4j.Slf4j;

// @Slf4j
// @Component
// public class QuartzJobStarter implements ApplicationListener<ApplicationReadyEvent>{

//     @Autowired
//     private QuartzJobRegistry registry;

//     @Override
//     public void onApplicationEvent(ApplicationReadyEvent event) {
//         String group = "Aggregate";
//         log.info("Application Ready");

//         // registry.register("Test", group,  "0 */1 * ? * *", CronJob.class, CronTrigger.MISFIRE_INSTRUCTION_DO_NOTHING);
        
//     }
    
// }