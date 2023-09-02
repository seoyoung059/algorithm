n,m = map(int, input().split())
war = [input() for i in range(m)]

visit = [[False for i in range(n)] for j in range(m)]

def dfs(y,x):
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    color = war[y][x]
    visit[y][x]=True
    cnt=1
    for i in range(4):
        new_x = x+dx[i]
        new_y = y+dy[i]
        if 0<=new_x<n and 0<=new_y<m:
            if color==war[new_y][new_x] and visit[new_y][new_x]==False:
                cnt+=dfs(new_y, new_x)[1]
    return [color,cnt]

power=[0,0]
for i in range(m):
    for j in range(n):
        if visit[i][j]==False:
            color, num = dfs(i,j)
            if color=='W':
                power[0]+=num**2
            else:
                power[1]+=num**2
print(power[0],end=" ")
print(power[1])

        
