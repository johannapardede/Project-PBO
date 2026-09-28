import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        // Membuat ArrayList untuk katalog
        ArrayList<produk> katalog = new ArrayList<produk>();

        // Membaca data dari file
        BufferedReader reader = new BufferedReader(
            new FileReader("katalog_produk.txt")
        );

        String baris;

        while ((baris = reader.readLine()) != null) {

            if (baris.trim().isEmpty()) {
                continue;
            }

            String[] data = baris.split(";");
            String kategori = data[0];
            String nama = data[1];
            double harga = Double.parseDouble(data[2]);
            String jenis = data[3];

            // Membuat object sesuai kategori
            if (kategori.equalsIgnoreCase("MAKEUP")) {

                makeup m = new makeup(nama, harga, jenis, 1);
                katalog.add(m);

            } else if (kategori.equalsIgnoreCase("SKINCARE")) {

                skincare s = new skincare(nama, harga, jenis, 1);
                katalog.add(s);
            }
        }

        reader.close();

        System.out.println("Data katalog berhasil dibaca.");


        // Input data kasir
        System.out.println("\n=== DATA TRANSAKSI ===");

        System.out.print("Nama Kasir     : ");
        String namaKasir = input.nextLine();

        // Membuat object kasir
        kasir k = new kasir(namaKasir, "");


        // Input data pelanggan
        System.out.print("Nama Pelanggan : ");
        String namaPelanggan = input.nextLine();

        System.out.print("Kode Pelanggan : ");
        String kodePelanggan = input.nextLine();

        // Membuat object pembeli
        pembeli p = new pembeli(
            namaPelanggan,
            0,
            kodePelanggan
        );


        // Menampilkan katalog
        System.out.println("\n======================================");
        System.out.println("          KATALOG PRODUK");
        System.out.println("======================================");

        for (int i = 0; i < katalog.size(); i++) {

            produk produk = katalog.get(i);

            System.out.println(
                (i + 1) + ". " +
                produk.getNamaProduk() +
                " - Rp " +
                produk.getHargaProduk()
            );
        }

        System.out.println("======================================");


        // Membuat keranjang belanja
        ArrayList<produk> keranjang = new ArrayList<produk>();


        // Memilih produk
        while (true) {

            System.out.print("\nPilih nomor produk (0 = selesai): ");
            int pilihan = input.nextInt();

            if (pilihan == 0) {

                if (keranjang.isEmpty()) {
                    System.out.println("Keranjang masih kosong.");
                    continue;
                }

                break;
            }


            if (pilihan > 0 && pilihan <= katalog.size()) {

                produk produkDipilih = katalog.get(pilihan - 1);

                System.out.println(
                    "Produk : " + produkDipilih.getNamaProduk()
                );

                System.out.print("Jumlah : ");
                int qty = input.nextInt();


                if (qty > 0) {

                    if (produkDipilih instanceof makeup) {

                        makeup m = (makeup) produkDipilih;

                        makeup produkBaru = new makeup(
                            m.getNamaProduk(),
                            m.getHargaProduk(),
                            m.getJenisMakeup(),
                            qty
                        );

                        keranjang.add(produkBaru);

                    } else if (produkDipilih instanceof skincare) {

                        skincare s = (skincare) produkDipilih;

                        skincare produkBaru = new skincare(
                            s.getNamaProduk(),
                            s.getHargaProduk(),
                            s.getJenisSkincare(),
                            qty
                        );

                        keranjang.add(produkBaru);
                    }

                    System.out.println("Produk berhasil ditambahkan.");

                } else {
                    System.out.println("Jumlah harus lebih dari 0.");
                }

            } else {
                System.out.println("Nomor produk tidak tersedia.");
            }
        }


        // Menghitung total harga
        int totalHarga = 0;

        for (produk produk : keranjang) {

            totalHarga +=
                produk.getHargaProduk() *
                produk.getQty();
        }


        // Input tanggal dan hari
        input.nextLine();

        System.out.println("\n=== DETAIL TRANSAKSI ===");

        System.out.print("Tanggal : ");
        String tanggal = input.nextLine();

        System.out.print("Hari    : ");
        String hari = input.nextLine();


        // Membuat object transaksi
        transaksi t = new transaksi(
            tanggal,
            p.getNamaPelanggan(),
            k.getNamaKasir(),
            p.getKodePelanggan(),
            totalHarga
        );


        // Mencetak struk
        System.out.println("\n");
        t.cetakStrukLengkap(keranjang, hari);


        input.close();
    }
}

