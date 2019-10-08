package tictactoe;
import java.util.*;
public class oyuncu {
    Scanner oku=new Scanner(System.in);
    String isim;
    char harf;
    boolean insanOlmaOzelligi;
        
    oyuncu(){
        this.harf='X';
        this.insanOlmaOzelligi=true;
    }
    oyuncu(boolean insanMiKontrolu){
        this.insanOlmaOzelligi=insanMiKontrolu;
        if(this.insanOlmaOzelligi==true)
            this.harf='X';
        else
             this.harf='O';
    }
    oyuncu(boolean insanMiKontolu,char kr){
        this.insanOlmaOzelligi=insanMiKontolu;
        this.harf=kr;
    }
    
    char karakteriAL(){
        return this.harf;
    }
    
    boolean oyuncuTurunuAl(){
        return this.insanOlmaOzelligi;
    }
    
    String oyuncununHamlesiniAl(){
        String hamle;
        System.out.print("(a,b) formatında Hamle giriniz: ");
        hamle=oku.nextLine();
        return hamle;
    }
    
    String insanOyuncuHamlesiniKontrol(){
        String koordinat;
        System.out.print("Koordinat giriniz: ");
        koordinat=oku.next();
        return koordinat;
    }
    String bilgisayarHamlesiUret(int boyut){
        int x,y;
        String k;
        Random r= new Random();
        x=r.nextInt(boyut);
        y=r.nextInt(boyut);
        k=x+",";
        k=k+y;
        return k;
    }
}
