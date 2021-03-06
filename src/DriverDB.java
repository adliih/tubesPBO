
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.crypto.Data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author adliih
 */
public class DriverDB {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Database db = new Database("localhost/db_PBO_Tubes", "root", "2354");
        db.connect();
//        ArrayList<Member> listMember = new ArrayList<>();
//        Member m;
//        m = new Member("andrids", "1111", "Andri Dhika", 21);
//        listMember = db.loadMember();
//        for (Member listMember1 : listMember) {
//            System.out.println(listMember1.toString());
//        }
//        m = listMember.get(0);
//        Lapangan l = new Vinyl(69, 69);
        ArrayList<Lapangan> listLapangan = db.loadLapangan();
//        for (Lapangan listLapangan1 : listLapangan) {
//            System.out.println(listLapangan1.getId_lapangan());
//            System.out.println(listLapangan1.toString());
//            System.out.println(listLapangan1.getJadwal(0, 14).getPenyewa().toString());
//        }
//        FileIO fileIO = new FileIO();
//        try {
//            String[] dbSetup = fileIO.loadDatabaseSetup();
//            for (String dbSetup1 : dbSetup) {
//                System.out.println(dbSetup1);
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        
        viewJadwal(listLapangan.get(0));
    }
    
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
}
