package pt.ipleiria.views.gestaoVeiculo;

import pt.ipleiria.ViewManagers.ColorManager;
import pt.ipleiria.ViewManagers.FontManager;
import pt.ipleiria.ViewManagers.UImodels;
import pt.ipleiria.ViewManagers.ViewManager;
import pt.ipleiria.model.CarCondition;
import pt.ipleiria.model.Storage;
import pt.ipleiria.model.Vehicle;
import pt.ipleiria.views.DashBoardView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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
        var currentOptionTitle = viewManager.CreateLabel("Adicionar Veículo", 22, "Inter Light", colorManager.getColor("DarkText"), 830, 50, 0, 20, false, true);

        var vinFieldDefaultText = viewManager.CreateLabel("Chassis (Vin)",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,175,155,false,false);

        var vinField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),175,195,220,35,false);

        vinField.setBorder(BorderFactory.createCompoundBorder(vinField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var licensePlateFieldDefaultText = viewManager.CreateLabel("Matrícula",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,175,235,false,false);

        var licensePlateField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),175,275,220,35,false);

        licensePlateField.setBorder(BorderFactory.createCompoundBorder(licensePlateField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var brandFieldDefaultText = viewManager.CreateLabel("Marca",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,175,315,false,false);

        var brandField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),175,355,220,35,false);

        brandField.setBorder(BorderFactory.createCompoundBorder(brandField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var modelFieldDefaultText = viewManager.CreateLabel("Modelo",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,175,395,false,false);

        var modelField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),175,435,220,35,false);

        modelField.setBorder(BorderFactory.createCompoundBorder(modelField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var conditionFieldDefaultText = viewManager.CreateLabel("Condição",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,175,475,false,false);

        var conditionField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),175,515,220,35,false);

        conditionField.setBorder(BorderFactory.createCompoundBorder(conditionField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));


        var colorFieldDefaultText = viewManager.CreateLabel("Cor",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,435,155,false,false);

        var colorField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),435,195,220,35,false);

        colorField.setBorder(BorderFactory.createCompoundBorder(colorField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var kilometersFieldDefaultText = viewManager.CreateLabel("Kilómetros",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,435,235,false,false);

        var kilometersField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),435,275,220,35,false);

        kilometersField.setBorder(BorderFactory.createCompoundBorder(kilometersField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var yearFieldDefaultText = viewManager.CreateLabel("Ano",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,435,315,false,false);

        var yearField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),435,355,220,35,false);

        yearField.setBorder(BorderFactory.createCompoundBorder(yearField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var inspectionDateFieldDefaultText = viewManager.CreateLabel("Data Inspeção",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,435,395,false,false);

        var inspectionDateField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),435,435,220,35,false);

        inspectionDateField.setBorder(BorderFactory.createCompoundBorder(inspectionDateField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));


        var valueFieldDefaultText = viewManager.CreateLabel("Valor no site",13, "Inter Light",
                colorManager.getColor("GreyText"),250,35,435,475,false,false);

        var valueField = viewManager.CreateTextField(null,15,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"),435,515,220,35,false);

        valueField.setBorder(BorderFactory.createCompoundBorder(valueField.getBorder(),BorderFactory.createEmptyBorder(5, 10, 5, 5)));

        var conditionSelect = viewManager.CreateSelector(175,515,220,35,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"));

        var cancelButton = viewManager.CreateButton("Retornar",0,700,415,50,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"));

        var gravarButton = viewManager.CreateButton("Gravar",415,700,415,50,13,colorManager.getColor("DarkText"),colorManager.getColor("LightBackground"));

        panel.add(cancelButton);
        panel.add(gravarButton);
        panel.add(vinFieldDefaultText);
        panel.add(vinField);
        panel.add(licensePlateField);
        panel.add(licensePlateFieldDefaultText);
        panel.add(brandField);
        panel.add(brandFieldDefaultText);
        panel.add(modelField);
        panel.add(modelFieldDefaultText);
        panel.add(colorField);
        panel.add(colorFieldDefaultText);
        panel.add(kilometersField);
        panel.add(kilometersFieldDefaultText);
        panel.add(yearField);
        panel.add(yearFieldDefaultText);
        panel.add(inspectionDateField);
        panel.add(inspectionDateFieldDefaultText);
        panel.add(conditionSelect);
        panel.add(conditionFieldDefaultText);
        panel.add(valueField);
        panel.add(valueFieldDefaultText);
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
                 //todo há aqui coisas como o nmr de owners e o cliente e etc que nao fazem muito sentido
                Storage.getInstance().getVehicleManager().addVehicle(new Vehicle(
                        false,
                        brandField.getText(),
                        modelField.getText(),
                        licensePlateField.getText(),
                        Integer.parseInt(kilometersField.getText()),
                        (float)((Math.random() * (50000 - 1000)) + 1000),
                        vinField.getText(),
                        colorField.getText(),
                        Integer.parseInt(yearField.getText()),
                        0,
                        Storage.getInstance().getClientManager().getRandomClient(),
                        new Date(),
                        CarCondition.valueOf(conditionSelect.getSelectedItem().toString())
                ));

                JOptionPane.showMessageDialog(null,
                        "Registado veiculo (vin): " + vinField.getText() );

                //todo tirar isto
                Storage.getInstance().getVehicleManager().printVehicles();
            }
        });
    }

    public static void main(String[] args) {
        addVehicleView = new AddVehicleView();
        addVehicleView.setVisible(true);
    }
}
