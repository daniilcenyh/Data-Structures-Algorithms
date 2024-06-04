package LinkedList;

public class SinglyLinkedList {

    private ListNode head;

    //---- класс для объявления нового элемента в односвязанном списке ----//
    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //---- вывод сипска на экран ----//
    public void print() {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    //---- нахождение длинны списка ----//
    public int findLength() {
        if (head == null) {
            return 0;
        }
        int cnt = 0;
        ListNode current = head;
        while (current != null) {
            cnt++;
            current = current.next;
        }
        return cnt;
    }

    //---- добавление в начало списка нового элемента ----//
    public void push_front(int value){
        ListNode node = new ListNode(value);
        node.next = head;
        head = node;
    }

    //---- добавление в конец списка нового элемента ----//
    public void push_back(int value) {
        ListNode node = new ListNode(value);
        if (head == null) {
            head = node;
            return;
        }

        ListNode current = head;
        while (null != current.next) {
            current = current.next;
        }
        current.next = node;
    }

    //---- добавление в заданную позицию списка нового элемента ----//
    public void push_in(int value, int position) {
        ListNode node = new ListNode(value);

        if (position == 0) {
            node.next = head;
            head = node;
        } else {
            ListNode previous = head;
            int cnt = 0;
            while (cnt < position-1) {
                previous = previous.next;
                cnt++;
            }
            ListNode current = previous.next;
            node.next = current;
            previous.next = node;
        }
    }

    //---- удаление первого элемента ----//
    public ListNode pop_front(){
        if (head == null) {
            return null;
        }
        ListNode node = head;
        head = head.next;
        node.next = null;
        return node;
    }

    //---- удаление последнего элемента ----//
    public ListNode pop_back() {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return previous;
    }

    //---- удаление элемента из произвольного места списка ----//
    public void pop_in(int position) {
        if (position == 0) {
            head = head.next;
        } else {
            ListNode previous = head;
            int cnt = 0;
            while (cnt < position-1) {
                previous = previous.next;
                cnt++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    //---- удаление по ключу ----//
    public void delete_for_key(int key) {
        ListNode current = head;
        ListNode temp = null;

        if (current != null && current.data == key) {
            head = current.next;
            return;
        }

        while (current != null && current.data != key) {
            temp = current;
            current = current.next;
        }

        if (current == null) return;
        temp.next = current.next;
    }

    //---- поиск по ключу ----//
    public String search(int key) {
        if (head == null) {
            return "такого элемента в спике нет";
        }
        ListNode current = head;
        while (current != null) {
            if (current.data == key) {
                return "такой элемент в списке есть";
            }
            current = current.next;
        }
        return "такого элемента в спике нет";
    }

    //---- удаление дубликатов из отсортированного списка ----//
    public void remove_dublicate() {
        if (head == null) return;

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
    }

    //---- разворот списка задом наперед ----//
    public ListNode reverse(){
        if (head == null) return head;

        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    //---- нахождение среднего элемента списка ----//
    public ListNode find_middle_node() {
        if (head == null) return null;

        ListNode slow_pointer = head;
        ListNode fast_pointer = head;
        while (fast_pointer != null && fast_pointer.next != null) {
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;
        }

        return slow_pointer;
    }

    //---- объединение двух отсортированных списков ----//
     public ListNode merge_two_sorted_list(ListNode first_list, ListNode second_list) {
        ListNode result_list = new ListNode(0);
        ListNode tail = result_list;

        while ((first_list != null) && (second_list != null)) {
            if (first_list.data <= second_list.data) {
                tail.next = first_list;
                first_list = first_list.next;
            } else {
                tail.next = second_list;
                second_list = second_list.next;
            }

            tail = tail.next;
        }

        if (first_list == null) {
            tail.next = second_list;
        } else {
            tail.next = first_list;
        }

        return result_list.next;
     }


    public static void main(String[] args) {
        SinglyLinkedList list_1 = new SinglyLinkedList();
        SinglyLinkedList list_2 = new SinglyLinkedList();

        list_1.push_back(1);
        list_1.push_back(3);
        list_1.push_back(5);
        list_1.push_back(7);
        list_1.push_back(9);
        list_1.push_back(11);

        list_2.push_back(2);
        list_2.push_back(4);
        list_2.push_back(6);
        list_2.push_back(8);
        list_2.push_back(10);
        list_2.push_back(12);

        list_1.print();
        list_2.print();

        SinglyLinkedList merge_list = new SinglyLinkedList();

        merge_list.head = merge_list.merge_two_sorted_list(list_1.head,list_2.head);

        merge_list.print();
        System.out.println(merge_list.find_middle_node().data);
    }
}
