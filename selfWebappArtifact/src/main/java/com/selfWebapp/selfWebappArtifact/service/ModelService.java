package com.selfWebapp.selfWebappArtifact.service;

import com.selfWebapp.selfWebappArtifact.dto.ModelDto;
import com.selfWebapp.selfWebappArtifact.entity.Model;
import org.springframework.stereotype.Service;


public interface ModelService {

    public Model save(ModelDto model);

}
