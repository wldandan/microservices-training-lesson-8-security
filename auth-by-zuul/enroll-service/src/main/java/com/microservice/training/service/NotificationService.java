package com.microservice.training.service;

import net.greghaines.jesque.Config;
import net.greghaines.jesque.ConfigBuilder;
import net.greghaines.jesque.Job;
import net.greghaines.jesque.client.Client;
import net.greghaines.jesque.client.ClientImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    private static Logger LOG = LoggerFactory.getLogger(NotificationService.class);

    @Value("${custom.redis.host}")
    public String redisHost;
    @Value("${custom.redis.port}")
    public int redisPort;

    public Config jesqueConfig() {
        return new ConfigBuilder().withHost(redisHost).withPort(redisPort).build();
    }

    public void enqueueNotificationJob(String recipient, String subject, String content) {
        final Job job = new Job("SendNotificationJob", recipient, subject, content);
        final Client client = new ClientImpl(jesqueConfig());
        client.enqueue("default", job);
        client.end();
        LOG.info("Enqueued notification!");
    }
}
