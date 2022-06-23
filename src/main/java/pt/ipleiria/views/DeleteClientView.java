package pt.ipleiria.views;

import pt.ipleiria.ViewManagers.ColorManager;
import pt.ipleiria.ViewManagers.FontManager;
import pt.ipleiria.ViewManagers.UImodels;
import pt.ipleiria.ViewManagers.ViewManager;
import pt.ipleiria.model.Storage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;


public class DeleteClientView extends JFrame {
    FontManager fontManager;
    ColorManager colorManager;
    ViewManager viewManager;
    private final UImodels uImodels;

    public static DeleteClientView deleteClientView;

    public DeleteClientView() {
        uImodels = new UImodels();
        fontManager = FontManager.getInstance();
        colorManager = ColorManager.getInstance();
        viewManager = new ViewManager();
        InitUI();
    }

    private void InitUI() {
        viewManager.CreateView(this, 830, 750);
        var panel = viewManager.CreateJpanel(830, 750, colorManager.getColor("BackgroundColor"));
        add(panel);
        InitMainPanel(panel);
    }

    private void InitMainPanel(JPanel panel) {
        var title = viewManager.CreateLabel("Bem Vindo", 22, "Inter Light", colorManager.getColor("DarkText"), 830, 50, 30, 20, false,
                false);
        var currentOptionTitle = viewManager.CreateLabel("Apagar Cliente", 22, "Inter Light", colorManager.getColor("DarkText"), 830, 50, 410, 20, false, false);

        var logoutButton = viewManager.CreateButton("Logout", 650, 32, 100, 30, 20, colorManager.getColor("DarkText"), colorManager.getColor("LightBackground"));


        var usernameTitle = viewManager.CreateLabel("LinuxTech", 22, "Inter Bold", colorManager.getColor("DarkText"), 830, 50, 147, 20
                , false, false);

        var companyName = viewManager.CreateLabel("Autosell Automóveis", 12, "Inter Regular", colorManager.getColor("DarkText"),
                830, 50, 30, 44, false, false);

        var clienteFieldDefaultText = viewManager.CreateLabel("NIF", 13, "Inter Light",
                colorManager.getColor("DarkText"), 250, 35, 140, 185, false, false);

        var clienteField = viewManager.CreateTextField(null, 15, 13, colorManager.getColor("DarkText"), colorManager.getColor("LightBackground"), 120, 225, 220, 35, false);

        clienteField.setBorder(BorderFactory.createCompoundBorder(clienteField.getBorder(), BorderFactory.createEmptyBorder(5, 10, 5, 5)));


        var cancelButton = viewManager.CreateButton("Cancelar", 0, 380, 230, 50, 13, colorManager.getColor("DarkText"), colorManager.getColor("LightBackground"));

        var deleteButton = viewManager.CreateButton("Apagar", 230, 380, 230, 50, 13, colorManager.getColor("DarkText"), colorManager.getColor("LightBackground"));

        panel.add(cancelButton);
        panel.add(deleteButton);
        panel.add(title);
        panel.add(logoutButton);
        panel.add(usernameTitle);
        panel.add(clienteFieldDefaultText);
        panel.add(clienteField);
        panel.add(companyName);
        panel.add(currentOptionTitle);

        logoutButton.addActionListener(e -> System.exit(0));
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DashBoardView(null).setVisible(true);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /* reference: https://stackoverflow.com/questions/299606/java-convert-a-char-to-a-charsequence */
                if (clienteField.getText().isEmpty()) return;
                if (Storage.getInstance().getClientManager().getClient(Integer.parseInt(clienteField.getText())) == null) {
                    JOptionPane.showMessageDialog(null, "Cliente não registado");
                    return;
                } else {
                    //Storage.getInstance().getClientManager().deleteClien(clienteField.getText());
                    JOptionPane.showMessageDialog(null, "Cliente apagado só que nao porque nao esta implementado");

                    dispose();
                    new DashBoardView(null).setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args) {
        deleteClientView = new DeleteClientView();
        deleteClientView.setVisible(true);
    }

}
