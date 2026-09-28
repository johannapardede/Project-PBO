
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class transaksi implements struk {

    // Atribut
    private String noReceipt;
    private String tanggal;
    private String namaPelanggan;
    private String namaKasir;
    private String kodePelanggan;
    private int totalHarga;


    // Constructor
    public transaksi(
        String tanggal,
        String namaPelanggan,
        String namaKasir,
        String kodePelanggan,
        int totalHarga
    ) {

        // Membuat nomor receipt otomatis
        SimpleDateFormat formatTanggal =
            new SimpleDateFormat("yyyyMMddHHmmss");

        this.noReceipt = "NSC-" + formatTanggal.format(new Date());
        this.tanggal = tanggal;
        this.namaPelanggan = namaPelanggan;
        this.namaKasir = namaKasir;
        this.kodePelanggan = kodePelanggan;
        this.totalHarga = totalHarga;
    }


    // Setter
    public void setNoReceipt(String noReceipt) {
        this.noReceipt = noReceipt;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public void setNamaKasir(String namaKasir) {
        this.namaKasir = namaKasir;
    }

    public void setKodePelanggan(String kodePelanggan) {
        this.kodePelanggan = kodePelanggan;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }


    // Getter
    public String getNoReceipt() {
        return noReceipt;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public String getNamaKasir() {
        return namaKasir;
    }

    public String getKodePelanggan() {
        return kodePelanggan;
    }

    public int getTotalHarga() {
        return totalHarga;
    }


    // Method untuk membuat format angka
    private String formatAngka(double angka) {
        DecimalFormat format = new DecimalFormat("#,##0");
        return format.format(angka).replace(',', '.');
    }


    // Method dari interface
    @Override
    public void cetakBarisStruk() {

    }
    // Method untuk mencetak struk
    public void cetakStrukLengkap(
        ArrayList<produk> daftarProduk,
        String hari
    ) 
    {

        double totalSubtotal = 0;
        double totalDiskon = 0;

        StringBuilder struk = new StringBuilder();


        // HEADER STRUK
        struk.append("                   " + HEADER_KLINIK + "\n");
        struk.append("            " + NAMA_PT + "\n");
        struk.append("  " + ALAMAT_KLINIK + "\n");
        struk.append( "             Kota Yogyakarta D.I Yogyakarta 55222\n" );

        struk.append("                    0025422336541000\n");
        struk.append("                 " + TELP_KLINIK + "\n\n" );
        // DATA TRANSAKSI
        struk.append(String.format("%-15s:%s%n","No. Receipt",noReceipt));

        struk.append(String.format("%-15s:%s%n","Tanggal",tanggal)
        );

        struk.append(
            String.format(
                "%-15s:%s%n",
                "Customer Code",
                kodePelanggan
            )
        );

        struk.append(
            String.format(
                "%-15s:%s%n",
                "Customer Name",
                namaPelanggan
            )
        );

        struk.append(
            String.format(
                "%-15s:%s%n",
                "Doctor",
                "dr. Dewi Lestari"
            )
        );

        struk.append(
            String.format(
                "%-15s:%s [ E ]%n",
                "Cashier",
                namaKasir
            )
        );

        struk.append(
            String.format(
                "%-15s:%s%n",
                "PA",
                ""
            )
        );

        struk.append(
            String.format(
                "%-15s:%s%n",
                "Comment",
                "ROSE"
            )
        );

        struk.append(
            "=================================================\n"
        );


        // DATA PRODUK
        int nomor = 1;

        for (produk p : daftarProduk) {

            double subtotal =
                p.getHargaProduk() * p.getQty();

            double diskon = 0;


            // Diskon hari Senin dan Rabu
            if (hari.equalsIgnoreCase("Senin") ||
                hari.equalsIgnoreCase("Rabu")) {

                diskon = subtotal * 0.05;
            }


            totalSubtotal =
                totalSubtotal + subtotal;

            totalDiskon =
                totalDiskon + diskon;


            // Menentukan jenis produk
            String jenis = "";

            if (p instanceof makeup) {

                makeup m = (makeup) p;
                jenis = m.getJenisMakeup();

            } else if (p instanceof skincare) {

                skincare s = (skincare) p;
                jenis = s.getJenisSkincare();

            } else {

                jenis = p.getJenisProduk();
            }


            // Menampilkan produk
            struk.append(
                String.format(
                    "%2d. %-15s %d.00 Pcs     %10s*%n",
                    nomor,
                    p.getNamaProduk().toUpperCase(),
                    p.getQty(),
                    formatAngka(subtotal)
                )
            );

            struk.append(
                String.format(
                    "    %-25s%n",
                    jenis
                )
            );


            // Menampilkan diskon
            if (diskon > 0) {

                struk.append(
                    String.format(
                        "    %-20s     -%10s%n",
                        "Disc 5.00%",
                        formatAngka(diskon)
                    )
                );
            }

            nomor++;
        }


        // Menghitung total belanja
        double totalBelanja =
            totalSubtotal - totalDiskon;


        // Gift pouch jika belanja minimal 500.000
        if (totalSubtotal >= 500000) {

            struk.append(
                String.format(
                    "%2d. %-15s 1.00 Pcs     %10s*%n",
                    nomor,
                    "GIFT POUCH NATASHA",
                    "0"
                )
            );

            struk.append(
                String.format(
                    "    %-25s%n",
                    "FREE GIFT MIN BELANJA 500K"
                )
            );

            struk.append(
                String.format(
                    "    %-20s     -%10s%n",
                    "Disc 100.00%",
                    "0"
                )
            );
        }


        // TOTAL
        struk.append(
            "-------------------------------------------------\n"
        );

        struk.append(
            String.format(
                "%-30s %14s%n%n",
                "TOTAL (include tax)",
                formatAngka(totalBelanja)
            )
        );

        struk.append(
            String.format(
                "%-30s %14d%n",
                "Sales Discount",
                0
            )
        );

        struk.append(
            String.format(
                "%-30s %14d%n",
                "Rounding",
                0
            )
        );

        struk.append(
            String.format(
                "%-30s %14s%n%n",
                "AMOUNT DUE",
                formatAngka(totalBelanja)
            )
        );

        struk.append(
            String.format(
                "%-30s %14s%n",
                "EDC BCA",
                formatAngka(totalBelanja)
            )
        );

        struk.append(
            "-------------------------------------------------\n"
        );


        // TAX
        double hargaJualObat =
            totalBelanja / 1.11;

        double ppnObat =
            totalBelanja - hargaJualObat;


        struk.append("Obat / Cream\n");

        struk.append(
            String.format(
                "   %-27s %14s%n",
                "Harga Jual",
                formatAngka(hargaJualObat)
            )
        );

        struk.append(
            String.format(
                "   %-27s %14s%n%n",
                "PPN",
                formatAngka(ppnObat)
            )
        );


        struk.append("Jasa Klinik / Medik\n");

        struk.append(
            String.format(
                "   %-27s %14d%n",
                "Harga Jual",
                0
            )
        );

        struk.append(
            String.format(
                "   %-27s %14d%n",
                "PPN",
                0
            )
        );

        struk.append(
            "(PPN Dibebaskan - PP Nomor 49 Tahun 2022)\n"
        );

        struk.append(
            "-------------------------------------------------\n"
        );


        // POIN
        struk.append(
            "Cashback (POIN) : Rp. 31.000\n\n"
        );

        struk.append(
            "Saldo Poin : 1641\n"
        );

        struk.append(
            "Saldo DP   : 0\n\n"
        );


        // FOOTER
        struk.append(
            "      " + Footer_1 + "\n"
        );

        struk.append(
            "            " + Footer_2 + "\n\n"
        );

        struk.append(
            String.format(
                "%45s%n",
                "07:17:34/" + tanggal
            )
        );


        // Menampilkan struk
        System.out.println(struk.toString());


        // Menyimpan struk ke file
        simpanKeFile(struk.toString());
    }


    // Method untuk menyimpan struk
    private void simpanKeFile(String isiStruk) {

        try {

            PrintWriter writer =
                new PrintWriter(
                    new FileWriter(
                        "struk_transaksi.txt",
                        true
                    )
                );

            writer.println(isiStruk);

            writer.println(
                "\n=================================================================\n"
            );

            writer.close();

            System.out.println(
                "Data transaksi berhasil disimpan ke file."
            );

        } catch (IOException e) {

            System.out.println(
                "Gagal menyimpan data transaksi."
            );
        }
    }
}

