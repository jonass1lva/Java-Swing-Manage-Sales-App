package pt.ipleiria.model;

import pt.ipleiria.views.login.LoginView;


public class Main {
    public static LoginView loginView;
    public static void main(String[] args) {
        // Manager Sets
        Storage.getInstance();
        // Initial View Load
        loginView = new LoginView();
        loginView.setVisible(true);
    }
}
