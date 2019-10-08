package tictactoe;

import java.util.*;
import java.io.*;

public class TicTacToe {
    public static void oyun(oyunTahtasi oT,oyuncu o1,oyuncu o2) throws IOException{
        boolean deger;
        char c,c1;
        String s;
        Scanner oku=new Scanner(System.in);
        
        System.out.println("tablonun durumu: ");
            oT.oyunTahtasiniYazdir();
        
        do{
            if(oT.hamleyiYaz(o1.oyuncununHamlesiniAl(), o1.karakteriAL())){
                oT.oyunTahtasiniYazdir();
                if(oT.kazanan(o1.karakteriAL())){
                    System.out.println(o1.isim+" kazandı.");
                    System.exit(0);
                }
                if(oT.beraberlikKontrol(o1, o2)){
                    System.out.println("Berabere kalındı.");
                    System.exit(0);
                }
                
            }
            //bilgisayar dolu yere yazmasın diye
            deger=oT.hamleyiYaz(o2.bilgisayarHamlesiUret(oT.boyut),o2.karakteriAL());
            while(deger==false)
                deger=oT.hamleyiYaz(o2.bilgisayarHamlesiUret(oT.boyut),o2.karakteriAL());

            System.out.println("bilgisayarın hamlesi: ");
            oT.oyunTahtasiniYazdir();
                if(oT.kazanan(o2.karakteriAL())){
                    System.out.println("bilgisayar kazandı.");
                    System.exit(0);
                }
                if(oT.beraberlikKontrol(o1, o2)){
                    System.out.println("Berabere kalındı.");
                    System.exit(0);
                }

            System.out.print("oyuna devam etmek istiyor musunuz ? (e: evet, h: hayır)");    
            c=oku.next().charAt(0);
            if(c=='h'){
                System.out.print("oyun kaydedilsin mi ?(e: evet, h: hayır)");
                c1=oku.next().charAt(0);
                if(c1=='e'){
                    //metin belgesine kaydet
                    File dosya=new File("TicTacToe.txt");
                    
                    FileWriter yazici=new FileWriter(dosya,false);
                    BufferedWriter bYazici=new BufferedWriter(yazici);
                    
                    for (int i = 0; i < oT.boyut; i++) {
                        for (int j = 0; j < oT.boyut; j++) {
                            bYazici.write(oT.tahta[i][j]);
                        }
                        bYazici.newLine();
                    }
                    bYazici.write(o1.isim);
                    bYazici.newLine();
                    bYazici.write(o1.harf);
                    bYazici.newLine();
                    if(o1.insanOlmaOzelligi)
                        bYazici.write("true");
                    bYazici.close();
                }
                System.exit(0);
            }
        }while(c=='e');
        
        
        
    }
    
    public static void main(String[] args) throws IOException{
        int b;
        String i,h;
        char cevap;
        Scanner oku=new Scanner(System.in);
        
        System.out.print("yeni bir oyun mu başlasın, son kapatılandan mı devam etsin? (y: yeni, d:devam)");
        cevap=oku.next().charAt(0);
        
        if(cevap=='y'){
            System.out.print("oyun tahtasının boyutunu girin(3 - 5 - 7): ");
            b=oku.nextInt();

            System.out.print("kullanıcı ismini girin: ");
            i=oku.next();

            System.out.print("harf belirlemek ister misiniz? (e:evet , h:hayır) ");
            cevap=oku.next().charAt(0);
        
            if(cevap=='e'){
                System.out.print("hangi harf ile başlamak istersiniz? (X / O)");
                h=oku.next();
                h=h.toUpperCase();

                if(h=="X"){
                    oyuncu o1=new oyuncu(true,'X');
                    o1.isim=i;
                    oyuncu bilgisayar=new oyuncu(false);

                    oyunTahtasi oyunT =new oyunTahtasi(b);

                    oyun(oyunT, o1, bilgisayar);

                }
                else{
                    oyuncu o1=new oyuncu(true,'O');
                    o1.isim=i;
                    oyuncu bilgisayar=new oyuncu(false,'X');

                    oyunTahtasi oyunT =new oyunTahtasi(b);

                    oyun(oyunT, o1, bilgisayar);
                }
            }
            else{
                oyuncu o1=new oyuncu();
                o1.isim=i;
                oyuncu bilgisayar=new oyuncu(false);

                oyunTahtasi oyunT =new oyunTahtasi(b);

                oyun(oyunT, o1, bilgisayar);
            }
        }
        else if(cevap=='d'){
            char [][] temp;
            String t;
            boolean a;
            //metin dosyasından okuyacak
            File dosya=new File("TicTacToe.txt");
            
            FileReader okuyucu=new FileReader(dosya);
            FileReader okuyucu2=new FileReader(dosya);
            
            try (BufferedReader bOkuyucu=new BufferedReader(okuyucu)) {
                String u=bOkuyucu.readLine();
                //raf ı tekrar başa çektim
                bOkuyucu.close();
                BufferedReader bOkuyucu2=new BufferedReader(okuyucu2);
                temp=new char[u.length()][u.length()];
                
                for (int j = 0; j < u.length(); j++) {
                    u=bOkuyucu2.readLine();
                    for (int k = 0; k < u.length(); k++) {
                        temp[j][k]=u.charAt(k);
                    }
                }
                i=bOkuyucu2.readLine();
                h=bOkuyucu2.readLine();
                t=bOkuyucu2.readLine();
                bOkuyucu2.close();
                
                if(t.equals("true"))
                    a=true;
                else
                    a=false;
                
                oyunTahtasi oyunT=new oyunTahtasi(temp,u.length());
                
                
                oyuncu o1=new oyuncu(a,h.charAt(0));
                o1.isim=i;
                
                cevap=o1.karakteriAL();
                
                if(cevap=='X'){
                    oyuncu bilgisayar = new oyuncu(false);
                    oyun(oyunT,o1,bilgisayar);
                }
                
                else{
                    oyuncu bilgisayar=new oyuncu(false,'X');
                    oyun(oyunT,o1,bilgisayar);
                }
            }
        }
    }
}
