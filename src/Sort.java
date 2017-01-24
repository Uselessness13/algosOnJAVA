import java.util.ArrayList;

/**
 * Created by Dns on 24.01.2017.
 */
public class Sort {
    Sort(){
    }

    public ArrayList<Integer> insertion(ArrayList<Integer> array){
        for (int i = 0; i < array.size(); i++)
        {
            int temp = array.get(i);// запомним i-ый элемент
            int j =i-1;//будем идти начиная с i-1 элемента
            while(j >= 0 && array.get(j) > temp)
            // пока не достигли начала массива
            // или не нашли элемент больше i-1-го
            // который храниться в переменной temp
            {
                array.set(j + 1, array.get(j));
                //проталкиваем элемент вверх
                j--;
            }
            array.set(j + 1, temp);
            // возвращаем i-1 элемент
        }
        return array;
    }
}
