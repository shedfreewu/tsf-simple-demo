package com.tencent.tsf.demo.consumer.schedule;

import com.tencent.tsf.demo.consumer.proxy.ProviderDemoService;
import com.tencent.tsf.demo.consumer.proxy.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@ConditionalOnProperty(value = "consumer.auto.test.enabled", matchIfMissing = true)
@EnableScheduling
@Service
public class ScheduledProviderDemo {
    private static final Logger LOG = LoggerFactory.getLogger(ScheduledProviderDemo.class);

    @Autowired
    private ProviderService providerService;

    @Autowired
    private ProviderDemoService providerDemoService;

    @Scheduled(fixedDelayString = "${consumer.auto.test.interval:1000}")
    public void doWork() throws InterruptedException {
        String response = providerDemoService.echo("auto-test");
        LOG.info("consumer-demo auto test, response: [" + response + "]");
    }
}