package com.selfWebapp.selfWebappArtifact.DataProviderList;

import com.selfWebapp.selfWebappArtifact.entity.GlobalUsers;
import com.selfWebapp.selfWebappArtifact.service.GlobalUsersService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GlobalUsersDataProviderList implements DataProvider{

   @Autowired
   private GlobalUsersService  globalUsersService;

    @Override
    public String getData() {

        JSONArray jsonArray = new JSONArray();
        List<GlobalUsers> allGlobalUsers = globalUsersService.getAllGlobalUsers();

        for(GlobalUsers globalUsers:allGlobalUsers){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("firstName",globalUsers.getFirstName());
            jsonObject.put("lastName",globalUsers.getLastName());
            jsonObject.put("department",globalUsers.getDepartment());
            jsonObject.put("employeeId",globalUsers.getEmployeeId());
            jsonObject.put("riskscore",globalUsers.getRiskscore());
            jsonArray.put(jsonObject);
        }


        return jsonArray.toString();
    }
}
