
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
    private String dbuser,dbpass,dbname;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet = null;

    public Database(String dbname, String dbuser, String dbpass) {
        this.dbuser = dbuser;
        this.dbpass = dbpass;
        this.dbname = dbname;
    }
    
    public void connect() throws SQLException, ClassNotFoundException{
        connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbname, dbuser, dbpass);
        statement = connection.createStatement();
    }
    
    public Member loginMember(String username, String password) throws SQLException{
        Member m = null;
        String sql = "SELECT * FROM member WHERE username = '" + username + "' AND password = PASSWORD('" + password + "')";
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            m = new Member (resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("nama"), resultSet.getInt("umur"));
        }
        return m;
    }
    public void addMember(Member m) throws SQLException{
        String sql = "INSERT INTO member VALUES (NULL, TRUE, '" + m.getNama() + "' , " + m.getUmur() + " , '" + m.getUsername() +"', PASSWORD('" + m.getPassword() + "'))";
        statement.execute(sql);
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
    
    public void updateMember(Member m) throws SQLException{
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
            listLapangan.add(lap);
        }
        return listLapangan;
    }
    
    public void addLapangan( Lapangan e) throws SQLException{
        Boolean isVinyl;
        if (e instanceof Vinyl){
            isVinyl = true;
        } else {
            isVinyl = false;
        }
        String sql;
        sql = "INSERT INTO lapangan VALUES (NULL, " + isVinyl + ", " + e.getLebar()  + ", " + e.getPanjang() + ")";
        statement.execute(sql);        
    }
    
    
}
