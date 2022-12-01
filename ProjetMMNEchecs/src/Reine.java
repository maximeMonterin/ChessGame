import java.util.ArrayList;
import java.util.List;

public class Reine extends Piece{
    private int posx;
    private int posy;
    private Case caseReine;

    public Reine(int couleur, int posx, int posy) {
        super(new Case(posx, posy), posx, posy,couleur);
        this.posx = posx;
        this.posy = posy;
    }

    @Override
    String getNom() {
        return "Reine";
    }

    @Override
    public List<Case> mouvement() {

        List<Case> res = new ArrayList<>();
        for(int i=0;i<8;i++){
            if(i!=this.getPosx()){
                res.add(new Case(i, this.getPosy()));
            }

            if(i!=this.getPosy()) {
                res.add(new Case(this.getPosx(), i));
            }

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
    public Boolean manger(Piece next) {
        return (couleur != next.getCouleurPiece());
    }

    public int getCouleur(){
        return this.getCouleurPiece();
    }
}
