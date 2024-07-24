package com.selfWebapp.selfWebappArtifact.Controller;

import com.selfWebapp.selfWebappArtifact.DataProviderList.DataProvider;
import com.selfWebapp.selfWebappArtifact.DataProviderList.DataProviderFactory;
import com.selfWebapp.selfWebappArtifact.dto.GridTypeDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/datalist")
public class DatalistController {

    @PostMapping("/fetchDatalist")
    public ResponseEntity<String> fetchDatalist( @RequestBody  GridTypeDto gridTypeDto){
        DataProvider dataProvider = DataProviderFactory.getDataProvider(gridTypeDto.getGridType());
        String globalUsers = dataProvider.getData();
        return ResponseEntity.ok(globalUsers);
    }

}
