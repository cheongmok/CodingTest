package SWEA;

/*
지금은 자정에서부터 정확히 A시간이 지났다.
정확히 B시간이 더 지난다면 24시간제 시계에서 그 때는 몇 시일까?
 */

import java.util.Scanner;

public class SWEA12368 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalCase = sc.nextInt();

        for (int testCase = 1; testCase <= totalCase; ++testCase) {
            int startTime, elapsedTime;
            startTime = sc.nextInt();
            elapsedTime = sc.nextInt();

            //  0 <= A, B <= 23
            // 자정은 0시
            // 0 ~ 46시(22시)

            // 1. A + B < 24 --> A + B
            // 2. A + B > 24 --> A + B - 24

            int endTime = startTime + elapsedTime;
            if (endTime >= 24) {
                endTime -= 24;
            }
            System.out.println("#" + testCase + " " + endTime);
        }

    }
}
