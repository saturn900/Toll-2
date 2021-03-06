package jdev.servercore;

import jdev.servercore.services.ServiceTakeMsg;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
@PropertySource("classpath:/application.properties")
public class CoreContext {
    @Bean
    public ServiceTakeMsg serviceTakeMsg() {return new ServiceTakeMsg();}

    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("ServerCore_pool_");
        scheduler.setPoolSize(10);
        return scheduler;
    }
}
