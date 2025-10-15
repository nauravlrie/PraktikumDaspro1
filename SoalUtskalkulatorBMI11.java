import java.util.Scanner;
import java.text.DecimalFormat; //untuk tinggi badan

public class SoalUtskalkulatorBMI11 {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== KALKULATOR BMI (Body Mass Index) ===");
        System.out.println("Masukkan berat badan dalam kilogram (kg) dan tinggi badan dalam meter (m).");

        double berat = readPositiveDouble(scanner, "Masukkan berat badan (kg): ");
        double tinggi = readPositiveDouble(scanner, "Masukkan tinggi badan (m): ");

        double bmi = calculateBMI(berat, tinggi);
        String bmiFormatted = formatDouble(bmi, 2);

        // Menentukan kategori dan risiko
        String kategori;
        String risiko;

        if (bmi < 18.5) {
            kategori = "Kurang berat badan (Underweight)";
            risiko = "Risiko kesehatan: Kekurangan gizi, osteoporosis, penurunan sistem kekebalan tubuh.";
        } else if (bmi < 25) { // 18.5 <= bmi < 25
            kategori = "Berat badan normal (Normal weight)";
            risiko = "Risiko kesehatan: Relatif rendah.";
        } else if (bmi < 30) { // 25 <= bmi < 30
            kategori = "Kelebihan berat badan (Overweight)";
            risiko = "Risiko kesehatan: Meningkatnya risiko penyakit jantung, diabetes, tekanan darah tinggi.";
        } else { // bmi >= 30
            kategori = "Obesitas (Obese)";
            risiko = "Risiko kesehatan: Risiko tinggi penyakit jantung, diabetes, tekanan darah tinggi, masalah pernapasan, dan beberapa jenis kanker.";
        }

        // Menampilkan hasil
        System.out.println("\n===== HASIL BMI =====");
        System.out.println("Berat badan : " + berat + " kg");
        System.out.println("Tinggi badan : " + tinggi + " m");
        System.out.println("Nilai BMI   : " + bmiFormatted);
        System.out.println("Kategori    : " + kategori);
        System.out.println(risiko);

        scanner.close();
    }

    /**
     * Membaca input double positif dari user. Akan mengulang sampai input valid (> 0).
     */
    private static double readPositiveDouble(Scanner scanner, String prompt) {
        double value = -1;
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Input kosong. Silakan masukkan nilai yang valid.");
                continue;
            }
            try {
                value = Double.parseDouble(line);
                if (Double.isNaN(value) || Double.isInfinite(value)) {
                    System.out.println("Input tidak valid. Masukkan angka yang benar.");
                    continue;
                }
                if (value <= 0) {
                    System.out.println("Nilai harus lebih besar dari 0. Coba lagi.");
                    continue;
                }
                break; // valid
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Harap masukkan angka (contoh: 60 atau 1.75).");
            }
        }
        return value;
    }

    /**
     * Menghitung BMI = berat(kg) / (tinggi(m) * tinggi(m))
     */
    private static double calculateBMI(double berat, double tinggi) {
        return berat / (tinggi * tinggi);
    }

    /**
     * Format angka desimal ke n desimal.
     */
    private static String formatDouble(double value, int decimals) {
        StringBuilder pattern = new StringBuilder("0");
        if (decimals > 0) {
            pattern.append(".");
            for (int i = 0; i < decimals; i++) pattern.append("0");
        }
        DecimalFormat df = new DecimalFormat(pattern.toString());
        return df.format(value);
    }
}
    

