package com.selfWebapp.selfWebappArtifact.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class KafkaProducerService {

    private  KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = new ObjectMapper();
    }

    public void sendMessage(List<Map<String, Object>> message){
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(message);
            kafkaTemplate.send("Ingestion",jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

     }

}
