// package com.example.baseproject.bath;

// import java.util.Date;

// import org.quartz.JobBuilder;
// import org.quartz.JobDetail;
// import org.quartz.Scheduler;
// import org.quartz.SchedulerException;
// import org.quartz.Trigger;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.ApplicationContext;
// import org.springframework.scheduling.quartz.QuartzJobBean;
// import org.springframework.scheduling.quartz.SchedulerFactoryBean;
// import org.springframework.stereotype.Component;
// import org.springframework.transaction.annotation.Transactional;

// import lombok.extern.slf4j.Slf4j;

// @Slf4j
// @Component
// public class QuartzJobRegistry {

//     @Autowired
//     private SchedulerFactoryBean schedulerFactoryBean;
//     @Autowired
//     private JobScheduleCreator scheduleCreator;
//     @Autowired
//     private ApplicationContext context;
    
//     @Transactional
//     public void register(String name, String group, String cronExpression, Class<? extends QuartzJobBean> jobClass, int missFireStrategy){
//         try {
//             Scheduler scheduler = schedulerFactoryBean.getScheduler();
//             JobDetail jobDetail = JobBuilder
//                 .newJob(jobClass)
//                 .withIdentity(name, group).build();
//             if (!scheduler.checkExists(jobDetail.getKey())) {
      
//               jobDetail = scheduleCreator.createJob(
//                   jobClass, false,
//                   context,
//                   name, group);
      
//               Trigger
//                   trigger = scheduleCreator.createCronTrigger(name, new Date(),
//                   cronExpression, missFireStrategy);
//               scheduler.scheduleJob(jobDetail, trigger);
//               scheduler.start();
      
//               log.info(">>>>> jobName = [" + name + "]" + " scheduled.");
//             }
//           } catch (SchedulerException e) {
//             log.error(e.getMessage(), e);
//           }
//     }
// }