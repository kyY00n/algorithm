package leetcode;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class FindMissingPositiveTest {

    @ParameterizedTest
    @MethodSource("testcases")
    void findTwo(int[] nums, int expected) {
        //given
        FindMissingPositive solution = new FindMissingPositive();

        //when
        int actual = solution.firstMissingPositive(nums);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> testcases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 0}, 3),
                Arguments.of(new int[]{3, 4, -1, 1}, 2),
                Arguments.of(new int[]{7, 8, 9, 11, 12}, 1)
        );
    }

}
