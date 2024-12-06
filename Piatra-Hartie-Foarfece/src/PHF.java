import java.util.Random;
import java.util.Scanner;

public class PHF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String[] phf = {"piatra", "hartie", "foarfeca"};
            Random random = new Random();
            String computerMove = phf[random.nextInt(phf.length)];

            String playerMove;

            
            while (true) {
                System.out.println("Introduceti miscarea (piatra, hartie sau foarfeca):");
                playerMove = scanner.nextLine().toLowerCase();
                if (playerMove.equals("piatra") || playerMove.equals("hartie") || playerMove.equals("foarfeca")) {
                    break; 
                } else {
                    System.out.println(playerMove + " este o miscare invalida. Incercati din nou.");
                }
            }

            
            System.out.println("Miscare sistem: " + computerMove);

           
            if (playerMove.equals(computerMove)) {
                System.out.println("Egalitate!");
            } else if (playerMove.equals("piatra")) {
                if (computerMove.equals("hartie")) {
                    System.out.println("Ai pierdut!");
                } else if (computerMove.equals("foarfeca")) {
                    System.out.println("Ai castigat!");
                }
            } else if (playerMove.equals("hartie")) {
                if (computerMove.equals("piatra")) {
                    System.out.println("Ai castigat!");
                } else if (computerMove.equals("foarfeca")) {
                    System.out.println("Ai pierdut!");
                }
            } else if (playerMove.equals("foarfeca")) {
                if (computerMove.equals("hartie")) {
                    System.out.println("Ai castigat!");
                } else if (computerMove.equals("piatra")) {
                    System.out.println("Ai pierdut!");
                }
            }

         
            System.out.println("Joc nou? (Da/Nu)");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("da")) {
                System.out.println("Multumim pentru joc! La revedere!");
                break; 
            }
        }

        scanner.close(); 
    }
}
