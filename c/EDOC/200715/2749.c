//2749. 피보나치 수 3 실패잼..
#include <stdio.h>
#include <math.h>

int fibonacci(int n, int* arr) {

	if (n == 0) return 0;
	else if (n == 1) return 1;

	if (arr[n] == 0) {
		arr[n] = (fibonacci(n - 2, arr) + fibonacci(n - 1, arr)) % 1000000;
	}
	return arr[n];
}

int main() {
	int n;
	scanf_s("%d", &n);
	int* fibArr = malloc(sizeof(int) * n);
	printf("%d",fibonacci(n, fibArr));
	free(fibArr);
	return 0;
}