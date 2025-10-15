import java.util.Scanner;

public class Menentukan3angkaterbesar11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            // Input tiga angka
            System.out.print("Masukkan angka pertama: ");
            int a = input.nextInt();
            System.out.print("Masukkan angka kedua: ");
            int b = input.nextInt();
            System.out.print("Masukkan angka ketiga: ");
            int c = input.nextInt();
            
            // Tentukan angka terbesar
            int terbesar = a;
            if (b > terbesar) terbesar = b;
            if (c > terbesar) terbesar = c;
            
            // Tampilkan angka terbesar
            System.out.println("Angka terbesar adalah: " + terbesar);
            
            // Cek jika ada dua atau lebih angka yang sama dan terbesar
            if ((a == terbesar && b == terbesar) || (a == terbesar && c == terbesar) || (b == terbesar && c == terbesar)) {
                System.out.println("Ada beberapa angka terbesar dan salah satunya adalah: " + terbesar);
            }
        } catch (Exception e) {
            System.out.println("Error: Masukkan hanya angka yang valid!");
        } finally {
            input.close();
        }
    }
}