import java.util.Stack;

public class StringReverse {

    public static String reverse(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();

        for (char element : chars) {
            stack.push(element);
        }

        for (int i = 0; i < str.length(); i++) {
            chars[i] = stack.pop();
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(str);
        System.out.println(reverse(str));

    }
}
