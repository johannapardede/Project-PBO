public class App {
    public static void main(String[] args) throws Exception {
        makeup makeup = new makeup("Lipstick", 75000, "Lip Product", 2);
        skincare skincare = new skincare("Facial Wash", 50000, "Cleanser", 1);
        kasir kasir = new kasir("Kania", "08123456789");
        pembeli pembeli = new pembeli("Salsa", 812345678, "P001");

        transaksi transaksi = new transaksi("TR001", "28-09-2026", pembeli.getNamaPelanggan(), kasir.getNamaKasir(), pembeli.getKodePelanggan(), 600000);

        // HEADER TOKO DI PALING ATAS
        System.out.println("=========================================================");
        System.out.println("                       " + struk.HEADER_KLINIK);
        System.out.println("             " + struk.NAMA_PT);
        System.out.println("  " + struk.ALAMAT_KLINIK);
        System.out.println("                " + struk.TELP_KLINIK);
        System.out.println("=========================================================");

        // DETAIL ITEM BELANJA
        System.out.println("                   RINCIAN PRODUK                        ");
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-16s : %s%n", "Nama Makeup", makeup.getNamaProduk());
        System.out.printf("%-16s : Rp %,.0f%n", "Harga", makeup.getHargaProduk());
        System.out.printf("%-16s : %s%n", "Jenis", makeup.getJenisMakeup());
        System.out.printf("%-16s : %d pcs%n", "Jumlah", makeup.getQty());
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-16s : %s%n", "Nama Skincare", skincare.getNamaProduk());
        System.out.printf("%-16s : Rp %,.0f%n", "Harga", skincare.getHargaProduk());
        System.out.printf("%-16s : %s%n", "Jenis", skincare.getJenisSkincare());
        System.out.printf("%-16s : %d pcs%n", "Jumlah", skincare.getQty());
        System.out.println("=========================================================\n");

        // CEK PROMO
        transaksi.cekPromo("Senin");

        // CETAK STRUK FINAL
        transaksi.cetakBarisStruk();
    }
}