package com.selfWebapp.selfWebappArtifact.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.selfWebapp.selfWebappArtifact.constants.Constants;
import com.selfWebapp.selfWebappArtifact.entity.GlobalUsers;
import com.selfWebapp.selfWebappArtifact.global.GlobalVariables;
import com.selfWebapp.selfWebappArtifact.service.GlobalUsersService;
import com.selfWebapp.selfWebappArtifact.service.KafkaProducerService;
import jakarta.servlet.http.HttpServletRequest;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pipeline")
public class PipelineController {

    private static final Logger log = LoggerFactory.getLogger(PipelineController.class);
    @Autowired
    private GlobalUsersService globalUsersService;

    private KafkaProducerService kafkaProducerService;

    @Autowired
    PipelineController(KafkaProducerService kafkaProducerService){
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/ingestData")
   public String ingestData(@RequestBody List<Map<String,Object>> jsonData ){

        boolean isingested;
        long count =0;
        JSONObject jsonObject= new JSONObject();
      try {
          for(Map<String,Object> json: jsonData){
              if(json.size() != 4){
                  throw new NoSuchFieldException();
              }
              GlobalUsers globalUsers = new GlobalUsers();
              globalUsers.setFirstName(json.get("firstName").toString());
              globalUsers.setLastName(json.get("lastName").toString());
              globalUsers.setEmployeeId(json.get("employeeId").toString());
              globalUsers.setDepartment(json.get("department").toString());
              isingested = globalUsersService.saveGlobalUsers(globalUsers);

              if(isingested){
                  count = count + 1;
              }
          }
          jsonObject.put("ingested users",count);
          log.info("Ingestion Ended !");

      }catch (Exception e){
          if(e instanceof NoSuchFieldException){
              jsonObject.put("ingested users",count);
          }else
              jsonObject.put("ingested users",-1);
      }
        return jsonObject.toString();
    }

    @PostMapping("/ingestActivity")
    public String ingestActivity(HttpServletRequest request) throws JsonProcessingException {
        String jsonString = request.getParameter("data");
        GlobalVariables.SELECTED_RESOURCE =  request.getParameter(Constants.SELECTED_RESOURCE);

        ObjectMapper objectMapper =  new ObjectMapper();
        List<Map<String,Object>> jsonData =  objectMapper.readValue(jsonString, new TypeReference<List<Map<String, Object>>>() {
        });

        this.kafkaProducerService.sendMessage(jsonData);
        return "";
    }
}
