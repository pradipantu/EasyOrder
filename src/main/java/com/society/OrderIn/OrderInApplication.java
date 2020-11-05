package com.society.OrderIn;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;
@EnableJms
@SpringBootApplication
public class OrderInApplication {
	public static Logger log= LoggerFactory.getLogger(OrderInApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(OrderInApplication.class, args);
		log.info("Application Started Succesfully");
	}
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("java2blog.queue");
	}

    @Bean
    public ActiveMQConnectionFactory connectionFatory(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        return new JmsTemplate(connectionFatory());
    }

}
