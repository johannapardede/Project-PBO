
public class makeup extends produk {
    // Atribut
    private String jenisMakeup;

    // Constructor
    public makeup(
        String namaProduk,
        double hargaProduk,
        String jenisMakeup,
        int qty
    ) {
        super(namaProduk, hargaProduk, "Makeup", qty);
        this.jenisMakeup = jenisMakeup;
    }

    // Setter
    public void setJenisMakeup(String jenisMakeup) {
        this.jenisMakeup = jenisMakeup;
    }

    // Getter
    public String getJenisMakeup() {
        return jenisMakeup;
    }
}
