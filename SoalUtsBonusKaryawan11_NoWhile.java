import java.util.Scanner;
import java.text.DecimalFormat;

public class SoalUtsBonusKaryawan11_NoWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== PROGRAM PERHITUNGAN BONUS KARYAWAN ===");

        System.out.print("Masukkan nilai kinerja (1-100): ");
        double nilaiKinerja = input.nextDouble();

        System.out.print("Masukkan lama bekerja (dalam tahun): ");
        double lamaBekerja = input.nextDouble();

        System.out.print("Masukkan gaji pokok (Rp): ");
        double gajiPokok = input.nextDouble();

        input.nextLine(); // membersihkan buffer
        System.out.print("Apakah memiliki sertifikasi profesional? (ya/tidak): ");
        String sertifikasi = input.nextLine().trim().toLowerCase();

        // === Validasi input (tanpa while, hanya dengan if-else) ===
        if (nilaiKinerja < 1 || nilaiKinerja > 100) {
            System.out.println("Nilai kinerja harus antara 1 dan 100.");
        } else if (lamaBekerja < 0) {
            System.out.println("Lama bekerja tidak boleh negatif.");
        } else if (gajiPokok <= 0) {
            System.out.println("Gaji pokok harus lebih dari 0.");
        } else {
            // === Semua input valid, lanjut perhitungan ===
            double bonusPersentase = 0;
            double bonus = 0;
            double bonusTambahan = 0;
            double totalBonus;

            // a. Jika nilai kinerja di bawah 70 → tidak dapat bonus
            if (nilaiKinerja < 70) {
                bonus = 0;
                System.out.println("\nKaryawan tidak mendapatkan bonus karena nilai kinerja di bawah 70.");
            } 
            // b. Nilai kinerja 70–89
            else if (nilaiKinerja >= 70 && nilaiKinerja < 90) {
                if (lamaBekerja < 2) {
                    bonusPersentase = 0.01;
                } else if (lamaBekerja < 5) {
                    bonusPersentase = 0.03;
                } else {
                    bonusPersentase = 0.05;
                }
                bonus = gajiPokok * bonusPersentase;
            } 
            // c. Nilai kinerja 90 ke atas
            else if (nilaiKinerja >= 90) {
                if (lamaBekerja < 2) {
                    bonusPersentase = 0.02;
                } else if (lamaBekerja < 5) {
                    bonusPersentase = 0.04;
                } else {
                    bonusPersentase = 0.07;
                }
                bonus = gajiPokok * bonusPersentase;
            }

            // d. Tambahan sertifikasi
            if (bonus > 0 && sertifikasi.equalsIgnoreCase("ya")) {
                bonusTambahan = 500000;
            }

            totalBonus = bonus + bonusTambahan;

            // === Tampilkan hasil ===
            System.out.println("\n===== HASIL PERHITUNGAN BONUS =====");
            System.out.println("Nilai kinerja  : " + nilaiKinerja);
            System.out.println("Lama bekerja   : " + lamaBekerja + " tahun");
            System.out.println("Gaji pokok     : Rp " + String.format("%,.0f", gajiPokok));
            System.out.println("Sertifikasi    : " + (sertifikasi.equals("ya") ? "Ya" : "Tidak"));
            System.out.println("------------------------------------");

            if (bonus > 0) {
                System.out.println("Bonus kinerja  : Rp " + String.format("%,.0f", bonus));
                if (bonusTambahan > 0) {
                    System.out.println("Bonus sertifikasi: Rp " + String.format("%,.0f", bonusTambahan));
                }
                System.out.println("------------------------------------");
                System.out.println("Total bonus    : Rp " + String.format("%,.0f", totalBonus));
            } else {
                System.out.println("Tidak ada bonus yang diterima.");
            }
        }

        input.close();
    }
}
