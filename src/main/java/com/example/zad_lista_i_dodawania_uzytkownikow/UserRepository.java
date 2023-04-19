package com.example.zad_lista_i_dodawania_uzytkownikow;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserRepository {

    List<User> userList;

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
        return userList;
    }

    public String printAllUsers() {
        List<User> allUsers = findAllUsers();
        StringBuilder result = new StringBuilder();
        for (User user : allUsers) {
            result.append(user).append("<br/>");
        }
        return result.toString();
    }
}