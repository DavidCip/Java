import java.util.Scanner;

public class Inmultirea {
	// Tabel inmultire orice numar de la 1 pana la 10
	public static void main(String[] args) {
	int numar;
	System.out.println("Introduceti numarul pentru inmultire:");
	Scanner sc = new Scanner(System.in);
	numar = sc.nextInt();
	int i;
	for(i=1;i<=10;i++)
		System.out.println(numar + " * " + i + " = " + (numar * i) );
	
	// Pasi rulare program : 1. Run ; 2. Introduceti in "Console" orice numar ; 3. Enter
	
	}
		
}