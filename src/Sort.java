import java.util.ArrayList;

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

}
