//2447. �����-10
//Ǯ������ ���ش� �ȵȴ�^^....
//��� ������ ����� ���

#include <stdio.h>
#include <stdlib.h>

void blank(char* arr[], int N, int Ndiv3) {

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if ((i % (Ndiv3 * 3) / Ndiv3 == 1) && (j % (Ndiv3 * 3) / Ndiv3 == 1)) arr[i][j] = ' ';
			//blank(arr, 27, 9) �� ���: i%27 / 9 ==1 �̸鼭 j%27 / 9 == 1 �϶� ��ũ
		}
	}
	/*
	for(int i = 0; i < N; i++){
		printf("%s\n", arr[i]);
	}
	*/
	if (Ndiv3 == 1)
	{
		for (int i = 0; i < N; i++) {
			printf("%s\n", arr[i]);
		}
		return;
	}

	Ndiv3 /= 3;
	blank(arr, N, Ndiv3);
}

int main() {
	int N = 0;
	scanf_s("%d", &N);

	char** arr = (char**)malloc(sizeof(char*) * N + 1);
	
	for (int i = 0; i < N; i++) {
		arr[i] = (char*)malloc(sizeof(char) * N + 1);
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			arr[i][j] = '*';
		}
		arr[i][N] = '\0';
	}
	
	blank(arr, N, N);

	for (int i = 0; i < N; i++) {
		free(arr[i]);
	}
	free(arr);
	return 0;
}
