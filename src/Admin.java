
public class Admin extends Orang {

    public Admin(String nama, int umur) {
        super(nama, umur);
    }

    @Override
    public String getStatus() {
        return "Admin";
    }
}
