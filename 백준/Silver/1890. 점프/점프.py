import sys
input=sys.stdin.readline

def findway(cy,cx):

    if board[cy][cx]==0:
       return 0
    if arr[cy][cx]!=0:
       return arr[cy][cx]
    if arr[cy][cx]==0:
       for i in range(2):
           ny = cy+dy[i]*board[cy][cx]
           nx = cx+dx[i]*board[cy][cx]
           if 0<=ny<n and 0<=nx<n:
               if ny==n-1 and nx==n-1:
                   arr[cy][cx]=1
               elif arr[ny][nx]!=0:
                   arr[cy][cx]+=arr[ny][nx]
               else:
                   arr[cy][cx]+=findway(ny,nx)
       return arr[cy][cx]

n=int(input())
board = [list(map(int,input().split())) for _ in range(n)]


dy = [1,0]
dx = [0,1]
arr = [[0] * n for _ in range(n)]
findway(0,0)
print(arr[0][0])