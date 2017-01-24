import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Dns on 24.01.2017.
 */
public abstract class Sort {
    Sort(){
    }

    public static ArrayList<Integer> insertion(ArrayList<Integer> array){
        for (int i = 0; i < array.size(); i++)
        {
            int temp = array.get(i);
            int j =i-1;
            while(j >= 0 && array.get(j) > temp)
            {
                array.set(j + 1, array.get(j));
                j--;
            }
            array.set(j + 1, temp);
        }
        return array;
    }

    public static ArrayList<Integer> choose(ArrayList<Integer> array){
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

    public static ArrayList<Integer> shell(ArrayList<Integer> array){
        int size = array.size();
        int step = size / 2;
        while (step > 0)
        {
            for (int i = 0; i < (size - step); i++)
            {
                int j = i;

                while (j >= 0 && array.get(j) > array.get(j + step))
                {
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

    public static int[] mergeSort(int[] array){
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




    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
