package pt.ipleiria.views;

import pt.ipleiria.ViewManagers.ColorManager;
import pt.ipleiria.ViewManagers.FontManager;
import pt.ipleiria.ViewManagers.UImodels;
import pt.ipleiria.ViewManagers.ViewManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEventView extends JFrame{

    FontManager fontManager;
    ColorManager colorManager;
    ViewManager viewManager;
    private final UImodels uImodels;

    public static AddEventView addEventView;

    public AddEventView() {
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
        var currentOptionTitle = viewManager.CreateLabel("Adicionar Evento", 22, "Inter Light", colorManager.getColor("DarkText"), 830, 50, 410, 20, false, false);

        var logoutButton = viewManager.CreateButton("Logout", 650, 32, 100, 30, 20, colorManager.getColor("DarkText"), colorManager.getColor("LightBackground"));


        var usernameTitle = viewManager.CreateLabel("LinuxTech", 22, "Inter Bold", colorManager.getColor("DarkText"), 830, 50, 147, 20
                , false, false);

        var companyName = viewManager.CreateLabel("Autosell Automóveis", 12, "Inter Regular", colorManager.getColor("DarkText"),
                830, 50, 30, 44, false, false);

        var nameFieldDefaultText = viewManager.CreateLabel("Nome",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,140,155,false,false);

        var nameField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),120,195,220,35,false);

        nameField.setBorder(BorderFactory.createCompoundBorder(nameField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var localFieldDefaultText = viewManager.CreateLabel("Local",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,140,235,false,false);

        var localField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),120,275,220,35,false);

        localField.setBorder(BorderFactory.createCompoundBorder(localField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var initialDateFieldDefaultText = viewManager.CreateLabel("Data Inicial",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,140,315,false,false);

        var initialDateField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),120,355,220,35,false);

        initialDateField.setBorder(BorderFactory.createCompoundBorder(initialDateField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var finalDateFieldDefaultText = viewManager.CreateLabel("Data Final",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,140,395,false,false);

        var finalDateField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),120,435,220,35,false);

        finalDateField.setBorder(BorderFactory.createCompoundBorder(finalDateField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));


        var cancelButton = viewManager.CreateButton("Cancelar",0,520,230,50,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"));

        var deleteButton = viewManager.CreateButton("Gravar",230,520,230,50,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"));

        panel.add(cancelButton);
        panel.add(deleteButton);
        panel.add(title);
        panel.add(logoutButton);
        panel.add(usernameTitle);
        panel.add(nameFieldDefaultText);
        panel.add(nameField);
        panel.add(localField);
        panel.add(localFieldDefaultText);
        panel.add(initialDateField);
        panel.add(initialDateFieldDefaultText);
        panel.add(finalDateField);
        panel.add(finalDateFieldDefaultText);
        panel.add(companyName);
        panel.add(currentOptionTitle);

        logoutButton.addActionListener(e -> System.exit(0));
        cancelButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DashBoardView(null).setVisible(true);
            }
        });
        deleteButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                /* reference: https://stackoverflow.com/questions/299606/java-convert-a-char-to-a-charsequence */

            }
        });
    }

    public static void main(String[] args) {
        addEventView = new AddEventView();
        addEventView.setVisible(true);
    }

}
