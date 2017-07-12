package com.example.test1.service;

import com.example.test1.dao.TwitterUser;
import com.example.test1.repositry.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ridha on 12/7/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainserviceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private TwitterUser users;
    @InjectMocks
    Mainservice mainservice;

    @Before

    public void setupMock() {

        MockitoAnnotations.initMocks(this);


        // mainservice.setUserRepository(userRepository);


    }
    @Test
    public void insertUser() throws Exception {
    }
    @Test
    public void editUser() throws Exception {
        TwitterUser user = new TwitterUser();
        user.setUser_name("yogi");
        user.setStatus(false);
        when(userRepository.getUserByname(Mockito.eq(user.getUser_name()))).thenReturn(user);
        String isAuthenticated  = mainservice.editUser(user);
        assertEquals("enter valid user",isAuthenticated);
    }

    @Test
    public void composeMessage() throws Exception {
    }

    @Test
    public void listAllByPage() throws Exception {
    }

    //private Mainservice mainservice;

    @Test
    public void  authenticateUSer() {

    // Arrange
    TwitterUser user = new TwitterUser();
    user.setPassword("password");
    when(userRepository.getUserByname(Mockito.eq("yogi"))).thenReturn(user);


    // Act

    boolean isAuthenticated  = mainservice.authenticateUSer("yogi","yogi");
    assertFalse(isAuthenticated);
    //assertTrue(isAuthenticated);

    // Assert


    }

    }