/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProje;


public class Oyun {
    private int oyunKodu;
    private String oyunIsmi;
    private int enerjiTuketimi;
    private int kolGucuPuanYuzdesi;
    private int vucutGucuPuanYuzdesi;
    private int bacakGucuPuanYuzdesi;

    public Oyun(int oyunKodu,
                String oyunIsmi,
                int enerjiTuketimi,
                int kolGucuPuanYuzdesi,
                int vucutGucuPuanYuzdesi,
                int bacakGucuPuanYuzdesi)
    {
        this.oyunKodu = oyunKodu;
        this.oyunIsmi = oyunIsmi;
        this.enerjiTuketimi = enerjiTuketimi;
        this.kolGucuPuanYuzdesi = kolGucuPuanYuzdesi;
        this.vucutGucuPuanYuzdesi = vucutGucuPuanYuzdesi;
        this.bacakGucuPuanYuzdesi = bacakGucuPuanYuzdesi;
    }

    public Oyun(){
        
    }
    
    public int getOyunKodu() {
        return this.oyunKodu;
    }

    public String getOyunIsmi() {
        return this.oyunIsmi;
    }

    public int getEnerjiTuketimi() {
        return this.enerjiTuketimi;
    }

    public int getKolGucuPuanYuzdesi() {
        return this.kolGucuPuanYuzdesi;
    }

    public int getVucutGucuPuanYuzdesi() {
        return this.vucutGucuPuanYuzdesi;
    }

    public int getBacakGucuPuanYuzdesi() {
        return this.bacakGucuPuanYuzdesi;
    }

    
        
    }


