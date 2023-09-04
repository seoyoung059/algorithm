from collections import deque
import sys

input = sys.stdin.readline

def bfs():
    answer = -1
    q = deque()
    q.append([x1-1,y1-1])

    dx = [0,0,1,-1]
    dy = [1,-1,0,0]

    visited = [[float('inf')]*m for _ in range(n)]
    visited[x1-1][y1-1] = 0
    
    # print(maze)
    # print(visited)

    while q:
        # print(visited)
        # for i in range(n):
        #     print(visited[i])
        c_x, c_y = q.popleft()

        if c_x==x2-1 and c_y==y2-1:
            answer = visited[c_x][c_y]
            break
        for i in range(4):
            for j in range(1, k+1):
                n_x = c_x+dx[i]*j
                n_y = c_y+dy[i]*j
                
                # print(c_x, c_y, n_x, n_y)
                if 0 <= n_x < n and 0 <= n_y < m:
                    if visited[n_x][n_y]>visited[c_x][c_y]:
                        if maze[n_x][n_y]=='.':
                            if visited[n_x][n_y]==float('inf'):   
                                visited[n_x][n_y] = visited[c_x][c_y]+1
                                q.append([n_x, n_y])
                        else:
                            break
                    else:
                        break
                else:
                    break
    print(answer)

n,m,k = map(int, input().split())
maze=[input().rstrip() for _ in range(n)]
x1, y1, x2, y2 = map(int, input().split())

bfs()