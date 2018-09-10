package com.service;

/**
 * UserAdminService
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.dao.User;
import com.dao.UserAdminDAO;

@CrossOrigin(origins = "http://localhost:4000")
@RestController
public class UserAdminService {

    @RequestMapping(value="/auth", method=RequestMethod.POST)
    public ResponseEntity<Object> greeting(@RequestBody User user) {
        
        ResponseEntity<Object> responseEntity = null;
        try{
            UserAdminDAO userAdminDao = new UserAdminDAO();
            boolean isValid = userAdminDao.isVaidUser(user);
            if(isValid){
                responseEntity =  new ResponseEntity<>(null,HttpStatus.OK);
            }else{
                responseEntity =  new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
            }
        }catch(Exception e){
            e.printStackTrace();
            responseEntity =  new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
        }
        return responseEntity;
    }
}