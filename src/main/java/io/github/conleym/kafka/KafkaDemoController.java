package io.github.conleym.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaDemoController {
    private final MessageSender messageSender;

    @Autowired
    public KafkaDemoController(final MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @RequestMapping(method = RequestMethod.POST, value = "send")
    public String sendMessage() throws Exception {
        final SendResult<Object, Object> result = messageSender.sendMessage();
        return result.toString();
    }
}
