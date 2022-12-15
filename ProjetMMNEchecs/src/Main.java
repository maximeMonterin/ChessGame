import java.util.Timer;
import java.util.TimerTask;

/***
 * Main de du Jeu D'echecs
 */
public class Main {

    static int sec = 0;
    static int min = 0;
    static int hour = 0;
    public static String time = "";
    public static TimerTask timerTask;


    /***
     * Constructeur de Main
     * Instancie un jeu d'echecs et son affichage
     * @param args String[]
     */
    public static void main(String[] args){
        timerTask = new TimerTask() {
            @Override
            public void run() {
                time = "Temps: " + hour + "h " + min + "min " + sec + "sec";
                Echecs.timer.setText(time);
                sec++;
                if(min == 60){
                    ++hour;
                    min = 0;
                    sec = 0;
                }
                if(sec == 60){
                    ++min;
                    sec = 0;
                }
            }
        };

        Timer timer = new Timer("Timer");

        timer.scheduleAtFixedRate(timerTask, 30, 1000);
        Echecs Chess= new Echecs();
        Chess.setVisible(true);
    }
}
