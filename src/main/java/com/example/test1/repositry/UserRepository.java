package com.example.test1.repositry;

import com.example.test1.dao.TwitterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ridha on 10/7/17.
 */

@Repository
public interface UserRepository extends JpaRepository<TwitterUser,Integer> {

    @Query(value = "select u.user_name,u.password  from TwitterUser u")
    HashMap<String,String> userMap();
    @Query(value="select u.user_name from TwitterUser u where u.user_name in :userlist ")
    List<String> getUserList(@Param("userlist")List<String>userlist);
    //?1
   @Query(value = "select u from TwitterUser u where u.user_name=:name ")
    TwitterUser getUserByname(@Param("name") String name);

    @Query(value = "select u from TwitterUser u where u.user_name=:name ")
    TwitterUser verifyUser(@Param("name") String name);
    @Modifying
    @Query("UPDATE TwitterUser u SET u.name=:name,u.contact_number=:contact_number WHERE u.user_name =:user_name")
    void updateUser( @Param("user_name") String user_name,@Param("name")String name, @Param("contact_number") String contact_number);

//    @Query(value="Update TwitterUser u Set attribute:=value where u.user_name:=name")
//    TwitterUser updateUser(String name,String attribute,String value);

//       @Query(value = "select u from TwitterUser u")
//        List<TwitterUser> findAllUsers();
//
//        TwitterUser findByUserId(Integer id);


        /*  @Override
    <S extends > S saveAndFlush(TwitterUser);
    */
}

