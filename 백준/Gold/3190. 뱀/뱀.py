from collections import deque

n = int(input())
k = int(input())

apples = [[0]*n for _ in range(n)]
for i in range(k):
    a, b = map(int, input().split())
    apples[a-1][b-1] = 1
    
l = int(input())
turns = []
for i in range(l):
    t, dir = input().split()
    turns.append([int(t), dir])
    
collision = False
# 0 - 오른쪽, 1 - 아래쪽, 2 - 왼쪽, 3 - 아래쪽
dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]

start_head =[0,0]
curr_dir = 0

snake = deque()
snake.append(start_head)
cnt = 0
idx = 0

while not collision:
    curr_head = snake[-1]
    
    #방향 전환
    if idx < l:
        if cnt  == turns[idx][0]:
            if turns[idx][1] == 'D':
                curr_dir = (curr_dir+1)%4
            elif turns[idx][1] == 'L':
                curr_dir = (curr_dir-1)%4
            idx += 1
    # 머리 다음칸 이동
    next_head = [curr_head[0]+dy[curr_dir], curr_head[1]+dx[curr_dir]]
    # 벽/몸일시 게임 끝
    if not (0<= next_head[0]<n and 0<=next_head[1]<n) or next_head in snake:
        break
    # 사과 있으면 꼬리 안 움직임
    if apples[next_head[0]][next_head[1]]==0:
        snake.popleft()
    else:
        apples[next_head[0]][next_head[1]]=0

    snake.append(next_head)
    cnt+=1
print(cnt+1)
