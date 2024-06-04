package Array;

public class ArrayUtil {

    public static void print_array(int[] array) {
        int length_array = array.length;

        for (int i = 0; i < length_array; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void array_demo(int length_array) {
        int[] array = new int[length_array];
        print_array(array);
    }

    public static int[] remove_odd_numbers(int[] array) {
        int count_odd_number = 0;
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                count_odd_number++;
            }
        }

        int[] result_array = new int[count_odd_number];

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                result_array[index] = array[i];
                index++;
            }
        }

        return result_array;
    }

    public static void reverse_array(int[] array, int start_pointer, int end_pointer) {
        while (start_pointer < end_pointer) {
            int temp = array[start_pointer];
            array[start_pointer] = array[end_pointer];
            array[end_pointer] = temp;

            start_pointer++;
            end_pointer--;
        }
    }

    public static int min_value_array(int[] array) {
        if (array.length == 0) {
            return -1;
        }

        int min_value = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min_value) {
                min_value = array[i];
            }
        }
        return min_value;
    }

    public static int msx_value(int[] array) {
        if (array.length == 0) {
            return -1;
        }

        int max_value = Integer.MIN_VALUE;
        for (int i = 0 ; i < array.length; i++) {
            if (array[i] > max_value) {
                max_value = array[i];
            }
        }

        return max_value;
    }

    public static int find_second_max_value(int[] array) {
        int max_value = Integer.MIN_VALUE;
        int second_max_value = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max_value) {
                second_max_value = max_value;
                max_value = array[i];
            } else if ((array[i] > second_max_value) && (array[i] != max_value)) {
                second_max_value = array[i];
            }
        }

        return second_max_value;
    }

    public static void move_zeroes_to_end_array(int[] array) {
        int j = 0;

        for (int i = 0; i < array.length; i++) {
            if ((array[i] != 0) && (array[j] == 0)) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            if (array[j] != 0) {
                j++;
            }
        }
    }
    // поиск недостающего числа из последовательности n-ой размерности
    public static int find_missing_number(int[] array) {
        int n = array.length + 1;
        int sum = n*(n+1) / 2;

        for (int element : array) {
            sum -= element;
        }
        return sum;
    }

    public static void main(String... args) {
        ArrayUtil arrayUtil = new ArrayUtil();
//        arrayUtil.array_demo(12);

        int[] array = {0,1,2,3,4,5,6,7,8,9};

        print_array(array);

        print_array(remove_odd_numbers(array));

        reverse_array(array, 0, array.length-1);

        print_array(array);

        int second_max_value = find_second_max_value(array);

        System.out.println(min_value_array(array));
        System.out.println(second_max_value);

        reverse_array(array, 0, array.length-1);

        print_array(array);

        int[] array_2 = {1,0,645,0,0,0,0,5758,5,6,0,0,23,457,2332,3411,1,1,1,0};

        print_array(array_2);

        move_zeroes_to_end_array(array_2);

        print_array(array_2);
    }
}
