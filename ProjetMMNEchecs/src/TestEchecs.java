import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestEchecs {
    @org.junit.jupiter.api.Test
    public void testCreerInstanceEchiquier(){
        Echiquier e = new Echiquier();
    }

    @org.junit.jupiter.api.Test
    public void testCreerInstanceCase(){Case c = new Case(0,5);}

    @org.junit.jupiter.api.Test
    public void testCreerInstanceEchecs(){Echecs echecs = new Echecs();}

    @org.junit.jupiter.api.Test
    public void testCreerInstanceVide(){
        Vide v = new Vide(0,5);
    }

    @org.junit.jupiter.api.Test
    public void testCreerInstancePion(){
        Pion p= new Pion(true, 0,5);
    }

    @org.junit.jupiter.api.Test
    public void testCreerInstanceTour(){
        Tour t= new Tour(true, 0,5);
    }

    @org.junit.jupiter.api.Test
    public void testCreerInstanceFou(){
        Fou f= new Fou(true, 0,5);
    }

    @org.junit.jupiter.api.Test
    public void testCreerInstanceCavalier(){
        Cavalier c= new Cavalier(true, 0,5);
    }

    @org.junit.jupiter.api.Test
    public void testCreerInstanceReine(){
        Reine r= new Reine(true, 0,5);
    }

    @org.junit.jupiter.api.Test
    public void testCreerInstanceRoi() {Roi roi = new Roi(true, 0, 5);}

    @Test
    public void testAccesseurPion() {
        Pion p = new Pion(true, 1, 5);
        assertEquals(p.getCouleurPiece(), true);
        assertEquals(p.getNom(), "Pion");
        assertEquals(p.getPosx(), 1);
        assertEquals(p.getPosy(), 5);
        assertEquals(p.mouvement(), Arrays.asList(new Case(0, 5), new Case(0, 6), new Case(0, 4)));
    }

    @Test
    public void testAccesseurTour() {
        Tour t = new Tour(true, 1, 5);
        assertEquals(t.getCouleurPiece(), true);
        assertEquals(t.getNom(), "Tour");
        assertEquals(t.getPosx(), 1);
        assertEquals(t.getPosy(), 5);
    }

    @Test
    public void testAccesseurCavalier() {
        Cavalier c = new Cavalier(true, 1, 5);
        assertEquals(c.getCouleurPiece(), true);
        assertEquals(c.getNom(), "Cavalier");
        assertEquals(c.getPosx(), 1);
        assertEquals(c.getPosy(), 5);
    }

    @Test
    public void testAccesseurFou() {
        Fou f = new Fou(true, 1, 5);
        assertEquals(f.getCouleurPiece(), true);
        assertEquals(f.getNom(), "Fou");
        assertEquals(f.getPosx(), 1);
        assertEquals(f.getPosy(), 5);
    }

    @Test
    public void testAccesseurReine() {
        Reine r = new Reine(true, 1, 5);
        assertEquals(r.getCouleurPiece(), true);
        assertEquals(r.getNom(), "Reine");
        assertEquals(r.getPosx(), 1);
        assertEquals(r.getPosy(), 5);
    }

    @Test
    public void testAccesseurRoi() {
        Roi roi = new Roi(true, 1, 5);
        roi.setEchec(true);
        assertEquals(roi.getCouleurPiece(), true);
        assertEquals(roi.getNom(), "Roi");
        assertEquals(roi.getPosx(), 1);
        assertEquals(roi.getPosy(), 5);
        assertEquals(roi.estEchec(), true);
    }

    @Test
    public void testAccesseurEchiquier() {
        Echiquier e = new Echiquier();
        assertEquals(e.getListeCase(0, 0), e.getPlateau().get(0).get(0).mouvement());
        assertEquals(e.getCaseActuelle(0, 0), new Case(0, 0));
        assertEquals(e.getJoueur(), "Bleus");
    }

    @Test
    public void testMangerPion() {
        Pion p = new Pion(true, 0, 5);
        assertEquals(p.manger(new Cavalier(false, 0, 6)), true);
        assertEquals(p.manger(new Cavalier(true, 0, 6)), false);
    }

    @Test
    public void testMangerTour() {
        Tour t= new Tour(true, 0, 5);
        assertEquals(t.manger(new Cavalier(false,0,6)),true);
        assertEquals(t.manger(new Cavalier(true,0,6)),false);
    }

    @Test
    public void testMangerCavalier() {
        Cavalier c= new Cavalier(true, 0, 5);
        assertEquals(c.manger(new Cavalier(false,0,6)),true);
        assertEquals(c.manger(new Cavalier(true,0,6)),false);
    }

    @Test
    public void testMangerFou() {
        Fou f= new Fou(true, 0, 5);
        assertEquals(f.manger(new Cavalier(false,0,6)),true);
        assertEquals(f.manger(new Cavalier(true,0,6)),false);
    }

    @Test
    public void testMangerReine() {
        Reine r= new Reine(true, 0, 5);
        assertEquals(r.manger(new Cavalier(false,0,6)),true);
        assertEquals(r.manger(new Cavalier(true,0,6)),false);
    }

    @Test
    public void testMangerRoi() {
        Roi roi= new Roi(true, 0, 5);
        assertEquals(roi.manger(new Cavalier(false,0,6)),true);
        assertEquals(roi.manger(new Cavalier(true,0,6)),false);
    }

    @Test
    public void testEqualsCase(){
        Case c= new Case(0,5);
        Case b= new Case(0,5);
        assertEquals(c.equals(b),true);
    }

    @Test
    public void testToStringCase(){
        Case c= new Case(0,5);
        assertEquals(c.toString(),"{0, 5}");
    }

}