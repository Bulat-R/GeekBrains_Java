package level_1.hw8.tic_tac_toe_with_gui.core;

import level_1.hw8.tic_tac_toe_with_gui.core.domain.MatrixCoordinate;
import level_1.hw8.tic_tac_toe_with_gui.enums.DotType;

public interface GameService {

    MatrixCoordinate aiTurn();

    void humanTurn(int rowIndex, int columnIndex);

    boolean checkWin(DotType dotType);

    boolean isMapFull();

}
