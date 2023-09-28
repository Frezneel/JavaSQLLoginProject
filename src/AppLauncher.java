import db.MyJDBC;
import guis.LoginFormGUI;
import guis.RegisterFormGUI;

import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        // Penting untuk diingat bahwa semua kode yang memanipulasi UI
        // harus dieksekusi di EDT menggunakan SwingUtilities.invokeLater()
        // Dengan menggunakan metode ini, kita memastikan bahwa operasi UI seperti pembuatan frame dilakukan dengan benar di thread EDT

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // insta
                new LoginFormGUI().setVisible(true);

                // check kondisi koding
                // System.out.println(MyJDBC.checkUser("tatang"));
                // System.out.println(MyJDBC.register("user1234", "password"));
                // System.out.println(MyJDBC.validateLogin("Tatang","Tatang"));
            }
        });
    }
}
