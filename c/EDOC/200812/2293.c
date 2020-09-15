#include <stdio.h>

//�𸣰ھ ���۸��� �ڵ�
int main() {

    int i, j, n, k;
    int dp[10001] = { 0 }; //memoization

    scanf("%d%d", &n, &k);

    int coins[n]; //���� ��ġ�� ������ �迭.

    for (i = 0; i < n; i++) scanf("%d", &coins[i]);

    dp[0] = 1; //k=0 �̸� ����� 1�����̹Ƿ�.

    for (i = 0; i < n; i++) { //���� �������� �ݺ�
        for (j = coins[i]; j <= k; j++) {
            if (j - coins[i] >= 0) dp[j] += dp[j - coins[i]]; // �������� ����� ���� �����մϴ�. ���ذ� �ȵʿ�
    }
    printf("%d\n", dp[k]);
    return 0;

}
