
import java.util.*;

public class TempatFutsal {

    private String nama, alamat;
    private Lapangan lapangan[] = new Lapangan[5];
    private int nLap = 0;
    private int nMember = 0;
    private Member member[] = new Member[100];

    Scanner scan = new Scanner(System.in);

    public TempatFutsal(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getNLap() {
        return nLap;
    }
//    Membuat Lapangan Baru
//    1 = Lapangan Sintetis
//    2 = Lapangan Vinyl

    public void createLapangan(int x, double lebar, double panjang) {
        //Mencoba menambah array lapangan
        if (nLap < 5) {
            if (x == 0) {
                lapangan[nLap++] = new Sintetis(lebar, panjang);
            } else if (x == 1) {
                lapangan[nLap++] = new Vinyl(lebar, panjang);
            }
        } else {
            //Melempar Kesalahan Ketika nLap sudah maksimal
            throw new RuntimeException("Array Lapangan Sudah Penuh");
        }
    }

    /*
     Delete Lapangan akan mengganti isi lapangan pada id yang ditentukan dengan indeks selanjutnya.
     Proses akan berlanjut hingga akhir array lapangan
     Lapangan terakhir akan diisi dengan null dan jumlah lapangan akan dkurangi
     */
    public void deleteLapangan(int id) {
        if (id >= nLap || nLap < 0) {
            //Melempar Kesalahan akses indeks Array
            throw new ArrayIndexOutOfBoundsException("Kesalahan Akses Indeks Array Lapangan");
        }
        for (int j = id; j < (nLap - 1); j++) {
            lapangan[j] = lapangan[j + 1];
        }
        lapangan[--nLap] = null;
    }

    public Lapangan getLapangan(int id) {
        Lapangan lap = null;
        try {
            lap = lapangan[id];
        } catch (ArrayIndexOutOfBoundsException e) {
            //Melempar Kesalahan akses indeks Array
            throw new ArrayIndexOutOfBoundsException("Kesalahan Akses Indeks Array Lapangan");
        }
        return lap;
    }

    public void viewLapangan() {
        try {
            for (int i = 0; i < nLap; i++) {
                System.out.println("Lapangan " + i + ". " + lapangan[i].getClass().toString().substring(6) + " " + lapangan[i].getLebar() + " x " + lapangan[i].getPanjang() + " berharga " + lapangan[i].getHarga() + " per jam");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //Melempar Kesalahan akses indeks Array
            throw new ArrayIndexOutOfBoundsException("Kesalahan Akses Indeks Array Lapangan");
        }
    }

    public Member getMember(int id) {
        Member m = null;
        try {
            m = member[id];
        } catch (ArrayIndexOutOfBoundsException e) {
            //Melempar Kesalahan akses indeks Array
            throw new ArrayIndexOutOfBoundsException("Kesalahan Akses Indeks Array Member");
        }
        return m;
    }

    public void addMember(Member member) {
        if (nMember < 100) {
            this.member[nMember++] = member;
        } else {
            //Melempar Kesalahan Ketika nMember sudah maksimal
            throw new RuntimeException("Array Member Sudah Penuh");
        }
    }

    /*
     Fungsi mencari member berdasarkan username
     Mengembalikan indeks member jika ditemukan
     Mengembalikan -1 jika member tidak ditemukan
     */
    public int searchMember(String username) {
        int tmp = -1;
        for (int i = 0; i < nMember; i++) {
            if (member[i].getUsername().equals(username)) {
                tmp = i;
                break;  //Menghentikan loop agar tidak terlalu lama
            }
        }
        return tmp;
    }
    /*
     Menghapus member berdasarkan id yang dimasukkan
     */

    public void deleteMember(int id) {
        try {
            for (int j = id; j < nMember - 1; j++) {
                member[j] = member[j + 1];
            }
            member[nMember--] = null;
        } catch (ArrayIndexOutOfBoundsException e) {
            //Melempar Kesalahan akses indeks Array
            throw new ArrayIndexOutOfBoundsException("Kesalahan Akses Indeks Array Member");
        }
    }

    public void viewMember() {
        try {
            for (int i = 0; i < nMember; i++) {
                System.out.println((i + 1) + ". " + member[i].getUsername());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //Melempar Kesalahan akses indeks Array
            throw new ArrayIndexOutOfBoundsException("Kesalahan Akses Indeks Array Member");
        }

    }
}
