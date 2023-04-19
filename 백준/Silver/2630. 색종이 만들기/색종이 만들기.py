import sys
input = sys.stdin.readline

#전체 종이의 한 변의 길이
n = int(input())
whole = []
for _ in range(n):
  whole.append(list(map(int,input().split())))

def sol(paper,r,c,n):
  if n==1:
    if paper[r][c]==1:
      return [0,1]
    else:
      return [1,0]
  
  else:
    next_n=n//2
    [w0,b0]=sol(paper,r,c,next_n)
    [w1,b1]=sol(paper,r,c+next_n,next_n)
    [w2,b2]=sol(paper,r+next_n,c,next_n)
    [w3,b3]=sol(paper,r+next_n,c+next_n,next_n)
    color_sum=[w0+w1+w2+w3,b0+b1+b2+b3]
    if color_sum==[4,0]:
      return [1,0]
    elif color_sum==[0,4]:
      return [0,1]
    else:
      return color_sum

ans=sol(whole,0,0,n)

for i in ans:
    print(i)
