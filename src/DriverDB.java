
import java.sql.SQLException;
import java.util.ArrayList;
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
        Database db = new Database("db_PBO_Tubes", "root", "2354");
        db.connect();
        ArrayList<Member> listMember = new ArrayList<>();
        try {
            Member m;
//            db.addMember(m);
//            m = new Member("andrids", "1111", "Andri Dhika", 21);
//            db.addMember(m);
            listMember = db.loadMember();
            for (Member listMember1 : listMember) {
                System.out.println(listMember1.toString());
            }
//        db.deleteMember(listMember.get(0));
//            m = listMember.get(0);
//            m.setNama("CIACIA");
//            db.updateMember(m);

//            m = db.searchMember("andrids");
//            System.out.println(m.toString());

            Lapangan l = new Vinyl(69, 69);
            db.addLapangan(l);
            
            ArrayList<Lapangan> listLapangan = db.loadLapangan();
            for (Lapangan listLapangan1 : listLapangan) {
                System.out.println(listLapangan1.getId_lapangan());
                System.out.println(listLapangan1.toString());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
//        m.setNama("Hilda");
//        db.updateMember(m, 3);
//        listMember = db.searchMember("hilda");
//        System.out.println("Hasil Pencarian hilda");
//        for (Member listMember1 : listMember) {
//            System.out.println(listMember1.toString());   
//        }
//        Lapangan lap = new Sintetis(90, 220);
//        db.addLapangan(tf, lap);
//        ArrayList<Lapangan> listLapangan = db.loadLapangan(tf);
//        for (Lapangan listLapangan1 : listLapangan) {
//            System.out.println(listLapangan1.toString());
//        }

    }
}
