import java.util.*;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        List<int[]> result = new ArrayList<>();
        int[] previous = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];

            if (overlaps(previous, current)) {
                previous[1] = Math.max(previous[1], current[1]);
            } else {
                result.add(previous);
                previous = current;
            }
        }

        result.add(previous);

        return result.toArray(new int[result.size()][]);
    }

    private boolean overlaps(int[] first, int[] second) {
        return first[1] >= second[0];
    }
}
