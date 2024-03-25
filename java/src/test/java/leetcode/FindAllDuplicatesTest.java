package leetcode;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class FindAllDuplicatesTest {
    @Test
    void test1() {
        //given
        FindAllDuplicates solution = new FindAllDuplicates();

        //when
        List<Integer> duplicates = solution.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});

        //then
        assertThat(duplicates).contains(2,3);
    }

    @Test
    void test2() {
        //given
        FindAllDuplicates solution = new FindAllDuplicates();

        //when
        List<Integer> duplicates = solution.findDuplicates(new int[]{1,1,2});

        //then
        assertThat(duplicates).contains(1);
    }
}
