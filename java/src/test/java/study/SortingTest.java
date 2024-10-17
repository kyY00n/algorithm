package study;

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

}
