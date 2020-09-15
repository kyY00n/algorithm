#include <stdio.h>
#define MAX 1001

int metrix[MAX][MAX];
int visited[MAX * MAX];

void DFS(int v, int N) {
	// ���� ���
	printf("%d ", v);

	// �湮 ǥ��
	visited[v] = 1;

	// ���� ���� üũ
	for (int d = 1; d <= N; d++) {
		// �湮���� �ʾҰ� �̵� �����ϴٸ�
		if (!visited[d] && metrix[v][d]) {
			DFS(d, N);
		}
	}
}

void BFS(int v, int N) {
	// ť�� ���õ� ���� ����
	int front = -1, rear = -1;
	int queue[MAX * MAX] = { 0 };

	// ù��° �߰�
	rear++;
	queue[rear] = v;

	// �湮 ǥ��
	visited[v] = 1;

	// �ϴ� ���
	printf("%d ", v);

	// �ʺ� �켱 Ž��
	while (front < rear) {
		// ť���� ������
		front++;
		int nextV = queue[front];

		// ���� ���� üũ
		for (int d = 1; d <= N; d++) {
			// �湮���� �ʾҰ�, �̵��� �����ϴٸ�
			if (!visited[d] && metrix[nextV][d]) {
				rear++;
				visited[d] = 1;
				queue[rear] = d;

				printf("%d ", d);
			}
		}
	}
}

void init(int N) {
	printf("\n");
	for (int i = 1; i <= N; i++) {
		visited[i] = 0;
	}
}

int main(void) {
	int N = 0;
	int M = 0;
	int V = 0;

	scanf("%d %d %d", &N, &M, &V);

	for (int i = 0; i < M; i++) {
		int s = 0;
		int d = 0;

		scanf("%d %d", &s, &d);

		metrix[s][d] = 1;
		metrix[d][s] = 1;
	}

	DFS(V, N);

	init(N);

	BFS(V, N);

	return 0;
}