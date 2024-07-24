package com.selfWebapp.selfWebappArtifact.DataProviderList;

import com.selfWebapp.selfWebappArtifact.Configuration.SpringContext;

public class DataProviderFactory {

    public static DataProvider getDataProvider(String gridType){
        if(gridType.equals("USERS")){
            return SpringContext.getBean(GlobalUsersDataProviderList.class);
        }

        throw new IllegalArgumentException("Invalid GridType"+gridType);
    }
}
