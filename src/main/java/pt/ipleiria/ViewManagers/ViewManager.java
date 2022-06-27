package pt.ipleiria.ViewManagers;

import pt.ipleiria.model.CarCondition;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class ViewManager {

    public void CreateView(JFrame frame, int width, int height) {
        frame.setUndecorated(true);
        frame.setShape(new RoundRectangle2D.Double(0, 0, width, height, 16, 16));
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
    }

    public JPanel CreateJpanel(
            int width,
            int height,
            Color background) {
        var panel = new JPanel();
        panel.setSize(width, height);
        panel.setBackground(background);
        panel.setLayout(null);
        return panel;
    }

    public JLabel CreateLabel(
            String text,
            int size,
            String font,
            Color color,
            int width,
            int height,
            int x,
            int y,
            boolean bold,
            boolean centered) {
        var label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setForeground(color);
        label.setFont(new Font(font, Font.TRUETYPE_FONT, size));
        if (centered) {
            label.setHorizontalAlignment(SwingConstants.CENTER);
        }
        return label;
    }

    public JLabel CreateLabelIcon(
            String path,
            int imgWidht,
            int imgHeight,
            int width,
            int height,
            int x,
            int y,
            boolean centered) {
        var imageIcon = new ImageIcon(path);
        Image labelimg = imageIcon.getImage().getScaledInstance(imgWidht, imgHeight, Image.SCALE_AREA_AVERAGING);
        imageIcon.setImage(labelimg);
        var label = new JLabel();
        label.setIcon(imageIcon);
        label.setBounds(x, y, width, height);
        label.setBorder(null);
        return label;
    }

    public JTextField CreateTextField(
            String text,
            int columns,
            int size,
            Color color,
            Color background,
            int x,
            int y,
            int width,
            int height,
            boolean centered
    ) {
        var textfield = new JTextField(text,columns);
        textfield.setBounds(x,y,width,height);
        if(centered){
            textfield.setHorizontalAlignment(JTextField.CENTER);
        }
        textfield.setFont(new Font("Inter Regular", Font.PLAIN, size));
        textfield.setBorder(new EmptyBorder(0, 0, 0, 0));
        textfield.setBackground(background);
        textfield.setForeground(color);
        return textfield;
    }

    public JButton CreateButtonWithImage(
            String path,
            int imgWidht,
            int imgHeight,
            Color background,
            int width,
            int height,
            int x,
            int y,
            boolean centered
    ) {
        var imageIcon = new ImageIcon(path);
        Image buttonImg = imageIcon.getImage().getScaledInstance(imgWidht, imgHeight, Image.SCALE_AREA_AVERAGING);
        imageIcon.setImage(buttonImg);
        var button = new JButton();
        button.setIcon(imageIcon);
        button.setBackground(background);
        button.setBorderPainted(false);
        button.setBounds(x, y, width, height);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        if(centered){
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        return button;
    }

    public JComboBox<?> CreateSelector(
            int x,
            int y,
            int width,
            int height,
            Color color,
            Color background
    ){
        var conditionList = new JComboBox<Object>(CarCondition.values());
        conditionList.setBounds(x,y,width,height);
        conditionList.setSelectedIndex(4);
        conditionList.setForeground(color);
        conditionList.setBackground(background);
        conditionList.setOpaque(true);
        conditionList.setBorder(null);
        return conditionList;
    }

    public JButton CreateButton(
            String text,
            int x,
            int y,
            int width,
            int height,
            int size,
            Color color,
            Color background

    ) {
        var button = new JButton(text);
        button.setBounds(x,y,width,height);
        button.setFont(new Font("Inter Regular", Font.PLAIN, size));
        button.setForeground(color);
        button.setBackground(background);
        button.setBorderPainted(true);
        button.setFocusPainted(false);//mudei isto para false
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBorder(null);
        return button;
    }


    public JPasswordField CreatePasswordField(
            String text,
            int size,
            Color color,
            Color background,
            int x,
            int y,
            int width,
            int height,
            boolean centered
    ) {
        var passwordField = new JPasswordField(text);
        passwordField.setBounds(x,y,width,height);
        if(centered){
            passwordField.setHorizontalAlignment(JTextField.CENTER);
        }
        passwordField.setFont(new Font("Inter Light", Font.PLAIN, size));
        passwordField.setBorder(null);
        passwordField.setBorder(BorderFactory.createCompoundBorder(passwordField.getBorder(), BorderFactory.createEmptyBorder(5, 12, 5, 5)));
        passwordField.setBackground(background);
        passwordField.setForeground(color);
        return passwordField;
    }

    public void AddHover(JComponent component, Color colorIn, Color backgroundIn, Color colorOut, Color backgroundOut) {

        component.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                component.setBackground(backgroundIn);
                component.setForeground(colorIn);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                component.setBackground(backgroundOut);
                component.setForeground(colorOut);
            }
        });
    }
}
