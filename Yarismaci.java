/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProje;

public class Yarismaci {

    private int takimKodu;
    private String sporcuIsmi;
    private int kolGucuBazPuani;
    private int vucutGucuBazPuani;
    private int bacakGucuBazPuani;
    private int enerjiYenilemeBazPuani;
    private double enerji;

    public Yarismaci(int takimKodu,
            String sporcuIsmi,
            int kolGucuBazPuani,
            int vucutGucuBazPuani,
            int bacakGucuBazPuani,
            int enerjiYenilemeBazPuani) {
        this.takimKodu = takimKodu;
        this.sporcuIsmi = sporcuIsmi;
        this.kolGucuBazPuani = kolGucuBazPuani;
        this.vucutGucuBazPuani = vucutGucuBazPuani;
        this.bacakGucuBazPuani = bacakGucuBazPuani;
        this.enerjiYenilemeBazPuani = enerjiYenilemeBazPuani;
        // Her sporcunun başlangıç enerjisi 100 olarak tanımlanacaktır.
        this.enerji = 100;
    }

    public int getTakimKodu() {
        return this.takimKodu;
    }

    public String getSporcuIsmi() {
        return this.sporcuIsmi;
    }

    public int getKolGucuBazPuani() {
        return this.kolGucuBazPuani;
    }

    public int getVucutGucuBazPuani() {
        return this.vucutGucuBazPuani;
    }

    public int getBacakGucuBazPuani() {
        return this.bacakGucuBazPuani;
    }

    public int getEnerjiYenilemeBazPuani() {
        return this.enerjiYenilemeBazPuani;
    }

    public double getEnerji() {
        return this.enerji;
    }

    public void setEnerji(double enerji) {
        this.enerji = enerji;
    }

}
