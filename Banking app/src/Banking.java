import java.util.Scanner;

public class Banking {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("ABC", "123");
        account.showMenu();
    }
}

class BankAccount {
    int balanta;
    int tranzactieAnterioara;
    String Nume;
    String ID;

    BankAccount(String cname, String cid) {
        Nume = cname;
        ID = cid;
    }

    void deposit(int amount) {
        if (amount > 0) {
            balanta = balanta + amount;
            tranzactieAnterioara = amount;
        }
    }

    void withdraw(int amount) {
        if (amount > 0) {
            balanta = balanta - amount;
            tranzactieAnterioara = -amount;
        }
    }

    void gettranzactieAnterioara() {
        if (tranzactieAnterioara > 0) {
            System.out.println("Adaugare: " + tranzactieAnterioara);
        } else if (tranzactieAnterioara < 0) {
            System.out.println("Extragere: " + Math.abs(tranzactieAnterioara));
        } else {
            System.out.println("Fara tranzactie");
        }
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bine ati venit " + Nume);
        System.out.println("ID-ul dumneavoastra este: " + ID);
        System.out.println("\n");
        System.out.println("A. Verificare balanta");
        System.out.println("B. Adaugare");
        System.out.println("C. Extragere");
        System.out.println("D. Tranzactie anterioara");
        System.out.println("E. Exit");

        do {
            System.out.println("==================================================================");
            System.out.println("Introduceti o optiune:");
            System.out.println("==================================================================");
            option = scanner.next().toUpperCase().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("==================================================================");
                    System.out.println("balanta = " + balanta);
                    System.out.println("==================================================================");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("==================================================================");
                    System.out.println("Introduceti suma:");
                    System.out.println("==================================================================");
                    try {
                        int amount = scanner.nextInt();
                        deposit(amount);
                    } catch (Exception e) {
                        System.out.println("Introducere invalida");
                        scanner.next();
                    }
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("==================================================================");
                    System.out.println("Introduceti suma pentru extragere:");
                    System.out.println("==================================================================");
                    try {
                        int amount2 = scanner.nextInt();
                        withdraw(amount2);
                    } catch (Exception e) {
                        System.out.println("Introducere invalida");
                        scanner.next(); 
                    }
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("==================================================================");
                    gettranzactieAnterioara();
                    System.out.println("==================================================================");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("***************************************************************");
                    break;

                default:
                    System.out.println("Introducere invalida");
                    break;
            }
        } while (option != 'E');

        System.out.println("Va multumim pentru folosirea servicilor noastre!");
        scanner.close();
    }
}
