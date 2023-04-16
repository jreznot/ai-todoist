package com.example.todoist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class TodoKafkaProducer {

    private static final String TOPIC_NAME = "todo-topic";

    @Autowired
    private KafkaTemplate<String, TodoDTO> kafkaTemplate;

    public void sendTodoDTO(TodoDTO todoDTO) {
        kafkaTemplate.send(TOPIC_NAME, todoDTO);
    }
}
