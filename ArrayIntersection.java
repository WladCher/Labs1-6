import java.util.*;

public class ArrayIntersection {

    public int[] findIntersection(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);

        int pointer1 = 0;
        int pointer2 = 0;

        List<Integer> intersectionList = new ArrayList<>();

        while (pointer1 < array1.length && pointer2 < array2.length) {
            int value1 = array1[pointer1];
            int value2 = array2[pointer2];

            if (value1 < value2) {
                pointer1++;
            } else if (value1 > value2) {
                pointer2++;
            } else {
                intersectionList.add(value1);
                pointer1++;
                pointer2++;
            }
        }

        return convertListToArray(intersectionList);
    }

    private int[] convertListToArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
