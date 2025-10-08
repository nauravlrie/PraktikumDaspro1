import java.util.Scanner;

public class CM1_11 {

    public static double hitungNilaiAkhir(double uts, double uas, double tugas) {
        return (uts * 0.3) + (uas * 0.4) + (tugas * 0.3);
    }

    public static String konversiNilaiHuruf(double nilai) {
        if (nilai > 80) return "A";
        else if (nilai > 73) return "B+";
        else if (nilai >= 65) return "B";
        else if (nilai >= 60) return "C+";
        else if (nilai >= 50) return "C";
        else if (nilai >= 39) return "D";
        else return "E";
    }

    public static String statusKelulusan(double nilaiAkhir) {
        return (nilaiAkhir >= 60) ? "LULUS" : "TIDAK LULUS";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===== INPUT DATA MAHASISWA =====");
        System.out.print("Nama : ");
        String nama = input.nextLine();
        System.out.print("NIM  : ");
        String nim = input.nextLine();

        System.out.println("\n---- Mata Kuliah 1: Algoritma dan Pemrograman ----");
        System.out.print("Nilai UTS   : ");
        double uts1 = input.nextDouble();
        System.out.print("Nilai UAS   : ");
        double uas1 = input.nextDouble();
        System.out.print("Nilai Tugas : ");
        double tugas1 = input.nextDouble();

        System.out.println("\n---- Mata Kuliah 2: Struktur Data ----");
        System.out.print("Nilai UTS   : ");
        double uts2 = input.nextDouble();
        System.out.print("Nilai UAS   : ");
        double uas2 = input.nextDouble();
        System.out.print("Nilai Tugas : ");
        double tugas2 = input.nextDouble();

        double nilaiAkhir1 = hitungNilaiAkhir(uts1, uas1, tugas1);
        double nilaiAkhir2 = hitungNilaiAkhir(uts2, uas2, tugas2);

        String huruf1 = konversiNilaiHuruf(nilaiAkhir1);
        String huruf2 = konversiNilaiHuruf(nilaiAkhir2);

        String status1 = statusKelulusan(nilaiAkhir1);
        String status2 = statusKelulusan(nilaiAkhir2);

        double rataRata = (nilaiAkhir1 + nilaiAkhir2) / 2;

        String statusSemester;
        if (status1.equals("LULUS") && status2.equals("LULUS")) {
            if (rataRata >= 70) {
                statusSemester = "LULUS";
            } else {
                statusSemester = "TIDAK LULUS (Rata-rata < 70)";
            }
        } else {
            statusSemester = "TIDAK LULUS (Ada mata kuliah tidak lulus)";
        }
        
        System.out.println("\n======= HASIL PENILAIAN AKADEMIK =======");
        System.out.println("Nama : " + nama);
        System.out.println("NIM  : " + nim);
        System.out.println("------------------------------------------");
        System.out.println("Mata Kuliah\t\tUTS\tUAS\tTugas\tNilai Akhir\tHuruf\tStatus");
        System.out.printf("Algoritma Pemrograman\t%.0f\t%.0f\t%.0f\t%.2f\t\t%s\t%s\n",
                uts1, uas1, tugas1, nilaiAkhir1, huruf1, status1);
        System.out.printf("Struktur Data\t\t%.0f\t%.0f\t%.0f\t%.2f\t\t%s\t%s\n",
                uts2, uas2, tugas2, nilaiAkhir2, huruf2, status2);
        System.out.println("------------------------------------------");
        System.out.printf("Rata-rata Nilai Akhir: %.2f\n", rataRata);
        System.out.println("Status Semester: " + statusSemester);
        
        input.close();
    }
}

    

