package com.selfWebapp.selfWebappArtifact.service;

import com.selfWebapp.selfWebappArtifact.entity.Resource;
import com.selfWebapp.selfWebappArtifact.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ResourceService {

    public Resource saveResource(Resource resource);

    public List<Resource> loadResources();
}
