import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
/***
 * Classe Echecs
 * Defini le jeu des Échecs avec une interface Graphique associée
 */
public class Echecs extends JFrame implements ActionListener, MouseListener {
    private Echiquier plateauDeJeu;
    private List<Case> nextMouvementCases;
    private Case caseActuelle;
    private JLabel titre;
    private JLabel joueur;
    private JLabel info;
    public static JLabel timer = new JLabel(Main.time);
    private int compteurDeplacement = 0;
    private int positionActuelleX;
    private int positionActuelleY;

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

        joueur = new JLabel("Au tour des Noirs");
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
                /*for(Case cases : nextMouvementCases){
                    plateauDeJeu.getListeCase(cases.getPosx(), cases.getPosy());
                }*/

                }
                else {
                    try{
                        if(!nextMouvementCases.isEmpty()){
                            info.setText(plateauDeJeu.actionMouvement(positionX/100, positionY/100, nextMouvementCases, positionActuelleX, positionActuelleY));
                            List<Case> caseRoiPossible=plateauDeJeu.getListeCase(positionX/100, positionY/100);
                            for(List<Piece> pieces : plateauDeJeu.getPlateau()){
                                for(Piece piece : pieces){
                                    Case tmp = new Case(piece.getPosx(),piece.getPosy());
                                    if(piece instanceof Pion){
                                        plateauDeJeu.mangerPiece(tmp.getPosx(),tmp.getPosy(),caseRoiPossible,positionX/100,positionY/100);
                                    }else{
                                        plateauDeJeu.collisionTour_Reine(tmp.getPosx(),tmp.getPosy(),caseRoiPossible,positionX/100,positionY/100);
                                        plateauDeJeu.collisionFou_Reine(tmp.getPosx(),tmp.getPosy(),caseRoiPossible,positionX/100,positionY/100);
                                    }
                                    if( caseRoiPossible.contains(tmp) && piece instanceof Roi && ((Roi) piece).getCouleur() != plateauDeJeu.getPlateau().get(positionX / 100).get(positionY / 100).getCouleurPiece()) {
                                            ((Roi) piece).setEchec(true);
                                            info.setText("Le joueur " + (((Roi) piece).getCouleur()?"Noir":"Blanc") + " est en Echec ");
                                            //System.out.println(plateauDeJeu.getMouvementEchecRoi(((Roi) piece).getCouleur(), positionX/100, positionY/100));
                                            if(plateauDeJeu.getMouvementEchecRoi(((Roi) piece).getCouleur(), tmp.getPosx(), tmp.getPosy()).isEmpty() /*&& plateauDeJeu.getMouvementProtectionRoi(((Roi) piece).getCouleur(),inter).isEmpty()*/){
                                                info.setText("Le joueur " + (((Roi) piece).getCouleur()?"Noir":"Blanc") + " est en Echec & Mat !");
                                                //fin de partie
                                            }
                                            break;
                                    }
                                }
                            }
                            joueur.setText("Au tour des " + plateauDeJeu.getJoueur());
                            nextMouvementCases.clear();
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
