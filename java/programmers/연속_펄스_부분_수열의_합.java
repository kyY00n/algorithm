import java.lang.Math;

// https://school.programmers.co.kr/learn/courses/30/lessons/161988

public class 연속_펄스_부분_수열의_합 {

    public long solution(int[] sequence) {
        long startFromPlus = hi(sequence, 1L);
        long startFromMinus = hi(sequence, -1L);
        return Math.max(startFromPlus, startFromMinus);
    }

    private long hi(int[] sequence, long start) {
        long[] accum = new long[sequence.length];
        accum[0] = sequence[0] * start;
        long ans = accum[0];
        start *= -1;
        for(int i = 1; i < sequence.length; i++, start *= -1) {
            long seq = sequence[i] * start;
            if (accum[i-1] > 0) {
                seq += accum[i-1];
            }
            accum[i] = seq;
            if (ans < accum[i]) {
                ans = accum[i];
            }
        }
        return ans;
    }

}
