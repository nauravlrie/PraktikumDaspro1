package jobsheet5;

import java.util.Scanner;

public class Tugas3no1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Apakah membawa kartu mahasiswa? (true/false)");
        boolean kartuMahasiswa = sc.nextBoolean();

        System.out.println("Apakah sudah registrasi online? (true/false)");
        boolean registrasiOnline = sc.nextBoolean();

        if (kartuMahasiswa || registrasiOnline) {
            System.out.println("Boleh masuk");
        } else {
            System.out.println("Ditolak masuk");
        }

        sc.close();
    }
}
  
