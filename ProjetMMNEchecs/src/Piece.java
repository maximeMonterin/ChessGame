import java.util.List;

public abstract class Piece {
    protected Case position;

    public Piece(Case position) {
        this.position = position;
    }

    abstract String getNom();

    abstract List<Case> mouvement();

    abstract void manger();
    public Case getPosition() {
        return position;
    }


}
