package pt.ipleiria.views;

import pt.ipleiria.ViewManagers.*;
import pt.ipleiria.model.Storage;
import pt.ipleiria.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashBoardView extends JFrame {
    FontManager fontManager;
    ColorManager colorManager;
    ViewManager viewManager;
    private final UImodels uImodels;

    public static DashBoardView dashBoardView;
    public String selection;

    public DashBoardView(String selection) {
        uImodels = new UImodels();
        fontManager = FontManager.getInstance();
        colorManager = ColorManager.getInstance();
        viewManager = new ViewManager();
        this.selection = selection;
        InitUI();
    }

    private void InitUI() {
        viewManager.CreateView(this, 830, 750);
        var panel = viewManager.CreateJpanel(830, 750, colorManager.getColor("BackgroundColor"));
        add(panel);
        InitMainPanel(panel);
        InitCustomOptions(panel);
        InitCustomOptionsPanel(panel, selection);
        InitTransactions(panel);
    }

    private void InitMainPanel(JPanel panel) {
        var title = viewManager.CreateLabel("Bem Vindo", 22, "Inter Light", colorManager.getColor("DarkText"), 830, 50, 30, 20, false,
                false);
        var currentOptionTitle = viewManager.CreateLabel("Gestão de Veículos", 22, "Inter Light", colorManager.getColor("DarkText"), 830, 50, 410, 20, false, false);

        var buttonLogout = viewManager.CreateButton("Logout", 610, 20, 830, 50, 50, colorManager.getColor("DarkText"), colorManager.getColor("DarkText"));


        var usernameTitle = viewManager.CreateLabel("LinuxTech", 22, "Inter Bold", colorManager.getColor("DarkText"), 830, 50, 147, 20
                , false, false);

        var companyName = viewManager.CreateLabel("Autosell Automóveis", 12, "Inter Regular", colorManager.getColor("DarkText"),
                830, 50, 30, 44, false, false);


        var transactionTitle = viewManager.CreateLabel("Ultimas transações", 17, "Inter Regular", colorManager.getColor("DarkText"),
                830,
                50, 32
                , 95, false,
                false);


        var showTransactionBtn = viewManager.CreateButtonWithImage("src/resources/show.png",
                48, 24,
                colorManager.getColor("AccentBackgroundColor"), 48, 24, 297, 110, false);

        var logoutButton = viewManager.CreateButton("Logout", 610, 20, 130, 25, 18, colorManager.getColor("DarkText"), colorManager.getColor("LightBackground"));

        panel.add(title);
        panel.add(logoutButton);
        panel.add(usernameTitle);
        panel.add(companyName);
        panel.add(transactionTitle);
        panel.add(showTransactionBtn);
        panel.add(currentOptionTitle);
    }

    private void ChangeCustomOptionsPanel(JPanel panel, String selection) {
        System.out.println(selection);
        dispose();
        var view = new DashBoardView(selection);
        view.setVisible(true);
    }

    private void InitCustomOptionsPanel(JPanel panel, String selection) {
        var firstYBg = 95;
        var firstYLabel = 112;
        if ("Gestão de Veículo".equals(selection) || selection == null) {
            var options = uImodels.getGestaoVeiculosOptions();
            for (String option : options) {
                var optionBtn = viewManager.CreateButtonWithImage("src/resources/buttonLargeWhite.png",
                        388, 83,
                        colorManager.getColor("AccentBackgroundColor"), 388, 84, 408, firstYBg, false);
                var optionLabel = viewManager.CreateLabel(option, 15, "Inter Medium", colorManager.getColor("LightText"),
                        830,
                        50, 435
                        , firstYLabel, false,
                        false);
                panel.add(optionLabel);
                panel.add(optionBtn);
                firstYBg = firstYBg + 103;
                firstYLabel = firstYLabel + 103;

                optionBtn.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        var imageIcon = new ImageIcon("src/resources/buttonLargeBlack.png");
                        Image buttonImg = imageIcon.getImage().getScaledInstance(388, 84,
                                Image.SCALE_AREA_AVERAGING);
                        imageIcon.setImage(buttonImg);
                        optionBtn.setIcon(imageIcon);
                        optionLabel.setForeground(colorManager.getColor("LightBackground"));
                    }

                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        var imageIcon = new ImageIcon("src/resources/buttonLargeWhite.png");
                        Image buttonImg = imageIcon.getImage().getScaledInstance(388, 84,
                                Image.SCALE_AREA_AVERAGING);
                        imageIcon.setImage(buttonImg);
                        optionBtn.setIcon(imageIcon);
                        optionLabel.setForeground(colorManager.getColor("LightText"));

                    }
                });
                optionBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        switch (option) {
                            case "Adicionar Veículo":
                                dispose();
                                new AddVehicleView().setVisible(true);
                                break;
                            case "Alterar Veículo":
                                dispose();
                                new ChangeVehicleView().setVisible(true);
                                break;
                            case "Eliminar Veículo":
                                dispose();
                                new DeleteVehicleView().setVisible(true);
                                break;
                            case "Transferir Veículo":
                                dispose();
                                new TransferVehicleView().setVisible(true);
                                break;
                            case "Registar Compra": //todo se calhar a compra e venda é a mesma merda mas passar um atributo lá para dentro
                                dispose();
                                new RegisterPurchaseView().setVisible(true);
                                break;
                            case "Registar Venda":
                                dispose();
                                new RegisterSaleView().setVisible(true);
                                break;
                        }
                    }
                });
            }
        }
        if ("Gestão de Peças".equals(selection)) {
            var options = uImodels.getGestaoPeçasOptions();
            for (String option : options) {
                var optionBtn = viewManager.CreateButtonWithImage("src/resources/buttonLargeWhite.png",
                        388, 83,
                        colorManager.getColor("AccentBackgroundColor"), 388, 84, 408, firstYBg, false);
                var optionLabel = viewManager.CreateLabel(option, 15, "Inter Medium", colorManager.getColor("LightText"),
                        830,
                        50, 435
                        , firstYLabel, false,
                        false);
                panel.add(optionLabel);
                panel.add(optionBtn);
                firstYBg = firstYBg + 103;
                firstYLabel = firstYLabel + 103;

                optionBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        switch (option) {
                            case "Adicionar Peça":
                                dispose();
                                new AddPartView().setVisible(true);
                                break;
                            case "Alterar Peça":
                                dispose();
                                new ChangePartView().setVisible(true);
                                break;
                        }
                    }
                });
            }

        }
        if ("Gestão de Eventos".equals(selection)) {
            var options = uImodels.getGestaoEventosOptions();
            for (String option : options) {
                var optionBtn = viewManager.CreateButtonWithImage("src/resources/buttonLargeWhite.png",
                        388, 83,
                        colorManager.getColor("AccentBackgroundColor"), 388, 84, 408, firstYBg, false);
                var optionLabel = viewManager.CreateLabel(option, 15, "Inter Medium", colorManager.getColor("LightText"),
                        830,
                        50, 435
                        , firstYLabel, false,
                        false);
                panel.add(optionLabel);
                panel.add(optionBtn);
                firstYBg = firstYBg + 103;
                firstYLabel = firstYLabel + 103;

                optionBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        switch (option) {
                            case "Adicionar Evento":
                                dispose();
                                new AddEventView().setVisible(true);
                                break;
                            case "Alterar Evento":
                                dispose();
                                new ChangeEventView().setVisible(true);
                                break;
                        }
                    }
                });
            }
        }
        if ("Gestão de Clientes".equals(selection)) {
            var options = uImodels.getGestaoClientesOptions();
            for (String option : options) {
                var optionBtn = viewManager.CreateButtonWithImage("src/resources/buttonLargeWhite.png",
                        388, 83,
                        colorManager.getColor("AccentBackgroundColor"), 388, 84, 408, firstYBg, false);
                var optionLabel = viewManager.CreateLabel(option, 15, "Inter Medium", colorManager.getColor("LightText"),
                        830,
                        50, 435
                        , firstYLabel, false,
                        false);
                panel.add(optionLabel);
                panel.add(optionBtn);
                firstYBg = firstYBg + 103;
                firstYLabel = firstYLabel + 103;

                optionBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        switch (option) {
                            case "Adicionar Cliente":
                                dispose();
                                new AddClientView().setVisible(true);
                                break;
                            case "Alterar Cliente":
                                dispose();
                                new ChangeClientView().setVisible(true);
                                break;
                            case "Eliminar Cliente":
                                dispose();
                                new DeleteClientView().setVisible(true);
                                break;
                        }
                    }
                });
            }
        }
    }

    private void InitCustomOptions(JPanel panel) {
        var options = uImodels.getOptionsButton();

        var optionBG = viewManager.CreateButtonWithImage("src/resources/optionsBG.png",
                353, 292,
                colorManager.getColor("AccentBackgroundColor"), 352, 293, 28, 404, false);

        for (DashboardOptions option : options) {
            var Btn = viewManager.CreateButtonWithImage(option.isSelected() ? "src/resources/buttonBGBlack.png" : "src/resources/buttonBGGrey.png",
                    164, 133,
                    colorManager.getColor("AccentBackgroundColor"), 164, 133, option.getxBG(), option.getyBG(), false);

            var Img = viewManager.CreateButtonWithImage(option.getIcon(),
                    20, 20,
                    colorManager.getColor("AccentBackgroundColor"), 20, 20, option.getxImg(), option.getyImg(), false);

            var Label = viewManager.CreateLabel(option.getName(), 13, "Inter Light", colorManager.getColor("DarkText"),
                    830,
                    50, option.getxLbl()
                    , option.getyLbl(), false,
                    false);

            // EFFECTS
            Btn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    var imageIcon = new ImageIcon(option.isSelected() ? "src/resources/buttonBGBlack.png" : "src/resources/buttonBGBlack.png");
                    Image buttonImg = imageIcon.getImage().getScaledInstance(164, 133,
                            Image.SCALE_AREA_AVERAGING);
                    imageIcon.setImage(buttonImg);
                    Btn.setIcon(imageIcon);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    var imageIcon = new ImageIcon(option.isSelected() ? "src/resources/buttonBGBlack.png" : "src" +
                            "/resources/buttonBGGrey.png");
                    Image buttonImg = imageIcon.getImage().getScaledInstance(164, 133,
                            Image.SCALE_AREA_AVERAGING);
                    imageIcon.setImage(buttonImg);
                    Btn.setIcon(imageIcon);
                }
            });

            Btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ChangeCustomOptionsPanel(panel, option.getName());
                }
            });

            panel.add(Img);
            panel.add(Label);
            panel.add(Btn);

        }
    }

    private void InitTransactions(JPanel panel) {
        var firstYIcon = 147;
        var firstYLabel = 160;
        var options = uImodels.getTransactions();

        for (Transaction option : options) {

            var label = viewManager.CreateLabel(option.getName(), 12, "Inter Medium",
                    colorManager.getColor("DarkText"),
                    830,
                    50, 64
                    , firstYIcon, false,
                    false);

            var img = viewManager.CreateButtonWithImage(option.getIcon(),
                    24, 23,
                    colorManager.getColor("AccentBackgroundColor"), 24, 24, 30, firstYLabel, false);

            panel.add(img);
            panel.add(label);
            firstYIcon = firstYIcon + 40;
            firstYLabel = firstYLabel + 40;
        }
    }


    public static void main(String[] args) {
        dashBoardView = new DashBoardView(null);
        dashBoardView.setVisible(true);
    }

}
