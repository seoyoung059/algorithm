# 정수 삼각형

n = int(input())

arr=[list(map(int, input().split())) for i in range(n)]

for i in range(1,n):
    for j in range(i+1):
        tmp = 0
        if j > 0:
            tmp = arr[i-1][j-1]
        if j < i:
            tmp = max(tmp, arr[i-1][j])
        arr[i][j]+=tmp

print(max(arr[-1]))

