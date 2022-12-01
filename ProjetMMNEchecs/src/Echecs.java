import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
public class Echecs extends JFrame implements ActionListener, MouseListener {
    private Echiquier plateau;
    private List<Case> oldMouvementCases;
    private Case currCase;
    private JLabel titre;
    private JLabel joueur;
    private JLabel info;
    private int cpt = 0;
    private int savePosX;
    private int savePosY;
    public Echecs(){
        plateau= new Echiquier();
        plateau.setBounds(0,0,910,910);

        titre = new JLabel("Echecs");
        titre.setBounds(100,10, 200, 30);
        titre.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        joueur= new JLabel("Au tour de Joueur 1");
        joueur.setBounds(650,10, 300, 30);
        joueur.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));

        info= new JLabel("");
        info.setBounds(350,920, 500, 20);
        info.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

        this.add(info);
        this.add(joueur);
        this.add(titre);
        this.add(plateau);
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
        ++cpt;
        int positionX= (e.getY()-80);
        int positionY= (e.getX()-100);
        if(positionX>=0 && positionY>=0 && positionX<=800 && positionY<=800){
            if(cpt % 2 != 0){
                currCase = plateau.getCurrentCase(positionX/100,positionY/100);
                info.setText("Vous avez selectionné la piece '"+ plateau.getPlateau().get(positionX/100).get(positionY/100).getNom()+"' en "+ currCase.toString());
                //System.out.println("Vous avez selectionné la piece '"+ plateau.getPlateau().get(positionX/100).get(positionY/100).getNom()+"' en "+ currCase.toString());
                savePosX = positionX/100;
                savePosY = positionY/100;
                oldMouvementCases = plateau.getListeCase(savePosX, savePosY);
            } else {
                info.setText(plateau.actionMouvement(positionX/100, positionY/100, oldMouvementCases, savePosX, savePosY));
                if(!oldMouvementCases.isEmpty()){
                    joueur.setText("Au tour de Joueur " + cpt);
                    oldMouvementCases.clear();
                }
            }
        }else{
            System.out.println("Hors Plateau");
        }
        plateau.repaint();
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
