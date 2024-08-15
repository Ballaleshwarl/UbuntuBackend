package com.selfWebapp.selfWebappArtifact.Controller;

import com.selfWebapp.selfWebappArtifact.entity.Resource;
import com.selfWebapp.selfWebappArtifact.service.ResourceService;
import jakarta.servlet.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    public final String SUCCESS= "success";
    public final String ERROR= "error";

    @PostMapping("saveOrUpdateResource")
    public String saveOrUpdateResource(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
    try {
        Resource resource = new Resource();
        resource.setResourceName(request.getParameter("resource"));
        Resource  savedResource = resourceService.saveResource(resource);
        if(savedResource !=null) {
            jsonObject.put("status", SUCCESS);
        }
    }catch (Exception e){
        jsonObject.put("status",ERROR);
    }
        return jsonObject.toString();
    }

    @GetMapping("loadResources")
    public List<String> loadResources(){
        List<Resource> resources = resourceService.loadResources();
        return extractResourceName(resources);
    }

    List<String> extractResourceName(List<Resource> resources){
        return resources.stream().map(Resource::getResourceName).collect(Collectors.toList());
    }
}
