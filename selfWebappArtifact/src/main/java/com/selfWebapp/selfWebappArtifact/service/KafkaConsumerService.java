package com.selfWebapp.selfWebappArtifact.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.selfWebapp.selfWebappArtifact.Dao.ActivityIngestionDaoImpl;
import com.selfWebapp.selfWebappArtifact.global.GlobalVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class KafkaConsumerService {

    Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    private final ObjectMapper objectMapper;

    @Autowired
    private ActivityIngestionDaoImpl activityIngestionDao;

    public KafkaConsumerService() {
        this.objectMapper = new ObjectMapper();
    }

    @KafkaListener(topics = "Ingestion", groupId = "kafka-group1")
    public void listen(String message) {
        try {
            List<Map<String, Object>> data = objectMapper.readValue(message, new TypeReference<List<Map<String, Object>>>() {
            });
            logger.info("current code change 14sept:-");
            logger.info("Received:{} ", data);
            activityIngestionDao.importActivity(GlobalVariables.SELECTED_RESOURCE,data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
