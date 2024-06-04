package Stack;

//реализация стека на основе массива
public class StackOnArray {
    //инициализация переменных
    private final int max_size;
    private long[] stack_array;
    private int top;

    //конструктор стэка
    public StackOnArray(int length) {
        this.max_size = length;//максимальный размер
        this.stack_array = new long[max_size];//инициализация (stack_array) размером (max_size)
        this.top = -1;//пока нет ни одного элемента
    }

    //размещение элемента на вершине стэка
    public void push(long element) {
        stack_array[++top] = element;
    }
    //извлечение верхнего элемента из стэка
    public long pop() {
        return stack_array[top--];
    }
    //чтение элемента с вершины стэка
    public long peek() {
        return stack_array[top];
    }
    //проверка на пустоту стэка
    public boolean id_empty() { // True если стэк пуст
        return top == -1;
    }
    //проверка на полноту стэка
    public boolean if_full() {
        return top == max_size-1;
    }
}
