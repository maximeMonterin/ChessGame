import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Affichage extends JFrame implements ActionListener, MouseListener {

    private JPanel panelMain;
    private  Echiquier plateau;

    public Affichage(){
        plateau= new Echiquier();
        plateau.setBounds(0,0,910,910);
        panelMain= new JPanel();
        this.add(plateau);
        this.setTitle("Echecs");
        this.setSize(1000,1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX());
        System.out.println(e.getY());
        int positionX= (e.getY()-80);
        int positionY= (e.getX()-100);
        System.out.println(positionX);
        System.out.println(positionY);
        if(positionX>=0 && positionY>=0 && positionX<=800 && positionY<=800){
            System.out.println(plateau.getNomPiece(positionX/100,positionY/100));
        }else{
            System.out.println("Hors Plateau");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
