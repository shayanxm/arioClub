package com.example.shayanmoradi.arioclub.model.users;

public enum UserType {
    admin(0),patient(1),doctor(2);
    public final int id;

    UserType(int id) {
        this.id = id;
    }
}
