package com.example.test1.dao;

/**
 * Created by ridha on 7/7/17.
 */

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.HashMap;

/**
 * Created by ridha on 7/7/17.
 */
@Entity
@Table(name = "twitter_user")
public class TwitterUser {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
   // @Column(name="status", columnDefinition=" default 'Boolean.True'")
    private Boolean status;
    //@Lob
    //@Column(name = "imageInByte",length = 31457280)
    //@Basic(fetch = FetchType.LAZY)
    //private byte[] imageInByte;
    @Column(name="online_status", columnDefinition="Boolean default True")
    private Boolean online_status;
    private Integer age;
    private String work;
    private String education;
    private String place_lived;
    @Column(length=10)
    private String contact_number;
    @Column(unique=true, nullable=false,length=40)
    private String user_name;
    @Column( nullable=false,length=40)
    private String password;

    public TwitterUser() {
    }

    public TwitterUser(Long id, String name, Boolean status, HashMap<Integer, String> friend_list, Boolean online_status, Integer age, String work, String education, String place_lived, String contact_number, String user_name, String password) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.online_status = online_status;
        this.age = age;
        this.work = work;
        this.education = education;
        this.place_lived = place_lived;
        this.contact_number = contact_number;
        this.user_name = user_name;
        this.password = password;
    }



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getStatus() {
        return status;
    }

    public Boolean getOnline_status() {
        return online_status;
    }

    public Integer getAge() {
        return age;
    }

    public String getWork() {
        return work;
    }

    public String getEducation() {
        return education;
    }

    public String getPlace_lived() {
        return place_lived;
    }

    public String getContact_number() {
        return contact_number;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }



    public void setOnline_status(Boolean online_status) {
        this.online_status = online_status;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setPlace_lived(String place_lived) {
        this.place_lived = place_lived;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  /*  public String toString() {
        return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
    }*/
}

