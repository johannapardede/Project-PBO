public class produk {

    // Atribut
    private String namaProduk;
    private double hargaProduk;
    private String jenisProduk;
    private int qty;


    // Constructor
    public produk(
        String namaProduk,
        double hargaProduk,
        String jenisProduk,
        int qty
    ) {
        this.namaProduk = namaProduk;
        this.hargaProduk = hargaProduk;
        this.jenisProduk = jenisProduk;
        this.qty = qty;
    }


    // Setter
    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public void setHargaProduk(double hargaProduk) {
        this.hargaProduk = hargaProduk;
    }

    public void setJenisProduk(String jenisProduk) {
        this.jenisProduk = jenisProduk;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }


    // Getter
    public String getNamaProduk() {
        return namaProduk;
    }

    public double getHargaProduk() {
        return hargaProduk;
    }

    public String getJenisProduk() {
        return jenisProduk;
    }

    public int getQty() {
        return qty;
    }
}

