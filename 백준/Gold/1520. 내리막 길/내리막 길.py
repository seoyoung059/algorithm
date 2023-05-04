import sys
input = sys.stdin.readline

def findway(cy,cx):
    if cy == m-1 and cx==n-1:
        return 1
    if arr[cy][cx]!=-1:
        return arr[cy][cx]
    else:
        arr[cy][cx]=0
        for i in range(4):
            ny = cy+dy[i]
            nx = cx+dx[i]
            if 0<=ny<m and 0<=nx<n:
                if trip[ny][nx] < trip[cy][cx]:
                    if arr[ny][nx]!=-1:
                        arr[cy][cx]+=arr[ny][nx]
                    else:
                        arr[cy][cx]+=findway(ny,nx)
        return arr[cy][cx]


m,n = map(int,input().split())
trip = [list(map(int,input().split())) for _ in range(m)]
arr = [[-1] * n for _ in range(m)]
dy = [0,0,1,-1]
dx = [1,-1,0,0]

ans = findway(0,0)
print(ans)