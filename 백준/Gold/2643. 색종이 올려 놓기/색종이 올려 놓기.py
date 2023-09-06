n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
for a in arr:
    a.sort()
arr.sort()

dp = [[0]*(n+1) for _ in range(3)]

ans = 0
for i in range(n):
    nx, ny = arr[i]
    for j in range(i, -1, -1):
        if (nx >= dp[1][j] and ny >= dp[2][j]) or (nx >= dp[2][j] and ny >= dp[1][j]):
            if dp[0][i+1] < dp[0][j]+1:
                dp[0][i+1] = dp[0][j]+1
                dp[1][i+1] = nx
                dp[2][i+1] = ny
            ans = max(ans, dp[0][i+1])
print(ans)