n,m = map(int, input().split())
maze = [input() for _ in range(n)]

from collections import deque
def bfs():
    q = deque()
    q.append((0,0,0,1))

    dx = [0,0,1,-1]
    dy = [1,-1,0,0]

    visited = [[0]*m for _ in range(n)]
    visited_wall = [[0]*m for _ in range(n)]
    visited[0][0]=1
    

    while q:
        curr_y, curr_x, wall, cnt = q.popleft()
        if curr_y == n-1 and curr_x==m-1:
            return cnt
            
        for i in range(4):
            new_y = curr_y + dy[i]
            new_x = curr_x + dx[i]

            if new_x<0 or new_x >=m or new_y<0 or new_y >= n:
                continue
            
            if wall==0:
                if visited[new_y][new_x]==0:
                    if maze[new_y][new_x]=='0':
                        visited[new_y][new_x]=1
                        q.append((new_y, new_x, wall, cnt+1))
                    else:
                        visited_wall[new_y][new_x]=1
                        q.append((new_y, new_x, wall+1, cnt+1))


            else:
                if visited_wall[new_y][new_x]==0:
                    if maze[new_y][new_x]=='0':
                        visited_wall[new_y][new_x]=1
                        q.append((new_y, new_x, wall, cnt+1))
                    else:
                        continue

    return -1

print(bfs())