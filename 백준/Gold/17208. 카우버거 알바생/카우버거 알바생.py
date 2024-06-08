import sys
input = sys.stdin.readline

n, m, k = map(int, input().rstrip().split())

curr = [[0]*(k+1) for _ in range(m+1)]

for _ in range(n):
    x, y = map(int, input().rstrip().split())
    for i in range(m, x-1, -1):
        for j in range(k, y-1, -1):
            curr[i][j] = max(curr[i][j], curr[i-x][j-y]+1)

print(curr[m][k])