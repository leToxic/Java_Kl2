package challanges;

public class FindTheWord {

    public static String Finder(String input, String toFind) {
        String[] arr = input.split(" ");
        int position = 1;
        for (String s : arr) {
            if ((s).equalsIgnoreCase(toFind)) {
                System.out.println(position);
                return s;
            } else {
                position++;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(Finder("I love u", "LOVE"));
        System.out.println(Finder("Trains are good", "trains"));
    }
}
