package Math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LC406_QueueReconstructionbyHeight {
    /*
    最后一个测试用例超时
    后一个是AC的算法，后半部分进行了优化
    res.toArray(new int[res.size()][2]);
    注意这种写法
     */
    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        List<int[]> res = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            int number = people[i][0];
            int kth = people[i][1];

            int j = 0;
            while (kth > 0 && j < res.size()) {
                if (res.get(j)[0] >= number) {
                    kth--;
                }
                j++;
            }
            res.add(j, people[i]);
        }
        return res.toArray(new int[res.size()][2]);
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        List<int[]> res = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            res.add(people[i][1], people[i]);
        }
        return res.toArray(new int[res.size()][2]);
    }
}
