package tictactoe;
import java.util.Scanner;

public class oyunTahtasi {
    Scanner oku=new Scanner(System.in);
    int boyut;
    char[][] tahta;
    oyunTahtasi(int b){
        this.boyut=b;
        tahta=new char[boyut][boyut];
        for(int i=0;i<boyut;i++){
               for(int j=0;j<boyut;j++){
                   this.tahta[i][j]='-';
               }
        }
    }
    
    oyunTahtasi(char [][]diziOT,int b){
        boyut=b;
        //yaratmasakta olur mu dene
        this.tahta=new char[boyut][boyut];
        this.tahta=diziOT;
    }
    
    boolean kazanan(char harf){
        if(boyut==3){
            if(this.tahta[0][0]==harf && this.tahta[0][1]==harf && this.tahta[0][2]==harf)
                return true;

            if(this.tahta[0][0]==harf && this.tahta[1][0]==harf && this.tahta[2][0]==harf)
                return true;

            if(this.tahta[0][0]==harf && this.tahta[1][1]==harf && this.tahta[2][2]==harf)
                return true;

            if(this.tahta[2][0]==harf && this.tahta[1][1]==harf && this.tahta[0][2]==harf)
                return true;

            if(this.tahta[1][0]==harf && this.tahta[1][1]==harf && this.tahta[1][2]==harf)
                return true;

            if(this.tahta[0][1]==harf && this.tahta[1][1]==harf && this.tahta[2][1]==harf)
                return true;

            if(this.tahta[0][2]==harf && this.tahta[1][2]==harf && this.tahta[2][2]==harf)
                return true;

            if(this.tahta[2][0]==harf && this.tahta[2][1]==harf && this.tahta[2][2]==harf)
                return true;
        }           
        else if(boyut==5){
            if(satirlariKontolEt(2,harf) || sutunlariKontolEt(2,harf) || asagiKosegenleriKontrolEt(2,harf) || yukariKosegenleriKontrolEt(2,harf))
                return true;
        }
        else if(boyut==7){
            if(satirlariKontolEt(4,harf) || sutunlariKontolEt(4,harf) || asagiKosegenleriKontrolEt(4,harf) || yukariKosegenleriKontrolEt(4,harf))
                return true;
        }
        return false;
    }
    
    
    boolean satirlariKontolEt(int t,char harf){
        for(int j=0;j<boyut;j++){
            for(int k=0;k<t;k++){
                if(this.tahta[j][k]==harf && this.tahta[j][k]==this.tahta[j][k+1] && this.tahta[j][k+1]==this.tahta[j][k+2] && this.tahta[j][k+2]==this.tahta[j][k+3])
                    return true;
            }
        }
        return false;
    }
    
    boolean sutunlariKontolEt(int t,char harf){
        for(int j=0;j<boyut;j++){
            for(int k=0;k<t;k++){
                if(harf==this.tahta[k][j] && this.tahta[k][j]==this.tahta[k+1][j] && this.tahta[k+1][j]==this.tahta[k+2][j] && this.tahta[k+2][j]==this.tahta[k+3][j])
                    return true;
            }
        }
        return false;
    }
  
  	 boolean asagiKosegenleriKontrolEt(int t,char harf){
        for(int j=0;j<t;j++){
            for(int k=0;k<t;k++){
                if(this.tahta[k][j]==harf && this.tahta[k][j]==this.tahta[k+1][j+1] && this.tahta[k+1][j+1]==this.tahta[k+2][j+2] && this.tahta[k+2][j+2]==this.tahta[k+3][j+3])
                    return true;
            }
        }
        return false;
		}
    
  	boolean yukariKosegenleriKontrolEt(int t,char harf){
        for(int j=boyut-1;j<=t;j--){
            for(int k=0;k<t;k++){
                if(harf==this.tahta[k][j] && this.tahta[k][j]==this.tahta[k-1][j+1] && this.tahta[k-1][j+1]==this.tahta[k-2][j+2] && this.tahta[k-2][j+2]==this.tahta[k-3][j+3])
                    return true;
            }
        }
        return false;
   }
        
  boolean beraberlikKontrol(oyuncu o1,oyuncu o2){
        int sayac=1;
        for(int i=0;i<boyut;i++)
            for(int j=0;j<boyut;j++){
                if(this.tahta[i][j]!='-')
                    sayac++;
        }
        if(sayac==(boyut*boyut))
            if(kazanan(o1.harf)==false && kazanan(o2.harf)==false)
                return true;
        return false;
}	
        
    void oyunTahtasiniYazdir(){ 
        for(int i=0;i<boyut;i++)
            System.out.print("  "+i+" ");
        System.out.println();
        for(int i=0;i<boyut;i++){
            System.out.print(i+" ");
            for(int j=0;j<boyut;j++){
                if(j==this.tahta.length-1)
                    System.out.print(this.tahta[i][j]);
                else
                    System.out.print(this.tahta[i][j]+" | ");
            }
            System.out.println();
        }
    }
    
    char [][] oyunTahtasiniAl(){
        return this.tahta;
    }
    
    boolean hamleyiYaz(String koordinat,char harf){
        if(this.tahta[((koordinat.charAt(0))-'0')][((koordinat.charAt(2))-'0')]=='-'){
            this.tahta[((koordinat.charAt(0))-'0')][((koordinat.charAt(2))-'0')]=harf;
            return true;
        }
            return false;
    }
    
}
