
public class TicTacToe_MichelDepcik {
    
    
    private String[] zahlen;
    private int zähler;
    private int zählerKILeicht;
    private int beleidigungsZähler;
    private int gewonnenZähler;
    private int gewonnenKIZähler;
    private int gewonnenSpielerZähler;
    
    public TicTacToe_MichelDepcik() {
        zahlen = new String[9];
        int i = 0;
        zahlen[0] = "1";
        zahlen[1] = "2";
        zahlen[2] = "3";
        zahlen[3] = "4";
        zahlen[4] = "5";
        zahlen[5] = "6";
        zahlen[6] = "7";
        zahlen[7] = "8";
        zahlen[8] = "9";
        spielfeldAusgeben();
        zählerKILeicht = 0;
        zähler = 0;
        beleidigungsZähler = 0;
        gewonnenZähler = 0;
        gewonnenKIZähler = 0;
        gewonnenSpielerZähler = 0;
        System.out.println("Der Spieler1 hat das Zeichen x.");
        System.out.println("Die KI hat das Zeichen O.");
        System.out.println("Wenn alle Felder voll sind, benutzen sie die Reset-Methode um ein neues Spiel zu starten.");
    }
    
    
    
    
    public void Spielestandasugeben(){
        System.out.println("KISchwer: " + gewonnenKIZähler);
        System.out.println("Spieler: " + gewonnenSpielerZähler);
    }
    
    
    
    
    public void spielfeldAusgeben() {
        int i=0;
        System.out.println("–------");
        System.out.println("|" + zahlen[0]+ " " + zahlen[1]+ " " + zahlen[2]+  "|");
        System.out.println("|" + zahlen[3]+ " " + zahlen[4]+ " " + zahlen[5]+  "|");
        System.out.println("|" + zahlen[6]+ " " + zahlen[7]+ " " + zahlen[8]+  "|");
        System.out.println("–------");
    }
    
    
    
    
    public void reset(){
        zahlen[0] = "1";
        zahlen[1] = "2";
        zahlen[2] = "3";
        zahlen[3] = "4";
        zahlen[4] = "5";
        zahlen[5] = "6";
        zahlen[6] = "7";
        zahlen[7] = "8";
        zahlen[8] = "9";
        spielfeldAusgeben();
        zählerKILeicht = 0;
        zähler = 0;
        beleidigungsZähler = 0;
        gewonnenZähler = 0;
        System.out.println("Der Spieler1 hat das Zeichen x.");
        System.out.println("Die KI hat das Zeichen O.");
    }
    
    
    
    
    public void naechsterZug(int feldnr){
        überprüfenObGewonnen();
        feldnr--;
        if(gewonnenZähler == 0){
         if(feldnr <= 8 && feldnr >= 0) {
            if(zähler == 0){
                if(zahlen[feldnr] != "x" && zahlen[feldnr] != "O"){
                    zahlen[feldnr] = "x";
                    zähler = 1;
                }else{
                    System.out.println("Dieses Feld ist bereits belegt.");
                }
            }else{
                if(zahlen[feldnr] != "x" && zahlen[feldnr] != "O"){
                    zahlen[feldnr] = "O";
                    zähler = 0;
                }else{
                    System.out.println("Dieses Feld ist bereits belegt.");
                }
            }
         }else{
            System.out.println("Geben sie eine gültige Nummer für das feld ein.");
         }
        }else{
            System.out.println("Um noch ein Spiel starten zu können müssen Sie die reset Methode verwenden.");   
        }
        spielfeldAusgeben();
    }
    
    
    
    
    public void naechsterZugGegenKIVielZuLeicht(int feldnr){
        feldnr--;
        überprüfenObGewonnen();
        if(gewonnenZähler == 0){
         if(feldnr <= 8 && feldnr >= 0) {
            zahlen[feldnr] = "x";
            if(zahlen[4] != "O"&& zahlen[4] != "x"){
                zahlen[4]="O"; 
                   überprüfenObGewonnen();
            }else if(zahlen[5] != "O"&& zahlen[5] != "x"){
                zahlen[5]="O";
                   überprüfenObGewonnen();
            }else if(zahlen[3] != "O"&& zahlen[3] != "x") {
                zahlen[3]="O";
                   überprüfenObGewonnen();
            }else if(zahlen[7] != "O"&& zahlen[7] != "x") {
                zahlen[7]="O";
                   überprüfenObGewonnen();
            }else if(zahlen[1] != "O"&& zahlen[1] != "x") {
                zahlen[1]="O";
                   überprüfenObGewonnen();
            }
         }else if(feldnr == -1){
            if(zählerKILeicht == 0){
                zählerKILeicht = 1;
               if(zahlen[4] != "O"&& zahlen[4] != "x"){
                   zahlen[4]="O"; 
                   überprüfenObGewonnen();
               }else if(zahlen[5] != "O"&& zahlen[5] != "x"){
                   zahlen[5]="O";
                   überprüfenObGewonnen();
               }else if(zahlen[3] != "O"&& zahlen[3] != "x") {
                   zahlen[3]="O";
                   überprüfenObGewonnen();
               }else if(zahlen[7] != "O"&& zahlen[7] != "x") {
                   zahlen[7]="O";
                   überprüfenObGewonnen();
               }else if(zahlen[1] != "O"&& zahlen[1] != "x") {
                   zahlen[1]="O";
                   überprüfenObGewonnen();
               }
         }
         }else{
            System.out.println("Geben sie eine gültige Nummer für das feld ein.");
         }
        }else{
            System.out.println("Um noch ein Spiel starten zu können müssen Sie die reset Methode verwenden.");   
       }
        spielfeldAusgeben();
    }
    
    
    
    
    public void überprüfenObGewonnen(){
        if (zahlen[0] == "O" && zahlen[1] == "O" && zahlen[2] == "O"){/*Erste Zeile*/
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[1] == "O" && zahlen[2] == "O" && zahlen[0] == "O"){/*Erste Zeile*/
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[0] == "O" && zahlen[2] == "O" && zahlen[1] == "O"){/*Erste Zeile*/
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[3] == "O" && zahlen[4] == "O" && zahlen[5] == "O"){/*Zweite Zeile*/
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[3] == "O" && zahlen[5] == "O" && zahlen[4] == "O"){/*Zweite Zeile*/
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach(case a)");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[4] == "O" && zahlen[5] == "O" && zahlen[3] == "O"){/*Zweite Zeile*/
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach(case b)");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[6] == "O" && zahlen[7] == "O" && zahlen[8] == "O"){/*Dritte Zeile*/
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach(case c)");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[7] == "O" && zahlen[8] == "O" && zahlen[6] == "O"){/*Dritte Zeile*/
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach(case d)");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[6] == "O" && zahlen[8] == "O" && zahlen[7] == "O"){/*Dritte Zeile*/
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach(case e)");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[0] == "O" && zahlen[3] == "O" && zahlen[6] == "O"){/*Erste Spalte1*/
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach(case f)");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[3] == "O" && zahlen[6] == "O" && zahlen[0] == "O"){/*Erste Spalte2*/
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach(case g)");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[0] == "O" && zahlen[6] == "O" && zahlen[3] == "O"){/*Erste Spalte3*/
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach(case h)");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[1] == "O" && zahlen[4] == "O" && zahlen[7] == "O"){/*Zweite Spalte1*/
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach(case i)");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[4] == "O" && zahlen[7] == "O" && zahlen[1] == "O"){/*Zweite Spalte2*/
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach(case j)");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[1] == "O" && zahlen[7] == "O" && zahlen[4] == "O"){/*Zweite Spalte3*/
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach(case k)");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[2] == "O" && zahlen[5] == "O" && zahlen[8] == "O"){/*Dritte Spalte1*/
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach(case l)");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[5] == "O" && zahlen[8] == "O" && zahlen[2] == "O" ){/*Dritte Spalte2*/
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach(case m)");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[2] == "O" && zahlen[8] == "O" && zahlen[2] == "O"){/*Dritte Spalte3*/
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach(case n)");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[0] == "O" && zahlen[4] == "O" && zahlen[8] == "O"){/*Schräg 1 */
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach(case o)");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[4] == "O" && zahlen[8] == "O" && zahlen[0] == "O"){/*Schräg 2 */
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach(case p)");
            gewonnenZähler = 1;
            gewonnenKIZähler++;
        }else if(zahlen[0] == "O" && zahlen[8] == "O" && zahlen[4] == "O"){/*Schräg 3 */
            System.out.println("KISchwer hat gewonnen.");
            System.out.println("KI: Das war jetzt aber viel zu einfach(case q)");
            gewonnenZähler = 1; 
            gewonnenKIZähler++;
        }else if (zahlen[0] == "x" && zahlen[1] == "x" && zahlen[2] == "x"){/*Erste Zeile*/
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[1] == "x" && zahlen[2] == "x" && zahlen[0] == "x"){/*Erste Zeile*/
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[0] == "x" && zahlen[2] == "x" && zahlen[1] == "x"){/*Erste Zeile*/
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[3] == "x" && zahlen[4] == "x" && zahlen[5] == "x"){/*Zweite Zeile*/
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[3] == "x" && zahlen[5] == "x" && zahlen[4] == "x"){/*Zweite Zeile*/
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[4] == "x" && zahlen[5] == "x" && zahlen[3] == "x"){/*Zweite Zeile*/
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[6] == "x" && zahlen[7] == "x" && zahlen[8] == "x"){/*Dritte Zeile*/
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[7] == "x" && zahlen[8] == "x" && zahlen[6] == "x"){/*Dritte Zeile*/
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[6] == "x" && zahlen[8] == "x" && zahlen[7] == "x"){/*Dritte Zeile*/
            System.out.println("KISchwer hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[0] == "x" && zahlen[3] == "x" && zahlen[6] == "x"){/*Erste Spalte1*/
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[3] == "x" && zahlen[6] == "x" && zahlen[0] == "x"){/*Erste Spalte2*/
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[0] == "x" && zahlen[6] == "x" && zahlen[3] == "x"){/*Erste Spalte3*/
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[1] == "x" && zahlen[4] == "x" && zahlen[7] == "x"){/*Zweite Spalte1*/
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[4] == "x" && zahlen[7] == "x" && zahlen[1] == "x"){/*Zweite Spalte2*/
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[1] == "x" && zahlen[7] == "x" && zahlen[4] == "x"){/*Zweite Spalte3*/
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[2] == "x" && zahlen[5] == "x" && zahlen[8] == "x"){/*Dritte Spalte1*/
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[5] == "x" && zahlen[8] == "x" && zahlen[2] == "x" ){/*Dritte Spalte2*/
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[2] == "x" && zahlen[8] == "x" && zahlen[2] == "x"){/*Dritte Spalte3*/
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[0] == "x" && zahlen[4] == "x" && zahlen[8] == "x"){/*Schräg 1 */
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[4] == "x" && zahlen[8] == "x" && zahlen[0] == "x"){/*Schräg 2 */
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }else if(zahlen[0] == "x" && zahlen[8] == "x" && zahlen[4] == "x"){/*Schräg 3 */
            System.out.println("Spieler hat gewonnen.");
            gewonnenZähler = 1;
            gewonnenSpielerZähler++;
        }
    }
    
    
    
    
    public void naechsterZugGegenKISchwerer(int feldnr){
      beleidigungsZähler++;
      feldnr--;      
      if(gewonnenZähler == 0){
        if(feldnr <= 8 && feldnr >= 0) {
            if(zahlen[feldnr]!= "O" &&zahlen[feldnr]!= "x"){
                 zahlen[feldnr] = "x";
                 spielfeldAusgeben();
            }else {
                System.out.println("Dieses Feld ist bereits belegt");
            }
            if(zahlen[0] == "O" && zahlen[1] == "O" && zahlen[2] != "O" && zahlen[2] != "x"){ /*Erste Zeile1 FINISHER*/
                   zahlen[2] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[1] == "O" && zahlen[2] == "O" && zahlen[0] != "O" && zahlen[0] != "x"){/*Erste Zeile2 FINISHER*/
                   zahlen[0] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "O" && zahlen[2] == "O" && zahlen[1] != "O" && zahlen[1] != "x"){/*Erste zeile3 FINISHER*/
                   zahlen[1] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[3] == "O" && zahlen[4] == "O" && zahlen[5] != "O" && zahlen[5] != "x"){/*Zweite Zeile1 FINISHER*/
                   zahlen[5] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[3] == "O" && zahlen[5] == "O" && zahlen[4] != "O" && zahlen[4] != "x" ){/*Zweite Zeile2 FINISHER*/
                   zahlen[4] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[4] == "O" && zahlen[5] == "O" && zahlen[3] != "O" && zahlen[3] != "x"){/*Zweite Zeile3 FINISHER*/
                   zahlen[3] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[6] == "O" && zahlen[7] == "O" && zahlen[8] != "O" && zahlen[8] != "x"){/*Dritte Zeile1 FINISHER*/
                   zahlen[8] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[7] == "O" && zahlen[8] == "O" && zahlen[6] != "O" && zahlen[6] != "x" ){/*Dritte Zeile2 FINISHER*/
                   zahlen[6] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[6] == "O" && zahlen[8] == "O" && zahlen[7] != "O" && zahlen[7] != "x"){/*Dritte Zeile3 FINISHER*/
                   zahlen[7] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "O" && zahlen[3] == "O" && zahlen[6] != "O" && zahlen[6] != "x"){/*Erste Spalte1 FINISHER*/
                   zahlen[6] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[3] == "O" && zahlen[6] == "O" && zahlen[0] != "O" && zahlen[0] != "x"){/*Erste Spalte2 FINISHER*/
                   zahlen[0] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "O" && zahlen[6] == "O" && zahlen[3] != "O" && zahlen[3] != "x"){/*Erste Spalte3 FINISHER*/
                   zahlen[3] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[1] == "O" && zahlen[4] == "O" && zahlen[7] != "O" && zahlen[7] != "x"){/*Zweite Spalte1 FINISHER*/
                   zahlen[7] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[4] == "O" && zahlen[7] == "O" && zahlen[1] != "O" && zahlen[1] != "x"){/*Zweite Spalte2 FINISHER*/
                   zahlen[1] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[1] == "O" && zahlen[7] == "O" && zahlen[4] != "O" && zahlen[4] != "x"){/*Zweite Spalte3 FINISHER*/
                   zahlen[4] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[2] == "O" && zahlen[5] == "O" && zahlen[8] != "O" && zahlen[8] != "x"){/*Dritte Spalte1 FINISHER*/
                   zahlen[8] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[5] == "O" && zahlen[8] == "O" && zahlen[2] != "O" && zahlen[2] != "x"){/*Dritte Spalte2 FINISHER*/
                   zahlen[2] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[2] == "O" && zahlen[8] == "O" && zahlen[2] != "O" && zahlen[2] != "x"){/*Dritte Spalte3 FINISHER*/
                   zahlen[2] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "O" && zahlen[4] == "O" && zahlen[8] != "O" && zahlen[8] != "x"){/*Schräg 1 FINISHER*/
                   zahlen[8] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[8] == "O" && zahlen[0] == "O" && zahlen[4] != "O" && zahlen[4] != "x"){/*Schräg 2 FINISHER*/
                   zahlen[4] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[4] == "O" && zahlen[8] == "O" && zahlen[0] != "O" && zahlen[0] != "x"){/*Schräg 3 FINISHER*/
                   zahlen[0] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[4] == "O" && zahlen[2] == "O" && zahlen[6] != "O" && zahlen[6] != "x"){/*Schräg 1 FINISHER*/
                   zahlen[0] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[2] == "O" && zahlen[6] == "O" && zahlen[4] != "O" && zahlen[4] != "x"){/*Schräg 2 FINISHER*/
                   zahlen[4] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[6] == "O" && zahlen[4] == "O" && zahlen[2] != "O" && zahlen[2] != "x"){/*Schräg 3 FINISHER*/
                   zahlen[2] = "O";
                   überprüfenObGewonnen();
                   
            }else if(zahlen[0] == "x" && zahlen[1] == "x" && zahlen[2] != "O" && zahlen[2] != "x"){ /*Erste Zeile1 COUNTERZUG*/
                   zahlen[2] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[1] == "x" && zahlen[2] == "x" && zahlen[0] != "O" && zahlen[0] != "x"){/*Erste Zeile2 COUNTERZUG*/
                   zahlen[0] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "x" && zahlen[2] == "x" && zahlen[1] != "O" && zahlen[1] != "x"){/*Erste zeile3 COUNTERZUG*/
                   zahlen[1] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[3] == "x" && zahlen[4] == "x" && zahlen[5] != "O" && zahlen[5] != "x"){/*Zweite Zeile1 COUNTERZUG*/
                   zahlen[5] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[3] == "x" && zahlen[5] == "x" && zahlen[4] != "O" && zahlen[4] != "x" ){/*Zweite Zeile2 COUNTERZUG*/
                   zahlen[4] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[4] == "x" && zahlen[5] == "x" && zahlen[3] != "O" && zahlen[3] != "x"){/*Zweite Zeile3 COUNTERZUG*/
                   zahlen[3] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[6] == "x" && zahlen[7] == "x" && zahlen[8] != "O" && zahlen[8] != "x"){/*Dritte Zeile1 COUNTERZUG*/
                   zahlen[8] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[7] == "x" && zahlen[8] == "x" && zahlen[6] != "O" && zahlen[6] != "x" ){/*Dritte Zeile2 COUNTERZUG*/
                   zahlen[6] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[6] == "x" && zahlen[8] == "x" && zahlen[7] != "O" && zahlen[7] != "x"){/*Dritte Zeile3 COUNTERZUG*/
                   zahlen[7] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "x" && zahlen[3] == "x" && zahlen[6] != "O" && zahlen[6] != "x"){/*Erste Spalte1 COUNTERZUG*/
                   zahlen[6] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[3] == "x" && zahlen[6] == "x" && zahlen[0] != "O" && zahlen[0] != "x"){/*Erste Spalte2 COUNTERZUG*/
                   zahlen[0] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "x" && zahlen[6] == "x" && zahlen[3] != "O" && zahlen[3] != "x"){/*Erste Spalte3 COUNTERZUG*/
                   zahlen[3] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[1] == "x" && zahlen[4] == "x" && zahlen[7] != "O" && zahlen[7] != "x"){/*Zweite Spalte1 COUNTERZUG*/
                   zahlen[7] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[4] == "x" && zahlen[7] == "x" && zahlen[1] != "O" && zahlen[1] != "x"){/*Zweite Spalte2 COUNTERZUG*/
                   zahlen[1] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[1] == "x" && zahlen[7] == "x" && zahlen[4] != "O" && zahlen[4] != "x"){/*Zweite Spalte3 COUNTERZUG*/
                   zahlen[4] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[2] == "x" && zahlen[5] == "x" && zahlen[8] != "O" && zahlen[8] != "x"){/*Dritte Spalte1 COUNTERZUG*/
                   zahlen[8] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[5] == "x" && zahlen[8] == "x" && zahlen[2] != "O" && zahlen[2] != "x"){/*Dritte Spalte2 COUNTERZUG*/
                   zahlen[2] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[2] == "x" && zahlen[8] == "x" && zahlen[2] != "O" && zahlen[2] != "x"){/*Dritte Spalte3 COUNTERZUG*/
                   zahlen[2] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "x" && zahlen[4] == "x" && zahlen[8] != "O" && zahlen[8] != "x"){/*Schräg 1 COUNTERZUG*/
                   zahlen[8] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[4] == "x" && zahlen[8] == "x" && zahlen[0] != "O" && zahlen[0] != "x"){/*Schräg 2 COUNTERZUG*/
                   zahlen[0] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "x" && zahlen[8] == "x" && zahlen[4] != "O" && zahlen[4] != "x"){/*Schräg 3 COUNTERZUG*/
                   zahlen[4] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "x" || zahlen[2] == "x" || zahlen[8] == "x" || zahlen[6] == "x"){/*Andere Züge*/
              if(zahlen[4] != "O"&& zahlen[4] != "x"){/*Andere Züge*/
                zahlen[4]="O"; 
                überprüfenObGewonnen();
                }else if(zahlen[2] == "x" &&zahlen[5] != "O"&& zahlen[5] != "x"){/*Andere Züge*/
                zahlen[6]="O"; 
                überprüfenObGewonnen();
                }else if(zahlen[2] == "x" &&zahlen[1] != "O"&& zahlen[1] != "x"){/*Andere Züge*/
                zahlen[1]="O"; 
                überprüfenObGewonnen();
                }else if(zahlen[0] == "x" &&zahlen[1] != "O"&& zahlen[1] != "x"){/*Andere Züge*/
                zahlen[1]="O";
                überprüfenObGewonnen();
                }else if(zahlen[0] == "x" &&zahlen[3] != "O"&& zahlen[3] != "x"){/*Andere Züge*/
                zahlen[3]="O"; 
                überprüfenObGewonnen();
                }else if(zahlen[8] == "x" &&zahlen[7] != "O"&& zahlen[7] != "x"){/*Andere Züge*/
                zahlen[7]="O"; 
                überprüfenObGewonnen();
                }else if(zahlen[8] == "x" &&zahlen[5] != "O"&& zahlen[5] != "x"){/*Andere Züge*/
                zahlen[5]="O"; 
                überprüfenObGewonnen();
                }else if(zahlen[6] == "x" &&zahlen[3] != "O"&& zahlen[3] != "x"){/*Andere Züge*/
                zahlen[3]="O"; 
                überprüfenObGewonnen();
                }else if(zahlen[6] == "x" &&zahlen[7] != "O"&& zahlen[7] != "x"){/*Andere Züge*/
                zahlen[7]="O";
                überprüfenObGewonnen();
              }else if(zahlen[8] != "O"&& zahlen[8] != "x"){/*Andere Züge*/
                zahlen[8]="O";
                überprüfenObGewonnen();
              }else if(zahlen[0] != "O"&& zahlen[0] != "x"){/*Andere Züge*/
                zahlen[0]="O";
                überprüfenObGewonnen();
              }else if(zahlen[2] != "O"&& zahlen[2] != "x"){/*Andere Züge*/
                zahlen[2]="O";
                überprüfenObGewonnen();
              }else if(zahlen[6] != "O"&& zahlen[6] != "x"){/*Andere Züge*/
                zahlen[6]="O";
                überprüfenObGewonnen();
              }
              }else if(zahlen[4] != "O"&& zahlen[4] != "x"){/*Andere Züge*/
                zahlen[4]="O";
                überprüfenObGewonnen();
              }else if(zahlen[2]== "O" && zahlen[0] != "O"&& zahlen[0] != "x"){/*Andere Züge*/
                zahlen[0]="O";
                überprüfenObGewonnen();
              }else if(zahlen[2]== "O" && zahlen[8] != "O"&& zahlen[8] != "x"){/*Andere Züge*/
                zahlen[8]="O";
                überprüfenObGewonnen();
              }else if(zahlen[6]== "O" && zahlen[0] != "O"&& zahlen[0] != "x"){/*Andere Züge*/
                zahlen[0]="O";
                überprüfenObGewonnen();
              }else if(zahlen[6]== "O" && zahlen[8] != "O"&& zahlen[8] != "x"){/*Andere Züge*/
                zahlen[8]="O";
                überprüfenObGewonnen();
              }else if(zahlen[0]== "O" && zahlen[2] != "O"&& zahlen[2] != "x"){/*Andere Züge*/
                zahlen[2]="O";
                überprüfenObGewonnen();
              }else if(zahlen[0]== "O" && zahlen[6] != "O"&& zahlen[6] != "x"){/*Andere Züge*/
                zahlen[6]="O";
                überprüfenObGewonnen();
              }else if(zahlen[8]== "O" && zahlen[2] != "O"&& zahlen[2] != "x"){/*Andere Züge*/
                zahlen[2]="O";
                überprüfenObGewonnen();
              }else if(zahlen[8]== "O" && zahlen[6] != "O"&& zahlen[6] != "x"){/*Andere Züge*/
                zahlen[6]="O";
                überprüfenObGewonnen();
              }else if(zahlen[6] != "O"&& zahlen[6] != "x"){/*Andere Züge*/
                zahlen[6]="O";
                   überprüfenObGewonnen(); 
            }else if(zahlen[0] != "O"&& zahlen[0] != "x"){/*Andere Züge*/
                zahlen[0]="O"; 
                   überprüfenObGewonnen();
            }else if(zahlen[2] != "O"&& zahlen[2] != "x"){/*Andere Züge*/
                zahlen[2]="O"; 
                   überprüfenObGewonnen();
            }else if(zahlen[8] != "O" && zahlen[8] != "x"){/*Andere Züge*/
                zahlen[8]="O"; 
                   überprüfenObGewonnen();
            }else if(zahlen[4] != "O"&& zahlen[4] != "x"){/*Andere Züge*/
                zahlen[4]="O"; 
                   überprüfenObGewonnen();
            }else if(zahlen[7] != "O"&& zahlen[7] != "x"){/*Andere Züge*/
                zahlen[7]="O"; 
                   überprüfenObGewonnen();
            }else if(zahlen[1] != "O"&& zahlen[1] != "x"){/*Andere Züge*/
                zahlen[1]="O"; 
                   überprüfenObGewonnen();
            }else if(zahlen[3] != "O"&& zahlen[3] != "x"){/*Andere Züge*/
                zahlen[3]="O"; 
                   überprüfenObGewonnen();
            }else if(zahlen[5] != "O"&& zahlen[5] != "x"){/*Andere Züge*/
                zahlen[5]="O"; 
                   überprüfenObGewonnen();
            }
       }else if(feldnr == -1){
          if(zählerKILeicht == 0){
            zählerKILeicht = 1;
            if(zahlen[0] == "O" && zahlen[1] == "O" && zahlen[2] != "O" && zahlen[2] != "x"){ /*Erste Zeile1 FINISHER*/
                   zahlen[2] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[1] == "O" && zahlen[2] == "O" && zahlen[0] != "O" && zahlen[0] != "x"){/*Erste Zeile2 FINISHER*/
                   zahlen[0] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "O" && zahlen[2] == "O" && zahlen[1] != "O" && zahlen[1] != "x"){/*Erste zeile3 FINISHER*/
                   zahlen[1] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[3] == "O" && zahlen[4] == "O" && zahlen[5] != "O" && zahlen[5] != "x"){/*Zweite Zeile1 FINISHER*/
                   zahlen[5] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[3] == "O" && zahlen[5] == "O" && zahlen[4] != "O" && zahlen[4] != "x" ){/*Zweite Zeile2 FINISHER*/
                   zahlen[4] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[4] == "O" && zahlen[5] == "O" && zahlen[3] != "O" && zahlen[3] != "x"){/*Zweite Zeile3 FINISHER*/
                   zahlen[3] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[6] == "O" && zahlen[7] == "O" && zahlen[8] != "O" && zahlen[8] != "x"){/*Dritte Zeile1 FINISHER*/
                   zahlen[8] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[7] == "O" && zahlen[8] == "O" && zahlen[6] != "O" && zahlen[6] != "x" ){/*Dritte Zeile2 FINISHER*/
                   zahlen[6] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[6] == "O" && zahlen[8] == "O" && zahlen[7] != "O" && zahlen[7] != "x"){/*Dritte Zeile3 FINISHER*/
                   zahlen[7] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "O" && zahlen[3] == "O" && zahlen[6] != "O" && zahlen[6] != "x"){/*Erste Spalte1 FINISHER*/
                   zahlen[6] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[3] == "O" && zahlen[6] == "O" && zahlen[0] != "O" && zahlen[0] != "x"){/*Erste Spalte2 FINISHER*/
                   zahlen[0] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "O" && zahlen[6] == "O" && zahlen[3] != "O" && zahlen[3] != "x"){/*Erste Spalte3 FINISHER*/
                   zahlen[3] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[1] == "O" && zahlen[4] == "O" && zahlen[7] != "O" && zahlen[7] != "x"){/*Zweite Spalte1 FINISHER*/
                   zahlen[7] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[4] == "O" && zahlen[7] == "O" && zahlen[1] != "O" && zahlen[1] != "x"){/*Zweite Spalte2 FINISHER*/
                   zahlen[1] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[1] == "O" && zahlen[7] == "O" && zahlen[4] != "O" && zahlen[4] != "x"){/*Zweite Spalte3 FINISHER*/
                   zahlen[4] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[2] == "O" && zahlen[5] == "O" && zahlen[8] != "O" && zahlen[8] != "x"){/*Dritte Spalte1 FINISHER*/
                   zahlen[8] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[5] == "O" && zahlen[8] == "O" && zahlen[2] != "O" && zahlen[2] != "x"){/*Dritte Spalte2 FINISHER*/
                   zahlen[2] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[2] == "O" && zahlen[8] == "O" && zahlen[2] != "O" && zahlen[2] != "x"){/*Dritte Spalte3 FINISHER*/
                   zahlen[2] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "O" && zahlen[4] == "O" && zahlen[8] != "O" && zahlen[8] != "x"){/*Schräg 1 FINISHER*/
                   zahlen[8] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[4] == "O" && zahlen[8] == "O" && zahlen[0] != "O" && zahlen[0] != "x"){/*Schräg 2 FINISHER*/
                   zahlen[0] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "O" && zahlen[8] == "O" && zahlen[4] != "O" && zahlen[4] != "x"){/*Schräg 3 FINISHER*/
                   zahlen[4] = "O";
                   überprüfenObGewonnen();
                   
            }else if(zahlen[0] == "x" && zahlen[1] == "x" && zahlen[2] != "O" && zahlen[2] != "x"){ /*Erste Zeile1 COUNTERZUG*/
                   zahlen[2] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[1] == "x" && zahlen[2] == "x" && zahlen[0] != "O" && zahlen[0] != "x"){/*Erste Zeile2 COUNTERZUG*/
                   zahlen[0] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "x" && zahlen[2] == "x" && zahlen[1] != "O" && zahlen[1] != "x"){/*Erste zeile3 COUNTERZUG*/
                   zahlen[1] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[3] == "x" && zahlen[4] == "x" && zahlen[5] != "O" && zahlen[5] != "x"){/*Zweite Zeile1 COUNTERZUG*/
                   zahlen[5] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[3] == "x" && zahlen[5] == "x" && zahlen[4] != "O" && zahlen[4] != "x" ){/*Zweite Zeile2 COUNTERZUG*/
                   zahlen[4] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[4] == "x" && zahlen[5] == "x" && zahlen[3] != "O" && zahlen[3] != "x"){/*Zweite Zeile3 COUNTERZUG*/
                   zahlen[3] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[6] == "x" && zahlen[7] == "x" && zahlen[8] != "O" && zahlen[8] != "x"){/*Dritte Zeile1 COUNTERZUG*/
                   zahlen[8] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[7] == "x" && zahlen[8] == "x" && zahlen[6] != "O" && zahlen[6] != "x" ){/*Dritte Zeile2 COUNTERZUG*/
                   zahlen[6] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[6] == "x" && zahlen[8] == "x" && zahlen[7] != "O" && zahlen[7] != "x"){/*Dritte Zeile3 COUNTERZUG*/
                   zahlen[7] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "x" && zahlen[3] == "x" && zahlen[6] != "O" && zahlen[6] != "x"){/*Erste Spalte1 COUNTERZUG*/
                   zahlen[6] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[3] == "x" && zahlen[6] == "x" && zahlen[0] != "O" && zahlen[0] != "x"){/*Erste Spalte2 COUNTERZUG*/
                   zahlen[0] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "x" && zahlen[6] == "x" && zahlen[3] != "O" && zahlen[3] != "x"){/*Erste Spalte3 COUNTERZUG*/
                   zahlen[3] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[1] == "x" && zahlen[4] == "x" && zahlen[7] != "O" && zahlen[7] != "x"){/*Zweite Spalte1 COUNTERZUG*/
                   zahlen[7] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[4] == "x" && zahlen[7] == "x" && zahlen[1] != "O" && zahlen[1] != "x"){/*Zweite Spalte2 COUNTERZUG*/
                   zahlen[1] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[1] == "x" && zahlen[7] == "x" && zahlen[4] != "O" && zahlen[4] != "x"){/*Zweite Spalte3 COUNTERZUG*/
                   zahlen[4] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[2] == "x" && zahlen[5] == "x" && zahlen[8] != "O" && zahlen[8] != "x"){/*Dritte Spalte1 COUNTERZUG*/
                   zahlen[8] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[5] == "x" && zahlen[8] == "x" && zahlen[2] != "O" && zahlen[2] != "x"){/*Dritte Spalte2 COUNTERZUG*/
                   zahlen[2] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[2] == "x" && zahlen[8] == "x" && zahlen[2] != "O" && zahlen[2] != "x"){/*Dritte Spalte3 COUNTERZUG*/
                   zahlen[2] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "x" && zahlen[4] == "x" && zahlen[8] != "O" && zahlen[8] != "x"){/*Schräg 1 COUNTERZUG*/
                   zahlen[8] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[4] == "x" && zahlen[8] == "x" && zahlen[0] != "O" && zahlen[0] != "x"){/*Schräg 2 COUNTERZUG*/
                   zahlen[0] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[0] == "x" && zahlen[8] == "x" && zahlen[4] != "O" && zahlen[4] != "x"){/*Schräg 3 COUNTERZUG*/
                   zahlen[4] = "O";
                   überprüfenObGewonnen();
            }else if(zahlen[6] != "O"&& zahlen[6] != "x"){/*Andere Züge*/
                zahlen[6]="O";
                   überprüfenObGewonnen(); 
            }else if(zahlen[0] != "O"&& zahlen[0] != "x"){/*Andere Züge*/
                zahlen[0]="O"; 
                   überprüfenObGewonnen();
            }else if(zahlen[2] != "O"&& zahlen[2] != "x"){/*Andere Züge*/
                zahlen[8]="O"; 
                   überprüfenObGewonnen();
            }else if(zahlen[8] != "O" && zahlen[8] != "x"){/*Andere Züge*/
                zahlen[2]="O"; 
                   überprüfenObGewonnen();
            }else if(zahlen[4] != "O"&& zahlen[4] != "x"){/*Andere Züge*/
                zahlen[4]="O"; 
                   überprüfenObGewonnen();
            }else if(zahlen[7] != "O"&& zahlen[7] != "x"){/*Andere Züge*/
                zahlen[7]="O"; 
                   überprüfenObGewonnen();
            }else if(zahlen[1] != "O"&& zahlen[1] != "x"){/*Andere Züge*/
                zahlen[1]="O"; 
                   überprüfenObGewonnen();
            }else if(zahlen[3] != "O"&& zahlen[3] != "x"){/*Andere Züge*/
                zahlen[3]="O"; 
                   überprüfenObGewonnen();
            }else if(zahlen[5] != "O"&& zahlen[5] != "x"){/*Andere Züge*/
                zahlen[5]="O"; 
                   überprüfenObGewonnen();
            }else {
                System.out.println("Alle Felder sind belegt.");
            }
        }
        }else{
           System.out.println("Geben sie eine gültige Nummer für das feld ein.");
        }
      }else{
        System.out.println("Um noch ein Spiel starten zu können müssen Sie die reset Methode verwenden.");   
      }
      
      spielfeldAusgeben();
      
      if(beleidigungsZähler == 0){
            System.out.println("KI: Du denkst das wird einfach? Falsch gedacht!");
      }
      if(beleidigungsZähler == 1){
            System.out.println("KI: Das hast du nicht erwartet was?");
        }
      if(beleidigungsZähler == 2){
            System.out.println("KI: Das ist schwieriger als ich dachte..");
        }
      if(beleidigungsZähler == 3){
            System.out.println("KI: Das war jetzt nicht geplant...");
      }
    
    }
}