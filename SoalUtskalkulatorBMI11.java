import java.util.Scanner;
import java.text.DecimalFormat;

public class SoalUtskalkulatorBMI11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== KALKULATOR BMI (Body Mass Index) ===");
        System.out.println("Masukkan berat badan dalam kilogram (kg) dan tinggi badan dalam meter (m).");

        // menginput berat dan tinggi badan
        System.out.print("Masukkan berat badan (kg): ");
        String inputBerat = scanner.nextLine();

        System.out.print("Masukkan tinggi badan (m): ");
        String inputTinggi = scanner.nextLine();

        // Validasi input 
        if (isNumeric(inputBerat) && isNumeric(inputTinggi)) {
            double berat = Double.parseDouble(inputBerat);
            double tinggi = Double.parseDouble(inputTinggi);

            if (berat <= 0 || tinggi <= 0) {
                System.out.println("\n❌ Nilai berat dan tinggi harus lebih besar dari 0.");
            } else {
                // menghitung BMI
                double bmi = calculateBMI(berat, tinggi);
                String bmiFormatted = formatDouble(bmi, 2);

                // menentukan kategori dan risiko menggunakan else if
                String kategori, risiko;

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

                // menampilkan hasil
                System.out.println("\n===== HASIL BMI =====");
                System.out.println("Berat badan : " + berat + " kg");
                System.out.println("Tinggi badan : " + tinggi + " m");
                System.out.println("Nilai BMI   : " + bmiFormatted);
                System.out.println("Kategori    : " + kategori);
                System.out.println(risiko);
            }
        } 
        else {
            System.out.println("\n❌ Input tidak valid! Harap masukkan angka (contoh: 60 atau 1.75).");
        }

        scanner.close();
    }

    // membantu mengecek apakah input bisa dikonversi menjadi angka
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // menghitung BMI
    private static double calculateBMI(double berat, double tinggi) {
        return berat / (tinggi * tinggi);
    }

    // menghitung format angka desimal
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
