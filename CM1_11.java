import java.util.Scanner;
//Mengimpor class Scanner untuk mengambil input dari pengguna

public class CM1_11 {
    //Nama class utama, harus sama dengan nama file

    //Fungsi untuk menghitung nilai akhir berdasarkan bobot
    public static double hitungNilaiAkhir(double uts, double uas, double tugas) {
        //Rumus: 30% UTS + 40% UAS + 30% Tugas
        return (uts * 0.3) + (uas * 0.4) + (tugas * 0.3);
    }
    
    //Fungsi untuk mengubah nilai angka menjadi nilai huruf
    public static String konversiNilaiHuruf(double nilai) {
        //Menentukan nilai huruf berdasarkan kisaran nilai akhir
        if (nilai > 80) return "A";
        else if (nilai > 73) return "B+";
        else if (nilai >= 65) return "B";
        else if (nilai >= 60) return "C+";
        else if (nilai >= 50) return "C";
        else if (nilai >= 39) return "D";
        else return "E"; //Nilai paling rendah
    }

    //Fungsi untuk menentukan apakah mahasiswa lulus atau tidak
    public static String statusKelulusan(double nilaiAkhir) {
        //Jika nilai akhir >= 60 maka "LULUS", selain itu "TIDAK LULUS"
        return (nilaiAkhir >= 60) ? "LULUS" : "TIDAK LULUS";
    }

    //Fungsi utama (program dimuali dari sini)
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Mmembuat objek Scanner untuk input

        //Input data mahasiswa
        System.out.println("===== INPUT DATA MAHASISWA =====");
        System.out.print("Nama : ");
        String nama = input.nextLine();
        System.out.print("NIM  : ");
        String nim = input.nextLine();

        //Input nilai mata kuliah pertama
        System.out.println("\n---- Mata Kuliah 1: Algoritma dan Pemrograman ----");
        System.out.print("Nilai UTS   : ");
        double uts1 = input.nextDouble(); //Input nilai UTS mata kuliah 1
        System.out.print("Nilai UAS   : ");
        double uas1 = input.nextDouble(); //Input nilai UAS mata kuliah 1
        System.out.print("Nilai Tugas : ");
        double tugas1 = input.nextDouble(); //Input nilai tugas mata kuliah 1

        //  Input nilai mata kuliah kedua
        System.out.println("\n---- Mata Kuliah 2: Struktur Data ----");
        System.out.print("Nilai UTS   : ");
        double uts2 = input.nextDouble(); //Input nilai UTS mata kuliah 2
        System.out.print("Nilai UAS   : ");
        double uas2 = input.nextDouble(); //Input nilai UAS mata kuliah 2
        System.out.print("Nilai Tugas : ");
        double tugas2 = input.nextDouble(); //Input nilai tugas mata kuliah 2

        //Proses perhitungan nilai akhir untuk masing-masing mata kuliah
        double nilaiAkhir1 = hitungNilaiAkhir(uts1, uas1, tugas1); //Nilai akhir matkul 1
        double nilaiAkhir2 = hitungNilaiAkhir(uts2, uas2, tugas2); //Nilai akhir matkul 2

        //Mengonversi nilai angka menjadi huruf
        String huruf1 = konversiNilaiHuruf(nilaiAkhir1);
        String huruf2 = konversiNilaiHuruf(nilaiAkhir2);

        //Menentukan status kelulusan masing-masing mata kuliah
        String status1 = statusKelulusan(nilaiAkhir1);
        String status2 = statusKelulusan(nilaiAkhir2);

        //Menentukan rata-rata nilai akhir dari dua mata kuliah
        double rataRata = (nilaiAkhir1 + nilaiAkhir2) / 2;

        //Menentukan status kelulusan semester
        String statusSemester;
        if (status1.equals("LULUS") && status2.equals("LULUS")) { //Jika dua-duanya lulus
            if (rataRata >= 70) { //Jika rata-rata cukup tinggi
                statusSemester = "LULUS";
            } else {
                statusSemester = "TIDAK LULUS (Rata-rata < 70)";
            }
        } else {
            //Jika ada salah satu mata kuliah tidak lulus
            statusSemester = "TIDAK LULUS (Ada mata kuliah tidak lulus)";
        }
        
        System.out.println("\n======= HASIL PENILAIAN AKADEMIK =======");
        System.out.println("Nama : " + nama);
        System.out.println("NIM  : " + nim);
        System.out.println("------------------------------------------");
        System.out.println("Mata Kuliah\t\tUTS\tUAS\tTugas\tNilai Akhir\tHuruf\tStatus");
        
        //Menampilkan data hasil perhitungan mata kuliah 1 dan 2 dengan format tabel
        System.out.printf("Algoritma Pemrograman\t%.0f\t%.0f\t%.0f\t%.2f\t\t%s\t%s\n",
                uts1, uas1, tugas1, nilaiAkhir1, huruf1, status1);
        System.out.printf("Struktur Data\t\t%.0f\t%.0f\t%.0f\t%.2f\t\t%s\t%s\n",
                uts2, uas2, tugas2, nilaiAkhir2, huruf2, status2);
        System.out.println("------------------------------------------");
        System.out.printf("Rata-rata Nilai Akhir: %.2f\n", rataRata); //Menampilkan rata-rata
        System.out.println("Status Semester: " + statusSemester); //Menampilkan status akhir
        
        input.close(); //Menutup objek Scanner agar tidak terjadikebocoran memori
    }
}

    

