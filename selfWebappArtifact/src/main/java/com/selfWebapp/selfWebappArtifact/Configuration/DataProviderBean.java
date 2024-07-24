package com.selfWebapp.selfWebappArtifact.Configuration;

import com.selfWebapp.selfWebappArtifact.DataProviderList.GlobalUsersDataProviderList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.selfWebapp.selfWebappArtifact"})
public class DataProviderBean {

    @Bean
    public GlobalUsersDataProviderList globalUsersDataProviderList(){
       return new GlobalUsersDataProviderList();
    }
}
