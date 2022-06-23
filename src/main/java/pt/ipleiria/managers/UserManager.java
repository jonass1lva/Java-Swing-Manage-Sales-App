package pt.ipleiria.managers;

import pt.ipleiria.model.User;

import java.util.LinkedList;
import java.util.Objects;

public class UserManager {
    LinkedList<User> users = new LinkedList<>();

    public UserManager() {
        seedUsers();
    }

    private void seedUsers() {
        users.add(new User("miguel", "12345"));
        users.add(new User("jonas", "12345"));
        users.add(new User("jose", "12345"));
    }
    private User getUser(String username) {
        for( User user: this.users){
            if (user.getUsername().equals(username)) return user;
        }
        return null;
    }
    public boolean verifyUser(String username, CharSequence rawPassword) {
        //TODO: Null pointer exception on wrong credentials
        User user = getUser(username);
        if (user==null)return false;
        return (getUser(username)).isMatchingPassword(rawPassword);
    }
 }
