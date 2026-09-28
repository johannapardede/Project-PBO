public class skincare extends produk {

    // Atribut
    private String jenisSkincare;


    // Constructor
    public skincare(
        String namaProduk,
        double hargaProduk,
        String jenisSkincare,
        int qty
    ) {
        super(namaProduk, hargaProduk, "Skincare", qty);
        this.jenisSkincare = jenisSkincare;
    }


    // Setter
    public void setJenisSkincare(String jenisSkincare) {
        this.jenisSkincare = jenisSkincare;
    }


    // Getter
    public String getJenisSkincare() {
        return jenisSkincare;
    }
}

