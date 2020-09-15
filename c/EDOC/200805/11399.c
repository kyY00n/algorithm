#include <stdio.h>
#include <stdlib.h>

int compare(const void* a, const void* b) {
	int num1 = *(int*)a;
	int num2 = *(int*)b;

	if (num1 < num2) return -1;
	if (num1 > num2) return 1;
	return 0;
}

int main() {
	int N;
	scanf_s("%d", &N);

	int* delay = (int*) malloc(sizeof(int) * N);
		
	for (int i = 0; i < N; i++) {
		scanf_s("%d", &delay[i]);
	}

	qsort(delay, N, sizeof(int), compare);

	int sum = 0;

	for (int i = 0; i < N; i++) {
		sum += delay[i] * (N - i);
	}
	printf("%d", sum);

	free(delay);
	return 0;
}