
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

    public void createLapangan(int x, double lebar, double panjang) {
        if (x == 0) {
            lapangan[nLap++] = new Sintetis(lebar, panjang);
        } else if (x == 1) {
            lapangan[nLap++] = new Vinyl(lebar, panjang);
        }
    }

    public Lapangan getLapangan(int id) {
        return lapangan[id];
    }

    public Member getMember(int id) {
        return member[id];
    }

    public void addMember(Member member) {
        this.member[nMember++] = member;
    }

    public int searchMember(String username) {
        int tmp = 0;
        for (int i = 0; i < nMember; i++) {
            if (member[i].getUsername() == username) {
                tmp = i;
            }
        }
        return tmp;
    }

    public void deleteMember(int id) {

        for (int j = id; j < nMember; j++) {
            member[j] = member[j + 1];
        }
        nMember--;

    }

    public void viewMember() {

        for (int i = 0; i < nMember; i++) {
            System.out.println((i + 1) + ". " + member[i].getUsername());
        }
    }
}