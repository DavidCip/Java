import java.util.Random;
import java.util.Scanner;

public class pass {
    
    public static String genereazaParola(int length) {
        if (length <= 0) {
            return "Lungimea trebuie să fie mai mare decât 0!";
        }

        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder password = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = rand.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }
        
        
        

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdu lungimea parolei: ");
        int length = sc.nextInt();

        String password = genereazaParola(length);
        System.out.println("Parola generată: " + password);

        sc.close();
    }
}
