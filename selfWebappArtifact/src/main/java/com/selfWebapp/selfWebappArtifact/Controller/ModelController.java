package com.selfWebapp.selfWebappArtifact.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.selfWebapp.selfWebappArtifact.constants.Constants;
import com.selfWebapp.selfWebappArtifact.dto.ModelDto;
import com.selfWebapp.selfWebappArtifact.entity.Model;
import com.selfWebapp.selfWebappArtifact.service.ModelService;
import jakarta.servlet.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.selfWebapp.selfWebappArtifact.constants.Constants.DATA;

@RestController
@RequestMapping("/api/model")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PostMapping("/saveModel")
    public String saveModel(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        ModelDto modelDto = new ModelDto();
        try {
            modelDto.setEntity( request.getParameter("entity"));
            modelDto.setModelName( request.getParameter("modelName"));
            modelDto.setResourceAttribute( request.getParameter("resourceAttribute"));
            modelDto.setResource(request.getParameter("resource"));
            modelDto.setEventDesc(request.getParameter("eventDesc"));
            modelDto.setRiskScore( Integer.parseInt(request.getParameter("riskScore")));

            Model savedModel = modelService.save(modelDto);
            jsonObject.put(Constants.STATUS,Constants.SUCCESS);
            jsonObject.put(DATA,mapper.writeValueAsString(savedModel));


        }catch (Exception e){
        jsonObject.put(Constants.STATUS,Constants.FAILED);
        }

       return jsonObject.toString();
    }


    @PostMapping("runModel")
    private String runModel(@RequestParam("id") long id){
        return "";
    }
}

