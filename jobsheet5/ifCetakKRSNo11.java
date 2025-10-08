package jobsheet5;

import java.util.Scanner;

public class ifCetakKRSNo11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Cetak KRS SIAKAD");
        System.out.println("Apakah UKT sudah lunas? (true/false): ");
        boolean uktLunas = sc.nextBoolean();
        String pesan = uktLunas ? "Pembayaran UKT terverifikasi" : "Registrasi ditolak. Silahkan lunasi UKT terlebih dahulu";
        System.out.println(pesan);

        if (uktLunas) {
            System.out.println("Masukkan semester saat ini: ");
            int semester = sc.nextInt();

            String krsPesan = (semester == 1) ? "KRS Semester 1 ditampilkan" :
                            (semester == 2) ? "KRS Semester 2 ditampilkan" :
                            (semester == 3) ? "KRS Semester 3 ditampilkan" :
                            (semester == 4) ? "KRS Semester 4 ditampilkan" :
                            (semester == 5) ? "KRS Semester 5 ditampilkan" :
                            (semester == 6) ? "KRS Semester 6 ditampilkan" :
                            (semester == 7) ? "KRS Semester 7 ditampilkan" :
                            (semester == 8) ? "KRS Semester 8 ditampilkan" : "Semester tidak valid";
            System.out.println(krsPesan);

            System.out.println("Silahkan minta tanda tangan DPA");
        } else {
            System.out.println("Registrasi ditolak. Silakan lunasi UKT terlebih dahulu");
        }

        sc.close();
    }
}