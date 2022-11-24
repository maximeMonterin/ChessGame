import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Echiquier extends JComponent {
    private List<Map<Case,Piece>> plateau;
    public Echiquier() {
        plateau = new ArrayList<>();
        for(int i=0;i<8;i++){
            HashMap<Case,Piece> tmp = new HashMap<>();
            plateau.add(tmp);
        }
        setPions();
        setTours();
        setCavaliers();
        setFous();
        setReines();
        setRois();
        setVides();
    }
    public void setPions(){
        for(int i=0;i<8;i++){
            plateau.get(1).put(new Case(i % 2, 1, (char) ('A' + i)), new Pion(0));
            plateau.get(6).put(new Case((i+1) % 2, 6, (char) ('A' + i)), new Pion(1));
        }
    }
    public void setTours(){
        plateau.get(0).put(new Case(1, 0, 'A'), new Tour(0));
        plateau.get(0).put(new Case(0, 0, 'H'), new Tour(0));
        plateau.get(7).put(new Case(0, 7, 'A'), new Tour(1));
        plateau.get(7).put(new Case(1, 7, 'H'), new Tour(1));
    }
    public void setCavaliers(){
        plateau.get(0).put(new Case(0, 0, 'B'), new Cavalier(0));
        plateau.get(0).put(new Case(1, 0, 'G'), new Cavalier(0));
        plateau.get(7).put(new Case(1, 7, 'B'), new Cavalier(1));
        plateau.get(7).put(new Case(0, 7, 'G'), new Cavalier(1));
    }
    public void setFous(){
        plateau.get(0).put(new Case(1, 0, 'C'), new Fou(0));
        plateau.get(0).put(new Case(0, 0, 'F'), new Fou(0));
        plateau.get(7).put(new Case(0, 7, 'C'), new Fou(1));
        plateau.get(7).put(new Case(1, 7, 'F'), new Fou(1));
    }
    public void setRois(){
        plateau.get(0).put(new Case(1, 0, 'E'), new Roi(0));
        plateau.get(7).put(new Case(0, 7, 'E'), new Roi(1));
    }
    public void setReines(){
        plateau.get(0).put(new Case(0, 0, 'D'), new Reine(0));
        plateau.get(7).put(new Case(1, 7, 'D'), new Reine(0));
    }
    public void setVides(){
        for(int i=0;i<8;i++){
            for(int j=2;j<6;j++){
                if(j%2==0){
                    plateau.get(j).put(new Case(i%2, j, (char) ('A'+ i)), new Vide());
                }else{
                    plateau.get(j).put(new Case((i+1)%2, j, (char) ('A'+ i)), new Vide());
                }
            }
        }
    }
    public void paintComponent(Graphics g){
        Graphics2D plateauReel= (Graphics2D) g;

        int tailleCase = 90;
        boolean couleur=true;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if (couleur) {
                    plateauReel.setPaint(Color.WHITE);
                } else {
                    plateauReel.setPaint(Color.BLACK);
                }
                plateauReel.fill(new Rectangle2D.Double((j+1)*tailleCase, (i+1)*tailleCase,tailleCase,tailleCase));
                couleur=!couleur;
            }
            couleur=!couleur;
        }

        int legendeChiffres;
        for(int i=1;i<9;i++){
            plateauReel.setPaint(Color.BLACK);
            plateauReel.drawString("" + i,tailleCase/2, (int) (tailleCase*(10-i-0.5)));
        }

        for(int j=0;j<8;j++){
            plateauReel.setPaint(Color.BLACK);
            plateauReel.drawString(String.valueOf((char)('A'+ j)), (int) (tailleCase*(j+1.5)), (int) (tailleCase * 9.5));
        }

        plateauReel.setPaint(Color.BLUE);
        plateauReel.setStroke(new BasicStroke(2));
        plateauReel.draw(new Rectangle2D.Double(tailleCase,tailleCase,tailleCase*8,tailleCase*8));
        plateauReel.dispose();
    }

}























