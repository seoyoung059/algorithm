from collections import deque

def solution(maps):
    answer = bfs(maps)
    return answer

def bfs(maps):
    my = len(maps)
    mx = len(maps[0])
    
    q = deque()
    q.append([0,0,0])
    
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    
    visited = [[0]*mx for _ in range(my)]
    visited[0][0] = 1
    cnt = 0
    
    while q:
        cx, cy, cnt = q.popleft()
        
        if cx==mx-1 and cy==my-1:
            return cnt+1
        
        for i in range(4):
            nx = cx + dy[i]
            ny = cy + dx[i]

            if 0<=nx<mx and 0<=ny<my:
                if maps[ny][nx]==1 and not visited[ny][nx]:
                    visited[ny][nx] = 1
                    q.append([nx, ny, cnt+1])
    return -1