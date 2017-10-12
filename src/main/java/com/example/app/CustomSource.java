package com.example.app;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface CustomSource extends Source {

	String testOutput1 = "testOutput1";
	String testOutput2 = "testOutput2";

	@Output(CustomSource.testOutput1)
	MessageChannel testOutput1();

	@Output(CustomSource.testOutput2)
	MessageChannel testOutput2();

}
