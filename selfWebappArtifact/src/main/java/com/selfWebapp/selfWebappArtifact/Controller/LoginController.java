package com.selfWebapp.selfWebappArtifact.Controller;

import com.selfWebapp.selfWebappArtifact.dto.LraDto;
import com.selfWebapp.selfWebappArtifact.entity.LraUser;
import com.selfWebapp.selfWebappArtifact.service.LraUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LraUserService lraUserService;

    @PostMapping("/saveUser")
    public boolean saveUser(@RequestBody  LraDto lraDto) {
        boolean status;
       try {
           LraUser lraUser =convertToLraUserEntity(lraDto);
           lraUserService.saveUser(lraUser);
           status = true;
       }catch (Exception e){
           status = false;
       }
        return status;
    }

    @PostMapping("/loginUser")
    public boolean loginUser(@RequestBody LraDto lraDto){
        boolean status;
     try {
         LraUser lraUser = lraUserService.findByEmail(lraDto.getEmail());
         status = lraUser != null;
     }catch (Exception e){
         status = false;
     }
        return  status;
    }

   public LraUser convertToLraUserEntity(LraDto lraDto){
        LraUser lraUser = new LraUser();
        lraUser.setName(lraDto.getName());
        lraUser.setEmail(lraDto.getEmail());
        lraUser.setPassword(lraDto.getPassword());
        return lraUser;
   }
}
