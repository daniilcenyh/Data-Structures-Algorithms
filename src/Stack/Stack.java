package Stack;


import java.util.EmptyStackException;

public class Stack {
    private ListNode top;
    private int length;

    //---- класс для объявления нового элемента в стэке ----//
    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Stack() {
        top = null;
        length = 0;
    }

    public int lehgth() {
        return length;
    }

    public boolean is_empty() {
        return length == 0;
    }

    // ---- добавление нового элемента ---- //
    public void push(int data) {
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    // ---- удаление елемента TOP ---- //
    public int pop() {
        if (is_empty()) {
            throw new EmptyStackException();
        }

        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public int top() {
        if (is_empty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    // ---- преобразование строки в стэк ---- //


    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.push(25);

        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.top());
    }
}
