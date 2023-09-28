package guis;

import constants.CommonConstants;

import javax.swing.*;

public class Form extends JFrame {
    // Membuat Constructaor
    public Form(String title) {
        // Mengatur judul dari bar judul
        super(title);

        // Mengatur size GUI
        setSize(520,680);

        // Mengatur GUI untuk mengakhiri setelah menutup
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set layout to null to disable layout management so we can use absolute positionig
        // untuk menaruh komponen dimana yang kita mau
        setLayout(null);

        // Mengatur load gui di tengah screen
        setLocationRelativeTo(null);

        // Mengatur GUI untuk tetap sesuai dengan sizenya
        setResizable(false);

        //change the background color of the GUI
        getContentPane().setBackground(CommonConstants.PRIMARY_COLOR);
    }
}
