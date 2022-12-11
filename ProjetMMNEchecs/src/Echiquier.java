import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/***
 * Classe Echiquier heritant de Jcomponent
 * Defini un echiquier de jeu avec son affichage
 */
public class Echiquier extends JComponent {
    private List<List<Piece>> plateau;
    private BufferedImage iconePiece;
    private int cptMouvement = 0;
    private String joueur = "Noirs";

    /***
     * Getter du nom du joueur qui joue
     * @return String
     */
    public String getJoueur() {
        return joueur;
    }

    /***
     * Constructeur de Echiquier
     * Initialise le plateau virtuellement et le placement des différentes Pieces dans celui-ci
     */
    public Echiquier() {
        plateau = new ArrayList<>();
        for(int i=0;i<8;i++){
            List<Piece> tmp = new ArrayList<>();
            plateau.add(tmp);
        }
        setVides();
        setPions();
        setTours();
        setCavaliers();
        setFous();
        setReines();
        setRois();
    }

    /***
     * Initialise les pions virtuellement dans le plateau
     */
    public void setPions(){
        for(int i=0;i<8;i++){
            plateau.get(1).set(i,new Pion(false,1, i ));
            plateau.get(6).set(i,new Pion(true,6, i));
        }
    }

    /***
     * Initialise les tours virtuellement dans le plateau
     */
    public void setTours(){
        plateau.get(0).set(0,new Tour(false, 0, 0));
        plateau.get(0).set(7,new Tour(false, 0, 7));
        plateau.get(7).set(0,new Tour(true, 7, 0));
        plateau.get(7).set(7,new Tour(true, 7, 7));
    }

    /***
     * Initialise les cavaliers virtuellement dans le plateau
     */
    public void setCavaliers(){
        plateau.get(0).set(1,new Cavalier(false, 0, 1));
        plateau.get(0).set(6,new Cavalier(false, 0, 6));
        plateau.get(7).set(1,new Cavalier(true, 7, 1));
        plateau.get(7).set(6,new Cavalier(true, 7, 6));
    }

    /***
     * Initialise les fous virtuellement dans le plateau
     */
    public void setFous(){
        plateau.get(0).set(2,new Fou(false, 0, 2));
        plateau.get(0).set(5,new Fou(false, 0, 5));
        plateau.get(7).set(2,new Fou(true, 7, 2));
        plateau.get(7).set(5,new Fou(true, 7, 5));
    }

    /***
     * Initialise les rois virtuellement dans le plateau
     */
    public void setRois(){
        plateau.get(0).set(4,new Roi(false,0, 4));
        plateau.get(7).set(4,new Roi(true,7, 4));
    }

    /***
     * Initialise les reines virtuellement dans le plateau
     */
    public void setReines(){
        plateau.get(0).set(3,new Reine(false,0, 3));
        plateau.get(7).set(3,new Reine(true,7, 3));
    }

