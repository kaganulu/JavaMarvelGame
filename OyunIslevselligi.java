/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProje;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OyunIslevselligi {

     private Takim[] takimlar;
    private Oyun[] oyunlar;
    private Yarismaci[] yarismacilar;
    private FileIO fileIO;
    private Random rand;

    public OyunIslevselligi() {
        this.fileIO = new FileIO();
        this.yarismacilar = fileIO.yarismacilariOku();
        this.oyunlar = fileIO.oyunculariOku();
        this.takimlar = fileIO.takimlariOku();
        this.rand = new Random(0);
    }

    public void takimOyunculariAta() {
        for (int i = 0; i < yarismacilar.length; i++) {
            for (int j = 0; j < takimlar.length; j++) {
                if (yarismacilar[i].getTakimKodu() == takimlar[j].getTakimKodu()) {
                    takimlar[j].setTakimYarismacisi(yarismacilar[i]);
                    break;
                }
            }
        }
    }

    public void run() {
        takimOyunculariAta();

        int gun = 0;

        // 1 den fazla aktif takım olduğu sürece yarışmalar devam edecek ve yarışmalar
        // bitince puan listesi yayınlanacaktır.
        while (this.getAktifTakimlar().length > 1) {
            birGunOyna();
            gun++;
        }

        this.puanListesiYazdir();
        System.out.println(" Gün : " + gun);
    }

    public Oyun rastgeleOyunSec() {
        return this.oyunlar[this.rand.nextInt(this.oyunlar.length)];
    }

    public int rastgeleYuzdelikSec(int baslangic) {
        return this.rand.nextInt(101 - baslangic) + baslangic;
    }

    public void puanListesiYazdir() {
        for (Takim takim : this.takimlar) {
            System.out.println("(" + takim.getTakimKodu() + ") " + takim.getTakimIsmi() + " : " + takim.getPuan() + " : " + takim.getTakimYarismacisi().getSporcuIsmi() + " : "  + takim.getTakimYarismacisi().getEnerji());
        }
    }

    public Takim[] getAktifTakimlar() {
        Takim[] aktifTakimlar = new Takim[0];
        int sayac = 0;
        for (Takim takim : this.takimlar) {
            if (takim.isAktif()) {
                sayac++;
            }

        }
        aktifTakimlar = new Takim[sayac];
        sayac = 0;
        for (Takim takim : this.takimlar) {
            if (takim.isAktif()) {
                aktifTakimlar[sayac] = takim;
                sayac++;

            }
        }

        return aktifTakimlar;
    }

    public void oyunOyna(Oyun oyun) {

        Takim[] takimlar = getAktifTakimlar();

        // Her oyun sonrası oyuncu enerjileri hesaplanacak
        // enerjisi 0 olan oyuncunun takımı pasif hale getirilecektir.
        for (Takim takim : takimlar) {
            Yarismaci yarismaci = takim.getTakimYarismacisi();
            double enerji = yarismaci.getEnerji();
            double yeniEnerji = enerji - oyun.getEnerjiTuketimi();
            if (yeniEnerji < 0) {
                yeniEnerji = 0;


            }
             yarismaci.setEnerji(yeniEnerji);
                if (yeniEnerji == 0) {
                    takim.setAktif(false);

                }

        }

        // Oyun sonunda oyuna katılan her takıma 1 puan verilecektir.
        for (Takim takim : takimlar) {
            takim.puanEkle(1);
        }

        // Oyunda birinci olan takıma 3 puan verilecektir.
        // Oyunda birincilik için puan hesabı oyun turunden ilgili yüzde için
        // Örnek ilgilipuanA = 100 ile bazDegerA arasında bir random değer alınacak ve her
        // puan türü için hesaplanarak “oyunpuanı = ilgiliPuanA * oyun.ilgiliPuanYüzdesiA
        // +.... “ seklinde tüm türlerin ağırlıklı toplamlarından oluşacaktır.
        Takim birinciTakim = null;
        int birinciTakimOyunPuani = -1;
        for (Takim takim : takimlar) {
            int takimOyunPuani = 0;
            Yarismaci yarismaci = takim.getTakimYarismacisi();
            int kolGucuPuani = rastgeleYuzdelikSec(yarismaci.getKolGucuBazPuani());
            int vucutGucuPuani = rastgeleYuzdelikSec(yarismaci.getVucutGucuBazPuani());
            int bacakGucuPuani = rastgeleYuzdelikSec(yarismaci.getBacakGucuBazPuani());

            int yarismaciOyunPuani
                    = kolGucuPuani * oyun.getKolGucuPuanYuzdesi()
                    + vucutGucuPuani * oyun.getVucutGucuPuanYuzdesi()
                    + bacakGucuPuani * oyun.getBacakGucuPuanYuzdesi();

            takimOyunPuani = yarismaciOyunPuani;

            if (birinciTakimOyunPuani < takimOyunPuani) {
                birinciTakimOyunPuani = takimOyunPuani;
                birinciTakim = takim;
            }
        }

        if (birinciTakim == null) {
            System.out.println("Takim sayisi: " + takimlar.length);
        }

        birinciTakim.puanEkle(3);
      

        // Gün sonunda oyunları tamamlayan ve aktif kalabilen her takıma 2 puan verilecektir.
        takimlar = getAktifTakimlar();
        for (Takim takim : takimlar) {
            takim.puanEkle(2);
        }

        // Gün sonunda sporcuların enerjileri verilen baz puan ile rasgele hesaplanacak bir
        // yüzde ile arttırılacak. Hesaplama sonucu yeni enerji miktarı en fazla 100 olabilir.
        // Not: Sadece aktif takimlarin oyuncularinin enerjileri arttiriliyor.
        for (Takim takim : takimlar) {
            Random rand = new Random();
            rand.nextDouble();
            Yarismaci yarismaci = takim.getTakimYarismacisi();
            if (takim.isAktif()) {
                double enerji = yarismaci.getEnerji();
            double eklenecekEnerji = enerji * rand.nextDouble();
            double yeniEnerji = enerji + eklenecekEnerji;
            if (yeniEnerji > 100) {
                yeniEnerji = 100;
            }
            yarismaci.setEnerji(yeniEnerji);
            }


        }
    }

    public void birGunOyna() {
        // Gün içerisinde birbirinden farklı 2 oyun oynanacaktır.
        Oyun ilkOyun = rastgeleOyunSec();
        Oyun ikinciOyun = rastgeleOyunSec();
        while (ilkOyun.getOyunKodu() == ikinciOyun.getOyunKodu()) {
            ikinciOyun = rastgeleOyunSec();
        }

        oyunOyna(ilkOyun);
        if (this.getAktifTakimlar().length > 1) {
            oyunOyna(ikinciOyun);
        }
    }
}
