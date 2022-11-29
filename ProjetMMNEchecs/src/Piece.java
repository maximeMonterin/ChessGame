import java.util.List;

public abstract class Piece {
    private int posx;
    private int posy;
    protected Case position;

    public Piece(Case position, int posx, int posy) {
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

    public void setPosition(Case position) {
        this.position = position;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }
}
