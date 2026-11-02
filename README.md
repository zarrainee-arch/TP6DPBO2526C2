# TP6DPBO2526C2

## Janji
Saya Zahra Qurrota Aini dengan NIM 2510155 mengerjakan TP 6 dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## Deskripsi Project

Flappy Bird merupakan game sederhana berbasis Java Swing yang dibuat untuk memenuhi Tugas Praktikum 6 mata kuliah Desain dan Pemrograman Berorientasi Objek (DPBO).

Dalam permainan ini, pemain mengendalikan seekor burung yang harus melewati rintangan berupa pipa tanpa menabraknya atau jatuh ke batas bawah permainan.

## Tech

- Java
- Java Swing
- Java AWT
- IntelliJ IDEA

## Feature

1. **Main Menu** — Menampilkan tombol Start Game dan Exit.
2. **Player Movement** — Burung bergerak menggunakan sistem gravitasi.
3. **Keyboard Control** — Tombol Space digunakan untuk membuat burung terbang.
4. **Pipe Obstacle** — Pipa muncul secara otomatis dan bergerak dari kanan ke kiri.
5. **Collision Detection** — Permainan berakhir ketika burung menabrak pipa atau jatuh.
6. **Game Over** — Menampilkan pesan ketika permainan berakhir.
7. **Score System** — Skor bertambah ketika burung berhasil melewati rintangan.
8. **Restart Game** — Tombol R digunakan untuk memulai ulang permainan setelah Game Over.

## Game Control

| Tombol | Fungsi |
|---|---|
| Space | Membuat burung terbang |
| R | Restart setelah Game Over |

## Struktur Project

```text
TP6-FlappyBird/
├── src/
│   ├── App.java
│   ├── Player.java
│   ├── Pipe.java
│   ├── Logic.java
│   └── View.java
│
├── Dokumentasi/
│   └── screenshot/
│       ├── 1.png
│       ├── 2.png
│       ├── 3.png
│       ├── 4.png
│       ├── 5.png
│       └── 6.png
│
└── README.md
```

## Class Desc

- **App**: Mengatur JFrame, Main Menu, serta navigasi menuju permainan.
- **Player**: Menyimpan informasi posisi, ukuran, dan kecepatan burung.
- **Pipe**: Merepresentasikan objek pipa sebagai rintangan permainan.
- **Logic**: Mengatur mekanisme permainan, gravitasi, pergerakan pipa, collision detection, skor, Game Over, dan restart.
- **View**: Mengatur tampilan permainan dan menggambar objek menggunakan Java Swing Graphics.

## Dokumentasi

Dokumentasi berupa screenshot hasil implementasi permainan tersedia di folder `Dokumentasi/screenshot`.

## How to run the program

1. Clone repository ini atau download project.
2. Buka project menggunakan IntelliJ IDEA.
3. Pastikan Java Development Kit (JDK) sudah terpasang.
4. Buka file `src/App.java`.
5. Jalankan method `main()`.
