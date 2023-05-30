package com.example.food_planner.Authentication;

import java.io.Serializable;

public class UserDTO implements Serializable {
    String userName;
    String email;
    String number;
    //ArrayList<MealDTO> savedMeals=new ArrayList<>();

    public UserDTO(String userName, String email,String number) {
        this.userName = userName;
        this.email = email;
        this.number=number;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
