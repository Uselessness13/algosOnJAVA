import java.util.List;

/**
 * Created by Dns on 24.01.2017.
 */
class Search {

    Search() {
    }

    static <T extends Comparable<T>> int binary(List<T> array, T x){
        int l = 0;
        int r = array.size()-1;
        while(r-l>1){
            int med = l+(r-l)/2;
            if(array.get(med).compareTo(x)<0){
                l = med;
            }else{
                r = med;
            }

        }
        for(int i=l;i<=r;i++){ //нахождение элемнта х на интервале [l..r]
            if(array.get(i).equals(x)){
                return i;
            }
        }

        return -1;
    }

    int linear(List<Integer> array, int x){
        for (int i = 0; i < array.size(); i++){
            if (array.get(i) == x)
                return i;
        }
        return -1;
    }
}
