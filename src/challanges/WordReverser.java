package challanges;

public class WordReverser {

    public static String Reverser(String toReverse) {
        StringBuilder sb = new StringBuilder();
        char[] arr = toReverse.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Reverser("car"));
    }
}
