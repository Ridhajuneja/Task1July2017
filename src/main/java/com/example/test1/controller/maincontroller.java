package com.example.test1.controller;

import com.example.test1.dao.Message;
import com.example.test1.dao.TwitterUser;
import com.example.test1.service.Mainservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ridha on 7/7/17.
 * @RequestParam("id") Integer id, @RequestParam("name") String name,
 @RequestParam("status") Boolean status, @RequestParam("online_status") Boolean online_status,
 @RequestParam("age") Integer age, @RequestParam("work") String work, @RequestParam("education") String
 education,
 @RequestParam("place_lived") String place_lived, @RequestParam("contact_number") String contact_number,
 @RequestParam(" user_name") String user_name, @RequestParam("password") String password)

 */
@RestController
@RequestMapping(value = "/register")
public class maincontroller {

   @Autowired
    Mainservice mainservice;


//   @Autowired
//   TwitterUser newuser;

    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public String registerUser(@RequestBody TwitterUser newuser)

    {
        mainservice.insertUser(newuser);
        return "welcome"+newuser.getName();

    }
    @RequestMapping(value = "/loginUser",method = RequestMethod.POST)
    public String loginUser(@RequestParam("user_name") String user_name,
                            @RequestParam("password") String password)
    {

        boolean isAuth =mainservice.authenticateUSer(user_name,password);
        if (isAuth) {

            return "Welcome "+user_name;
        }
        return"user not found";
    }
    @RequestMapping(value="/editUser",method = RequestMethod.POST)
    public String editUser(@RequestBody TwitterUser newuser){

        mainservice.editUser(newuser);
        return "string updated";

    }
    @RequestMapping(value="/sendMessage",method = RequestMethod.POST)
    public String ComposeMessage(@RequestParam("sender") String sender,@RequestParam("recieverList") List<String> recieverList,@RequestParam("message")  String message)
    {
        mainservice.composeMessage(sender,recieverList,message);
        return "msg sent";
    }

//    @RequestMapping(value="/myMessage",method = RequestMethod.POST)
//    Page<Message> listall(@Param("sender") String sender, @RequestBody Pageable pageable){
//        Page<Message> msg = mainservice.listAllByPage(sender,pageable);
//       return  msg;
//    }

    @RequestMapping(value="/myMessage",method = RequestMethod.POST)
    Page<Message>listall(@RequestParam("sender") String sender, @RequestParam ("size")Integer size,@RequestParam ("page")Integer pageNumber){
    PageRequest page1 = new PageRequest(0, 20);
        Page<Message> msg = mainservice.listAllByPage(sender,page1);
         return  msg;

    }


            }

