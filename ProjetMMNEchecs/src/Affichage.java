import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Affichage extends JFrame implements ActionListener {

    private JPanel panelMain;

    public Affichage(){
        Echiquier plateau= new Echiquier();
        plateau.setBounds(10,10,900,900);
        panelMain= new JPanel();
        this.add(plateau);
        this.setTitle("Echecs");
        this.setSize(1000,1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
