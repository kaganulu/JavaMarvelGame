/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProje;

/**
 *
 * @author kaganulu
 */
public class Takim {
    
    private int takimKodu;
    private String takimIsmi;
    private boolean aktif;
    private int puan;
    private Yarismaci takimYarismacisi;

    public Takim(int takimKodu, String takimIsmi) {
        this.takimKodu = takimKodu;
        this.takimIsmi = takimIsmi;
       
        // Her sınıf ilk başta aktif olarak tanımlanacak
        this.aktif = true;
        this.puan = 0;
    }

    public Yarismaci getTakimYarismacisi() {
        return takimYarismacisi;
    }

    public void setTakimYarismacisi(Yarismaci takimYarismacisi) {
        this.takimYarismacisi = takimYarismacisi;
    }

    
    
    public int getTakimKodu() {
        return this.takimKodu;
    }

    public String getTakimIsmi() {
        return this.takimIsmi;
    }

    public boolean isAktif() {
        return this.aktif;
    }

    public int getPuan() {
        return this.puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public void puanEkle(int fark) {
        this.puan += fark;
    }

    public void setAktif(boolean aktif) {
        this.aktif = aktif;
    }
        
   
    
}

