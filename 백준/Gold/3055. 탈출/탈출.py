import sys
from collections import deque

def kaktus(queue, graph):
    dy=[0,0,1,-1]
    dx=[1,-1,0,0]
    while queue:
        current_y,current_x,water = queue.popleft()
        for i in range(4):
            new_y=current_y+dy[i]
            new_x=current_x+dx[i]
            if 0<=new_y<r and 0<=new_x<c:
                if water=='*':
                    if graph[new_y][new_x]!='D' and graph[new_y][new_x]!='*' and graph[new_y][new_x]!='X':
                       graph[new_y][new_x]=graph[current_y][current_x]
                       queue.append((new_y,new_x,'*'))
                else:
                    if graph[current_y][current_x]=='*':
                        continue
                    if graph[new_y][new_x]=='.':
                        graph[new_y][new_x]=water+1
                        queue.append((new_y,new_x,water+1))
                    elif graph[new_y][new_x]=='D':
                        print(graph[current_y][current_x]+1)
                        return
                    

    print('KAKTUS')


r,c = map(int, sys.stdin.readline().split())
graph=[]
water=[]
for i in range(r):
    row=list(sys.stdin.readline().rstrip())
    graph.append(row)
    for j in range(len(row)):
        if row[j]=='*':
            water.append((i,j,'*'))
        elif row[j]=='S':
            s = [i,j,0]
            graph[i][j]=0


queue=deque([s]+water)
kaktus(queue,graph)