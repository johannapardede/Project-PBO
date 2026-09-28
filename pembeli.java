
public class pembeli {

    // Atribut
    private String namaPelanggan;
    private int noTelepon;
    private String kodePelanggan;


    // Constructor
    public pembeli(
        String namaPelanggan,
        int noTelepon,
        String kodePelanggan
    ) {
        this.namaPelanggan = namaPelanggan;
        this.noTelepon = noTelepon;
        this.kodePelanggan = kodePelanggan;
    }


    // Setter
    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public void setNoTelepon(int noTelepon) {
        this.noTelepon = noTelepon;
    }

    public void setKodePelanggan(String kodePelanggan) {
        this.kodePelanggan = kodePelanggan;
    }


    // Getter
    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public int getNoTelepon() {
        return noTelepon;
    }

    public String getKodePelanggan() {
        return kodePelanggan;
    }
}

