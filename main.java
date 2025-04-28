import Controllers.*;

public class main {
    public static void main(String[] args) {
        AuthenticationManager a = new AuthenticationManager();

        a.register("Jashan","1234","student");
        a.register("Jasmine","1234","student");
        a.register("Japit","1234","student");
        a.register("aman","1234","instructor");

        User profile = a.login("Jashan", "1234");
        System.out.println(profile);

    }
}
