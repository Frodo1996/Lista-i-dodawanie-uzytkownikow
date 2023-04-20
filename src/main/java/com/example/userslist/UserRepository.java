package com.example.userslist;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private final List<User> userList;

    public UserRepository(List<User> userList) {
        userList.add(new User("Ania", "Kowalska", 36));
        userList.add(new User("Andrzej", "Strzelba", 27));
        userList.add(new User("Włodzimierz", "Tyczka", 68));
        this.userList = userList;
    }

    public void addNewUser(String firstName, String lastName, int age) {
        userList.add(new User(firstName, lastName, age));
    }

    public List<User> findAllUsers() {
        return new ArrayList<>(userList);
    }
}