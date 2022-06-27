package pt.ipleiria.views.gestaoVeiculo;

import pt.ipleiria.ViewManagers.ColorManager;
import pt.ipleiria.ViewManagers.FontManager;
import pt.ipleiria.ViewManagers.UImodels;
import pt.ipleiria.ViewManagers.ViewManager;
import pt.ipleiria.model.*;
import pt.ipleiria.views.DashBoardView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class VehicleTransaction  extends JFrame {

    FontManager fontManager;
    ColorManager colorManager;
    ViewManager viewManager;
    private final UImodels uImodels;
    ArrayList<String> clients = new ArrayList<String>();
    public static VehiclePageView vehiclePageView;

    private final Vehicle vehicle;

    public VehicleTransaction(Vehicle vehicle) {
        this.vehicle = vehicle;
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

        var currentOptionTitle = viewManager.CreateLabel("Registar Transação", 22, "Inter Light", colorManager.getColor("DarkText"), 830, 50, 0, 20, false, true);

        var vinFieldDefaultText = viewManager.CreateLabel("Chassis (Vin)",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,175,155,false,false);

        var vinField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),175,195,220,35,false);

        vinField.setBorder(BorderFactory.createCompoundBorder(vinField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var clientFieldDefaultText = viewManager.CreateLabel("Cliente",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,175,235,false,false);

        for (Client client : Storage.getInstance().getClientManager().getClients()) {
            clients.add(client.getName());
        }

        var clientField = new JComboBox<>(clients.toArray());
        clientField.setBounds(175,275,220,35);
        clientField.setSelectedIndex(0);
        clientField.setForeground(colorManager.getColor("DarkText"));
        clientField.setBackground(colorManager.getColor("LightBackground"));
        clientField.setOpaque(true);
        clientField.setBorder(null);

        clientField.setBorder(BorderFactory.createCompoundBorder(clientField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var dateFieldDefaultText = viewManager.CreateLabel("Data",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,435,155,false,false);

        var dateField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),435,195,220,35,false);

        dateField.setBorder(BorderFactory.createCompoundBorder(dateField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var valueDefaultText = viewManager.CreateLabel("Valor",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,435,235,false,false);

        var valueField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),435,275,220,35,false);

        valueField.setBorder(BorderFactory.createCompoundBorder(valueField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var cancelButton = viewManager.CreateButton("Retornar",0,700,415,50,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"));

        var gravarButton = viewManager.CreateButton("Gravar",415,700,415,50,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"));

        panel.add(cancelButton);
        panel.add(gravarButton);

        panel.add(vinFieldDefaultText);
        panel.add(vinField);

        panel.add(clientField);
        panel.add(clientFieldDefaultText);

        panel.add(dateField);
        panel.add(dateFieldDefaultText);

        panel.add(valueField);
        panel.add(valueDefaultText);
        panel.add(currentOptionTitle);

        viewManager.AddHover(cancelButton, colorManager.getColor("hoverColor"), colorManager.getColor("hoverBackground"), colorManager.getColor("DarkText"), colorManager.getColor("LightBackground"));
        viewManager.AddHover(gravarButton, colorManager.getColor("hoverColor"), colorManager.getColor("hoverBackground"), colorManager.getColor("DarkText"), colorManager.getColor("LightBackground"));

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

                Storage.getInstance().getClientManager().getClient(clientField.getSelectedItem().toString()).registerPurchase(Storage.getInstance().getVehicleManager().getVehicle(vinField.getText()));

                System.out.println(Storage.getInstance().getClientManager().getClient(clientField.getSelectedItem().toString()).getTransactions());
                JOptionPane.showMessageDialog(null, "Transicionado com sucesso" );
            }
        });
    }
}
