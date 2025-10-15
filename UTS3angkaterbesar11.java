import java.util.Scanner;
import java.util.Arrays; //saya ingin mendapatkan urutannya juga sehingga saya menambahkan array 
 //untuk mengetahui urutan angka dari yang terkecil hingga terbesar

public class UTS3angkaterbesar11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double angka1 = 0, angka2 = 0, angka3 = 0;
        boolean valid = false;

        //Validasi input angka
        while (!valid) {
            try {
                System.out.print("Masukkan angka pertama: ");
                angka1 = Double.parseDouble(input.nextLine());

                System.out.print("Masukkan angka kedua: ");
                angka2 = Double.parseDouble(input.nextLine());

                System.out.print("Masukkan angka ketiga: ");
                angka3 = Double.parseDouble(input.nextLine());

                valid = true; // input valid
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Harap masukkan angka yang benar.\n");
            }
        }

        //Menentukan angka terbesar
        double terbesar = angka1;
        if (angka2 > terbesar) terbesar = angka2;
        if (angka3 > terbesar) terbesar = angka3;

        //Urutkan angka dari terkecil ke terbesar
        double[] urutan = {angka1, angka2, angka3};
        Arrays.sort(urutan);

        //Hitung berapa angka yang sama dengan nilai terbesar
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

        //Tampilkan hasil
        System.out.println("\n===== HASIL =====");
        System.out.println("Urutan angka dari terkecil ke terbesar: " +
                           urutan[0] + ", " + urutan[1] + ", " + urutan[2]);

        if (jumlahTerbesar == 1) {
            System.out.println("Angka terbesar adalah: " + terbesar);
        } else {
            System.out.println("Ada beberapa angka terbesar, yaitu: " + daftarTerbesar);
        }

        input.close();
    }
}
