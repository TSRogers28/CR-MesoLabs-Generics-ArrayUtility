package com.zipcodewilmington.arrayutility;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {

    private T[] array;

    public ArrayUtility(T[] array){
        this.array = array;
    }


 public Integer countDuplicatesInMerge(T[] array, T value){
        int count = getNumberOfOccurrences(value);
        ArrayUtility<Object> arrayUtility = new ArrayUtility<Object>(array);
        count += arrayUtility.getNumberOfOccurrences(value);
     return count;
 }




    public  T[] removeValue(T value){
        T[] array = Arrays.copyOf(this.array, this.array.length - getNumberOfOccurrences(value));
        int x = 0;
        for(T t : this.array)
            if (!t.equals(value)) {
                array[x] = t;
                x++;
            }
        return array;
    }


    public T getMostCommonFromMerge(T[] arrayToMerge) {
        int count;
        HashMap<T, Integer> testMap = new HashMap<>();
        for(T t: this.array) {
            count = testMap.getOrDefault(t, 0);
            testMap.put(t, ++count);
        }
        for(T t: arrayToMerge) {
            count = testMap.getOrDefault(t, 0);
            testMap.put(t, ++count);
        }

        count = 0;
        T answer = null;
        for(T t: testMap.keySet())
            if(testMap.get(t) > count){
            count = testMap.get(t);
            answer =t;
            }


//        T [] mergedArray = mergeArrays(arrayToMerge);
//        int count = 0;
//        T answer = null;
//        for(T t : mergedArray)
//            if(getNumberOfOccurrences(t) > count) {
//                count = getNumberOfOccurrences(t);
//                answer = t;
//            }
        return answer;
    }

    public T [] mergeArrays(T[] arrayToMerge){
        int thisALen = this.array.length;
        int AToMergeLen = arrayToMerge.length;
        T[] mergedArray = (T[]) Array.newInstance(arrayToMerge.getClass().getComponentType(), thisALen+ AToMergeLen);
        System.arraycopy(this.array, 0, mergedArray, 0, thisALen);
        System.arraycopy(arrayToMerge, 0, mergedArray, AToMergeLen, AToMergeLen);
        return mergedArray;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int count = 0;
        for(T t : this.array)
            if (t.equals(valueToEvaluate))
                count++;
        return count;
    }
}
