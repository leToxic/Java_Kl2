package playerColors;

import java.util.Random;

/**
 * Created: 14.06.2022 at 15:25
 *
 * @author Plasek Sebastian
 */
public class Player {
    private String name;
    private Color color;
    private int playerID;
    public static int playerCount;
    public static Color[] assignedColors = new Color[Color.values().length];


    public Player(String name, Color color) {
        Random rnd = new Random();
        for (Color colorTest : assignedColors) {
            if (!(colorTest.rgb == color.rgb)) {
                this.color = color;
                for (int i = 0; i < assignedColors.length - 1; i++) {
                    if (assignedColors[i] == null) {
                        assignedColors[i] = color;
                        break;
                    }
                }
                break;
            }
        }
        this.name = name;
        playerID = rnd.nextInt(5000) * 30;
        playerCount += 1;
    }

    @Override
    public String toString() {
        return name + " mit ID: " + playerID + " hat die Farbe: " + color;
    }


    public int compareTo(Player player) {
        return this.color.sumRGB() - player.color.sumRGB();
    }


    public static void main(String[] args) {
        System.out.println((new RGBColors(255, 0, 0).getHex()));
    }

}
