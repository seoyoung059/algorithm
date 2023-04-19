import sys  
sys.setrecursionlimit(10**8) # 10^8 까지 늘림.

n=int(input())
ground=[]
for i in range(n):
    ground.append(list(map(int,input().split())))

dy=[0,0,1,-1]
dx=[1,-1,0,0]

def solution(n,h,ground):
    count=0
    checked = [[0]*n for _ in range(n)]
    for y in range(n):
        for x in range(n):
            if ground[y][x] > h and checked[y][x]==0:
                checked[y][x]=1
                checked=find_ground(y,x,checked,h,n)
                count+=1
    return count


def find_ground(y,x,checked,h,n):
    for i in range(4):
        new_y=y+dy[i]
        new_x=x+dx[i]
        if new_y >= 0 and new_x>=0 and new_y<n and new_x<n:
            if ground[new_y][new_x] > h and checked[new_y][new_x]==0:
                checked[new_y][new_x]=1
                checked = find_ground(new_y,new_x,checked,h,n)            
    return checked


    
max = 1
for h in range(100):
    val = solution(n,h,ground)
    if max < val:
        max = val

print(max)
