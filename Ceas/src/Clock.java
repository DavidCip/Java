import java.awt.*;
import java.time.LocalTime; 
import javax.swing.*;

public class Clock extends JFrame {

    private JLabel lblClock;

    public Clock() {
        
        lblClock = new JLabel();
        lblClock.setHorizontalAlignment(JLabel.CENTER);
        lblClock.setOpaque(true);
        lblClock.setBackground(Color.WHITE);
        lblClock.setForeground(Color.BLACK);
        lblClock.setFont(new Font("Arial", Font.BOLD, 45));

       
        setTitle("Ceas");
        setSize(450, 100);
        add(lblClock);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true);

        
        new CeasulMeu().start();
    }

    class CeasulMeu extends Thread {

        public void run() {
            while (true) {
                
                LocalTime time = LocalTime.now();
                String s = String.format("%02d:%02d:%02d", 
                                           time.getHour(), 
                                           time.getMinute(), 
                                           time.getSecond());
                lblClock.setText(s);
                try {
                    Thread.sleep(1000); 
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Clock(); 
    }
}
