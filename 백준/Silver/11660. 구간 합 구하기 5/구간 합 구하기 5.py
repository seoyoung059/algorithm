import sys
input = sys.stdin.readline

n,m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
arr2 = [[0]*(n+1) for _ in range(n+1)]
for i in range(1,n+1):
    for j in range(1,n+1):
        if j==0 and i==0:
            arr2[i][j]=arr[i-1][j-1]
        elif j==0:
            arr2[i][j] = arr2[i-1][j]+arr[i-1][j-1]
        elif i==0:
            arr2[i][j] = arr2[i][j-1]+arr[i-1][j-1]
        else:
            arr2[i][j] = arr2[i-1][j]+arr2[i][j-1]-arr2[i-1][j-1]+arr[i-1][j-1]
            
            
for i in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    print(arr2[x2][y2] - arr2[x2][y1-1] - arr2[x1-1][y2] + arr2[x1-1][y1-1])