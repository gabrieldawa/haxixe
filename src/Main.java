import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String salt = "11037";
        Hash h = new Hash(salt);
        Scanner s = new Scanner(System.in);

        String password = s.nextLine();
        password = h.encode(password);
        System.out.println("hash: " + password);

        s.close();
    }
}