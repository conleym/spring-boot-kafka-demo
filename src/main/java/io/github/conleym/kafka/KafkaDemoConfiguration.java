package io.github.conleym.kafka;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class KafkaDemoConfiguration {
    public static final String DEMO_TOPIC_NAME = "demo";

    @Bean
    public NewTopic demoTopic() {
        return new NewTopic(DEMO_TOPIC_NAME, 1, (short)1);
    }
}
