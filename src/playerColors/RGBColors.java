package playerColors;

/**
 * Created: 14.06.2022 at 15:29
 *
 * @author Plasek Sebastian
 */
public class RGBColors {
    private int r;
    private int g;
    private int b;


    public RGBColors(int r, int g, int b) {
        if (r >= 0 && g >= 0 && b >= 0) {
            this.r = r;
            this.b = b;
            this.g = b;
        }
    }

    public RGBColors(String hex) {
        this.r = Integer.decode(hex.substring(0, 3));
        this.g = Integer.decode("#" + hex.substring(3, 5));
        this.b = Integer.decode("#" + hex.substring(5, 7));
    }

    public String getHex() {
        StringBuilder sb = new StringBuilder("#");
        if (Integer.toHexString(this.b).length() == 1) {
            sb.append("0").append(Integer.toHexString(this.b));
        } else {
            sb.append(Integer.toHexString(this.b));
        }
        if (Integer.toHexString(this.b).length() == 1) {
            sb.append("0").append(Integer.toHexString(this.b));
        } else {
            sb.append(Integer.toHexString(this.b));
        }
        if (Integer.toHexString(this.b).length() == 1) {
            sb.append("0").append(Integer.toHexString(this.b));
        } else {
            sb.append(Integer.toHexString(this.b));
        }


        return sb.toString();
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }
}
