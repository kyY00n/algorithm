#include <stdio.h>
#include <math.h>

double logB(double x, double base) {
	return log(x) / log(base);
}

int main() {
	int n;
	scanf_s("%d", &n);

	int count = (int)logB(n, 2);

	for (int i = 0; i < count; i++) {

	}

	return 0;
}