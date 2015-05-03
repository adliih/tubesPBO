
import java.util.*;

public class TempatFutsal {

    private String nama, alamat;
    private ArrayList<Lapangan> listLapangan = new ArrayList<>();
    private ArrayList<Member> listMember = new ArrayList<>();
    private int id_tempat_futsal;

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

    public int getId_tempat_futsal() {
        return id_tempat_futsal;
    }

    public void setId_tempat_futsal(int id_tempat_futsal) {
        this.id_tempat_futsal = id_tempat_futsal;
    }
    
    public int getJumlahLapangan(){
        return listLapangan.size();
    }
    
    public int getJumlahMember(){
        return listMember.size();
    }

    public void setListLapangan(ArrayList<Lapangan> listLapangan) {
        this.listLapangan = listLapangan;
    }

    public void setListMember(ArrayList<Member> listMember) {
        this.listMember = listMember;
    }
    
//    Membuat Lapangan Baru
//    0 = Lapangan Sintetis
//    1 = Lapangan Vinyl
    public void createLapangan(int x, double lebar, double panjang) {
        //Mencoba menambah array lapangan
        if (x == 0) {
            listLapangan.add(new Sintetis(lebar, panjang));
        } else if (x == 1) {
            listLapangan.add(new Vinyl(lebar, panjang));
        }
    }

    /*
     Delete Lapangan akan mengganti isi lapangan pada id yang ditentukan dengan indeks selanjutnya.
     Proses akan berlanjut hingga akhir array lapangan
     Lapangan terakhir akan diisi dengan null dan jumlah lapangan akan dkurangi
     */
    public void deleteLapangan(int id) {
        if (id >= listLapangan.size() || listLapangan.isEmpty()) {
            //Melempar Kesalahan akses indeks Array
            throw new ArrayIndexOutOfBoundsException("Kesalahan Akses Indeks Array Lapangan");
        }
        listLapangan.remove(id);
    }

    public Lapangan getLapangan(int id) {
        Lapangan lap = null;
        try {
            lap = listLapangan.get(id);
        } catch (ArrayIndexOutOfBoundsException e) {
            //Melempar Kesalahan akses indeks Array
            throw new ArrayIndexOutOfBoundsException("Kesalahan Akses Indeks Array Lapangan");
        }
        return lap;
    }

    public void viewLapangan() {
        try {
            for (Lapangan listLapangan1 : listLapangan) {
                System.out.println(listLapangan1.toString());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //Melempar Kesalahan akses indeks Array
            throw new ArrayIndexOutOfBoundsException("Kesalahan Akses Indeks Array Lapangan");
        }
    }

    public Member getMember(int id) {
        Member m = null;
        try {
            m = listMember.get(id);
        } catch (ArrayIndexOutOfBoundsException e) {
            //Melempar Kesalahan akses indeks Array
            throw new ArrayIndexOutOfBoundsException("Kesalahan Akses Indeks Array Member");
        }
        return m;
    }

    public void addMember(Member member) {
        listMember.add(member);
    }

    /*
     Fungsi mencari member berdasarkan username
     Mengembalikan indeks member jika ditemukan
     Mengembalikan -1 jika member tidak ditemukan
     */
    public int searchMember(String username) {
        int tmp = -1;
        for (Member listMember1 : listMember) {
            tmp++;
           if (listMember1.getUsername().equals(username)) {
                break;  //Menghentikan loop agar tidak terlalu lama
            }
        }
        return tmp;
    }
    /*
     Menghapus member berdasarkan id yang dimasukkan
     */

    public void deleteMember(int id) {
        if (id >= listMember.size() || listMember.isEmpty()) {
            //Melempar Kesalahan akses indeks Array
            throw new ArrayIndexOutOfBoundsException("Kesalahan Akses Indeks Array Lapangan");
        }
        listMember.remove(id);
    }

    public void viewMember() {
        try {
            for (Member listMember1 : listMember) {
                System.out.println(listMember1.toString());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //Melempar Kesalahan akses indeks Array
            throw new ArrayIndexOutOfBoundsException("Kesalahan Akses Indeks Array Member");
        }

    }
}
