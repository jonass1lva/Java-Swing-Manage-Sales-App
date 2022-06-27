package pt.ipleiria.views;

import pt.ipleiria.ViewManagers.ColorManager;
import pt.ipleiria.ViewManagers.FontManager;
import pt.ipleiria.ViewManagers.UImodels;
import pt.ipleiria.ViewManagers.ViewManager;
import pt.ipleiria.model.Storage;
import pt.ipleiria.views.gestaoVeiculo.VehiclePageView;
import pt.ipleiria.views.gestaoVeiculo.VehicleTransaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

public class VinAskView extends JFrame {
    FontManager fontManager;
    ColorManager colorManager;
    ViewManager viewManager;
    private String destination;
    private final UImodels uImodels;

    public static VinAskView vinAskView;

    public VinAskView(String destination) {
        this.destination = destination;
        uImodels = new UImodels();
        fontManager = FontManager.getInstance();
        colorManager = ColorManager.getInstance();
        viewManager = new ViewManager();
        InitUI();
    }

    public VinAskView() {
        uImodels = new UImodels();
        fontManager = FontManager.getInstance();
        colorManager = ColorManager.getInstance();
        viewManager = new ViewManager();
        InitUI();
    }

    private void InitUI() {
        viewManager.CreateView(this, 350, 350);
        var panel = viewManager.CreateJpanel(350, 350, colorManager.getColor("BackgroundColor"));
        add(panel);
        InitMainPanel(panel);
    }

    private void InitMainPanel(JPanel panel) {
        var title = viewManager.CreateLabel("Introduz o Nº de Chassis", 22, "Inter Light", colorManager.getColor("DarkText"), 350, 50, 0, 20, false,
                true);

        var companyName = viewManager.CreateLabel("nº of identification", 12, "Inter Regular", colorManager.getColor("DarkText"),
                350, 50, 0, 44, false, true);

        var vinFieldDefaultText = viewManager.CreateLabel("Chassis",13, "Inter Light",
                colorManager.getColor("GreyText"),350,35,0,150,false,true);

        var vinField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),0,185,350,35,true);

        vinField.setBorder(BorderFactory.createCompoundBorder(vinField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));


        var cancelButton = viewManager.CreateButton("Cancelar",0,300,175,50,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"));

        var goToPageButton = viewManager.CreateButton("Ir para a ficha",175,300,175,50,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"));


        panel.add(cancelButton);
        panel.add(goToPageButton);
        panel.add(title);
        panel.add(vinFieldDefaultText);
        panel.add(vinField);
        panel.add(companyName);

        System.out.println(Arrays.toString(Storage.getInstance().getUserManager().getUsers().toArray()));

        viewManager.AddHover(cancelButton, colorManager.getColor("hoverColor"), colorManager.getColor("hoverBackground"), colorManager.getColor("DarkText"), colorManager.getColor("LightBackground"));
        viewManager.AddHover(goToPageButton, colorManager.getColor("hoverColor"), colorManager.getColor("hoverBackground"), colorManager.getColor("DarkText"), colorManager.getColor("LightBackground"));

        cancelButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DashBoardView(null).setVisible(true);
            }
        });
        goToPageButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                /* reference: https://stackoverflow.com/questions/299606/java-convert-a-char-to-a-charsequence */
                if (vinField.getText().isEmpty()) return;
                if (Storage.getInstance().getVehicleManager().getVehicle(vinField.getText())==null){
                    JOptionPane.showMessageDialog(null, "Chassis não registado" );
                    return;
                }
                else{
                    dispose();
                    if (Objects.equals(destination, "Registar Transação")) {
                        new VehicleTransaction(Storage.getInstance().getVehicleManager().getVehicle(vinField.getText())).setVisible(true);
                    } else {
                        new VehiclePageView(Storage.getInstance().getVehicleManager().getVehicle(vinField.getText())).setVisible(true);
                        Storage.getInstance().getVehicleManager().printVehicles();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        vinAskView = new VinAskView();
        vinAskView.setVisible(true);
    }

}
