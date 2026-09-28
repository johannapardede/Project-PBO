public class kasir {

    // Atribut
    private String namaKasir;
    private String noTelepon;


    // Constructor
    public kasir(String namaKasir, String noTelepon) {
        this.namaKasir = namaKasir;
        this.noTelepon = noTelepon;
    }


    // Setter
    public void setNamaKasir(String namaKasir) {
        this.namaKasir = namaKasir;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }


    // Getter
    public String getNamaKasir() {
        return namaKasir;
    }

    public String getNoTelepon() {
        return noTelepon;
    }
}

