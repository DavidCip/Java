package Xsi0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {

    private static char turn = 'X'; 
    private static JLabel title2; 
    private static char[][] chars = new char[3][3]; 
    private static String winner = null; 

    public static void main(String[] args) {

        JFrame frame = new JFrame("X & 0");
        frame.setSize(320, 470);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("X & 0");
        title.setBackground(Color.white);
        title.setOpaque(true);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        title.setFont(new Font("Tahoma", Font.BOLD, 30));
        frame.add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 7, 7));
        panel.setBackground(Color.black);

        JLabel[][] grid = new JLabel[3][3]; 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JLabel label = new JLabel(" ");
                label.setOpaque(true);
                label.setBackground(Color.white);
                label.setFont(new Font("Tahoma", Font.BOLD, 60));
                label.setHorizontalAlignment(SwingConstants.CENTER);

                int row = i;
                int col = j; 
                label.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (label.getText().equals(" ") && winner == null) {
                            label.setText(String.valueOf(turn));
                            chars[row][col] = turn;

                            if (turn == 'X') {
                                label.setForeground(Color.BLUE);
                                turn = 'O';
                                title2.setText("Este randul jucatorului 2!");
                            } else {
                                label.setForeground(Color.RED);
                                turn = 'X';
                                title2.setText("Este randul jucatorului 1!");
                            }

                            if (checkWinner()) {
                                title2.setText("Castigator: " + winner + "!");
                            }
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {}

                    @Override
                    public void mouseReleased(MouseEvent e) {}

                    @Override
                    public void mouseEntered(MouseEvent e) {}

                    @Override
                    public void mouseExited(MouseEvent e) {}
                });

                grid[i][j] = label;
                panel.add(label);
            }
        }

        frame.add(panel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2, 1));

        title2 = new JLabel("Este randul jucatorului 1!");
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        title2.setBackground(Color.white);
        title2.setOpaque(true);
        title2.setFont(new Font("Tahoma", Font.BOLD, 25));
        title2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottomPanel.add(title2);

        JButton btn = new JButton("Joc nou");
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        grid[i][j].setText(" ");
                        grid[i][j].setForeground(Color.BLACK);
                        chars[i][j] = '\0'; 
                    }
                }
                turn = 'X';
                winner = null;
                title2.setText("Este randul jucatorului 1!");
            }
        });
        bottomPanel.add(btn);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private static boolean checkWinner() {
       
        for (int i = 0; i < 3; i++) {
            if (chars[i][0] == chars[i][1] && chars[i][0] == chars[i][2] && chars[i][0] != '\0') {
                winner = String.valueOf(chars[i][0]);
                return true;
            }
        }

       
        for (int i = 0; i < 3; i++) {
            if (chars[0][i] == chars[1][i] && chars[0][i] == chars[2][i] && chars[0][i] != '\0') {
                winner = String.valueOf(chars[0][i]);
                return true;
            }
        }

        
        if (chars[0][0] == chars[1][1] && chars[0][0] == chars[2][2] && chars[0][0] != '\0') {
            winner = String.valueOf(chars[0][0]);
            return true;
        }
        if (chars[2][0] == chars[1][1] && chars[2][0] == chars[0][2] && chars[2][0] != '\0') {
            winner = String.valueOf(chars[2][0]);
            return true;
        }

        return false;
    }
}
