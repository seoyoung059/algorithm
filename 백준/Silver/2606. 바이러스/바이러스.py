n = int(input())
con_num = int(input())

connections=[[] for i in range(n+1)]
for i in range(con_num):
    a,b=map(int,input().split())
    connections[a].append(b)
    connections[b].append(a)
    
    

def dfs(start,visit):
    if visit[start]:
        return 0
    visit[start]=True
    cnt=1
    for com in connections[start]:
        cnt+=dfs(com, visit)
    return cnt

cnt=0
visit = [False for i in range(n+1)]
print(dfs(1,visit)-1)
