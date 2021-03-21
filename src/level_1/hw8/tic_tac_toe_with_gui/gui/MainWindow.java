package level_1.hw8.tic_tac_toe_with_gui.gui;

import level_1.hw8.tic_tac_toe_with_gui.core.GameService;
import level_1.hw8.tic_tac_toe_with_gui.core.domain.MatrixCoordinate;
import level_1.hw8.tic_tac_toe_with_gui.core.impl.GameServiceImpl;
import level_1.hw8.tic_tac_toe_with_gui.enums.DotType;
import level_1.hw8.tic_tac_toe_with_gui.gui.component.StatusBar;
import level_1.hw8.tic_tac_toe_with_gui.gui.dialog.Configurable;
import level_1.hw8.tic_tac_toe_with_gui.gui.dialog.impl.ConfigurationDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    public static final String DOT_EMPTY = "•";

    private JButton[][] buttons;

    private StatusBar statusBar;

    private DotType playerType;
    private GameService gameService;

    public MainWindow() {
        setTitle("Крестики нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        statusBar = new StatusBar();
        statusBar.setMessage("Ожидание хода игрока");

        Configurable configurable = new ConfigurationDialog(this);
        int mapSize = configurable.getMapSize();
        playerType = configurable.getPlayerType();

        gameService = new GameServiceImpl(mapSize, playerType);

        setLayout(new BorderLayout());
        add(createGridButtons(mapSize));
        add(statusBar, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createGridButtons(int mapSize) {
        JPanel gridPanel = new JPanel(new GridLayout(mapSize, mapSize));

        buttons = new JButton[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                JButton button = new JButton(DOT_EMPTY);
                button.setFont(new Font(button.getFont().getName(), button.getFont().getStyle(), 20));
                button.putClientProperty("INDEX_ROW", i);
                button.putClientProperty("INDEX_COLUMN", j);
                button.addActionListener(getButtonListener());

                buttons[i][j] = button;
                gridPanel.add(button);
            }
        }

        return gridPanel;
    }

    private ActionListener getButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doHumanTurn((JButton) e.getSource());

                if (isGameContinue(playerType) && isGameContinue(DotType.getEnemyType(playerType))) {
                    doAiTurn();
                    statusBar.setMessage("Ход игрока...");
                } else {
                    finishGame();
                }
            }
        };
    }

    private void finishGame() {
        statusBar.setMessage("Игра окончена!");
        disableAllButtons();
    }

    private void disableAllButtons() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    private boolean isGameContinue(DotType dotType) {
        return !gameService.checkWin(dotType) && !gameService.isMapFull();
    }

    private void doAiTurn() {
        statusBar.setMessage("Ход компьютера...");

        MatrixCoordinate coordinate = gameService.aiTurn();
        JButton aiSelectedButton = buttons[coordinate.getRow()][coordinate.getColumn()];

        disableButtonWithMark(aiSelectedButton, DotType.getEnemyType(playerType));

        if (!isGameContinue(DotType.getEnemyType(playerType))) {
            finishGame();
        }
    }

    private void doHumanTurn(JButton selectedButton) {
        int rowIndex = (int) selectedButton.getClientProperty("INDEX_ROW");
        int columnIndex = (int) selectedButton.getClientProperty("INDEX_COLUMN");

        gameService.humanTurn(rowIndex, columnIndex);

        disableButtonWithMark(selectedButton, playerType);
    }

    private void disableButtonWithMark(JButton button, DotType dotType) {
        button.setEnabled(false);
        button.setText(dotType.toString());
    }

}
