package com.society.OrderIn.amq;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageCreator implements CommandLineRunner {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    public void run(String... arg0) throws Exception {
        // This will put text message to queue
        this.jmsTemplate.convertAndSend(this.queue, "Hello Java2blog!!");
        System.out.println("Message has been put to queue by sender");
    }
}