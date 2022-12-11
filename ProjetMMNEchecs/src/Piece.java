import java.util.List;

/***
 * Classe abstraite Piece
 * Defini une Piece et ses différentes fonctionnalités a implémenter
 */
public abstract class Piece {
    private int posx;
    private int posy;
    protected Case position;
    protected Boolean couleur;
    /*True = colore = Noir
        false = non colore = blanc
     */

    /***
     * Getter pour recupérer la couleur de la Piece
     * @return int
     */
    public Boolean getCouleurPiece() {
        return couleur;
    }

    /***
     * Constructeur 1 de Piece
     * @param position La case ou est la piece
     * @param posx la position en x de la case
     * @param posy la position en y de la case
     */
    public Piece(Case position, int posx, int posy) {
        this.position = position;
        this.posx = posx;
        this.posy = posy;
        this.couleur = false;
    }

    /***
     * Constructeur 2 de Piece
     * @param position la case ou est la piece
     * @param posx la position en x de la case
     * @param posy la position en y de la case
     * @param couleur la couleur de la piece
     */
    public Piece(Case position, int posx, int posy, Boolean couleur) {
        this(position, posx, posy);
        this.couleur = couleur;
    }

    /***
     * getter du nom de la piece
     * @return String
     */
    abstract String getNom();

    /***
     * Mouvements correspondant aux cases où pourra aller la piece au prochain coup
     * @return List<Case>
     */
    abstract List<Case> mouvement();

    /***
     * Getter pour récuperer la case de la piece
     * @return Case
     */
    public Case getPosition() {
        return position;
    }

    /***
     * Setter de la Case sur laquelle la piece se trouve
     * @param position
     */
    public void setPosition(Case position) {
        this.position = position;
    }

    /***
     * Getter de la position en x de la case
     * @return int
     */
    public int getPosx() {
        return posx;
    }

    /***
     * Setter de la position en x de la case
     * @param posx
     */
    public void setPosx(int posx) {
        this.posx = posx;
    }

    /***
     * Getter de la position en y de la case
     * @return int
     */
    public int getPosy() {
        return posy;
    }

    /***
     * Setter de la position en y de la case
     * @param posy
     */
    public void setPosy(int posy) {
        this.posy = posy;
    }

    /***
     * permet de définir si la piece que l'on souhaite manger est bien de la couleur opposée
     * @param p piece que l'on veut manger
     * @return Boolean
     */
    abstract Boolean manger(Piece p);
}
