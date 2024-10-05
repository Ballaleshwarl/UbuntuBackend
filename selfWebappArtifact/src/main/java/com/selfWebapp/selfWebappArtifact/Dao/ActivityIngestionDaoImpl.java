package com.selfWebapp.selfWebappArtifact.Dao;

import com.selfWebapp.selfWebappArtifact.entity.GlobalUsers;
import com.selfWebapp.selfWebappArtifact.repository.GlobalUsersRepository;
import org.springframework.stereotype.Component;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Map;

@Component
public class ActivityIngestionDaoImpl {


    private final GlobalUsersRepository globalUsersRepository;

    public ActivityIngestionDaoImpl(GlobalUsersRepository globalUsersRepository) {
        this.globalUsersRepository = globalUsersRepository;
    }

    public void importActivity(String selectedResource, List<Map<String,Object>> data) throws SQLException {

        String employeeId;
        String eventDesc;
        LocalDate eventDate;
        String tempDate ;
        try{
            String url = "jdbc:crate://localhost:5432/";
            String user = "crate";
            Connection con = DriverManager.getConnection(url, user,null);
            for(Map<String,Object> item : data){

                if(item.size() == 3){
                    employeeId =  item.get("employeeId").toString();
                    GlobalUsers globalUser = globalUsersRepository.findByEmployeeId(employeeId);
                    eventDesc = item.get("eventdesc").toString();
                     
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    TemporalAccessor temporalAccessor = formatter.parse(item.get("eventdate").toString());
                    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    formatter1.format(temporalAccessor)


                }


            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }


}
