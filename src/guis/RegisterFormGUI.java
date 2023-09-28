package guis;

import constants.CommonConstants;
import db.MyJDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterFormGUI extends Form {

    public RegisterFormGUI() {
        super("Register");
        addGUIComponent();
    }

    private void addGUIComponent(){
        // membuat login label
        JLabel registerLabel = new JLabel("REGISTER");

        // Mengatur komponen
        registerLabel.setBounds(0, 25, 520, 100);

        // Menganti warna Font
        registerLabel.setForeground(CommonConstants.TEXT_COLOR);

        // Menganti ukuran font
        registerLabel.setFont(new Font("Dialog", Font.BOLD, 40));

        //center text
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Menambahkan komponen ke GUI
        add(registerLabel);

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

        JLabel CpasswordLabel = new JLabel("Re-enter Password: ");
        CpasswordLabel.setBounds(30,350, 400,25);
        CpasswordLabel.setForeground(CommonConstants.TEXT_COLOR);
        CpasswordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // Membuat passwordLabel text Field
        JPasswordField CpasswordField = new JPasswordField();
        CpasswordField.setBounds(20, 385, 450, 55);
        CpasswordField.setBackground(CommonConstants.SCONDARY_COLOR);
        CpasswordField.setForeground(CommonConstants.TEXT_COLOR);
        CpasswordField.setFont(new Font("Dialog", Font.PLAIN, 24));
        CpasswordField.setToolTipText("Re-enter Password Field");

        add(CpasswordLabel);
        add(CpasswordField);


        // Membuat Button Login
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Dialog", Font.BOLD, 18));
        registerButton.setForeground(CommonConstants.TEXT_COLOR);

        // Menganti Cursor ke "hand" ketika berada di area button
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setBackground(CommonConstants.TEXT_COLOR);
        registerButton.setBounds(125, 520, 250, 50);
        registerButton.setBackground(CommonConstants.SCONDARY_COLOR);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String cpassword = new String(CpasswordField.getPassword());

                if (validateUserInput(username,password,cpassword)){
                    if(MyJDBC.register(username, password)){
                        RegisterFormGUI.this.dispose();

                        LoginFormGUI loginFormGUI = new LoginFormGUI();
                        loginFormGUI.setVisible(true);

                        //
                        JOptionPane.showMessageDialog(loginFormGUI,
                                "Registered Account Successfully!");
                    }else {
                        JOptionPane.showMessageDialog(RegisterFormGUI.this,
                                "Error : Username already taken");
                    }
                }else {
                    JOptionPane.showMessageDialog(RegisterFormGUI.this,
                            "Error: Username mus be at least 6 characters \n" +
                            "and/or password must match");
                }

            }
        });
        add(registerButton);

        // membuat label register
        JLabel loginLabel = new JLabel("have an account? Login Here");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLabel.setForeground(CommonConstants.TEXT_COLOR);
        loginLabel.setBounds(125, 580, 250, 30);
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RegisterFormGUI.this.dispose();
                new LoginFormGUI().setVisible(true);
            }
        });
        add(loginLabel);
    }

    private  boolean validateUserInput(String username, String password, String cPassword){

        if(username.length() == 0 || password.length() == 0 || cPassword.length() == 0)
            return false;

        if (username.length() < 6) return false;
        if (!password.equals(cPassword)) return false;

        return true;
    }
}
