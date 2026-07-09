# Oemah-Ku: Sistem Informasi Manajemen Asrama

Aplikasi "Oemah-Ku" adalah sebuah platform sistem informasi manajemen asrama terpadu berbasis antarmuka *Command Line Interface* (CLI) yang dibangun menggunakan bahasa pemrograman Java. Proyek ini dirancang untuk memenuhi tugas mata kuliah *Object Oriented Programming* (OOP) di Universitas Multimedia Nusantara (UMN). Keunggulan utama dari arsitektur sistem ini adalah pembangunannya yang dilakukan dari dasar (*from scratch*) dengan struktur data kustom, tanpa bergantung pada *library Java Collection Framework* bawaan.

## Fitur Utama

### 1. Modul Manajemen Kontrak
* **Validasi Otomatis:** Mengelola siklus kontrak sewa kamar secara dinamis dengan fitur validasi nomor kamar untuk mencegah terjadinya pemesanan ganda (*double booking*) oleh penghuni yang berbeda.
* **Operasi CRUD:** Mendukung penambahan, pembaruan durasi, serta penghapusan data kontrak secara efisien.

### 2. Modul Layanan Asrama (Dormi Services)
* **Manajemen Antrean:** Menangani tiket pengaduan keluhan fasilitas, permintaan *laundry*, pesanan pembersihan kamar, serta pelaporan *Lost and Found* secara terstruktur.
* **Pemrosesan Kronologis:** Sistem secara otomatis menyusun dan menyelesaikan permintaan berdasarkan urutan masuk pengajuan.

### 3. Modul Koperasi Mini (Kiosk)
* **Sistem POS Internal:** Berfungsi sebagai mesin kasir sederhana untuk memfasilitasi pembelian komoditas harian oleh penghuni asrama.
* **Fitur Pembatalan (Undo):** Menyediakan fleksibilitas bagi pengguna untuk membatalkan item barang terakhir yang dimasukkan ke dalam keranjang belanja tanpa merusak data lainnya.

### 4. Modul Konsolidasi Pembayaran Global
* **Tagihan Terpusat:** Menyatukan seluruh rincian konsumsi biaya (tagihan kontrak sewa, layanan berbayar, dan belanja koperasi) ke dalam satu lembar nota (*invoice*) personal secara transparan.
* **Pelunasan Terintegrasi:** Setelah pembayaran dilunasi, sistem otomatis menghapus rekapitulasi tagihan aktif milik penghuni yang bersangkutan dari pangkalan data.

## Implementasi Arsitektur OOP & Struktur Data Kustom

Proyek ini menonjolkan penerapan konsep fundamental *Computer Science* tingkat lanjut:

* **Penerapan Pilar OOP:** 
  * **Enkapsulasi:** Penguncian atribut finansial dan data vital menggunakan *modifier private* yang diakses secara ketat melalui metode validasi *setter/getter*.
  * **Pewarisan & Abstraksi:** Implementasi hierarki entitas pada kelas `User` dan `ServiceRequest` untuk mengurangi duplikasi kode.
  * **Polimorfisme:** Pembuatan kontrak `Interface Billable` yang memungkinkan terminal kasir menghitung total biaya transaksi secara dinamis tanpa perlu mengecek tipe objek (*Dynamic Method Dispatch*).
* **Struktur Data *Doubly Linked List*:** Digunakan pada `ContractLinkedList` agar navigasi dan pemutusan memori saat operasi CRUD (khususnya penghapusan di tengah antrean) berjalan jauh lebih cepat dan aman.
* **Struktur Data *Queue* (FIFO):** Diterapkan pada `ServiceQueue` untuk memastikan seluruh tiket keluhan dan layanan diproses secara adil dari antrean paling depan (*First In First Out*).
* **Struktur Data *Stack* (LIFO):** Diimplementasikan pada `CartStack` untuk mengelola keranjang belanja koperasi, yang memungkinkan eksekusi fitur *Undo* (pembatalan barang pesanan terakhir/teratas) berjalan sempurna (*Last In First Out*).
* **Struktur Data *Singly Linked List*:** Digunakan pada `BillableLinkedList` sebagai agregator raksasa yang menampung kumpulan objek heterogen untuk pencetakan nota pembayaran terpusat.
* **Ketahanan Sistem (*Exception Handling*):** Seluruh antarmuka input CLI dibungkus menggunakan blok *try-catch* (*InputMismatchException*) guna mencegah sistem *crash* akibat kesalahan ketik (*input error*) oleh pengguna.

## Tim Pengembang

Proyek ini dikembangkan secara kolaboratif oleh:
* Valent
* Nicolas Wijaya
* Loise Fernando Tjhai
* Asty Felyshia Eka Danastri
* Dickcent Ricardo
