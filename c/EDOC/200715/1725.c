//1725. 히스토그램

#include <stdio.h>

int main() {

	int N;
	scanf_s("%d", &N);
	int row[100000] = { 0 };

	int maxHeight = 0;

	for (int i = 0; i < N; i++) {
		scanf_s("%d", &row[i]);
		if (row[i] > maxHeight) maxHeight = row[i];
	}

	int maxArea = 0;
	int maxCount, testCount, testArea;

	for(int height = 1; height <= maxHeight; height++) {
		maxCount = 0, testCount = 0;

		for (int i = 0; i < N; i++) { //row array test
			if (row[i] >= height) {
				testCount++;
				if (maxCount < testCount) maxCount = testCount;
			}
			else testCount = 0;
		}

		testArea = maxCount * height;

		if (maxArea < testArea) maxArea = testArea;
	}

	printf("%d", maxArea);
		
	return 0;
}