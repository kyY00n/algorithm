package study;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SortingTest {

    @Test
    void bubble_sort() {
        //given
        int[] array = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        //when
        int[] sorted = Sorting.bubblesort(array);

        //then
        assertThat(sorted).containsExactly(0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283);
    }

    @Test
    void selection_sort() {
        //given
        int[] array = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        //when
        int[] sorted = Sorting.selectionsort(array);

        //then
        assertThat(sorted).containsExactly(0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283);
    }

    @Test
    void insertion_sort() {
        //given
        int[] array = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        //when
        int[] sorted = Sorting.insertionsort(array);
        //then
        assertThat(sorted).containsExactly(0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283);
    }

    @Test
    void merge_sort() {
        //given
        int[] array = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        //when
        int[] sorted = Sorting.mergesort(array);
        //then
        assertThat(sorted).containsExactly(0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283);
    }

    @Test
    void merge_sort_edge_case() {
        //given
        int[] array = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        //when
        int[] sorted = Sorting.mergesort(array);
        //then
        assertThat(sorted).containsExactly(
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                1, 2, 4, 5, 6, 44, 63, 87, 99, 283
        );
    }

    // test for quicksort
    @Test
    void quick_sort() {
        //given
        int[] array = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        //when
        int[] sorted = Sorting.quicksort(array);

        System.out.println(Arrays.toString(sorted));

        //then
        assertThat(sorted).containsExactly(0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283);
    }

    // test for already sorted array
    @Test
    void quick_sort_already_sorted() {
        //given
        int[] array = {0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283};

        //when
        int[] sorted = Sorting.quicksort(array);
        //then
        assertThat(sorted).containsExactly(0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283);
    }

    @Test
    void quick_select_kth_element() {
        //given
        int[] array = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        //when
        int selected = Sorting.quickSelect(array, 5);

        //then
        assertThat(selected).isEqualTo(5);
    }

}
