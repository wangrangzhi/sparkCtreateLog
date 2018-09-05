package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
@Component
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private static Logger log = LoggerFactory.getLogger(DemoApplication.class);

	@RequestMapping("/")
	public String home() {
		log.info("Handling home");
        homea();

		return "Hello World";
	}

    @RequestMapping("/a")
    public String homea() {
        log.info("Handling home");

        return "Hello World";
    }
	@Autowired
	private KafkaTemplate kafkaTemplate;

	@RequestMapping("/send")
	public String send(String msg){
		kafkaTemplate.send("Test2", "sd");
		return "success";
	}



	/**
	 * kafka 发送消息
	 *

	 */
	@RequestMapping("/send1")
	public void send() {

//
//		//发送消息
//		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("sparklogTest", "1");
//		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//			@Override
//			public void onFailure(Throwable throwable) {
//				log.info("Produce: The message failed to be sent:" + throwable.getMessage());
//			}
//
//
//
//
//			@Override
//			public void onSuccess(SendResult<String, String> stringStringSendResult) {
//				//log.info("Produce: The message was sent successfully:");
//			//	log.info("Produce: _+_+_+_+_+_+_+ result: " + stringStringSendResult.toString());
//			}
//		});
	}

}
