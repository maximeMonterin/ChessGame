import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
public class Echecs extends JFrame implements ActionListener, MouseListener {
    private Echiquier plateauDeJeu;
    private List<Case> nextMouvementCases;
    private Case caseActuelle;
    private JLabel titre;
    private JLabel joueur;
    private JLabel info;
    private int compteurDeplacement = 0;
    private int positionActuelleX;
    private int positionActuelleY;
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

        this.add(info);
        this.add(joueur);
        this.add(titre);
        this.add(plateauDeJeu);
        this.setTitle("Echecs");
        this.setSize(1000,1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.addMouseListener(this);
        joueur.addMouseListener(this);
        info.addMouseListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {
        ++compteurDeplacement;
        int positionX= (e.getY()-80);
        int positionY= (e.getX()-100);
        if(positionX>=0 && positionY>=0 && positionX<=800 && positionY<=800){
            if(compteurDeplacement % 2 != 0){
                caseActuelle = plateauDeJeu.getCurrentCase(positionX/100,positionY/100);
                info.setText("Vous avez selectionné la piece '"+ plateauDeJeu.getPlateau().get(positionX/100).get(positionY/100).getNom()+"' en "+ caseActuelle.toString());
                positionActuelleX = positionX/100;
                positionActuelleY = positionY/100;
                nextMouvementCases = plateauDeJeu.getListeCase(positionActuelleX, positionActuelleY);
            } else {
                if(!nextMouvementCases.isEmpty()){
                    info.setText(plateauDeJeu.actionMouvement(positionX/100, positionY/100, nextMouvementCases, positionActuelleX, positionActuelleY));
                    if(!plateauDeJeu.getJoueur().equals("")){
                        joueur.setText("Au tour des " + plateauDeJeu.getJoueur());
                    }else{
                        info.setText("Ce n'est pas votre tour !");
                    }
                    nextMouvementCases.clear();
                }
            }
        }else{
            System.out.println("Hors Plateau");
        }
        plateauDeJeu.repaint();
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
