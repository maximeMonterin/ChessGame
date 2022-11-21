public class Case {
    private final int couleur;//noir=1 blanc=0
    private final int posx;
    private final char posy;

    public Case(int couleur, int posx, char posy) {
        this.couleur = couleur;
        this.posx = posx;
        this.posy = posy;
    }

    public int getCouleur() {
        return couleur;
    }

    public int getPosx() {
        return posx;
    }

    public char getPosy() {
        return posy;
    }

}
