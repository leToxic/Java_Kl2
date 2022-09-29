package playerColors;

/**
 * Created: 14.06.2022 at 15:27
 *
 * @author Plasek Sebastian
 */
public enum Color {
    RED(new RGBColors(255, 0, 0)),
    GREEN(new RGBColors("#00FF00")),
    BLUE("#0000FF");
    RGBColors rgb;


    Color(RGBColors rgb) {
        this.rgb = rgb;
    }


    public int sumRGB() {
        return Integer.decode(rgb.getHex());
    }

    Color(String hex) {
        this(new RGBColors(hex));
    }
}
