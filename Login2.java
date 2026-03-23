import java.awt.*;
import javax.swing.*;

public class Login2 {
     public Login2() {

        
        JFrame frame = new JFrame("Login Page");//creates a frame name Login Page
        frame.setSize(300, 200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// exits the when closes the window 

        
        JPanel panel = new JPanel();// creates a panel
        panel.setLayout(new FlowLayout());
        panel.setBackground(new Color(11, 11, 12));// make the background cream white for better UI

        // ComponentsJLabel label1 = new JLabel("Username:");//create a label
        JLabel label1 = new JLabel("Username:");//create a label
        label1.setForeground(new Color(0,208,156));
        JLabel label2 = new JLabel("Password:");
        label2.setForeground(new Color(0,208,156));
        JLabel label = new JLabel();//create a label
        label.setForeground(new Color(0,208,156));
        JTextField textField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton button = new JButton("Submit");//creates a button displaying  submit 

        // Add components (ORDER MATTERS FOR UI)
        panel.add(label1);
        panel.add(textField);//add user input to panel

        panel.add(label2);
        panel.add(passwordField);//add password input to panel
        panel.add(button);//add button to panel
        panel.add(label);

        // Button logic
        button.addActionListener(e -> {
            String user = textField.getText();
            String pass = new String(passwordField.getPassword());

            if(user.equals("admin") && pass.equals("1234")) {
                frame.dispose();
                new Dashboard(); // go back to login

            } else {
                label.setText("Wrong Credentials");
            }
        });

        
        frame.add(panel);// Add panel to frame

        
        frame.setVisible(true);// Show frame
    }
    public static void main(String args[]){
        Login2 on = new Login2();
    }
}
