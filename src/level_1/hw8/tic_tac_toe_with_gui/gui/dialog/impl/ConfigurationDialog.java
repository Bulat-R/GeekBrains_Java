package level_1.hw8.tic_tac_toe_with_gui.gui.dialog.impl;

import level_1.hw8.tic_tac_toe_with_gui.enums.DotType;
import level_1.hw8.tic_tac_toe_with_gui.gui.dialog.Configurable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ConfigurationDialog extends JDialog implements Configurable {

    // Величина отступа содержимого от края окна
    public static final int MARGIN_VALUE = 10;

    // Задаем значения по умолчанию
    public DotType playerType = DotType.X;
    public int mapSize = 3;

    public ConfigurationDialog(JFrame parentFrame) {
        super(parentFrame, "Конфигурация игры", true);

        setBounds(300, 300, 400, 200);

        // Создаем поле для ввода размера игровой карты
        JTextField mapSizeTextField = new JTextField(String.valueOf(mapSize));

        JPanel commonPanel = getConfigurationPanel(mapSizeTextField);

        JButton applyButton = createApplyButton(mapSizeTextField);

        // В центре размещаем Grid панель с параметрами конфигурации, а внизу кнопку для выхода
        setLayout(new BorderLayout());
        add(commonPanel, BorderLayout.CENTER);
        add(applyButton, BorderLayout.SOUTH);

        // Устанавливаем отступы для параметров от края экрана
        commonPanel.setBorder(BorderFactory.createEmptyBorder(MARGIN_VALUE, MARGIN_VALUE, MARGIN_VALUE, MARGIN_VALUE));

        setVisible(true);
    }

    /**
     * В данном методе создается панель, на которой отображаются текстовые метки и
     * компонент параметра (радио кнопки и поле для ввода размерности карты).
     *
     * Панель строится на основе элемента таблицы (GridLayout)
     * --------------------------------------------------------------
     * | метка с информацией | компонент выбора крестика или нолика |
     * | метка с информацией | поле для ввода размерности карты    |
     * ------------------------------------------------------------
     */
    private JPanel getConfigurationPanel(JTextField mapSizeTextField) {
        int gridSize = 2;
        int horizontalGap = 10; // отступ по горизонтали между компонентами
        int verticalGap = 20; // отступ по вертикали между компонентами

        JPanel commonPanel = new JPanel(new GridLayout(gridSize, gridSize, horizontalGap, verticalGap));
        commonPanel.add(new JLabel("Выберите за кого вы будете играть?"));
        commonPanel.add(createChoiceButtonPanel());
        commonPanel.add(new JLabel("Укажите размер игрового поля"));
        commonPanel.add(mapSizeTextField);

        return commonPanel;
    }

    /**
     * В методе создается кнопка завершения игры
     *
     * @param mapSizeTextField текстовое поле, из которого надо вытащить размерность игровой карты
     */
    private JButton createApplyButton(JTextField mapSizeTextField) {
        JButton applyButton = new JButton("Принять");

        WindowEvent closeEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapSize = Integer.parseInt(mapSizeTextField.getText());
                dispatchEvent(closeEvent);
            }
        });

        return applyButton;
    }

    /**
     * В методе создается панель с кнопками для выбора крестика или нолика.
     */
    private JPanel createChoiceButtonPanel() {
        JRadioButton xButtonChoice = getRadioButton("X", DotType.X, true);
        JRadioButton oButtonChoice = getRadioButton("O", DotType.O, false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(xButtonChoice);
        buttonPanel.add(oButtonChoice);

        // Для того, чтобы компонент RadioButton работал корректно. Все кнопки данного типа надо объединить в группу
        ButtonGroup group = new ButtonGroup();
        group.add(xButtonChoice);
        group.add(oButtonChoice);

        return buttonPanel;
    }

    /**
     * Метод создает RadioButton и добавляет ей обработчик,
     * который по клику устанавливает выбранным крестик или нолик
     *
     * @param text текст кнопки
     * @param buttonDotType тип кнопки (X или O)
     * @param selected выбрано ли поле по умолчанию
     */
    private JRadioButton getRadioButton(String text, DotType buttonDotType, boolean selected) {
        JRadioButton choiceBtn = new JRadioButton(text, selected);
        choiceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerType = buttonDotType;
            }
        });

        return choiceBtn;
    }

    @Override
    public DotType getPlayerType() {
        return playerType;
    }

    @Override
    public int getMapSize() {
        return mapSize;
    }

}
