## Kampus Merdeka Academy - Pengenalan Docker
Repository ini dibuat untuk materi pengenalan docker dan membuat `docker images` pada aplikasi spring boot serta menjalankan container.

### Build Images
Membuat `docker images` dengan `Dockerfile`.

```dockerfile
Write dockerfile command here
```

Menjalankan perintah build
```bash
docker build -t <IMAGE_NAME>:<TAG> .
```

### Menjalankan Container
Menjalankan container dengan menggunakan perintah `docker run`.

```bash
docker run --name <CONTAINER_NAME>:<TAG> -d <IMAGE_NAME>
```

### Melihat List Container
Untuk melihat list container yang sedang berjalan dapat menggunakan perintah `docker ps` tetapi ketika ingin melihat semua container baik yang berjalan maupun tidak dapat menambahkan argumen `-a` sehingga perintah menjadi `docker ps -a`.

### Container Log
Melihat log dari sebuah container dengan meggunakan perintah `docker logs`. Menggunakan argumen `-f` untuk mem-*follow* log dari sebuah container.

```bash
docker logs <CONTAINER_NAME>
```

### Isi dari Container
Saat kita ingin masuk ke sebuah container, gunakan perintah `docker exec`.

```bash
docker exec -it <CONTAINER_NAME> <CMD>
```

### Expose Container Port
Agar container dapat di akses pada host OS maka diperlukan expose port pada container dengan menggunakan argumen `-p` pada perintah `docker run`.

```bash
docker run -p <HOST_PORT>:<CONTAINER_PORT> --name <CONTAINER_NAME>:<TAG> -d <IMAGE_NAME>
```

### Melihat Stats Penggunaan Memori
Untuk melihat stats penggunaan memori pada host secara realtime dapat menggunakan perintah `docker stats`.

### Perintah yang lain
Berikut perintah-perintah yang biasa digunakan untuk `start`, `stop`, atau menghapus container dan images.

```bash
docker stop <CONTAINER_NAME>
docker start <CONTAINER_NAME>
docker rm <CONTAINER_NAME>
docker rmi <IMAGE_NAME>
```