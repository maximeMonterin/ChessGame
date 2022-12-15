import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/***
 * Classe Echecs
 * Defini le jeu des Échecs avec une interface Graphique associée
 */
public class Echecs extends JFrame implements ActionListener, MouseListener {
    private final Echiquier plateauDeJeu;
    private List<Case> nextMouvementCases;
    private Case caseActuelle;
    private final JLabel titre;
    private final JLabel joueur;
    private final JLabel info;
    public static JLabel timer = new JLabel(Main.time);
    private int compteurDeplacement = 0;
    private int positionActuelleX;
    private int positionActuelleY;
    private List<Case> mouvementPossibleRoiEnEchec = new ArrayList<>();
    private HashMap<Piece,Case> mouvementPossiblePieceEnEchec = new HashMap<>();

    /***
     * Contructeur de Echecs
     * Defini la taille de la fenetre de l'interface
     * Defini le plateauDeJeu de la Classe Echiquier sur lequel on va jouer
     * Defini les différents attribut composants la fenetre
     */
    public Echecs(){
        plateauDeJeu = new Echiquier();
        plateauDeJeu.setBounds(0,0,910,910);

        titre = new JLabel("Echecs");
        titre.setBounds(100,10, 200, 30);
        titre.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        joueur = new JLabel("Au tour des Bleus");
        joueur.setBounds(650,10, 300, 30);
        joueur.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));

        info = new JLabel("");
        info.setBounds(350,920, 500, 20);
        info.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

        timer.setBounds(300,10, 500, 30);
        timer.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

        this.add(info);
        this.add(joueur);
        this.add(titre);
        this.add(timer);
        this.add(plateauDeJeu);
        this.setTitle("Echecs");
        this.setSize(1000,1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.addMouseListener(this);
        joueur.addMouseListener(this);
        info.addMouseListener(this);
    }

    /***
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {}

    /***
     * Permet de déplacer les differentes piece du plateauDeJeu grâce aux clics de la souris
     * Modifie l'affichage en fonction des actions effectuées
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        ++compteurDeplacement;
        int positionX= (e.getY()-80);
        int positionY= (e.getX()-100);
        if(positionX>=0 && positionY>=0 && positionX<=800 && positionY<=800){
            if(compteurDeplacement % 2 != 0){
                caseActuelle = plateauDeJeu.getCaseActuelle(positionX/100,positionY/100);
                info.setText("Vous avez selectionné la piece '" + plateauDeJeu.getPlateau().get(positionX / 100).get(positionY / 100).getNom() + "' en " + caseActuelle.toString());
                positionActuelleX = positionX / 100;
                positionActuelleY = positionY / 100;
                nextMouvementCases = plateauDeJeu.getListeCase(positionActuelleX, positionActuelleY);

                }
            else {
                try {
                    if (!nextMouvementCases.isEmpty()) {

                        if (!(plateauDeJeu.getRoi(plateauDeJeu.getPlateau().get(positionX / 100).get(positionY / 100).getCouleurPiece()).isEchec())) {
                            info.setText(plateauDeJeu.actionMouvement(positionX / 100, positionY / 100, nextMouvementCases, positionActuelleX, positionActuelleY));
                            List<Case> caseRoiPossible = plateauDeJeu.getListeCase(positionX / 100, positionY / 100);
                            for (List<Piece> pieces : plateauDeJeu.getPlateau()) {
                                for (Piece piece : pieces) {
                                    Case tmp = new Case(piece.getPosx(), piece.getPosy());
                                    if (piece instanceof Pion) {
                                        plateauDeJeu.mangerPiece(tmp.getPosx(), tmp.getPosy(), caseRoiPossible, positionX / 100, positionY / 100);
                                    } else {
                                        if(plateauDeJeu.getPlateau().get(positionX/100).get(positionY/100) instanceof Fou ||plateauDeJeu.getPlateau().get(positionX/100).get(positionY/100) instanceof Reine)
                                            plateauDeJeu.collisionTour_Reine(tmp.getPosx(), tmp.getPosy(), caseRoiPossible, positionX / 100, positionY / 100);
                                        else if(plateauDeJeu.getPlateau().get(positionX/100).get(positionY/100) instanceof Reine || plateauDeJeu.getPlateau().get(positionX/100).get(positionY/100) instanceof Tour)
                                            plateauDeJeu.collisionFou_Reine(tmp.getPosx(), tmp.getPosy(), caseRoiPossible, positionX / 100, positionY / 100);
                                    }
                                    if (caseRoiPossible.contains(tmp) && piece instanceof Roi && (piece).getCouleurPiece() != plateauDeJeu.getPlateau().get(positionX / 100).get(positionY / 100).getCouleurPiece()) {
                                        ((Roi) piece).setEchec(true);
                                        info.setText("Le joueur " + (( piece).getCouleurPiece() ? "Bleu" : "Beige") + " est en Echec ");
                                        List<Case> inter = plateauDeJeu.getCaseEntre(positionX / 100, positionY / 100, piece.getPosx(), piece.getPosy());
                                        mouvementPossibleRoiEnEchec = plateauDeJeu.getMouvementEchecRoi((piece).getCouleurPiece(), tmp.getPosx(), tmp.getPosy());
                                        mouvementPossiblePieceEnEchec = plateauDeJeu.getMouvementProtectionRoi((piece).getCouleurPiece(), inter);
                                        if (mouvementPossibleRoiEnEchec.isEmpty() && mouvementPossiblePieceEnEchec.isEmpty()){
                                            info.setText("Le joueur " + (( piece).getCouleurPiece() ? "Bleu" : "Beige") + " est en Echec & Mat !");
                                            plateauDeJeu.setFinDePartie(true);
                                        }
                                        break;
                                    }
                                }
                            }
                            joueur.setText("Au tour des " + plateauDeJeu.getJoueur());
                            nextMouvementCases.clear();
                        } else {
                            if(plateauDeJeu.getPlateau().get(positionActuelleX).get(positionActuelleY) instanceof Roi && !mouvementPossibleRoiEnEchec.isEmpty() && mouvementPossibleRoiEnEchec.contains(new Case(positionX/100,positionY/100))) {
                                ((Roi) plateauDeJeu.getPlateau().get(positionActuelleX).get(positionActuelleY)).setEchec(false);
                                info.setText(plateauDeJeu.actionMouvement(positionX / 100, positionY / 100, nextMouvementCases, positionActuelleX, positionActuelleY));
                            }else if(!mouvementPossiblePieceEnEchec.isEmpty() && !(plateauDeJeu.getPlateau().get(positionActuelleX).get(positionActuelleY) instanceof Roi)){
                                plateauDeJeu.getRoi(plateauDeJeu.getPlateau().get(positionActuelleX).get(positionActuelleY).getCouleurPiece()).setEchec(false);
                                info.setText(plateauDeJeu.actionMouvement(positionX / 100, positionY / 100, nextMouvementCases, positionActuelleX, positionActuelleY));
                            }else{
                                info.setText("Vous ne pouvez pas jouer cette pièce car vous êtes en Echec!");
                            }
                        }
                    }
                }catch(Exception exe){
                    System.out.println("La case Vide ne fait rien");
                }
            }
        }else{
            System.out.println("Hors Plateau");
        }
        plateauDeJeu.repaint();
    }

    /***
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {}

    /***
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {}

    /***
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {}

    /***
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {}
}
