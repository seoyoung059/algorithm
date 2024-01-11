n = int(input())
arr = [[0]*100 for _ in range(100)]
cnt = 0
for paper in range(n):
  x,y = map(int, input().split())
  for i in range(10):
    for j in range(10):
      if arr[x+i][y+j]==0:
        arr[x+i][y+j]=1
        cnt+=1
print(cnt)