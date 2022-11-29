import java.util.List;

public abstract class Piece {
    private int posx;
    private char posy;
    protected Case position;

    public Piece(Case position, int posx, char posy) {
        this.position = position;
        this.posx = posx;
        this.posy = posy;
    }

    abstract String getNom();

    abstract List<Case> mouvement();

    abstract void manger();
    public Case getPosition() {
        return position;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public char getPosy() {
        return posy;
    }

    public void setPosy(char posy) {
        this.posy = posy;
    }
}
