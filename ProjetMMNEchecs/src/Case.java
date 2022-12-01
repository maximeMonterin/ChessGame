import java.util.Objects;

public class Case {
    private final int posx;
    private final int posy;
    public Case(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
    }
    public int getPosx() {
        return posx;
    }
    public int getPosy() {
        return posy;
    }
    @Override
    public String toString() {
        return "Case{"+ posx +", " + posy +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Case aCase = (Case) o;
        return posx == aCase.posx && posy == aCase.posy;
    }
    @Override
    public int hashCode() {
        return Objects.hash(posx, posy);
    }
}
