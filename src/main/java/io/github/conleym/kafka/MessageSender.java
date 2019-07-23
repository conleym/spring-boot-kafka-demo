package io.github.conleym.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {
    private final KafkaTemplate<Object, Object> kafkaTemplate;

    @Autowired
    public MessageSender(final KafkaTemplate<Object, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public SendResult<Object, Object> sendMessage() throws Exception {
        return kafkaTemplate.send(KafkaDemoConfiguration.DEMO_TOPIC_NAME, "hello there.")
                .completable().get();
    }
}
