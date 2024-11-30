package operatii;

import java.util.Scanner;

public class simple {
    public static void main(String[] args) {
        int nr1;
        int nr2;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduceti primul numar");
        nr1 = sc.nextInt();
        
        System.out.println("Introduceti al doilea numar");
        nr2 = sc.nextInt();
        
        System.out.println("Suma celor 2 numere este: " + (nr1 + nr2));
        
        if(nr1>nr2)
        	System.out.println("Diferenta celor doua numere este:"+(nr1-nr2));
        else 
        	System.out.println("Diferenta celor doua numere este:"+(nr2-nr1));
        
        System.out.println("Produsul celor doua numere este:"+(nr1*nr2));
        
        if(nr1!=0 && nr2!=0)
        {
        if(nr1>nr2)
        	System.out.println("Daca primul numar este mai mare,rezultatul impartirii va fi:"+((double)nr1/nr2));
        else
        	System.out.println("Daca al doilea numar este mai mare,rezultatul impartirii va fi:"+((double)nr2/nr1));
        }
        else
        	System.out.println("Numerele trenuie sa fie diferite de 0 pentru operatia de impartire!");
        
        sc.close();
    }
}
