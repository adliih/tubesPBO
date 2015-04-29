
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

//		TempatFutsal tf = new TempatFutsal("Rajawali","Sukabirus");
//		tf.createLapangan(0,15,15);
//		tf.createLapangan(1,15,15);
//		
        Member m0 = new Member("vitoidi", "axiinside", "vito", 20);
        Member m1 = new Member("adliih", "rytyourth", "adli", 19);
        Admin a = new Admin("ferry", 23);
//		
//		tf.addMember(m0);
//		tf.addMember(m1);
//		int id = tf.searchMember(m0.getUsername());
//		tf.deleteMember(id);
//		System.out.println(tf.getMember(0).getUsername());
//		
//		
//		
//		tf.getLapangan(0).getJadwal(0,1).addPenyewa(m0);
//		tf.getLapangan(0).getJadwal(0,1).DP();
//		System.out.println(tf.getLapangan(0).getJadwal(0,1).getLogBook());
//		tf.getLapangan(1).getJadwal(0,1).addPenyewa(m1);
        int pil = -1;
        Orang orangAktif = null;
        TempatFutsal ivi = new TempatFutsal("Ivi", "Sukabirus");
        ivi.addMember(m1);
        ivi.addMember(m0);
        try {
            ivi.createLapangan(0, 100, 75);
            ivi.createLapangan(1, 100, 75);
            ivi.createLapangan(0, 100, 75);
            ivi.createLapangan(1, 100, 75);
            ivi.createLapangan(1, 100, 75);
            ivi.getLapangan(0).getJadwal(0, 0).addPenyewa(m0);
            ivi.getLapangan(0).getJadwal(0, 0).DP();
            ivi.getLapangan(0).getJadwal(3, 0).addPenyewa(m1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        do {
            System.out.println("Selamat Datang di Sisfo Lapangan " + ivi.getNama() + "\n" + ivi.getAlamat());
            try {
                viewMenuLogin();
                pil = inputAngka();
                if (pil < 0 || pil > 3) {
                    //Melemparkan eksepsi jika terjadi salah input
                    throw new InputMismatchException("Salah Input, Angka Harus Antara 0 - 3");
                }
                switch (pil) {
                    case 1:
                        orangAktif = (Admin) new Admin("Admin", 0);
                        break;
                    case 2:
                        orangAktif = (Member) new Member("username", "passowrd", "Member", 0);
                        break;
                    case 3:
                        orangAktif = (NonMember) new NonMember("Non Member", 0);
                        break;
                }
                if (orangAktif != null) {
                    do {
                        viewMenu(orangAktif);
                        pil = inputAngka();
                        if (pil < 0) {
                            //Melemparkan eksepsi jika terjadi salah input
                            orangAktif = null;
                            throw new InputMismatchException("Salah Input, Angka Harus Positif");
                        }
                        jalankanMenu(orangAktif, pil, ivi);
                    } while (pil != 0);
                    pil = -1;
                    orangAktif = null;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                pil = -1;
            }
        } while (pil != 0);
    }
    /*
     Fungsi untuk membuat pengecekan input user adalah angka
     */

    public static int inputAngka() {
        Scanner input = new Scanner(System.in);
        int x = -1;
        try {
            x = input.nextInt();
        } catch (InputMismatchException e) {
            //Melemparkan eksepsi jika terjadi salah input
            throw new InputMismatchException("Salah Input, Harus Angka");
        } finally {
            input = new Scanner(System.in);
        }
        return x;
    }

    /*
     Fungsi untuk membuat pengecekan input user adalah String
     */
    public static String inputString() {
        String x = "";
        Scanner input = new Scanner(System.in);
        x = input.nextLine();
        return x;
    }

    /*
     Menampilkan Menu Pilihan Jenis Login yang terdiri oleh Admin, Member, dan Non-Member
     */
    public static void viewMenuLogin() {
        System.out.println("Menu Login");
        System.out.println("0. Exit\n1. Admin\n2. Member\n3. Non - Member");
        System.out.print("Pilihan Login: ");
    }

    /*
     Menampilkan Menu yang dapat dilihat oleh User yang sedang aktif
     */
    public static void viewMenu(Orang orangAktif) {
        int wewenang = 0; //Pnenbtuan derajat wewenang user yang login
        if (orangAktif instanceof Admin) {
            wewenang = 3;
        } else if (orangAktif instanceof Member) {
            wewenang = 2;
        } else {
            wewenang = 1;
        }
        System.out.println("Menu");
        System.out.println("0. Exit");
        System.out.println("1. Melihat Jadwal");
        if (wewenang >= 2) {
            System.out.println("2. Memesan Jadwal ");
            System.out.println("3. Membatalkan Pemesanan");
        }
        if (wewenang == 3) {
            System.out.println("\n11. Lihat Member");
            System.out.println("12. Tambah Member");
            System.out.println("13. Hapus Member");
            System.out.println("14. Edit Member");
            System.out.println("15. Cari Member");
            System.out.println("\n21. Lihat Lapangan");
            System.out.println("22. Tambah Lapangan");
            System.out.println("23. Hapus Lapangan");
            System.out.println("24. Edit Lapangan");
            System.out.println("\n31. Set Penyewa");
            System.out.println("32. Ubah Status DP Penyewa");
            System.out.println("33. Hapus Penyewa");
        }
        System.out.print("Masukkan Pilihan: ");
    }

    /*
     Menjalakan menu sesuai wewenang ornag Aktif dan pilihan
     */
    public static void jalankanMenu(Orang orangAktif, int pil, TempatFutsal venue) {
        int wewenang = 0; //Pnenbtuan derajat wewenang user yang login
        if (orangAktif instanceof Admin) {
            wewenang = 3;
        } else if (orangAktif instanceof Member) {
            wewenang = 2;
        } else {
            wewenang = 1;
        }
        if (wewenang == 1) {
            switch (pil) {
                case 0:
                    pil = -1;
                    break;
                case 1:
                    System.out.print("Masukkan Nomor Lapangan: ");
                    int x = inputAngka();
                    viewJadwal(venue.getLapangan(x));
                    break;
                default:
                    throw new IllegalArgumentException("Salah Pilihan Menu");//Melempar eksepsi salah input
            }
        } else if (wewenang == 2) {
            switch (pil) {
                case 0:
                    pil = -1;
                    break;
                case 1:
                    System.out.print("Masukkan Nomor Lapangan: ");
                    int x = inputAngka();
                    viewJadwal(venue.getLapangan(x));
                    break;
                case 2:
                    System.out.print("Masukkan Nomor Lapangan: ");
                    int lap = inputAngka();
                    System.out.print("Masukkan Nomor Hari [0-6]: ");
                    int hari = inputAngka();
                    System.out.print("Masukkan Nomor Shift [0-16]: ");
                    int shift = inputAngka();
                    pesanJadwal((Member) orangAktif, venue.getLapangan(lap), hari, shift);
                    break;
                case 3:
                    System.out.print("Masukkan Nomor Lapangan: ");
                    lap = inputAngka();
                    System.out.print("Masukkan Nomor Hari [0-6]: ");
                    hari = inputAngka();
                    System.out.print("Masukkan Nomor Shift [0-16]: ");
                    shift = inputAngka();
                    batalPesan((Member) orangAktif, venue.getLapangan(lap), hari, shift);
                    break;
                default:
                    throw new IllegalArgumentException("Salah Pilihan Menu");//Melempar eksepsi salah input
            }
        } else {
            switch (pil) {
                case 0:
                    pil = -1;
                    break;
                case 1://View Jadwal
                    System.out.print("Masukkan Nomor Lapangan: ");
                    int x = inputAngka();
                    viewJadwal(venue.getLapangan(x));
                    break;
                case 3: //Membatalkan Pemesanan pada Lapangan tertentu. Hari dan shift tertentu
                    System.out.print("Masukkan Nomor Lapangan: ");
                    int lap = inputAngka();
                    System.out.print("Masukkan Nomor Hari [0-6]: ");
                    int hari = inputAngka();
                    System.out.print("Masukkan Nomor Shift [0-16]: ");
                    int shift = inputAngka();
                    batalPesan((Member) orangAktif, venue.getLapangan(lap), hari, shift);
                    break;
                case 11:
                    venue.viewMember(); //view member dari Lpangan futsal 
                    break;
                case 12:
                    /*
                     Input Atribut Yang Idbutuhkan Untuk Membuat Member
                     */
                    System.out.print("Masukkan Username Member: ");
                    String username = inputString();
                    System.out.print("Masukkan Password Member: ");
                    String password = inputString();
                    System.out.print("Masukkan Nama Member: ");
                    String nama = inputString();
                    System.out.print("Masukkan Umur Member: ");
                    int umur = inputAngka();
                    //Instansiasi member baru
                    Member newMember = new Member(username, password, nama, umur);
                    venue.addMember(newMember); //Add Member baru ke venue
                    break;
                case 13: //Hapus Member
                    System.out.print("Masukkan Username Member: ");
                    username = inputString();
                    int hasilCari = venue.searchMember(username);
                    if (hasilCari != -1) {
                        System.out.println("Member " + venue.getMember(hasilCari) + " Berhasil Dihapus");
                        venue.deleteMember(hasilCari); //Fungsi Menhapus Member
                    } else {
                        System.out.println("Member Tidak Ditemukan");
                    }
                    break;
                case 14: //Edit Member
                    System.out.print("Masukkan Username Member: ");
                    username = inputString();
                    hasilCari = venue.searchMember(username);
                    if (hasilCari != -1) {
                        //Bila Memeber Ditemukan
                        System.out.println("Member " + venue.getMember(hasilCari) + " Ditemukan");
                        System.out.print("Masukkan Username Baru Member: ");
                        username = inputString();
                        System.out.print("Masukkan Password Baru Member: ");
                        password = inputString();
                        System.out.print("Masukkan Nama Baru Member: ");
                        nama = inputString();
                        System.out.print("Masukkan Umur Baru Member: ");
                        umur = inputAngka();
                        editMember(venue.getMember(hasilCari), username, password, nama, umur);
                    } else {
                        System.out.println("Member Tidak Ditemukan");
                    }
                    break;
                case 15: //Cari Member
                    System.out.print("Masukkan Username Member: ");
                    username = inputString();
                    hasilCari = venue.searchMember(username);
                    if (hasilCari != -1) {
                        System.out.println("\nMember Ditemukan\n" + venue.getMember(hasilCari).toString());
                    } else {
                        System.out.println("Member Tidak Ditemukan");
                    }
                    break;
                case 21: //Lihat Lapangan
                    venue.viewLapangan();
                    break;
                case 22: //Tambah Lapangan
                    System.out.print("0: Sintetis\n1: Vinyl\nMasukkan Jenis Lapangan: ");
                    int jenis = inputAngka();
                    System.out.print("Masukkan Lebar Lapangan: ");
                    int lebar = inputAngka();
                    System.out.print("Masukkan Panjang Lapangan: ");
                    int panjang = inputAngka();
                    try {
                        venue.createLapangan(jenis, lebar, panjang);
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 23: //Hapus Lapangan
                    System.out.print("Masukkan Nomor Lapangan Yang Akan Dihapus: ");
                    int lapHapus = inputAngka();
                    venue.deleteLapangan(lapHapus);
                    break;
                case 24: //Edit Lapangan
                    System.out.print("Masukkan Nomor Lapangan Yang Akan Diedit: ");
                    int lapEdit = inputAngka();
                    System.out.print("Masukkan Lebar Lapangan Baru: ");
                    lebar = inputAngka();
                    System.out.print("Masukkan Panjang Lapangan Baru: ");
                    panjang = inputAngka();
                    try {
                        editLapangan(venue.getLapangan(lapEdit), lebar, panjang);
                    } catch (Exception e) {
                        throw e;
                    }
                    
                    break;
                case 31: //Set Penyewa
                    System.out.print("Masukkan Username Penyewa: "); 
                    Member penyewa = null;
                    try{
                        penyewa = venue.getMember(venue.searchMember(inputString()));
                    }catch (ArrayIndexOutOfBoundsException e){
                        throw new ArrayIndexOutOfBoundsException("Member Tidak Ditemukan");
                    }
                    System.out.print("Masukkan Nomor Lapangan: ");
                    int noLap = inputAngka();
                    System.out.print("Masukkan Nomor Hari [0-6]: ");
                    hari = inputAngka();
                    System.out.print("Masukkan Shift [0-16]: ");
                    shift = inputAngka();
                    try {
                        venue.getLapangan(noLap).getJadwal(hari, shift).addPenyewa(penyewa);
                    } catch (Exception e){
                        throw e;
                    }
                    break;
                case 32: //Ubah Status DP Penyewa
                    System.out.print("Masukkan Nomor Lapangan: ");
                    noLap = inputAngka();
                    System.out.print("Masukkan Nomor Hari [0-6]: ");
                    hari = inputAngka();
                    System.out.print("Masukkan Shift [0-16]: ");
                    shift = inputAngka();
                    try {
                        venue.getLapangan(noLap).getJadwal(hari, shift).DP();
                    } catch (Exception e){
                        throw e;
                    }
                    break;
                case 33: //Hapus Penyewa
                    System.out.print("Masukkan Nomor Lapangan: ");
                    noLap = inputAngka();
                    System.out.print("Masukkan Nomor Hari [0-6]: ");
                    hari = inputAngka();
                    System.out.print("Masukkan Shift [0-16]: ");
                    shift = inputAngka();
                    try {
                        venue.getLapangan(noLap).getJadwal(hari, shift).batal();
                    } catch (Exception e){
                        throw e;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Salah Pilihan Menu");//Melempar eksepsi salah input
            }
        }
    }

    /*
     Menampilkan Jadwal dari lapangan yang dipilih
     */
    public static void viewJadwal(Lapangan lap) {
        String x = "";
        for (int i = 0; i < 7; i++) {
            switch (i) {
                case 0:
                    x += "Minggu ";
                    break;
                case 1:
                    x += "Senin ";
                    break;
                case 2:
                    x += "Selasa ";
                    break;
                case 3:
                    x += "Rabu ";
                    break;
                case 4:
                    x += "Kamis ";
                    break;
                case 5:
                    x += "Jumat ";
                    break;
                case 6:
                    x += "Sabtu ";
                    break;
            }
            x += "\n";
            for (int j = 0; j < 17; j++) {
                x += "Pukul " + (j + 7) + ".00 " + lap.getJadwal(i, j).toString() + "\n";
            }
            x += "\n";
        }
        System.out.println(x);
    }

    /*
     Member memesan jadwal seesuai lapangan, hari dan shift
     Jadwal diisi oleh member.
     */
    public static void pesanJadwal(Member member, Lapangan lap, int hari, int shift) {
        try {
            lap.getJadwal(hari, shift).addPenyewa(member);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     Member membatalkan jadwal sesuai lapangan, hari dan shift berdasarkan keinginan member
     Member hanya dapat membatalkan pemesanan jika usernamenya sesuai.
     */
    public static void batalPesan(Member member, Lapangan lap, int hari, int shift) {
        if (lap.getJadwal(hari, shift).getPenyewa().getUsername() == member.getUsername()) {
            lap.getJadwal(hari, shift).batal();
        } else {
            throw new RuntimeException("Tidak dapat membatalakan pemesanan member lain");
        }

    }

    public static void editMember(Member member, String username, String password, String nama, int umur) {
        member.setNama(nama);
        member.setUsername(username);
        member.setUmur(umur);
        member.setPassword(password);
    }

    public static void editLapangan(Lapangan lap, double lebar, double panjang){
        lap.setLebar(lebar);
        lap.setPanjang(panjang);
    }
}
