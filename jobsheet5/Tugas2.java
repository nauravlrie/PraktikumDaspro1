package jobsheet5;

import java.util.Scanner;

public class Tugas2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Masukkan angka: ");
        int angka = sc.nextInt();

        if (angka % 2 == 0) {
            System.out.println("Genap");
        } else {
            System.out.println("Ganjil");
        }
        sc.close();
    }
    
}
