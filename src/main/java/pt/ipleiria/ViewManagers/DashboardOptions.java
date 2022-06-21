package pt.ipleiria.ViewManagers;

public class DashboardOptions {
    private String name;
    private String icon;
    private int xBG;
    private int yBG;
    private int xLbl;
    private int yLbl;
    private int xImg;
    private int yImg;
    boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getxImg() {
        return xImg;
    }

    public void setxImg(int xImg) {
        this.xImg = xImg;
    }

    public int getyImg() {
        return yImg;
    }

    public void setyImg(int yImg) {
        this.yImg = yImg;
    }

    public int getxBG() {
        return xBG;
    }

    public void setxBG(int xBG) {
        this.xBG = xBG;
    }

    public int getyBG() {
        return yBG;
    }

    public void setyBG(int yBG) {
        this.yBG = yBG;
    }

    public int getxLbl() {
        return xLbl;
    }

    public void setxLbl(int xLbl) {
        this.xLbl = xLbl;
    }

    public int getyLbl() {
        return yLbl;
    }

    public void setyLbl(int yLbl) {
        this.yLbl = yLbl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
