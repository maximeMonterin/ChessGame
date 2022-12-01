import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Affichage extends JFrame implements ActionListener, MouseListener {
    private  Echiquier plateau;
    private List<Case> oldMouvementCases;
    private Case currCase;
    private int cpt = 0;
    private int savePosX;
    private int savePosY;
    public Affichage(){
        plateau= new Echiquier();
        plateau.setBounds(0,0,910,910);
        this.add(plateau);
        this.setTitle("Echecs");
        this.setSize(1000,1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.addMouseListener(this);
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
                System.out.println("Vous avez selectionné la case = " + currCase.toString());
                savePosX = positionX/100;
                savePosY = positionY/100;
                oldMouvementCases = plateau.getListeCase(savePosX, savePosY);
            } else {
                plateau.actionMouvement(positionX/100, positionY/100, oldMouvementCases, savePosX, savePosY);
                if(!oldMouvementCases.isEmpty()){
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
