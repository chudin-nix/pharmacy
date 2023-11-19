package com.epam.webapphello.entity;

public class User implements Identifable{

    private String login;
    private Long id;
    public static final String TABLE = "pharmacy";

    public User() {

    }

    public User(long id, String login) {
        this.id = id;
        this.login = login;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
