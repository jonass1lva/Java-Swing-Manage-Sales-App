package pt.ipleiria.ViewManagers;

import java.awt.*;
import java.util.HashMap;

public class ColorManager {

    private static ColorManager colorManagerObject;
    private final HashMap<String,Color> colors = new HashMap<>();

    public ColorManager() {
        InitUIColors();
    }

    public Color getColor(String color) {
        return colors.get(color);
    }

    public static ColorManager getInstance() {
        if(colorManagerObject == null) {
            colorManagerObject = new ColorManager();
        }
        return colorManagerObject;
    }

    public void InitUIColors() {
        colors.put("LightBackground", new Color(222, 222, 222));
        colors.put("AccentBackgroundColor", new Color(242, 242, 242));
        colors.put("BackgroundColor", new Color(233, 233, 233));
        colors.put("DarkText", new Color(0, 0, 0));
        colors.put("LightText", new Color(37, 37, 37));
        colors.put("GreyText", new Color(133, 133, 133));
        colors.put("hoverBackground", new Color(30, 30, 30));
        colors.put("hoverColor", new Color(236, 233, 233));
    }
}
