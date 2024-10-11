package com.bravepaws.ideabrowser_v2.tables;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "users")
public class TableUsers implements BaseTable{
    private int userid;
    private String userName;
    private String contactInfo;
    private Date registrationDate;
    private Date birthDate;
    private int userIdeas;

    public TableUsers() {}

    public TableUsers(String userName)
    {
        this.userName = userName;
        this.contactInfo = userName;
        this.registrationDate = new Date(System.currentTimeMillis());
        this.birthDate = new Date(System.currentTimeMillis());
        this.userIdeas = 0;
    }

    public TableUsers(String userName, String contactInfo, Date registrationDate, Date birthDate, int userIdeas)
    {
        this.userName = userName;
        this.contactInfo = contactInfo;
        this.registrationDate = new Date(System.currentTimeMillis());
        this.birthDate = birthDate;
        this.userIdeas = userIdeas;
    }

    @Id
    @Column(name = "USERID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "USER_ID_GEN")
    @SequenceGenerator(name = "USER_ID_GEN", sequenceName = "users_pk", allocationSize = 1)
    public int getUserId()
    {
        return userid;
    }
    public void setUserId(int userid)
    {
        this.userid = userid;
    }

    @Basic
    @Column(name = "USER NAME")
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    @Basic
    @Column(name = "CONTACT INFO")
    public String getContactInfo()
    {
        return contactInfo;
    }
    public void setContactInfo(String contactInfo)
    {
        this.contactInfo = contactInfo;
    }

    @Basic
    @Column(name = "REGISTRATION DATE")
    public Date getRegistrationDate()
    {
        return registrationDate;
    }
    public void setRegistrationDate(Date registrationDate)
    {
        this.registrationDate = registrationDate;
    }

    @Basic
    @Column(name = "BIRTH DATE")
    public Date getBirthDate()
    {
        return birthDate;
    }
    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "USER IDEAS")
    public int getUserIdeas()
    {
        return userIdeas;
    }
    public void setUserIdeas(int userIdeas)
    {
        this.userIdeas = userIdeas;
    }
}
