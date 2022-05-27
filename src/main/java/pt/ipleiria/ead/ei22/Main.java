package pt.ipleiria.ead.ei22;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("jonas12", "Eiapp123");
        System.out.println(user1.isMatchingPassword("Eiapp123"));
    }
}
