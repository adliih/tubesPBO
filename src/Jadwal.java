
public class Jadwal {

    private Member penyewa;
    private boolean statusDP = false;
    protected String logBook = "LOGBOOK";

    public void addPenyewa(Member member) {
        if (penyewa != null){
            throw new IllegalArgumentException("Jadwal Sudah Dipesan");
        }
        penyewa = member;
        logBook += "\nmember " + penyewa.getUsername() + " telah membooking lapangan";
    }

    public Member getPenyewa() {
        if (penyewa == null){
            throw new IllegalArgumentException("Jadwal Masih Belum Disewa"); 
        }
        return penyewa;
    }

    public String getLogBook() {
        return logBook;
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
