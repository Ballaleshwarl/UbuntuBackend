package com.selfWebapp.selfWebappArtifact.Dao;

import com.selfWebapp.selfWebappArtifact.entity.GlobalUsers;
import com.selfWebapp.selfWebappArtifact.global.GlobalVariables;
import com.selfWebapp.selfWebappArtifact.repository.GlobalUsersRepository;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static com.selfWebapp.selfWebappArtifact.constants.Constants.*;

@Component
public class ActivityIngestionDaoImpl {

     Logger logger = LoggerFactory.getLogger(ActivityIngestionDaoImpl.class);
    private final GlobalUsersRepository globalUsersRepository;

    public ActivityIngestionDaoImpl(GlobalUsersRepository globalUsersRepository) {
        this.globalUsersRepository = globalUsersRepository;
    }

    public void importActivity(String selectedResource, List<Map<String,Object>> data) throws SQLException {
        Connection con = null;
        String employeeId;
        String eventDesc;
        try{
            String query  = "insert into transactions(user_id,eventdesc,eventdate,resource) values(?,?,?,?)";
            String url = "jdbc:mysql://localhost:3306/lra";
            Properties properties = new Properties();
            properties.setProperty("user","root");
            properties.setProperty("password","manager");
             con = DriverManager.getConnection(url, properties);
            PreparedStatement preparedStatement = con.prepareStatement(query);
            for(Map<String,Object> item : data){

                if(item.size() == 3){
                    employeeId =  item.get("employeeId").toString();
                    GlobalUsers globalUser = globalUsersRepository.findByEmployeeId(employeeId);
                    eventDesc = item.get("eventdesc").toString();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    TemporalAccessor temporalAccessor = formatter.parse(item.get("eventdate").toString());
                    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String formattedDate = formatter1.format(temporalAccessor);


                   if(globalUser != null){
                       preparedStatement.setInt(1, (int)globalUser.getId());
                   }else
                       preparedStatement.setInt(1, -1);

                   preparedStatement.setString(2,eventDesc);
                   preparedStatement.setDate(3, Date.valueOf(LocalDate.parse(formattedDate)));
                   preparedStatement.setString(4,selectedResource);

                   preparedStatement.addBatch();

                }
            }
           preparedStatement.executeBatch();
            GlobalVariables.IS_ACTIVITY_INGESTED =TRUE;


        }catch (Exception e){
           logger.error("Error Occurred into Activity-Ingestion:{}",e.toString());
            GlobalVariables.IS_ACTIVITY_INGESTED =FALSE;
        } finally {
            assert con != null;
            con.close();
        }



    }


}
