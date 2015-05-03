
import java.sql.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adliih
 */
public class Database {
    private String dbuser,dbpass,dburl;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet = null;

    public Database(String dburl, String dbuser, String dbpass) {
        this.dbuser = dbuser;
        this.dbpass = dbpass;
        this.dburl = dburl;
    }
    
    public void connect() throws SQLException, ClassNotFoundException{
        connection = DriverManager.getConnection("jdbc:mysql://" + dburl, dbuser, dbpass);
        statement = connection.createStatement();
    }
    
    public void addMember(Member m) throws SQLException{
        String sql = "INSERT INTO member VALUES (NULL, TRUE, '" + m.getNama() + "' , " + m.getUmur() + " , '" + m.getUsername() +"', PASSWORD('" + m.getPassword() + "'))";
        statement.execute(sql);
    }
    
    public String encryptPassword(String password) throws SQLException{
        String pass = null;
        String sql = "SELECT PASSWORD('" + password + "') as pass FROM DUAL";
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            pass = resultSet.getString("pass");
        }
        return pass;
    }
    
    public ArrayList<Member> loadMember() throws SQLException{
        ArrayList<Member> listMember = new ArrayList<>();
        String sql;
        sql = "SELECT * FROM member WHERE isAktif";
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Member m = new Member (resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("nama"), resultSet.getInt("umur"));
            m.setId_orang(resultSet.getInt("id_member"));
            listMember.add(m);
        }
        return listMember;
    }
    
    public void deleteMember(Member m) throws SQLException {
        String sql;
        sql = "DELETE FROM member WHERE id_member = " + m.getId_orang();
        statement.execute(sql);
    }
    
    public void editMember(Member m) throws SQLException{
        String sql;
        sql = "UPDATE member SET username = '" + m.getUsername() +"', nama = '" + m.getNama() + "' , umur = " + m.getUmur() + "  WHERE id_member = " + m.getId_orang();
        statement.execute(sql);
    }
    
    public Member searchMember (String username) throws SQLException{
        Member hasil = null;
        String sql;
        sql = "SELECT * FROM member WHERE username = '" + username + "'";
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            hasil = new Member(resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("nama"), resultSet.getInt("umur"));
            hasil.setId_orang(resultSet.getInt("id_member"));
        }
        return hasil;
    }
    
    public ArrayList<Lapangan> loadLapangan() throws SQLException{
        ArrayList<Lapangan> listLapangan = new ArrayList<>();
        String sql;
        sql = "SELECT * FROM lapangan";
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Lapangan lap;
            if (resultSet.getBoolean("isVinyl")){
                lap = new Vinyl(resultSet.getFloat("lebar"), resultSet.getFloat("panjang"));
            } else {
                lap = new Sintetis(resultSet.getFloat("lebar"), resultSet.getFloat("panjang"));
            }
            lap.setId_lapangan(resultSet.getInt("id_lapangan"));
//            loadJadwalLapangan(lap);
            listLapangan.add(lap);
        }
        return listLapangan;
    }
    
    public void addLapangan( Lapangan e) throws SQLException{
        Boolean isVinyl = e instanceof Vinyl;
        String sql;
        sql = "INSERT INTO lapangan VALUES (NULL, " + isVinyl + ", " + e.getLebar()  + ", " + e.getPanjang() + ")";
        statement.execute(sql);        
    }
    
    public void deleteLapangan(Lapangan e) throws SQLException {
        String sql;
        sql = "DELETE FROM lapangan where id_lapangan = " + e.getId_lapangan();
        statement.execute(sql);
    }
    
    public void editLapangan(Lapangan e) throws SQLException{
        String sql;
        sql = "UPDATE lapangan SET lebar = " + e.getLebar() + ", panjang = " + e.getPanjang() + " WHERE id_lapangan = " + e.getId_lapangan();
        statement.execute(sql);
    }
    
    public void setPenyewa(int hari, int shift, Lapangan l, Member m) throws SQLException{
        String sql;
        sql = "INSERT INTO jadwal_lapangan VALUES ( " + l.getId_lapangan() + ", (SELECT id_jadwal FROM jadwal WHERE hari = " + hari + " AND shift = " + shift + ") , " + m.getId_orang() + ", FALSE)";
        statement.execute(sql);
    }
    
    public void changeDP(int hari, int shift, Lapangan l) throws SQLException{
        String sql;
        sql = "UPDATE jadwal_lapangan SET isDP = TRUE WHERE id_lapangan = " + l.getId_lapangan() + " AND id_jadwal = (SELECT id_jadwal FROM jadwal WHERE hari = " + hari + " AND shift = " + shift + ")";
        statement.execute(sql);
    }
    
    public void deletePenyewa(int hari, int shift, Lapangan l) throws SQLException{
        String sql;
        sql = "DELETE FROM jadwal_lapangan WHERE id_lapangan = " + l.getId_lapangan() + " AND id_jadwal = (SELECT id_jadwal FROM jadwal WHERE hari = " + hari + " AND shift = " + shift + ")";
        statement.execute(sql);
    }
    
    public void loadJadwalLapangan(TempatFutsal tf, Lapangan l) throws SQLException{
        String sql;
        sql =   "SELECT jadwal_lapangan.id_jadwal, jadwal_lapangan.isDP, jadwal.hari, jadwal.shift, member.username \n" +
                "FROM jadwal_lapangan \n" +
                "JOIN jadwal ON jadwal_lapangan.id_jadwal = jadwal.id_jadwal \n" +
                "JOIN member ON jadwal_lapangan.id_member = member.id_member\n" +
                "WHERE jadwal_lapangan.id_lapangan = " + l.getId_lapangan();
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int hari = resultSet.getInt("hari");
            int shift = resultSet.getInt("shift");
            String username = resultSet.getString("username");
            int id_jadwal = resultSet.getInt("id_jadwal");
            boolean isDP = resultSet.getBoolean("isDP");
            Member m = tf.getMember(tf.searchMember(username));
            l.getJadwal(hari, shift).setPenyewa(m);
//            l.getJadwal(hari, shift).setId_jadwal(id_jadwal);
            if (isDP){
                l.getJadwal(hari, shift).setStatusDP(true);
            }
        }        
    }
}