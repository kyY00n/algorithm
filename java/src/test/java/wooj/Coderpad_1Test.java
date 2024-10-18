package wooj;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Coderpad_1Test {

    private Coderpad_1 solution = new Coderpad_1();

    @Test
    void compress_test() {
        //given
        String param = "aaabbbbbccccdaa";

        //when
//        String actual = solution.solve(param);
        String actual = solution.solve_improved(param);

        //then
        Assertions.assertThat(actual).isEqualTo("a3b5c4d1a2");
    }

}
