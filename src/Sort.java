import java.util.*;

/**
 * Created by Dns on 24.01.2017.
 */
public abstract class Sort {

    private static Random rnd = new Random();

    Sort() {
    }

    public static ArrayList<Integer> insertion(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            int temp = array.get(i);
            int j = i - 1;
            while (j >= 0 && array.get(j) > temp) {
                array.set(j + 1, array.get(j));
                j--;
            }
            array.set(j + 1, temp);
        }
        return array;
    }

    public static ArrayList<Integer> choose(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(j) < array.get(minValueIndex)) {
                    minValueIndex = j;
                }
            }
            int temp = array.get(i);
            array.set(i, array.get(minValueIndex));
            array.set(minValueIndex, temp);
        }
        return array;
    }

    public static ArrayList<Integer> shell(ArrayList<Integer> array) {
        int size = array.size();
        int step = size / 2;
        while (step > 0) {
            for (int i = 0; i < (size - step); i++) {
                int j = i;

                while (j >= 0 && array.get(j) > array.get(j + step)) {
                    int temp = array.get(j);
                    array.set(j, array.get(j + step));
                    array.set(j + step, temp);
                    j--;
                }
            }
            step = step / 2;
        }
        return array;
    }

    private static int[] mergeSort(int[] array) {
        int len = array.length;
        if (len < 2) return array;
        int middle = len / 2;
        return merge(mergeSort(Arrays.copyOfRange(array, 0, middle)),
                mergeSort(Arrays.copyOfRange(array, middle, len)));
    }

    private static int[] merge(int[] arr_1, int[] arr_2) {
        int len_1 = arr_1.length, len_2 = arr_2.length;
        int a = 0, b = 0, len = len_1 + len_2;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (b < len_2 && a < len_1) {
                if (arr_1[a] > arr_2[b]) result[i] = arr_2[b++];
                else result[i] = arr_1[a++];
            } else if (b < len_2) {
                result[i] = arr_2[b++];
            } else {
                result[i] = arr_1[a++];
            }
        }
        return result;
    }

    private static void heapify(int[] array, int size, int pos) {
        while (2 * pos + 1 < size) {
            int t = 2 * pos + 1;
            if (2 * pos + 2 < size && array[2 * pos + 1] < array[2 * pos + 2]) {
                t = 2 * pos + 2;
            }
            if (array[pos] < array[t]) {
                swap(array, pos, t);
                pos = t;
            } else {
                break;
            }
        }
    }


    private static int[] heapMake(int[] array) {
        int n = array.length;
        for (int i = n - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        return array;
    }

    public static int[] heapSort(int[] array) {
        int n = array.length;
        heapMake(array);
        while (n > 0) {
            printer(array);
            swap(array, 0, n - 1);
            n--;
            heapify(array, n, 0);

        }
        return array;
    }


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void printer(int[] array) {
        for (int i : array) System.out.print(i + " ");
        System.out.println();
    }

    static void qSort(List<Integer> array) {
        System.out.println(array);
        int n = array.size();
        int i = 0;
        int j = n - 1;
        int x = array.get(rnd.nextInt(n));
        while (i <= j) {
            while (array.get(i) < x) {
                i++;
            }
            while (array.get(j) > x) {
                j--;
            }
            if (i <= j) {
                Collections.swap(array, i, j);
                i++;
                j--;
            }
        }
        if (j > 0) {
            qSort(array.subList(0, j + 1));
        }
        if (i < n) {
            qSort(array.subList(i, n));
        }
    }

    public static void bubbleSort(int[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, array[j], array[j - 1]);
                }
            }
        }
        printer(array);
    }

    private static boolean correct(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1])
                return false;
        }
        return true;
    }

    public static void randomSort(int[] array) {
        int size = array.length;
        int count = 0;
        while (true) {
            count++;
            int i = rnd.nextInt(size - 1);
            int j = rnd.nextInt(size - 1);
            if (i != j && array[i] != array[j]) {
                swap(array, i, j);
            }
            if (correct(array)){
                //printer(array);
                System.out.println(count);
                return;
            }
        }
    }
}
