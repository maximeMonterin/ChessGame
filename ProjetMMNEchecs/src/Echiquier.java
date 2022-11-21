import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Echiquier {
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
            plateau.get(1).put(new Case(i % 2, 1, (char) ('A' + i)), new Pion());
            plateau.get(6).put(new Case((i+1) % 2, 6, (char) ('A' + i)), new Pion());
        }
    }

    public void setTours(){
        plateau.get(0).put(new Case(1, 0, 'A'), new Tour());
        plateau.get(0).put(new Case(0, 0, 'H'), new Tour());
        plateau.get(7).put(new Case(0, 7, 'A'), new Tour());
        plateau.get(7).put(new Case(1, 7, 'H'), new Tour());
    }

    public void setCavaliers(){
        plateau.get(0).put(new Case(0, 0, 'B'), new Cavalier());
        plateau.get(0).put(new Case(1, 0, 'G'), new Cavalier());
        plateau.get(7).put(new Case(1, 7, 'B'), new Cavalier());
        plateau.get(7).put(new Case(0, 7, 'G'), new Cavalier());
    }

    public void setFous(){
        plateau.get(0).put(new Case(1, 0, 'C'), new Fou());
        plateau.get(0).put(new Case(0, 0, 'F'), new Fou());
        plateau.get(7).put(new Case(0, 7, 'C'), new Fou());
        plateau.get(7).put(new Case(1, 7, 'F'), new Fou());
    }

    public void setRois(){
        plateau.get(0).put(new Case(1, 0, 'E'), new Roi());
        plateau.get(7).put(new Case(0, 7, 'E'), new Roi());
    }

    public void setReines(){
        plateau.get(0).put(new Case(0, 0, 'D'), new Reine());
        plateau.get(7).put(new Case(1, 7, 'D'), new Reine());
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
}























