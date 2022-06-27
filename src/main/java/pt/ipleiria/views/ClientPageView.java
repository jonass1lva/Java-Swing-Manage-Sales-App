package pt.ipleiria.views;

import pt.ipleiria.ViewManagers.ColorManager;
import pt.ipleiria.ViewManagers.FontManager;
import pt.ipleiria.ViewManagers.UImodels;
import pt.ipleiria.ViewManagers.ViewManager;
import pt.ipleiria.model.CarCondition;
import pt.ipleiria.model.Client;
import pt.ipleiria.model.Storage;
import pt.ipleiria.model.Vehicle;
import pt.ipleiria.views.gestaoVeiculo.VehiclePageView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ClientPageView extends JFrame {


    FontManager fontManager;
    ColorManager colorManager;
    ViewManager viewManager;
    private final UImodels uImodels;

    public static ClientPageView clientePageView;

    private final Client client;

    public ClientPageView(Client client) {
        this.client = client;
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

        var currentOptionTitle = viewManager.CreateLabel("Ficha de Cliente", 22, "Inter Light", colorManager.getColor("DarkText"), 830, 50, 0, 20, false, true);

        var nifFieldDefaultText = viewManager.CreateLabel("Nif)",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,175,155,false,false);

        var nifField = viewManager.CreateTextField((Integer.valueOf(client.getNif()).toString()),15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),175,195,220,35,false);

        nifField.setBorder(BorderFactory.createCompoundBorder(nifField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var nameFieldDefaultText = viewManager.CreateLabel("Nome",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,175,235,false,false);

        var nameField = viewManager.CreateTextField(client.getName(),15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),175,275,220,35,false);

        nameField.setBorder(BorderFactory.createCompoundBorder(nameField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));



        var cancelButton = viewManager.CreateButton("Retornar",0,700,276,50,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"));

        var gravarButton = viewManager.CreateButton("Gravar",276,700,276,50,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"));

        var deleteButton = viewManager.CreateButton("Apagar",552,700,277,50,13,new Color(255,0,0),colorManager.getColor("LightBackground"));

        panel.add(cancelButton);
        panel.add(gravarButton);
        panel.add(deleteButton);
        panel.add(nifFieldDefaultText);
        panel.add(nifFieldDefaultText);
        panel.add(nameField);
        panel.add(nameFieldDefaultText);

        panel.add(currentOptionTitle);

        viewManager.AddHover(cancelButton, colorManager.getColor("hoverColor"), colorManager.getColor("hoverBackground"), colorManager.getColor("DarkText"), colorManager.getColor("LightBackground"));
        viewManager.AddHover(gravarButton, colorManager.getColor("hoverColor"), colorManager.getColor("hoverBackground"), colorManager.getColor("DarkText"), colorManager.getColor("LightBackground"));
        viewManager.AddHover(deleteButton, colorManager.getColor("hoverColor"), colorManager.getColor("Red"), colorManager.getColor("DarkText"), colorManager.getColor("LightBackground"));

        cancelButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DashBoardView(null).setVisible(true);
            }
        });
        gravarButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                /* reference: https://stackoverflow.com/questions/299606/java-convert-a-char-to-a-charsequence *///todo há aqui coisas como o nmr de owners e o cliente e etc que nao fazem muito sentido

              //  Storage.getInstance().getClientManager().(client);



                //todo tirar isto
                Storage.getInstance().getVehicleManager().printVehicles();

            }
        });
        deleteButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                //Storage.getInstance().getVehicleManager().deleteVehicle(vehicle);
                JOptionPane.showMessageDialog(null, "Cliente apagado" );

                dispose();
                new DashBoardView(null).setVisible(true);

                //todo tirar isto
                Storage.getInstance().getVehicleManager().printVehicles();
            }
        });
    }
}
