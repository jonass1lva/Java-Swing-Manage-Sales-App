package pt.ipleiria.managers;

import pt.ipleiria.model.Vehicle;

import java.util.LinkedList;
import java.util.Objects;

public class VehicleManager {
    LinkedList<Vehicle> vehicles  = new LinkedList<>();

    private User getByClient(String username) {
        for( User user: this.users){
            if (user.getUsername().equals(username)) return user;
        }
        return null;
    }
    public boolean verifyUser(String username, CharSequence rawPassword) {
        return Objects.requireNonNull(getUser(username)).isMatchingPassword(rawPassword);
    }
}
