import java.util.Scanner;
import java.text.DecimalFormat;

public class SoalUtsBonusKaryawan11 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== PROGRAM PERHITUNGAN BONUS KARYAWAN ===");

        // --- Input Data Karyawan ---
        double nilaiKinerja = 0;
        double lamaBekerja = 0;
        double gajiPokok = 0;
        String sertifikasi;
        boolean valid = false;

        //Validasi input agar angka yang dimasukkan benar
        while (!valid) {
            try {
                System.out.print("Masukkan nilai kinerja (1-100): ");
                nilaiKinerja = Double.parseDouble(input.nextLine());

                if (nilaiKinerja < 1 || nilaiKinerja > 100) {
                    System.out.println("Nilai kinerja harus antara 1 dan 100.\n");
                    continue;
                }

                System.out.print("Masukkan lama bekerja (dalam tahun): ");
                lamaBekerja = Double.parseDouble(input.nextLine());

                if (lamaBekerja < 0) {
                    System.out.println("Lama bekerja tidak boleh negatif.\n");
                    continue;
                }

                System.out.print("Masukkan gaji pokok (Rp): ");
                gajiPokok = Double.parseDouble(input.nextLine());

                if (gajiPokok <= 0) {
                    System.out.println("Gaji pokok harus lebih dari 0.\n");
                    continue;
                }

                valid = true; // semua input valid
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Harap masukkan angka yang benar.\n");
            }
        }

        // Input status sertifikasi profesional
        System.out.print("Apakah memiliki sertifikasi profesional? (ya/tidak): ");
        sertifikasi = input.nextLine().trim().toLowerCase();

        // --- Proses Perhitungan Bonus ---
        double bonusPersentase = 0; // persen bonus dari gaji pokok
        double bonus = 0;            // nilai bonus awal (tanpa sertifikasi)
        double bonusTambahan = 0;    // bonus tambahan sertifikasi (jika ada)
        double totalBonus = 0;       // total keseluruhan bonus

        // a. Jika nilai kinerja di bawah 70 → tidak dapat bonus
        if (nilaiKinerja < 70) {
            bonus = 0;
            System.out.println("\nKaryawan tidak mendapatkan bonus karena nilai kinerja di bawah 70.");
        } 
        // b. Jika nilai kinerja 70–89 → bonus sesuai lama bekerja
        else if (nilaiKinerja >= 70 && nilaiKinerja < 90) {
            if (lamaBekerja < 2) {
                bonusPersentase = 0.01; // 1%
            } else if (lamaBekerja < 5) {
                bonusPersentase = 0.03; // 3%
            } else {
                bonusPersentase = 0.05; // 5%
            }
            bonus = gajiPokok * bonusPersentase;
        } 
        // c. Jika nilai kinerja 90 ke atas → bonus lebih tinggi
        else if (nilaiKinerja >= 90) {
            if (lamaBekerja < 2) {
                bonusPersentase = 0.02; // 2%
            } else if (lamaBekerja < 5) {
                bonusPersentase = 0.04; // 4%
            } else {
                bonusPersentase = 0.07; // 7%
            }
            bonus = gajiPokok * bonusPersentase;
        }

        // d. Bonus tambahan sertifikasi hanya diberikan jika sudah memenuhi syarat bonus
        if (bonus > 0 && sertifikasi.equalsIgnoreCase("ya")) {
            bonusTambahan = 500000; // Rp 500.000
        }

        // Total bonus
        totalBonus = bonus + bonusTambahan;

        // --- Tampilkan Hasil ---
        System.out.println("\n===== HASIL PERHITUNGAN BONUS =====");
        System.out.println("Nilai kinerja  : " + nilaiKinerja);
        System.out.println("Lama bekerja   : " + lamaBekerja + " tahun");
        System.out.println("Gaji pokok     : Rp " + String.format("%,.0f", gajiPokok));
        System.out.println("Sertifikasi    : " + (sertifikasi.equalsIgnoreCase("ya") ? "Ya" : "Tidak"));
        System.out.println("------------------------------------");

        // Rincian bonus
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

        input.close();
    }
}
    
     