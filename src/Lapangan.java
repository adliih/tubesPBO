
public abstract class Lapangan {

    private double lebar;
    private double panjang;
    private Jadwal[][] jadwal;
    private double harga;

    public Lapangan(double lebar, double panjang) {
        this.lebar = lebar;
        this.panjang = panjang;
        jadwal = new Jadwal[7][17];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 17; j++) {
                jadwal[i][j] = new Jadwal();
            }
        }
    }

    public void setLebar(double lebar) {
        this.lebar = lebar;
    }

    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public double getLebar() {
        return lebar;
    }

    public double getPanjang() {
        return panjang;
    }

    public Jadwal getJadwal(int hari, int shift) {
        Jadwal x = null;
        try {
            x = jadwal[hari][shift];
        } catch (ArrayIndexOutOfBoundsException e) {
            //Melempar Kesalahan akses indeks Array
            throw new ArrayIndexOutOfBoundsException("Kesalahan Akses Indeks Array Jadwal");
        }
        return x;
    }

    public abstract double getHarga();

}
