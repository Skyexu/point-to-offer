package examination.PDD;

import java.util.*;

/**
 * @Author: Skye
 * @Date: 20:12 2018/8/5
 * @Description:
 */
public class T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int personNum = scanner.nextInt();
        int targetPerson = scanner.nextInt();
        scanner.nextLine();
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < personNum; i++) {
            Set set = new HashSet();
            String[] strings = scanner.nextLine().trim().split(" ");
            Arrays.stream(strings).forEach(s -> set.add(s));
            list.add(set);
        }
        int maxCount = -1;
        int maxIndex = 0;
        for (int i = 0; i < personNum; i++) {
            if (i == targetPerson) {
                continue;
            }
            Set setTarget = new HashSet();
            setTarget.addAll(list.get(targetPerson));
            Set setNow = list.get(i);
            setTarget.retainAll(setNow);
            if (maxCount < setTarget.size()) {
                maxCount = setTarget.size();
                maxIndex = i;
            }
        }
        if (maxCount == 0){
            System.out.println(-1);
        }else {
            System.out.println(maxIndex);
        }

    }


}
