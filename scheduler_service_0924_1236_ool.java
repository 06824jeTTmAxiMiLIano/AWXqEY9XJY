// 代码生成时间: 2025-09-24 12:36:59
import org.apache.ibatis.session.SqlSession;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Properties;

/**
 * SchedulerService.java
 * A service class to manage scheduled tasks using Quartz Scheduler with MyBatis integration.
 */
public class SchedulerService {
    
    private Scheduler scheduler;
    private SqlSession sqlSession;

    public SchedulerService() {
        try {
            // Initialize Quartz scheduler with MyBatis configuration
            Properties properties = new Properties();
            properties.setProperty(org.quartz.impl.StdSchedulerFactory.PROP_SCHED_INSTANCE_ID, 