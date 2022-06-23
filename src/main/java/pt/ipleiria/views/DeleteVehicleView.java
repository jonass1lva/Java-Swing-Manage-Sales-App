package pt.ipleiria.views;

import pt.ipleiria.ViewManagers.ColorManager;
import pt.ipleiria.ViewManagers.FontManager;
import pt.ipleiria.ViewManagers.UImodels;
import pt.ipleiria.ViewManagers.ViewManager;
import pt.ipleiria.model.Storage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteVehicleView extends JFrame {
    FontManager fontManager;
    ColorManager colorManager;
    ViewManager viewManager;
    private final UImodels uImodels;

    public static DeleteVehicleView deleteVehicleView;

    public DeleteVehicleView() {
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
        var currentOptionTitle = viewManager.CreateLabel("Apagar Veículos", 22, "Inter Light", colorManager.getColor("DarkText"), 830, 50, 410, 20, false, false);

        var logoutButton = viewManager.CreateButton("Logout", 650, 32, 100, 30, 20, colorManager.getColor("DarkText"), colorManager.getColor("LightBackground"));


        var usernameTitle = viewManager.CreateLabel("LinuxTech", 22, "Inter Bold", colorManager.getColor("DarkText"), 830, 50, 147, 20
                , false, false);

        var companyName = viewManager.CreateLabel("Autosell Automóveis", 12, "Inter Regular", colorManager.getColor("DarkText"),
                830, 50, 30, 44, false, false);

        var vinFieldDefaultText = viewManager.CreateLabel("VIN",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,140,185,false,false);

        var vinField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),120,225,220,35,false);

        vinField.setBorder(BorderFactory.createCompoundBorder(vinField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));


        var cancelButton = viewManager.CreateButton("Cancelar",0,380,230,50,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"));

        var deleteButton = viewManager.CreateButton("Apagar",230,380,230,50,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"));

        panel.add(cancelButton);
        panel.add(deleteButton);
        panel.add(title);
        panel.add(logoutButton);
        panel.add(usernameTitle);
        panel.add(vinFieldDefaultText);
        panel.add(vinField);
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
                if (vinField.getText().isEmpty()) return;
                if (Storage.getInstance().getVehicleManager().getVehicle(vinField.getText())==null){
                    JOptionPane.showMessageDialog(null, "VIN não registado" );
                    return;
                }
                else{
                    Storage.getInstance().getVehicleManager().deleteVehicle(vinField.getText());
                    JOptionPane.showMessageDialog(null, "Veículo apagado" );

                    dispose();
                    new DashBoardView(null).setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args) {
        deleteVehicleView = new DeleteVehicleView();
        deleteVehicleView.setVisible(true);
    }

}
