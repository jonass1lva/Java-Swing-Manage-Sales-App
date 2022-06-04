package pt.ipleiria.model;

import pt.ipleiria.managers.ClientManager;
import pt.ipleiria.managers.UserManager;
import pt.ipleiria.views.LoginView;


public class Main {
    public static LoginView loginView;
    public static void main(String[] args) {
        // Manager Sets
        UserManager userManager = new UserManager();

        // Initial View Load
        loginView = new LoginView();
        loginView.setVisible(true);
    }
}
