package leetcode;

import java.util.Arrays;

public class Leetcode_274 {

    // My solution & my comment
    public int hIndex(int[] citations) { // runtime: 2ms, memory: 41.6mb
        // handle exceptional case
        // that the length of the array is 1 and that element is 0
        if (citations.length == 1 && citations[0] == 0) {
            return 0;
        }

        Arrays.sort(citations); // sort the array, then we can get the numbers of citations with increasing order.

        int answer = 0; // initialize answer with 0
        for (int i = 0; i < citations.length; i++) { // iterate the array through for loop
            int paperCount = citations.length
                    - i; // declare variable `paperCount` which represents the number of papers which is cited more than or exactly citations[i] times.
            if (paperCount
                    >= citations[i]) { // if the paperCount is equal to or greater than ith citations, then we can assign citations number to answer.
                answer = citations[i];
                continue;
            }
            // otherwise, we have to compare previous answer and available number of paper which is cited citations[i]+ times.
            if (paperCount > answer) {
                answer = paperCount;
                break;
            }
        }
        return answer;
    }

    // improved comment
    public int hIndexWithImprovedComment(int[] citations) {
        // Handle the case where the array length is 1 and the only element is 0
        if (citations.length == 1 && citations[0] == 0) {
            return 0;
        }

        Arrays.sort(citations); // Sort the array to arrange citations in increasing order.

        int answer = 0; // Initialize the answer variable to 0
        for (int i = 0; i < citations.length; i++) { // Iterate through the array using a for loop
            int paperCount = citations.length
                    - i; // Declare variable `paperCount`, which represents the number of papers cited at least `citations[i]` times.
            if (paperCount
                    >= citations[i]) { // If `paperCount` is at least `citations[i]`, update the answer with `citations[i]`.
                answer = citations[i];
                continue;
            }
            // Otherwise, compare the previous answer with the number of papers cited at least `citations[i]` times.
            if (paperCount > answer) {
                answer = paperCount;
                break;
            }
        }
        return answer;
    }

    // More readable solution
    public int hIndexMoreReadable(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        int length = citations.length;
        for(int i = 0; i < length; i++) {
            int paperCnt = length - i;
            if (citations[i] >= paperCnt) {
                answer = Math.max(answer, Math.min(citations[i], paperCnt));
            }
        }
        return answer;
    }


}
