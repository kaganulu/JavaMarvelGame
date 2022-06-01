/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProje;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileIO {

    public Yarismaci[] yarismacilariOku() {
        Yarismaci[] yarismacilar = new Yarismaci[0];
        File dosya = new File("Yarismacilar.txt");
        try {
            FileReader dosyaOkuyucu = new FileReader(dosya);
            BufferedReader tamponluOkuyucu = new BufferedReader(dosyaOkuyucu);
            int arrayBoyutu = Integer.valueOf(tamponluOkuyucu.readLine());
            yarismacilar = new Yarismaci[arrayBoyutu];
            String[] icerik;
            String satir;
            int takimKodu, kolGucuBazPuani, vucutGucuBazPuani, bacakGucuBazPuani, enerjiYenilemeBazPuani;
            String sporcuIsmi;
            Yarismaci yarismaci;
            for (int i = 0; i < yarismacilar.length; i++) {
                satir = tamponluOkuyucu.readLine();
                icerik = satir.split(",");
                takimKodu = Integer.valueOf(icerik[0]);
                kolGucuBazPuani = Integer.valueOf(icerik[2]);
                vucutGucuBazPuani = Integer.valueOf(icerik[3]);
                bacakGucuBazPuani = Integer.valueOf(icerik[4]);
                sporcuIsmi = icerik[1];
                enerjiYenilemeBazPuani = Integer.valueOf(icerik[5]);
                yarismaci = new Yarismaci(takimKodu, sporcuIsmi, kolGucuBazPuani, vucutGucuBazPuani, bacakGucuBazPuani, enerjiYenilemeBazPuani);
                yarismacilar[i] = yarismaci;
            }
            
            tamponluOkuyucu.close();
            dosyaOkuyucu.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return yarismacilar;

    }

    public Oyun[] oyunculariOku() {
        Oyun[] oyuncular = new Oyun[0];
        File dosya = new File("Oyunlar.txt");
        try {
            FileReader dosyaOkuyucu = new FileReader(dosya);
            BufferedReader tamponluOkuyucu = new BufferedReader(dosyaOkuyucu);
            int arrayBoyutu = Integer.valueOf(tamponluOkuyucu.readLine());
            oyuncular = new Oyun[arrayBoyutu];
            String[] icerik;
            String satir;
            int oyunKodu, enerjiTuketimi, kolGucuPuanYuzdesi, vucutGucuPuanYuzdesi, bacakGucuPuanYuzdesi;
            String oyunIsmi;
            Oyun oyun;
            for (int i = 0; i < oyuncular.length; i++) {
                satir = tamponluOkuyucu.readLine();
                icerik = satir.split(",");
                oyunKodu = Integer.valueOf(icerik[0]);
                enerjiTuketimi = Integer.valueOf(icerik[2]);
                kolGucuPuanYuzdesi = Integer.valueOf(icerik[3]);
                vucutGucuPuanYuzdesi = Integer.valueOf(icerik[4]);
                bacakGucuPuanYuzdesi = Integer.valueOf(icerik[5]);
                oyunIsmi = icerik[1];
                oyun = new Oyun(oyunKodu, oyunIsmi, enerjiTuketimi, kolGucuPuanYuzdesi, vucutGucuPuanYuzdesi, bacakGucuPuanYuzdesi);
                oyuncular[i] = oyun;

            }
            
            tamponluOkuyucu.close();
            dosyaOkuyucu.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return oyuncular;

    }

    public Takim[] takimlariOku() {
        Takim[] takimlar = new Takim[0];
        File dosya = new File("Takimlar.txt");
        try {
            FileReader dosyaOkuyucu = new FileReader(dosya);
            BufferedReader tamponluOkuyucu = new BufferedReader(dosyaOkuyucu);
            int arrayBoyutu = Integer.valueOf(tamponluOkuyucu.readLine());
            takimlar = new Takim[arrayBoyutu];
            String[] icerik;
            String satir;
            int takimKodu;
            String takimIsmi;
            Takim takim;
            for (int i = 0; i < takimlar.length; i++) {
                satir = tamponluOkuyucu.readLine();
                icerik = satir.split(",");
                takimKodu = Integer.valueOf(icerik[0]);
                takimIsmi = icerik[1];
                takim = new Takim(takimKodu, takimIsmi);
                takimlar[i] = takim;
            }
            
            tamponluOkuyucu.close();
            dosyaOkuyucu.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return takimlar;

    }
}
