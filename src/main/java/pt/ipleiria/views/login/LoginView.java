package pt.ipleiria.views.login;

import pt.ipleiria.ViewManagers.ColorManager;
import pt.ipleiria.ViewManagers.FontManager;
import pt.ipleiria.ViewManagers.ViewManager;
import pt.ipleiria.model.Storage;
import pt.ipleiria.model.User;
import pt.ipleiria.managers.UserManager;
import pt.ipleiria.views.DashBoardView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class LoginView extends JFrame
{
    FontManager fontManager;
    ColorManager colorManager;
    ViewManager viewManager;
    User user;

    public LoginView()
    {
        fontManager = FontManager.getInstance();
        colorManager = ColorManager.getInstance() ;
        viewManager = new ViewManager();
        InitUI();
    }

    private void InitUI()
    {
        viewManager.CreateView(this,460,430);
        var panel = viewManager.CreateJpanel(460,430,colorManager.getColor("BackgroundColor"));
        var title = viewManager.CreateLabel("Início de Sessão", 23,"Inter Medium",colorManager.getColor("DarkText"),460,50,0,20, false, true);


        var subtitle = viewManager.CreateLabel("Faça login para ter acesso",13, "Inter " + "Regular", colorManager.getColor( "GreyText"),460,50,0,57,false, true);


        var subtitleBottom = viewManager.CreateLabel("à nossa plataforma",13, "Inter Regular", colorManager.getColor("GreyText"), 460,50,0,75, false, true);


        var loginButton = viewManager.CreateButtonWithImage("src/resources/user.png",75,75,colorManager.getColor("AccentBackgroundColor"),460,75,0,125, true);


        var usernameFieldDefaultText = viewManager.CreateLabel("Username",13, "Inter Light", colorManager.getColor("GreyText"),250,35,140,238,false,false);

        var usernameField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),120,238,220,35,false);

        usernameField.setBorder(BorderFactory.createCompoundBorder(usernameField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var showPasswordIcn = viewManager.CreateButtonWithImage("src/resources/eye-96.png",16,16,null,16,96,310,250,true);

        var passFieldDefaultText = viewManager.CreateLabel("Password",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,140,280,false,false);

        var passField = viewManager.CreatePasswordField(null, 13,colorManager.getColor("DarkText"), colorManager.getColor("LightBackground"), 120, 280, 220,35, false);

        var cancelButton = viewManager.CreateButton("Cancelar",0,380,230,50,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"));

        var authenticateButton = viewManager.CreateButton("Autenticar",230,380,230,50,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"));

        add(panel);
        panel.add(title);
        panel.add(subtitle);
        panel.add(subtitleBottom);
        panel.add(loginButton);
        panel.add(usernameFieldDefaultText);
        panel.add(usernameField);
        panel.add(showPasswordIcn);
        panel.add(passFieldDefaultText);
        panel.add(passField);
        panel.add(cancelButton);
        panel.add(authenticateButton);

        // EFFECTS
        viewManager.AddHover(cancelButton, colorManager.getColor("hoverColor"), colorManager.getColor("hoverBackground"), colorManager.getColor("DarkText"), colorManager.getColor("LightBackground"));
        viewManager.AddHover(authenticateButton, colorManager.getColor("hoverColor"), colorManager.getColor("hoverBackground"), colorManager.getColor("DarkText"), colorManager.getColor("LightBackground"));

        // Listeners
        cancelButton.addActionListener(e -> System.exit(0));
        authenticateButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                /* reference: https://stackoverflow.com/questions/299606/java-convert-a-char-to-a-charsequence */
                CharSequence password = java.nio.CharBuffer.wrap(passField.getPassword());
                if (usernameField.getText().isEmpty() || password.isEmpty()) return;
                var request = Storage.getInstance().getUserManager().verifyUser(usernameField.getText(), password);
                if (!request){
                    JOptionPane.showMessageDialog(null, "Credênciais Erradas" );
                    return;
                }

                dispose();
                new DashBoardView(null).setVisible(true);
            }
        });

        usernameField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (usernameField.getText().length() > 0) {
                    usernameFieldDefaultText.setText(null);
                } else {
                    usernameFieldDefaultText.setText("Username");
                }
            }
        });

        passField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {if (passField.getPassword().length > 0) { passFieldDefaultText.setText(null); }
        else { passFieldDefaultText.setText("Password");} }});
        showPasswordIcn.addActionListener(e -> { if (passField.echoCharIsSet()) { passField.setEchoChar((char) 0); }
        else { passField.setEchoChar('•'); }
        });
    }
}
