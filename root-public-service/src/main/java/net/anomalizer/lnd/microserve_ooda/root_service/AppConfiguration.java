package net.anomalizer.lnd.microserve_ooda.root_service;

import com.microsoft.applicationinsights.web.internal.RequestTelemetryContext;
import com.microsoft.applicationinsights.web.internal.ThreadContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

//@Configuration
public class AppConfiguration {

    @Bean
    public Executor taskExecutor() {

        // Use a custom ThreadPool Executor
        ThreadPoolTaskExecutor executor = new MyThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("GithubLookup-");
        executor.initialize();
        return executor;
    }

    /**
     * Custom ThreadPoolExecutor for passing a wrapped runnable
     */
    private final class MyThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {

        @Override
        public void execute(Runnable command) {
            super.execute(new Wrapped(command, ThreadContext.getRequestTelemetryContext()));
        }
    }

    /**
     * A wrapper class that holds the instance of runnable and the associated context
     */
    private final class Wrapped implements Runnable {
        private final Runnable task;
        private final RequestTelemetryContext rtc;

        Wrapped(Runnable task, RequestTelemetryContext rtc) {
            this.task = task;
            this.rtc = rtc;
        }

        @Override
        public void run() {
            if (ThreadContext.getRequestTelemetryContext() != null) {
                ThreadContext.remove();
            }

            // Set the context explicitly
            ThreadContext.setRequestTelemetryContext(rtc);
            task.run();
        }
    }
}