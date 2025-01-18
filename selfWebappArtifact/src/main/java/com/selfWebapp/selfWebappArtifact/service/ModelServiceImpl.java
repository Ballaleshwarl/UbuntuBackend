package com.selfWebapp.selfWebappArtifact.service;

import com.selfWebapp.selfWebappArtifact.dto.ModelDto;
import com.selfWebapp.selfWebappArtifact.entity.Model;
import com.selfWebapp.selfWebappArtifact.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService{

    private final ModelRepository modelRepository;

    @Autowired
    ModelServiceImpl(ModelRepository modelRepository){
        this.modelRepository = modelRepository;
    }

    @Override
    public Model save(ModelDto modelDto) {
        Model model =  new Model();
        model.setModelName(modelDto.getModelName());
        model.setModelType(modelDto.getEntity());
        model.setResource(modelDto.getResource());
        model.setEventDesc(modelDto.getEventDesc());
        model.setResourceAttribute(modelDto.getResourceAttribute());
        model.setRiskScore(modelDto.getRiskScore());
        return modelRepository.save(model);
    }
}
