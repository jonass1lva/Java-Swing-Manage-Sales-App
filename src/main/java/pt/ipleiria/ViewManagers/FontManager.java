package pt.ipleiria.ViewManagers;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Font Manger é um singleton que permite aceder ás fontes o espectro da App
 */
public class FontManager {
    private static FontManager fontManagerObject;
    public FontManager() {
        setLightFont();
        setRegularFont();
        setMediumFont();
        setBoldFont();
    }

    public static FontManager getInstance() {

        if(fontManagerObject == null) {
            fontManagerObject = new FontManager();
        }
        return fontManagerObject;
    }

    // Font 300
    public void setLightFont() {
        try {
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Inter-Light.ttf")));
        } catch (IOException|FontFormatException e) {
            //Handle exception
        }
    }

    // Font 400
    public void setRegularFont() {
        try {
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Inter-Regular.ttf")));
        } catch (IOException|FontFormatException e) {
            //Handle exception
        }
    }

    // Font 500
    public void setMediumFont() {
        try {
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Inter-Medium.ttf")));
        } catch (IOException|FontFormatException e) {
            //Handle exception
        }
    }

    // Font 600
    public void setBoldFont() {
        try {
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Inter-SemiBold.ttf")));
        } catch (IOException|FontFormatException e) {
            //Handle exception
        }
    }
}
