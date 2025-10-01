package jobsheet5;

import java.util.Scanner;

public class Tugas3no2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Masukkan jenis pengguna (dosen/mahasiswa/lainnya): ");
        String jenisPengguna = sc.nextLine().trim();

        if (jenisPengguna.equalsIgnoreCase("dosen")) {
            System.out.println("Akses WiFi diberikan (dosen)");
        } else if (jenisPengguna.equalsIgnoreCase("mahasiswa")) {
            System.out.println("Masukkan jumlah SKS: ");
            int sks = sc.nextInt();
            if (sks >= 12) {
                System.out.println("Akses WiFi diberikan (mahasiswa aktif)");
            } else {
                System.out.println("Akses ditolak, SKS kurang dari 12");
            }
        } else {
            System.out.println("Akses ditolak");
        }

        sc.close();
    }
}
   