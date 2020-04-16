


package com.kgisl.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * User
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;
 @Column(unique = true)

     private String userEmail;
    
  

    /**
     * @return the userid
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param username the username to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

      /**
     * @return the useremail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param useremail the useremail to set
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}