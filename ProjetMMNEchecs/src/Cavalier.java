import java.util.ArrayList;
import java.util.List;

public class Cavalier extends Piece{
    private int couleur;
    private int posx;
    private int posy;

    public Cavalier(int couleur, int posx, int posy) {
        super(new Case(posx, posy), posx, posy);
        this.couleur = couleur;
        this.posx = posx;
        this.posy = posy;
    }

    @Override
    String getNom() {
        return "Cavalier";
    }

    @Override
    public List<Case> mouvement() {

        List<Case> res = new ArrayList<>();

        if(this.getPosx()+2<=7){
            if(this.getPosy()+1<=7){
                res.add(new Case(this.getPosx()+2, this.getPosy()+1));
            }
            if(this.getPosy()-1>=0){
                res.add(new Case(this.getPosx()+2, this.getPosy()-1));
            }
        }

        if(this.getPosx()-2>=0){
            if(this.getPosy()+1<=7){
                res.add(new Case(this.getPosx()-2, this.getPosy()+1));
            }
            if(this.getPosy()-1>=0){
                res.add(new Case(this.getPosx()-2, this.getPosy()-1));
            }
        }

        if(this.getPosx()+1<=7){
            if(this.getPosy()+2<=7){
                res.add(new Case(this.getPosx()+1, this.getPosy()+2));
            }
            if(this.getPosy()-2>=0){
                res.add(new Case(this.getPosx()+1, this.getPosy()-2));
            }
        }

        if(this.getPosx()-1>=0){
            if(this.getPosy()+2<=7){
                res.add(new Case(this.getPosx()-1, this.getPosy()+2));
            }
            if(this.getPosy()-2>=0){
                res.add(new Case(this.getPosx()-1, this.getPosy()-2));
            }
        }
        return res;
    }

    @Override
    public void manger() {

    }

    public int getCouleur() {
        return couleur;
    }


}
