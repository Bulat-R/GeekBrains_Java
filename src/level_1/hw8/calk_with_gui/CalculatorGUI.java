package level_1.hw8.calk_with_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CalculatorGUI extends JFrame {

    private final JLabel calcScreen;
    private final JPanel buttonsPanel;
    private final CalculatorService calculatorService = CalculatorFactory.getCalculatorService();

    public CalculatorGUI() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {

        }

        setTitle("Калькулятор");
        setBounds(610, 340, 400, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.gridheight = 2;
        calcScreen = createCalcScreen("0");
        add(calcScreen, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        constraints.gridheight = 4;
        buttonsPanel = createButtonsPanel();
        add(buttonsPanel, constraints);

        pack();
        setResizable(false);
        setVisible(true);
    }

    private JPanel createButtonsPanel() {

        String[] buttSymb = {   "7", "8", "9", "+/-", "C",
                                "4", "5", "6", "+", "-",
                                "1", "2", "3", "*", "/",
                                "0", ".", "<", "%", "="   };

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 5, 2, 2));

        for (int i = 0; i < buttSymb.length; i++) {
            JButton button = new JButton(buttSymb[i]);
            button.setPreferredSize(new Dimension(70, 70));
            button.setFont(new Font(panel.getFont().getName(), panel.getFont().getStyle(), 24));
            button.setFocusable(false);
            button.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }
                @Override
                public void mousePressed(MouseEvent e) {
                    if (button.getText().equals("C")) {
                        unblockButtons();
                    }
                    refreshCalcScreen(calculatorService.analyzeAndReturnOutput(button.getText()));
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
            });
            panel.add(button);
        }
        return panel;
    }

    private JLabel createCalcScreen(String text) {
        JLabel panel = new JLabel();
        panel.setPreferredSize(new Dimension(350, 90));
        panel.setFont(new Font(panel.getFont().getName(), panel.getFont().getStyle(), 36));
        panel.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.setText(text);
        return panel;
    }

    public void refreshCalcScreen(String text) {
        if (text != null) {
            if (text.contains("error")) {
                calcScreen.setText(text);
                blockButtons();
                return;
            }
            if (text.length() > 17) {
                if (!text.contains(".")) {
                    calcScreen.setText("error - overflow");
                    blockButtons();
                } else if (text.indexOf('.') > 16){
                    calcScreen.setText("error - overflow");
                    blockButtons();
                } else {
                    calcScreen.setText(text.substring(0, 17));
                }
            } else calcScreen.setText(text);
        }
    }

    public void blockButtons() {
        for (Component comp : buttonsPanel.getComponents()) {
            if (!((JButton)comp).getText().equals("C")) {
                comp.setEnabled(false);
                comp.setVisible(false);
            }
        }
    }

    public void unblockButtons() {
        for (Component comp : buttonsPanel.getComponents()) {
            comp.setEnabled(true);
            comp.setVisible(true);
        }
    }
}
