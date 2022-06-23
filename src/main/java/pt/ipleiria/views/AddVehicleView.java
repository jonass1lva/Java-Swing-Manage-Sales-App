package pt.ipleiria.views;

import pt.ipleiria.ViewManagers.ColorManager;
import pt.ipleiria.ViewManagers.FontManager;
import pt.ipleiria.ViewManagers.UImodels;
import pt.ipleiria.ViewManagers.ViewManager;
import pt.ipleiria.model.Storage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddVehicleView  extends JFrame {

    FontManager fontManager;
    ColorManager colorManager;
    ViewManager viewManager;
    private final UImodels uImodels;

    public static AddVehicleView addVehicleView;

    public AddVehicleView() {
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
        var currentOptionTitle = viewManager.CreateLabel("Adicionar Veículo", 22, "Inter Light", colorManager.getColor("DarkText"), 830, 50, 410, 20, false, false);

        var logoutButton = viewManager.CreateButton("Logout", 650, 32, 100, 30, 20, colorManager.getColor("DarkText"), colorManager.getColor("LightBackground"));


        var usernameTitle = viewManager.CreateLabel("LinuxTech", 22, "Inter Bold", colorManager.getColor("DarkText"), 830, 50, 147, 20
                , false, false);

        var companyName = viewManager.CreateLabel("Autosell Automóveis", 12, "Inter Regular", colorManager.getColor("DarkText"),
                830, 50, 30, 44, false, false);

        var vinFieldDefaultText = viewManager.CreateLabel("Chassis",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,140,155,false,false);

        var vinField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),120,195,220,35,false);

        vinField.setBorder(BorderFactory.createCompoundBorder(vinField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var licensePlateFieldDefaultText = viewManager.CreateLabel("Matrícula",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,140,235,false,false);

        var licensePlateFieldD = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),120,275,220,35,false);

        licensePlateFieldD.setBorder(BorderFactory.createCompoundBorder(licensePlateFieldD.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var brandFieldDefaultText = viewManager.CreateLabel("Marca",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,140,315,false,false);

        var brandField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),120,355,220,35,false);

        brandField.setBorder(BorderFactory.createCompoundBorder(brandField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var modelFieldDefaultText = viewManager.CreateLabel("Modelo",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,140,395,false,false);

        var modelField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),120,435,220,35,false);

        modelField.setBorder(BorderFactory.createCompoundBorder(modelField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));


        var colorFieldDefaultText = viewManager.CreateLabel("Cor",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,440,155,false,false);

        var colorField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),420,195,220,35,false);

        colorField.setBorder(BorderFactory.createCompoundBorder(colorField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var kilometersFieldDefaultText = viewManager.CreateLabel("Kilómetros",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,440,235,false,false);

        var kilometersField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),420,275,220,35,false);

        kilometersField.setBorder(BorderFactory.createCompoundBorder(kilometersField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var yearFieldDefaultText = viewManager.CreateLabel("Ano",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,440,155,false,false);

        var yearField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),420,195,220,35,false);

        yearField.setBorder(BorderFactory.createCompoundBorder(yearField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var inspectionDateDefaultText = viewManager.CreateLabel("Data Inspeção",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,440,235,false,false);

        var inspectionDateField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),420,275,220,35,false);

        inspectionDateField.setBorder(BorderFactory.createCompoundBorder(inspectionDateField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));




        var cancelButton = viewManager.CreateButton("Cancelar",0,525,230,50,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"));

        var deleteButton = viewManager.CreateButton("Gravar",230,525,230,50,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"));

        panel.add(cancelButton);
        panel.add(deleteButton);
        panel.add(title);
        panel.add(logoutButton);
        panel.add(usernameTitle);
        panel.add(vinFieldDefaultText);
        panel.add(vinField);
        panel.add(licensePlateFieldD);
        panel.add(licensePlateFieldDefaultText);
        panel.add(brandField);
        panel.add(brandFieldDefaultText);
        panel.add(modelField);
        panel.add(modelFieldDefaultText);
        panel.add(colorField);
        panel.add(colorFieldDefaultText);
        panel.add(kilometersField);
        panel.add(kilometersFieldDefaultText);
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
        addVehicleView = new AddVehicleView();
        addVehicleView.setVisible(true);
    }
}