    /***
     * Initialise les cases vides virtuellement dans le plateau
     */
    public void setVides(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(j%2==0){
                    plateau.get(j).add(new Vide(j, i));
                }else{
                    plateau.get(j).add(new Vide(j, i));
                }
            }
        }
    }

    /***
     * Permet l'affichage des images des pions sur l'echiquier
     * @param plateauReel le plateau réel (celui affiché)
     * @param tailleCase la taille d'une case du plateau
     */
    public void setImagePiece(Graphics2D plateauReel, int tailleCase){
        String couleurPiece = "";
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(plateau.get(i).get(j) instanceof Pion){
                    if(!((Pion) plateau.get(i).get(j)).getCouleur()){couleurPiece = "blanc";}
                    else {couleurPiece = "noir";}
                    try {
                        iconePiece = ImageIO.read(new FileInputStream("images/" + couleurPiece + "/pion.png"));
                    } catch (IOException e) {
                        System.out.println("err: image pion non trouvée");
                    }
                    plateauReel.drawImage(iconePiece, (int)((j+1.05)*tailleCase), (int)((i+0.55)*tailleCase), this);
                }

                else if(plateau.get(i).get(j) instanceof Tour){
                    if(!((Tour) plateau.get(i).get(j)).getCouleur()){couleurPiece = "blanc";}
                    else {couleurPiece = "noir";}
                    {
                        try {
                            iconePiece = ImageIO.read(new FileInputStream("images/" + couleurPiece + "/tour.png"));
                        } catch (IOException e) {
                            System.out.println("err: image tour non trouvée");
                        }
                    }
                    plateauReel.drawImage(iconePiece,(int)((j+1.05)*tailleCase), (int)((i+0.55)*tailleCase), this);
                }

                else if(plateau.get(i).get(j) instanceof Cavalier){
                    if(!((Cavalier) plateau.get(i).get(j)).getCouleur()){couleurPiece = "blanc";}
                    else {couleurPiece = "noir";}
                    {
                        try {
                            iconePiece = ImageIO.read(new FileInputStream("images/" + couleurPiece + "/cheval.png"));
                        } catch (IOException e) {
                            System.out.println("err: image cavalier non trouvée");
                        }
                    }
                    plateauReel.drawImage(iconePiece, (int)((j+1.05)*tailleCase), (int)((i+0.55)*tailleCase), this);

                }

                else if(plateau.get(i).get(j) instanceof Fou){
                    if(!((Fou) plateau.get(i).get(j)).getCouleur()){couleurPiece = "blanc";}
                    else {couleurPiece = "noir";}
                    {
                        try {
                            iconePiece = ImageIO.read(new FileInputStream("images/" + couleurPiece + "/fou.png"));
                        } catch (IOException e) {
                            System.out.println("err: image fou non trouvée");
                        }
                    }
                    plateauReel.drawImage(iconePiece, (int)((j+1.05)*tailleCase), (int)((i+0.55)*tailleCase), this);

                }

                else if(plateau.get(i).get(j) instanceof Roi){
                    if(!((Roi) plateau.get(i).get(j)).getCouleur()){couleurPiece = "blanc";}
                    else {couleurPiece = "noir";}
                    {
                        try {
                            iconePiece = ImageIO.read(new FileInputStream("images/"+ couleurPiece +"/roi.png"));
                        } catch (IOException e) {
                            System.out.println("err: image roi non trouvée");
                        }
                    }
                    plateauReel.drawImage(iconePiece, (int)((j+1.05)*tailleCase), (int)((i+0.55)*tailleCase), this);

                }

                else if(plateau.get(i).get(j) instanceof Reine){
                    if(!((Reine) plateau.get(i).get(j)).getCouleur()){couleurPiece = "blanc";}
                    else {couleurPiece = "noir";}
                    {
                        try {
                            iconePiece = ImageIO.read(new FileInputStream("images/"+ couleurPiece +"/reine.png"));
                        } catch (IOException e) {
                            System.out.println("err: image reine non trouvée");
                        }
                    }
                    plateauReel.drawImage(iconePiece, (int)((j+1.05)*tailleCase), (int)((i+0.55)*tailleCase), this);
                }
            }
        }
    }

    /***
     * Permet l'affichage de l'échiquier et comment l'afficher
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g){
        Graphics2D plateauReel= (Graphics2D) g;

        int tailleCase = 100;
        boolean couleur=true;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if (couleur) {
                    plateauReel.setPaint(Color.WHITE);
                } else {
                    plateauReel.setPaint(Color.BLACK);
                }
                plateauReel.fill(new Rectangle2D.Double((j+1)*tailleCase, (i+0.5)*tailleCase,tailleCase,tailleCase));
                couleur=!couleur;
            }
            couleur=!couleur;
        }

        for(int i=1;i<9;i++){
            plateauReel.setPaint(Color.BLACK);
            plateauReel.drawString("" + i,tailleCase/2, (tailleCase*(9-i)));
        }

        for(int j=0;j<8;j++){
            plateauReel.setPaint(Color.BLACK);
            plateauReel.drawString(String.valueOf((char)('A'+ j)), (int) (tailleCase*(j+1.45)),(tailleCase * 9));
        }

        setImagePiece(plateauReel, tailleCase);
        plateauReel.dispose();
    }

    /***
     * Récupere la liste des cases où la piece en positionX et positionY peut aller au prochain coup
     * @param positionX position en x de la piece
     * @param positionY position en y de la piece
     * @return List<Case>
     */
    public List<Case> getListeCase(int positionX, int positionY){
       return (plateau.get(positionX).get(positionY)).mouvement();
    }

    /***
     * Verifie si l'endroit où l'on veut aller est vide ou pas et si oui vérifie que les mouvements que la piece peut faire lui permette bien de manger
     * @param positionX position en x de où on veut aller avec la piece
     * @param positionY position en y de où on veut aller avec la piece
     * @param mouvementCasesPossibles liste des cases où la piece en positionActuelleX et positionActuelleY peut aller au prochain coup
     * @param positionActuelleX position en x actuelle de la piece
     * @param positionActuelleY position en y actuelle de la piece
     * @return boolean (true si la piece peut manger sinon false)
     */
    public boolean Manger(int positionX, int positionY, List<Case> mouvementCasesPossibles, int positionActuelleX, int positionActuelleY){
        Boolean peutManger = true;
        if(!(plateau.get(positionX).get(positionY) instanceof Vide) ){
            peutManger =plateau.get(positionActuelleX).get(positionActuelleY).manger(plateau.get(positionX).get(positionY));
            if(plateau.get(positionActuelleX).get(positionActuelleY) instanceof Pion){
                mouvementCasesPossibles.remove(0);
                if(mouvementCasesPossibles.size() == 3){
                    mouvementCasesPossibles.remove(0);
                }
            }
        }else{
            if(plateau.get(positionActuelleX).get(positionActuelleY) instanceof Pion){
                mouvementCasesPossibles.remove(mouvementCasesPossibles.size()-1);
                mouvementCasesPossibles.remove(mouvementCasesPossibles.size()-1);
                if(!(plateau.get(positionActuelleX-1).get(positionActuelleY) instanceof Vide) && ((Pion) plateau.get(positionActuelleX).get(positionActuelleY)).getCouleur() == true){
                    mouvementCasesPossibles.remove(mouvementCasesPossibles.size()-1);
                }
                else if(!(plateau.get(positionActuelleX+1).get(positionActuelleY) instanceof Vide) && ((Pion) plateau.get(positionActuelleX).get(positionActuelleY)).getCouleur() == false){
                    mouvementCasesPossibles.remove(mouvementCasesPossibles.size()-1);
                }
            }
        }
        return peutManger;
    }

    /***
     * Si la piece est une tour ou une reine, octroie ou non les mouvements réels que la piece peut faire horizontalement et verticalement
     * @param positionX position en x de où on veut aller avec la piece
     * @param positionY position en y de où on veut aller avec la piece
     * @param mouvementCasesPossibles liste des cases où la piece en positionActuelleX et positionActuelleY peut aller au prochain coup
     * @param positionActuelleX position en x actuelle de la piece
     * @param positionActuelleY position en y actuelle de la piece
     */
    public void collisionTour_Reine(int positionX, int positionY, List<Case> mouvementCasesPossibles, int positionActuelleX, int positionActuelleY){
        if(plateau.get(positionActuelleX).get(positionActuelleY) instanceof Tour || plateau.get(positionActuelleX).get(positionActuelleY) instanceof Reine){
            if(positionX == positionActuelleX){
                if(positionActuelleY-positionY > 0) {
                    for (int i = 1; i < Math.abs(positionActuelleY - positionY); ++i) {
                        if (!(plateau.get(positionActuelleX).get(positionActuelleY-i) instanceof Vide)) {
                            mouvementCasesPossibles.remove(new Case(positionX,positionY));
                            break;
                        }
                    }
                }else if (positionActuelleY-positionY < 0){
                    for (int i = 1; i < Math.abs(positionActuelleY - positionY); ++i) {
                        if (!(plateau.get(positionActuelleX).get(positionActuelleY+i) instanceof Vide)) {
                            mouvementCasesPossibles.remove(new Case(positionX,positionY));
                            break;
                        }
                    }
                }
            }
            else if(positionY == positionActuelleY){
                if(positionActuelleX-positionX > 0) {
                    for (int i = 1; i < Math.abs(positionActuelleX - positionX); ++i) {
                        if (!(plateau.get(positionActuelleX - i).get(positionY) instanceof Vide)) {
                            mouvementCasesPossibles.remove(new Case(positionX,positionY));
                            break;
                        }
                    }
                }else if (positionActuelleX-positionX < 0){
                    for (int i = 1; i < Math.abs(positionActuelleX - positionX); ++i) {
                        if (!(plateau.get(positionActuelleX + i).get(positionY) instanceof Vide)) {
                            mouvementCasesPossibles.remove(new Case(positionX,positionY));
                            break;
                        }
                    }
                }
            }
        }
    }

    /***
     * Si la piece est un fou ou une reine, octroie ou non les mouvements réels que la piece peut faire diagonalement
     * @param positionX position en x de où on veut aller avec la piece
     * @param positionY position en y de où on veut aller avec la piece
     * @param mouvementCasesPossibles liste des cases où la piece en positionActuelleX et positionActuelleY peut aller au prochain coup
     * @param positionActuelleX position en x actuelle de la piece
     * @param positionActuelleY position en y actuelle de la piece
     */
    public void collisionFou_Reine(int positionX, int positionY, List<Case> mouvementCasesPossibles, int positionActuelleX, int positionActuelleY){
        if(plateau.get(positionActuelleX).get(positionActuelleY) instanceof Fou || plateau.get(positionActuelleX).get(positionActuelleY) instanceof Reine){
            if(positionX<positionActuelleX){
                if(positionY<positionActuelleY){
                    for(int i=1;i<Math.abs(positionActuelleX-positionX);++i){
                        if(!(plateau.get(positionActuelleX-i).get(positionActuelleY-i) instanceof Vide)){
                            mouvementCasesPossibles.remove(new Case(positionX, positionY));
                            break;
                        }
                    }
                }else if(positionY>positionActuelleY){
                    for(int i=1;i<Math.abs(positionActuelleX-positionX);++i){
                        if(!(plateau.get(positionActuelleX-i).get(positionActuelleY+i) instanceof Vide)){
                            mouvementCasesPossibles.remove(new Case(positionX, positionY));
                            break;
                        }
                    }

                }
            }else if (positionX>positionActuelleX) {
                if (positionY < positionActuelleY) {
                    for (int i = 1; i < Math.abs(positionActuelleX - positionX); ++i) {
                        if (!(plateau.get(positionActuelleX + i).get(positionActuelleY - i) instanceof Vide)) {
                            mouvementCasesPossibles.remove(new Case(positionX, positionY));
                            break;
                        }
                    }

                } else if (positionY > positionActuelleY) {
                    for (int i = 1; i < Math.abs(positionActuelleX - positionX); ++i) {
                        if (!(plateau.get(positionActuelleX + i).get(positionActuelleY + i) instanceof Vide)) {
                            mouvementCasesPossibles.remove(new Case(positionX, positionY));
                            break;
                        }
                    }

                }
            }
        }
    }

    /***
     * Effectue les mouvements de la piece en fonction de ce que l'utilisateur fait si c'est possible ou non
     * @param positionX position en x de où on veut aller avec la piece
     * @param positionY position en y de où on veut aller avec la piece
     * @param mouvementCasesPossibles liste des cases où la piece en positionActuelleX et positionActuelleY peut aller au prochain coup
     * @param positionActuelleX position en x actuelle de la piece
     * @param positionActuelleY position en y actuelle de la piece
     * @return String renvoie les actions de jeux
     */
    public String actionMouvement(int positionX, int positionY, List<Case> mouvementCasesPossibles, int positionActuelleX, int positionActuelleY){
        String retourInfo="";
        Case prochaineCase = this.getCaseActuelle(positionX, positionY);
        boolean peutManger = Manger(positionX, positionY, mouvementCasesPossibles, positionActuelleX, positionActuelleY);
        collisionTour_Reine(positionX, positionY, mouvementCasesPossibles, positionActuelleX, positionActuelleY);
        collisionFou_Reine(positionX, positionY, mouvementCasesPossibles, positionActuelleX, positionActuelleY);

        if(cptMouvement % 2 == 0){

            if (mouvementCasesPossibles.contains(prochaineCase) && peutManger && plateau.get(positionActuelleX).get(positionActuelleY).getCouleurPiece()==true) {
                this.joueur = "Blancs";
                ++cptMouvement;
                retourInfo = plateau.get(positionActuelleX).get(positionActuelleY).getNom() +" déplacé(e) en " + prochaineCase.toString(); //this.joueur
                plateau.get(positionActuelleX).get(positionActuelleY).setPosition(prochaineCase);

                plateau.get(positionActuelleX).get(positionActuelleY).setPosx(positionX);
                plateau.get(positionActuelleX).get(positionActuelleY).setPosy(positionY);


                plateau.get(positionX).set(positionY, plateau.get(positionActuelleX).get(positionActuelleY));
                plateau.get(positionActuelleX).set(positionActuelleY, new Vide(positionActuelleX, positionActuelleY));
            } else {
                if(plateau.get(positionActuelleX).get(positionActuelleY).getCouleurPiece()==false){
                    retourInfo = "Ce n'est pas votre tour !" ;
                }else {
                    retourInfo = "Vous ne pouvez pas vous déplacer ici" ;
                }
            }
        }
        else {

            if (mouvementCasesPossibles.contains(prochaineCase) && peutManger && plateau.get(positionActuelleX).get(positionActuelleY).getCouleurPiece()==false) {
                this.joueur = "Noirs";
                ++cptMouvement;
                retourInfo = plateau.get(positionActuelleX).get(positionActuelleY).getNom() +" déplacé(e) en " + prochaineCase.toString();
                plateau.get(positionActuelleX).get(positionActuelleY).setPosition(prochaineCase);

                plateau.get(positionActuelleX).get(positionActuelleY).setPosx(positionX);
                plateau.get(positionActuelleX).get(positionActuelleY).setPosy(positionY);

                plateau.get(positionX).set(positionY, plateau.get(positionActuelleX).get(positionActuelleY));
                plateau.get(positionActuelleX).set(positionActuelleY, new Vide(positionActuelleX, positionActuelleY));
            } else {
                if(plateau.get(positionActuelleX).get(positionActuelleY).getCouleurPiece()==true){
                    retourInfo = "Ce n'est pas votre tour !" ;
                }else {
                    retourInfo = "Vous ne pouvez pas vous déplacer ici" ;
                }
            }
        }
        return retourInfo;
    }

    /***
     * recupère la case actuelle sur le plateau en fonction des positions x et y
     * @param positionX position en x de où on veut aller avec la piece
     * @param positionY position en y de où on veut aller avec la piece
     * @return Case
     */
    public Case getCaseActuelle(int positionX, int positionY){
        Case caseActuelle = new Case(plateau.get(positionX).get(positionY).getPosition().getPosx(), plateau.get(positionX).get(positionY).getPosition().getPosy());
        return caseActuelle;
    }

    /***
     * Getter pour récuperer le plateau de jeu
     * @return List<List<Piece>>
     */
    public List<List<Piece>> getPlateau() {
        return plateau;
    }
}
