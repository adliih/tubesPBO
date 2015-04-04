
public class NonMember extends Orang {

    public NonMember(String nama, int umur) {
        super(nama, umur);
    }

    @Override
    public String getStatus() {
        return "Non Member";
    }
}
