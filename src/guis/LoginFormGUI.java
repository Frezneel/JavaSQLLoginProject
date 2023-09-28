package guis;

import constants.CommonConstants;
import db.MyJDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFormGUI extends Form{
    public LoginFormGUI() {
        super("Login");
        addGUICommponent();
    }

    private void addGUICommponent(){
        // membuat login label
        JLabel loginLabel = new JLabel("Login");

        // Mengatur komponen
        loginLabel.setBounds(0, 25, 520, 100);

        // Menganti warna Font
        loginLabel.setForeground(CommonConstants.TEXT_COLOR);

        // Menganti ukuran font
        loginLabel.setFont(new Font("Dialog", Font.BOLD, 40));

        //center text
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Menambahkan komponen ke GUI
        add(loginLabel);

        //Membuat Komponent ke GUI
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setBounds(30,150, 400,25);
        usernameLabel.setForeground(CommonConstants.TEXT_COLOR);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // Membuat Username text Field
        JTextField usernameField = new JTextField();
        usernameField.setBounds(20, 185, 450, 55);
        usernameField.setBackground(CommonConstants.SCONDARY_COLOR);
        usernameField.setForeground(CommonConstants.TEXT_COLOR);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 24));
        usernameField.setToolTipText("Username Field");

        add(usernameLabel);
        add(usernameField);

        //Membuat Komponent ke GUI
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(30,250, 400,25);
        passwordLabel.setForeground(CommonConstants.TEXT_COLOR);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // Membuat passwordLabel text Field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(20, 285, 450, 55);
        passwordField.setBackground(CommonConstants.SCONDARY_COLOR);
        passwordField.setForeground(CommonConstants.TEXT_COLOR);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));
        passwordField.setToolTipText("Password Field");

        add(passwordLabel);
        add(passwordField);

        // Membuat Button Login
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Dialog", Font.BOLD, 18));
        loginButton.setForeground(CommonConstants.TEXT_COLOR);

        // Menganti Cursor ke "hand" ketika berada di area button
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setBackground(CommonConstants.TEXT_COLOR);
        loginButton.setBounds(125, 520, 250, 50);
        loginButton.setBackground(CommonConstants.SCONDARY_COLOR);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if(MyJDBC.validateLogin(username, password)){

                    JOptionPane.showMessageDialog(LoginFormGUI.this,
                            "Login Successful!");
                    //System.out.println("Anda telah LOGIN");
                }else{
                    JOptionPane.showMessageDialog(LoginFormGUI.this,
                            "Login Failed....");
                }
            }
        });
        add(loginButton);

        // membuat label register
        JLabel registerLabel = new JLabel("Not a user? Register Here");
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.setForeground(CommonConstants.TEXT_COLOR);
        registerLabel.setBounds(125, 580, 250, 30);
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose() = digunakan untuk menghancurkan atau membebaskan sumber daya
                // yang terkait dengan suatu komponen grafis, seperti JFrame, JDialog, atau JWindow.
                LoginFormGUI.this.dispose();
                // mulai register gui
                new RegisterFormGUI().setVisible(true);
            }
        });
        add(registerLabel);


    }
}
