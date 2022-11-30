import java.util.ArrayList;
import java.util.List;

public class Fou extends Piece{
    private int couleur;
    private int posx;
    private int posy;

    public Fou(int couleur, int posx, int posy) {
        super(new Case(posx, posy), posx, posy);
        this.couleur = couleur;
        this.posx = posx;
        this.posy = posy;
    }

    @Override
    String getNom() {
        return "Fou";
    }

    @Override
    public List<Case> mouvement() {

        List<Case> res = new ArrayList<>();
        for(int i=0;i<8;i++){
            if(this.getPosx()+i<=7){
                if(this.getPosy()+i<=7){
                    res.add(new Case(this.getPosx()+i,this.getPosy()+i));
                }
                if(this.getPosy()-i>=0){
                    res.add(new Case(this.getPosx()+i,this.getPosy()-i));
                }
            }

            if (this.getPosx()-i>=0){
                if(this.getPosy()+i<=7){
                    res.add(new Case(this.getPosx()-i,this.getPosy()+i));
                }
                if(this.getPosy()-i>=0){
                    res.add(new Case(this.getPosx()-i,this.getPosy()-i));
                }
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
