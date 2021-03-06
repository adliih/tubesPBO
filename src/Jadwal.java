
public class Jadwal {

    private Member penyewa = null;
    private boolean statusDP = false;
    protected String logBook = "LOGBOOK";
    private int id_jadwal;

    public void addPenyewa(Member member) {
        if (penyewa != null){
            throw new IllegalArgumentException("Jadwal Sudah Dipesan");
        }
        penyewa = member;
        logBook += "\nmember " + penyewa.getUsername() + " telah membooking lapangan";
    }

    public Member getPenyewa() {
        return penyewa;
    }

    public String getLogBook() {
        return logBook;
    }

    public int getId_jadwal() {
        return id_jadwal;
    }

    public void setId_jadwal(int id_jadwal) {
        this.id_jadwal = id_jadwal;
    }

    public void setPenyewa(Member penyewa) {
        this.penyewa = penyewa;
    }

    public void setStatusDP(boolean statusDP) {
        this.statusDP = statusDP;
    }
    
    
      
    /*
    Menampilkan Status Dari Lapangan (Tersedia/disewa/sudah dibooking)
    */
    @Override
    public String toString() {
        String x =  "";
        if (penyewa == null)
            x += "Tersedia";
        else{
            x += "Sudah dibooking a/n " + penyewa.getNama();
            if (statusDP){
                x+= " [Sudah DP]";
            }
        }
        return x;
        
    }

    public void DP() {
        this.statusDP = true;
        logBook += "\nmember " + penyewa.getUsername() + " telah membayar lapangan";
    }

    public void batal() {
        logBook += "\nmember " + penyewa.getUsername() + " telah membatal menyewa lapangan";
        statusDP = false;
        penyewa = null;
    }
}
