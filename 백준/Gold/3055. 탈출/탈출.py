import sys
from collections import deque


def kaktus(water_q, graph):
    while water_q:
        wy,wx,w = water_q.popleft()
        for i in range(4):
            n_wy=wy+dy[i]
            n_wx=wx+dx[i]
            if 0<=n_wy<r and 0<=n_wx<c:
                if w=='*':
                    if graph[n_wy][n_wx]!='D' and graph[n_wy][n_wx]!='*' and graph[n_wy][n_wx]!='X':
                       graph[n_wy][n_wx]=graph[wy][wx]
                       water_q.append((n_wy,n_wx,'*'))
                else:
                    if graph[wy][wx]=='*':
                        continue
                    if graph[n_wy][n_wx]=='.':
                        graph[n_wy][n_wx]=w+1
                        water_q.append((n_wy,n_wx,w+1))
                    elif graph[n_wy][n_wx]=='D':
                        print(graph[wy][wx]+1)
                        return
                    
        # for _ in graph:
        #     print(_)
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
        elif row[j]=='D':
            d = [i,j]
        elif row[j]=='S':
            s = [i,j,0]

dy=[0,0,1,-1]
dx=[1,-1,0,0]
graph[s[0]][s[1]]=0
water_q=deque([s]+water)

kaktus(water_q,graph)