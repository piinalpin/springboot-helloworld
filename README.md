## Spring Boot Helloworld

Repository ini dibuat sebagai dokumentasi untuk kebutuhan :
- Belajar menggunakan `docker` pada aplikasi spring boot
- Belajar provisioning VPS menggunakan `ansible` agar persiapan server dapat dilakukan secara otomatis
- Belajar membuat sebuah cloud IDE `Open VSCode` menggunakan `gitpod` yang dapat diakses melalui web browser
- Belajar membuat pipeline pada sebuah aplikasi mulai dari `Unit Testing` hingga `Deployment`
    
    ![Pipeline](/images/pipeline.png)

### Build Images
Membuat `docker images` dengan `Dockerfile`.

```dockerfile
# Import base JDK from Linux
FROM adoptopenjdk/openjdk11:alpine

# Set work directory
WORKDIR /app

# Copy application files
COPY target/*.jar app.jar

# Expose PORT
EXPOSE 8080

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]
```

Menjalankan perintah build
```bash
docker build -t <IMAGE_NAME>:<TAG> .
```

### Menjalankan Container
Menjalankan container dengan menggunakan perintah `docker run`.

```bash
docker run --name <CONTAINER_NAME>:<TAG> -d --rm <IMAGE_NAME>
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

### Menggunakan ENV File
Agar konfigurasi database tidak bergantung pada build aplikasi yaitu dengan menggunakan argument `--env-file`

```bash
docker run --name <CONTAINER_NAME> -p <HOST_PORT>:<CONTAINER_PORT> --env-file <FILE_ENV> -d <IMAGE_NAME>
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