# A3-SW-Testing-Final-Project
Final Project For SW Testing

## Deskripsi Program
  Repository ini berisi skrip yang dirancang untuk melakukan pengujian pada 2 SUT : 
  1. situs Swag Labs pada link (https://www.saucedemo.com/).
  2. API Testing pada dummyapi.io 

## Struktur Project
1. Swaglabs / Web Application Testing
   ![image](https://github.com/ZackyFaishal/A3-SW-Testing-Final-Project/assets/95175098/84da17a4-0064-4a1a-b5f6-902ba1a374a8)
3. dummyapi.io / API Testing
   ![image](https://github.com/ZackyFaishal/A3-SW-Testing-Final-Project/assets/95175098/a913d41a-6671-43d7-b90f-45c171eff33e)


### Penjelasan Struktur Project
- `stepdefinitions/` : Berisi file yang mendefinisikan langkah-langkah pengujian.
- `/features/` : Berisi file yang mendefinisikan skenario pengujian dalam format Gherkin.
- `pages/` : Berisi file yang mendefinisikan halaman web yang akan diuji.
- `runner/` : Berisi file java yang mengatur eksekusi pengujian.
- `utility/` : Berisi file yang menyediakan utilitas untuk pengujian.
- `drivers/` : Berisi driver yang diperlukan untuk menjalankan pengujian, seperti `chromedriver.exe`.
- `cucumber.properties` : Konfigurasi untuk Cucumber.
- `target/` : Berisi hasil kompilasi, laporan pengujian, dan artefak lainnya yang dihasilkan oleh Maven.

## Prequisites 
- **Programming Language** : Java
- **Build tools** : Apache Maven
- **Automation Tools** : Selenium, Cucumber
- **Web Driver** : ChromeDriver
- **Framework Test API** : Rest Assure
- **Report Generate Tools** : SureFire Report

## Cara Running Project
1. Pastikan semua java dan apache maven sudah terinstall pada komputer. 
2. Clone Repository 
```
https://github.com/ZackyFaishal/A3-SW-Testing-Final-Project.git
```
3. Buka project menggunakan Visual Studio Code atau Java IDE lainnya.

## Run Automation Test
1. Buka terminal dan jalankan perintah berikut untuk melakukan pengujian secara keseluruhan :
```
mvn clean test
```
2. Buka terminal dan jalankan perintah berikut untuk melakukan pengujian dengan anotasi tertentu saja yang dijalankan :
```
mvn test -Dcucumber.filter.tags="@EndToEnd"
```
3. Hasil Akan langsung muncul pada web yang dituju




# Authors 
- [@ZackyFaishal](https://github.com/ZackyFaishal) (Zacky Faishal Abror - 211524031) 
- [@MaolanaF](https://github.com/MaolanaF) (Maolana Firmansyah - 211524013)
- [@FadhilRa](https://github.com/FadhilRa) (Fadhil Radja A - 211524008)



