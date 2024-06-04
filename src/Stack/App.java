package Stack;

public class App {
    public static void main(String[] args) {
        StackOnArray stack = new StackOnArray(100);
        int count = 0;

        while (count < 10) {
            stack.push(count);
            count++;
        }

        while(!stack.id_empty()) {
            long value = stack.pop();
            System.out.println(value);
        }


        String[] string = {"h","e","l","l","o"};

        for(String elem : string) {
            if (elem == "l") {
                continue;
            }
            System.out.print(elem);
        }
    }
}
