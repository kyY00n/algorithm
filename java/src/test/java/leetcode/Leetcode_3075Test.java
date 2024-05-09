package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Leetcode_3075Test {

    @Test
    void test1() {
        //given
        Leetcode_3075 solution = new Leetcode_3075();

        //when
        long actual = solution.maximumHappinessSum(new int[]{1, 2, 3}, 2);

        //then
        assertThat(actual).isEqualTo(4);
    }

}
