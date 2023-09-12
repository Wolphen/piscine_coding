import java.util.Scanner;

public class Main {

   static String win_cond = "=";
   static boolean tie = false;
// Creating the id of the matrice/board
    static String[][] creer_tableau() {
        String[][] tab = new String[3][3];
        tab[0][0] = ".";
        tab[0][1] = ".";
        tab[0][2] = ".";
        tab[1][0] = ".";
        tab[1][1] = ".";
        tab[1][2] = ".";
        tab[2][0] = ".";
        tab[2][1] = ".";
        tab[2][2] = ".";
        return tab;
    }


// asking player to play + checks
    static boolean _requestAndPlay(String[][] tableau, String playStr){
        Scanner sc = new Scanner(System.in);
        System.out.println("Player "+playStr+" enter your coords : ");
        int l = sc.nextInt();
        int c = sc.nextInt();
        // check column >=0 && <=2
        if(c<0 || c>2){
            System.out.println("numero colonne faux !!");
            affiche((tableau));
            _requestAndPlay(tableau, playStr);
            return false;
        }
        // check row >=0 && <=2
        if(l<0 || l>2){
            System.out.println("numero ligne faux !!");
            affiche((tableau));
            _requestAndPlay(tableau, playStr);
            return false;
        }
        // check empty cell
        if( !tableau[l][c].equals(".") ){
            System.out.println("place occupée !!");
            affiche((tableau));
            _requestAndPlay(tableau, playStr);
            return false;
        }
        // play and return
        tableau[l][c]= playStr;
        _win_tie(tableau, playStr);
        return true;

    }
// printing the matrice/board
    public static void affiche(String[][] tablo){
        System.out.println(tablo[0][0] + "|" + tablo[0][1] + "|" + tablo[0][2] + "\n" + tablo[1][0] + "|" + tablo[1][1] + "|" + tablo[1][2] + "\n" + tablo[2][0] + "|" + tablo[2][1] + "|" + tablo[2][2]);

    }
    // win conditions





    //win & tie
    static void _win_tie(String[][] tablo, String playStr){

               if(tablo[0][0] == playStr && tablo[0][1]  == playStr && tablo[0][2] == playStr) {
                   win_cond = ".";
                   System.out.println("Le joueur " + playStr+ " à gagner la partie! ");
               }

               else if(tablo[1][0] == playStr && tablo[1][1]  == playStr && tablo[1][2] == playStr) {
                   win_cond = ".";
                   System.out.println("Le joueur " + playStr+ " à gagner la partie! ");
               }
               else  if(tablo[2][0] == playStr && tablo[2][1]  == playStr && tablo[2][2] == playStr) {
                   win_cond = ".";
                   System.out.println("Le joueur " + playStr+ " à gagner la partie! ");
               }
               else if(tablo[0][0] == playStr && tablo[1][0]  == playStr && tablo[2][0] == playStr) {
                   win_cond = ".";
                   System.out.println("Le joueur " + playStr+ " à gagner la partie! ");
               }
               else if(tablo[0][1] == playStr && tablo[1][1]  == playStr && tablo[2][1] == playStr) {
                   win_cond = ".";
                   System.out.println("Le joueur " + playStr+ " à gagner la partie! ");
               }
               else if(tablo[0][2] == playStr && tablo[1][2]  == playStr && tablo[2][2] == playStr) {
                   win_cond = ".";
                   System.out.println("Le joueur " + playStr+ " à gagner la partie! ");
               }
               else if (tablo[0][0] == playStr && tablo[1][1]  == playStr && tablo[2][2] == playStr){
                   win_cond = ".";
                   System.out.println("Le joueur " + playStr+ " à gagner la partie! ");
               }
               else if (tablo[0][2] == playStr && tablo[1][1]  == playStr && tablo[2][0] == playStr){
                   win_cond = ".";
                   System.out.println("Le joueur " + playStr+ " à gagner la partie! ");
               }
      int i = 0;
      for (String[] l : tablo) {
          for (String c : l) {
              if (c != ".") {
                  i += 1;

              }
          }
      }
      if (i == 9){
          System.out.println("Egaliter");
          tie = true;
      }
    }


    public static void main(String[] args) {
        String[][] tablo = creer_tableau();

        do{


        affiche(tablo);
        String o = "oui";
        _requestAndPlay(tablo, "X");
        affiche(tablo);
        if (win_cond == "." || tie){
        break;
        }
        o = "non";
        _requestAndPlay(tablo, "0");
        } while (win_cond != ".");
    }

}