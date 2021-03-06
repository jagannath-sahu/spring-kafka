package com.example.demo.produce;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.example.demo.model.Foo;

@Service
public class KafkaProducerService {

	@Autowired
    private KafkaTemplate<Object,Object> kafkaTemplate;

    private static int runningId = 0;

    public KafkaProducerService(KafkaTemplate<Object,Object> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

    public KafkaProducerService() {
    }

    @Scheduled(fixedRate = 1000 * 10, initialDelay = 5 * 1000)
    public void produceMessage(){
        System.out.println("Produce Message - BEGIN");
        String message = String.format("hello %d this is a kafka message %s", runningId++,
                LocalDateTime.now().toString());
//        ListenableFuture<SendResult<Object, Object>> listenableFuture = kafkaTemplate.send("mike", message);
        ListenableFuture<SendResult<Object, Object>> listenableFuture = kafkaTemplate.send("mike2", "Jagannath", new Foo("Krishna"));
        listenableFuture.addCallback(new ListenableFutureCallback<Object>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("ERROR Kafka error happened" + ex);
            }

            @Override
            public void onSuccess(Object result) {
                System.out.println("SUCCESS!!! This is the result: {}" + result);
            }
         });


        System.out.println("Produce Message - END {}" + message);
    }
}
