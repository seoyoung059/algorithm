from collections import deque

def bfs(s):
    q = deque()
    q.append([1, 0, 0])

    visit = [[0 for _ in range(1001)] for k in range(1001)]
    visit[1][0] = 1

    while q:
        num, clip_num, cnt = q.popleft()
        if num == s:
            return cnt
        if clip_num != num and visit[num][num]==0:
            visit[num][num]=1
            q.append([num, num, cnt+1])
        if clip_num > 0 and num+clip_num<1001 and visit[num+clip_num][clip_num]==0:
            visit[num+clip_num][clip_num]=1
            q.append([num+clip_num, clip_num, cnt+1])
        if num > 0 and visit[num-1][clip_num]==0:
            visit[num-1][clip_num]=1
            q.append([num-1, clip_num, cnt+1])
    
    


s = int(input())
print(bfs(s))