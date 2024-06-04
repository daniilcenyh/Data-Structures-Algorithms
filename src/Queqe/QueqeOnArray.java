package Queqe;

public class QueqeOnArray {
    private int max_size;
    private long[] queqe_array;
    private int front;
    private int rear;
    private int n_items;

    //конструктор для очереди
    public QueqeOnArray(int length) {
        max_size = length;
        queqe_array = new long[max_size];

        rear = -1;
        n_items = 0;
    }

    //---------------------------------------------------------------------------------------------------------
    public void insert(long element) { //вставка элемента в конец очереди
        if (rear == max_size - 1) {
            rear = -1;
        }
        queqe_array[++rear] = element;
        n_items++;
    }
    //---------------------------------------------------------------------------------------------------------
}
