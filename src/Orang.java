
public abstract class Orang {

    private String nama;
    private int umur;
    private int id_orang;

    
    public Orang(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }
    
    public int getId_orang() {
        return id_orang;
    }

    public void setId_orang(int id_orang) {
        this.id_orang = id_orang;
    }

    public abstract String getStatus();
}
