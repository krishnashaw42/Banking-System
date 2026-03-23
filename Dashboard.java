import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Dashboard {
    JFrame frame;
    double balance = 0.0; // live balance
    JLabel balanceLabel;  // live balance label

    Dashboard() {
        frame = new JFrame("Banking System");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Top
        JLabel labelTop = new JLabel("Banking System", SwingConstants.CENTER);
        labelTop.setOpaque(true);
        labelTop.setBackground(new Color(0, 100, 0));
        labelTop.setForeground(Color.WHITE);
        labelTop.setFont(new Font("Arial", Font.BOLD, 20));
        labelTop.setPreferredSize(new Dimension(0, 60));

        // Balance Panel (shown below top)
        JPanel balancePanel = new JPanel();
        balancePanel.setBackground(new Color(11, 11, 12));
        balanceLabel = new JLabel("Current Balance: ₹0.00");
        balanceLabel.setForeground(new Color(0, 208, 156));
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        balancePanel.add(balanceLabel);

        // Top + Balance combined
        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(labelTop, BorderLayout.NORTH);
        northPanel.add(balancePanel, BorderLayout.SOUTH);

        // Center
        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        centerPanel.setBackground(new Color(255, 253, 208));

        JButton deposit     = createButton("Deposit",     new Color(0, 180, 0));
        JButton withdraw    = createButton("Withdraw",    new Color(220, 50, 50));
        JButton transaction = createButton("Transaction", new Color(0, 120, 220));

        centerPanel.add(deposit);
        centerPanel.add(withdraw);
        centerPanel.add(transaction);

        // Bottom
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(100, 0, 0));
        bottomPanel.setPreferredSize(new Dimension(0, 60));
        JButton logout = new JButton("Logout");
        logout.setBackground(new Color(100, 0, 0));
        logout.setForeground(Color.WHITE);
        logout.setBorderPainted(false);
        logout.setFocusPainted(false);
        bottomPanel.add(logout, BorderLayout.CENTER);

        // Button Actions
        deposit.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter deposit amount:");
            if (input != null && !input.isEmpty()) {
                try {
                    double amount = Double.parseDouble(input);
                    if (amount > 0) {
                        balance += amount;
                        updateBalance();
                        add_Transaction(amount,balance);
                        JOptionPane.showMessageDialog(frame, "₹" + amount + " deposited successfully!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Enter a positive amount.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid amount entered.");
                }
            }
        });

        withdraw.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter withdrawal amount:");
            if (input != null && !input.isEmpty()) {
                try {
                    double amount = Double.parseDouble(input);
                    if (amount > balance) {
                        JOptionPane.showMessageDialog(frame, "Insufficient balance!");
                    } else if (amount > 0) {
                        balance -= amount;
                        add_Transaction((amount*-1),balance);
                        updateBalance();
                        JOptionPane.showMessageDialog(frame, "₹" + amount + " withdrawn successfully!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Enter a positive amount.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid amount entered.");
                }
            }
        });

        transaction.addActionListener(e -> {
               if (live_transaction.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No transactions yet.");
              return;
          }
          StringBuilder sb = new StringBuilder("Transaction History:\n\n");
           for (int i = 0; i < live_transaction.size(); i++) {
                sb.append("Txn " + (i + 1) + ": ₹" 
            + String.format("%.2f", live_transaction.get(i)) 
            + "  |  Balance: ₹" 
            + String.format("%.2f", live_Balance.get(i)) + "\n");
           }
            JOptionPane.showMessageDialog(frame, sb.toString());
              });

        logout.addActionListener(e -> {
            frame.dispose();
            new Login2();
        });

        // Add to frame
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
      LinkedList<Double> live_transaction = new LinkedList<Double>();    // Updates the balance label live
      LinkedList<Double> live_Balance = new LinkedList<Double>(); 
    void updateBalance() {
        balanceLabel.setText("Current Balance: ₹" + String.format("%.2f", balance));
     }
    void add_Transaction(double x, double y)
    {
        live_transaction.add(x);
        live_Balance.add(y);
    }
    // Button Styling Method
    JButton createButton(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setFocusPainted(false);
        return btn;
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
