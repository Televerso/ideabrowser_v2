package com.bravepaws.ideabrowser_v2.tables;

import jakarta.persistence.*;

import java.sql.Date;

// Таблица пользователей
@Entity
@Table(name = "users")
public class TableUsers implements BaseTable {
    private int userid;
    private String userName;
    private String contactInfo;
    private Date registrationDate;
    private Date birthDate;

    // Конструктор по умолчанию
    public TableUsers() {
    }

    // Протсой конструктор
    public TableUsers(String userName) {
        this.userName = userName;
        this.contactInfo = userName;
        this.registrationDate = new Date(System.currentTimeMillis());
        this.birthDate = new Date(System.currentTimeMillis());
    }

    // Сложный конструктор
    public TableUsers(String userName, String contactInfo, Date birthDate) {
        this.userName = userName;
        this.contactInfo = contactInfo;
        this.registrationDate = new Date(System.currentTimeMillis());
        this.birthDate = birthDate;
    }

    // Дальше идут сеттеры и геттеры для полей таблицы
    // Поле id генерируется, последовательность users_seq содержится в базе данных
    @Id
    @Column(name = "USERID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "USER_ID_GEN")
    @SequenceGenerator(name = "USER_ID_GEN", sequenceName = "users_seq", allocationSize = 1)
    public int getUserId() {
        return userid;
    }

    public void setUserId(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "USER NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "CONTACT INFO")
    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Basic
    @Column(name = "REGISTRATION DATE")
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Basic
    @Column(name = "BIRTH DATE")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
