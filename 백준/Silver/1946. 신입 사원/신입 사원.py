import sys
input = sys.stdin.readline

t=int(input())
for i in range(t):
  n=int(input())
  apply=[]
  for _ in range(n):
      apply.append(list(map(int, input().split())))
  apply.sort()
  minval=n+1
  cnt=0
  for a, b in apply:
      if b<minval:
        minval=b
        cnt+=1
  print(cnt)