import java.util.List;

public interface Piece {
    List<Case> mouvement(Case case_de_la_piece);

    void manger();
}
