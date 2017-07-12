package com.example.test1.service;

import com.example.test1.dao.Message;
import com.example.test1.dao.TwitterUser;
import com.example.test1.repositry.MessageRepository;
import com.example.test1.repositry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
//import java.awt.print.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;

/**
 * Created by ridha on 10/7/17.
 */

@Service
public class Mainservice {


    @Autowired
    private UserRepository userRepositry;

    public void insertUser(TwitterUser user)
    {
        //em.getTransaction().begin();
        TwitterUser newuser = new TwitterUser();
        newuser.setId(user.getId());
        newuser.setName(user.getName());
        newuser.setAge(user.getAge());
        newuser.setContact_number(user.getContact_number());
        newuser.setEducation(user.getEducation());
        newuser.setOnline_status(user.getOnline_status());
        newuser.setPlace_lived(user.getPlace_lived());
        newuser.setUser_name(user.getUser_name());
        newuser.setPassword(user.getPassword());
        newuser.setStatus(user.getStatus());
        newuser.setWork(user.getWork());

        userRepositry.save(user);

        //  em.persist(newuser);
        //em.flush();
        //em.getTransaction().commit();

        //em.close();
        // emf.close();
    }

public int  authenticateUSer(String user_name,String password){
    TwitterUser user=userRepositry.getUserByname(user_name);
    if(user.getPassword().equals(password))
        return 1;
   /* HashMap<String,String> hashMap=userRepositry.userMap();
    Set entrySet = hashMap.entrySet();
    Iterator it = entrySet.iterator();

    // Iterate through HashMap entries(Key-Value pairs)
    while(it.hasNext()){
        Map.Entry me = (Map.Entry)it.next();
        if(user_name.equals(me.getKey()))
            if(password.equals(me.getValue()))
                return 1;*/

    return 0;
}
@Transactional
public String editUser(TwitterUser newuser)
{
    TwitterUser user = userRepositry.getUserByname(newuser.getUser_name());
   if(!user.getStatus())
        return "enter valid user";
//   user.setStatus(newuser.getStatus());
//   user.setAge(newuser.getAge());
//   user.setContact_number(newuser.getContact_number());
//   user.setEducation(newuser.getEducation());
//   user.setPlace_lived(newuser.getPlace_lived());
//    user.setName(newuser.getName());
    userRepositry.updateUser( newuser.getUser_name(),newuser.getName(),newuser.getContact_number());

    return "user updated";



}
@Autowired
    MessageRepository msgRepository;
public void  composeMessage(String sender, List<String> recieverList, String msg ) {
List<String> userlist =recieverList;
//userlist.add(sender);
List <String> receivers=userRepositry.getUserList(userlist);
if(userRepositry.verifyUser(sender)==null) {
    return;
}
//    receivers.remove(receivers.size()-1);
    for (String reciever : receivers) {
        Message newmsg = new Message();
        newmsg.setSender(sender);
        newmsg.setReciever(reciever);
        newmsg.setMessage(msg);
        msgRepository.save(newmsg);

    }
}

public Page<Message> listAllByPage(String sender,Pageable pageable)
    {
        Page<Message> msg=msgRepository.getMsg(sender,pageable);
        return msg;
    }


    public Mainservice()
    {

    }
}
