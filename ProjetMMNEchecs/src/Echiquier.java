import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Echiquier extends JComponent {
    private List<List<Piece>> plateau;
    private BufferedImage iconeNave;
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
    public void setPions(){
        for(int i=0;i<8;i++){
            plateau.get(1).set(i,new Pion(0,1, i ));
            plateau.get(6).set(i,new Pion(1,6, i));
        }
    }
    public void setTours(){
        plateau.get(0).set(0,new Tour(0, 0, 0));
        plateau.get(0).set(7,new Tour(0, 0, 7));
        plateau.get(7).set(0,new Tour(1, 7, 0));
        plateau.get(7).set(7,new Tour(1, 7, 7));
    }
    public void setCavaliers(){
        plateau.get(0).set(1,new Cavalier(0, 0, 1));
        plateau.get(0).set(6,new Cavalier(0, 0, 6));
        plateau.get(7).set(1,new Cavalier(1, 7, 1));
        plateau.get(7).set(6,new Cavalier(1, 7, 6));
    }
    public void setFous(){
        plateau.get(0).set(2,new Fou(0, 0, 2));
        plateau.get(0).set(5,new Fou(0, 0, 5));
        plateau.get(7).set(2,new Fou(1, 7, 2));
        plateau.get(7).set(5,new Fou(1, 7, 5));
    }
    public void setRois(){
        plateau.get(0).set(4,new Roi(0,0, 4));
        plateau.get(7).set(4,new Roi(1,7, 4));
    }
    public void setReines(){
        plateau.get(0).set(3,new Reine(0,0, 3));
        plateau.get(7).set(3,new Reine(1,7, 3));
    }
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
            plateauReel.drawString("" + i,tailleCase/2, (int) (tailleCase*(9-i)));
        }

        for(int j=0;j<8;j++){
            plateauReel.setPaint(Color.BLACK);
            plateauReel.drawString(String.valueOf((char)('A'+ j)), (int) (tailleCase*(j+1.45)), (int) (tailleCase * 9));
        }

        String couleurPiece = "";

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(plateau.get(i).get(j) instanceof Pion){
                    if(((Pion) plateau.get(i).get(j)).getCouleur() == 0){couleurPiece = "blanc";}
                    else {couleurPiece = "noir";}
                    try {
                        iconeNave = ImageIO.read(new FileInputStream("ProjetMMNEchecs/images/" + couleurPiece + "/pion.png"));
                    } catch (IOException e) {
                        System.out.println("err: image pion non trouvée");
                    }
                    plateauReel.drawImage(iconeNave, (int)((j+1.05)*tailleCase), (int)((i+0.55)*tailleCase), this);
                }

                else if(plateau.get(i).get(j) instanceof Tour){
                    if(((Tour) plateau.get(i).get(j)).getCouleur() == 0){couleurPiece = "blanc";}
                    else {couleurPiece = "noir";}
                    {
                        try {
                            iconeNave = ImageIO.read(new FileInputStream("ProjetMMNEchecs/images/" + couleurPiece + "/tour.png"));
                        } catch (IOException e) {
                            System.out.println("err: image tour non trouvée");
                        }
                    }
                    plateauReel.drawImage(iconeNave,(int)((j+1.05)*tailleCase), (int)((i+0.55)*tailleCase), this);
                }

                else if(plateau.get(i).get(j) instanceof Cavalier){
                    if(((Cavalier) plateau.get(i).get(j)).getCouleur() == 0){couleurPiece = "blanc";}
                    else {couleurPiece = "noir";}
                    {
                        try {
                            iconeNave = ImageIO.read(new FileInputStream("ProjetMMNEchecs/images/" + couleurPiece + "/cheval.png"));
                        } catch (IOException e) {
                            System.out.println("err: image cavalier non trouvée");
                        }
                    }
                    plateauReel.drawImage(iconeNave, (int)((j+1.05)*tailleCase), (int)((i+0.55)*tailleCase), this);

                }

                else if(plateau.get(i).get(j) instanceof Fou){
                    if(((Fou) plateau.get(i).get(j)).getCouleur() == 0){couleurPiece = "blanc";}
                    else {couleurPiece = "noir";}
                    {
                        try {
                            iconeNave = ImageIO.read(new FileInputStream("ProjetMMNEchecs/images/" + couleurPiece + "/fou.png"));
                        } catch (IOException e) {
                            System.out.println("err: image fou non trouvée");
                        }
                    }
                    plateauReel.drawImage(iconeNave, (int)((j+1.05)*tailleCase), (int)((i+0.55)*tailleCase), this);

                }

                else if(plateau.get(i).get(j) instanceof Roi){
                    if(((Roi) plateau.get(i).get(j)).getCouleur() == 0){couleurPiece = "blanc";}
                    else {couleurPiece = "noir";}
                    {
                        try {
                            iconeNave = ImageIO.read(new FileInputStream("ProjetMMNEchecs/images/"+ couleurPiece +"/roi.png"));
                        } catch (IOException e) {
                            System.out.println("err: image roi non trouvée");
                        }
                    }
                    plateauReel.drawImage(iconeNave, (int)((j+1.05)*tailleCase), (int)((i+0.55)*tailleCase), this);

                }

                else if(plateau.get(i).get(j) instanceof Reine){
                    if(((Reine) plateau.get(i).get(j)).getCouleur() == 0){couleurPiece = "blanc";}
                    else {couleurPiece = "noir";}
                    {
                        try {
                            iconeNave = ImageIO.read(new FileInputStream("ProjetMMNEchecs/images/"+ couleurPiece +"/reine.png"));
                        } catch (IOException e) {
                            System.out.println("err: image reine non trouvée");
                        }
                    }
                    plateauReel.drawImage(iconeNave, (int)((j+1.05)*tailleCase), (int)((i+0.55)*tailleCase), this);
                }
            }
        }
        plateauReel.dispose();
    }

    public List<Case> getListeCase(int positionX, int positionY){
       return (plateau.get(positionX).get(positionY)).mouvement();
    }
    public List<String> listeCaseToString(List<Case> c){
        List<String> cases= new ArrayList<>();
        Iterator<Case> it= c.iterator();
        while(it.hasNext()){
            Case current= it.next();
            cases.add(current.toString());
        }
        return cases;
    }

    public void bouger(int positionX, int positionY, List<Case> oldMouvementCases, int savePosX, int savePosY){
        Case nextCase = this.getCurrentCase(positionX, positionY);
        Boolean canEat = true;
        if(!(plateau.get(positionX).get(positionY) instanceof Vide) ){
            canEat =plateau.get(savePosX).get(savePosY).manger(plateau.get(positionX).get(positionY));
            if(plateau.get(savePosX).get(savePosY) instanceof Pion){
                oldMouvementCases.remove(0);
                if(oldMouvementCases.size() == 3){
                    oldMouvementCases.remove(0);
                }
            }

        }else{
            if(plateau.get(savePosX).get(savePosY) instanceof Pion){
                oldMouvementCases.remove(oldMouvementCases.size()-1);
                oldMouvementCases.remove(oldMouvementCases.size()-1);
            }
        }

            if (oldMouvementCases.contains(nextCase) && canEat) {
                System.out.println("Pièce déplacée en " + nextCase.toString());
                plateau.get(savePosX).get(savePosY).setPosition(nextCase);

                plateau.get(savePosX).get(savePosY).setPosx(positionX);
                plateau.get(savePosX).get(savePosY).setPosy(positionY);

                plateau.get(positionX).set(positionY, plateau.get(savePosX).get(savePosY));
                plateau.get(savePosX).set(savePosY, new Vide(savePosX, savePosY));
            } else {
                System.out.println("Vous ne pouvez pas vous déplacer ici");
            }
    }
    public Case getCurrentCase(int positionX, int positionY){
        Case currCase = new Case(plateau.get(positionX).get(positionY).getPosition().getPosx(), plateau.get(positionX).get(positionY).getPosition().getPosy());

        return currCase;
    }
}























