import java.util.Scanner;
import java.util.Arrays;

public class SoalUtsmenentukan3angkaterbesar11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input angka dari pengguna
        System.out.print("Masukkan angka pertama: ");
        String input1 = input.nextLine();

        System.out.print("Masukkan angka kedua: ");
        String input2 = input.nextLine();

        System.out.print("Masukkan angka ketiga: ");
        String input3 = input.nextLine();

        double angka1, angka2, angka3;

        // Validasi input 
        if (isNumeric(input1) && isNumeric(input2) && isNumeric(input3)) {
            angka1 = Double.parseDouble(input1);
            angka2 = Double.parseDouble(input2);
            angka3 = Double.parseDouble(input3);

            // Menentukan angka terbesar 
            double terbesar = angka1;
            if (angka2 > terbesar) {
                terbesar = angka2;
            } else if (angka3 > terbesar) {
                terbesar = angka3;
            }

            // Mengurutkan angka dari kecil ke besar
            double[] urutan = {angka1, angka2, angka3};
            Arrays.sort(urutan);

            // Menghitung jumlah angka yang sama dengan terbesar
            int jumlahTerbesar = 0;
            String daftarTerbesar = "";

            if (angka1 == terbesar) {
                jumlahTerbesar++;
                daftarTerbesar += angka1 + " ";
            }
            if (angka2 == terbesar) {
                jumlahTerbesar++;
                daftarTerbesar += angka2 + " ";
            }
            if (angka3 == terbesar) {
                jumlahTerbesar++;
                daftarTerbesar += angka3 + " ";
            }

            // Menampilkan hasil
            System.out.println("\n===== HASIL =====");
            System.out.println("Urutan angka dari terkecil ke terbesar: "
                    + urutan[0] + ", " + urutan[1] + ", " + urutan[2]);

            if (jumlahTerbesar == 1) {
                System.out.println("Angka terbesar adalah: " + terbesar);
            } else if (jumlahTerbesar > 1) {
                System.out.println("Ada beberapa angka terbesar, yaitu: " + daftarTerbesar);
            } else {
                System.out.println("Tidak ada angka terbesar (semua nol).");
            }
        } 
        else {
            // Jika salah satu input bukan angka
            System.out.println("\nInput tidak valid! Harap masukkan angka yang benar.");
        }

        input.close();
    }

    // membantu untuk mengecek apakah input bisa dikonversi ke angka
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}