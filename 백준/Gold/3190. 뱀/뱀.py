from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
k = int(input())

apple=[]
move=deque()
for _ in range(k):
    a = list(map(int,input().split()))
    apple.append(a)
l = int(input())
for _ in range(l):
    sec, turn = map(str,input().split())
    move.append([int(sec),turn])
    
sec = 0
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
current_head = [1,1]
current=deque([current_head])
d = 1
while True:
    # print(current)
    sec += 1

    # 몸 길이를 늘려 머리를 다음 칸에 위치시킴
    current_head = [current_head[0]+dy[d],current_head[1]+dx[d]]
    if current_head in current:
        print(sec)
        break
    current.append(current_head)

    #이동한 칸에 사과가 있다면, 칸의 사과가 사라지고 꼬리는 움직이지 않음
    eat_apple = False
    for a in range(len(apple)):
        if current_head == apple[a]:
           eat_apple = True
          #  apple[a]=[-1,-1]
           apple.pop(a)
           break
    
    if not eat_apple:
        current.popleft()

    
    if not (0<current_head[0]<=n) or not (0<current_head[1]<=n):
        print(sec)
        break
    
    if len(move)>0:
      if move[0][0]==sec:
          # print('turn', move[0][1])
          if move[0][1]=='L':
              d += 1
              if d >=4:
                  d = d%4
          else:
              d -= 1
              if d < 0:
                  d += 4
          move.popleft()