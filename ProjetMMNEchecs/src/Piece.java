import java.util.List;

public abstract class Piece {
    protected Case position;

    public Piece(Case position) {
        this.position = position;
    }
    abstract List<Case> mouvement(Case case_de_la_piece);

    abstract void manger();
    public Case getPosition() {
        return position;
    }
}
