package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.support.MessageBuilder;

@SpringCloudApplication
@EnableTask
@EnableBinding(CustomSource.class)
public class StreamAppApplication {

	@Autowired
	CustomSource source;

	public static void main(String[] args) {
		SpringApplication.run(StreamAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLinerunner() {
		MessageObject message = new MessageObject();
		message.field1 = "test";
		message.field2 = "moreTest";

		return Publish -> {
			source.testOutput1().send(MessageBuilder.withPayload(message).build());
			source.testOutput2().send(MessageBuilder.withPayload(message).build());
		};
	}

	public class MessageObject {
		public String field1 = null;
		public String field2 = null;
	}
}
