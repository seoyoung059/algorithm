import sys
input = sys.stdin.readline

n,c = map(int, input().split())
h=[]
for i in range(n):
  h.append(int(input()))

h.sort()


e = h[-1]-h[0]
s=1
ans = 0
while s<=e:
  mid = (s+e)//2
  count=1
  current=h[0]
  val=float("INF")
  for i in range(1,n):
    if current+mid<=h[i]:
      val = min(val,h[i]-current)
      count+=1
      current=h[i]
  if count < c:
    e = mid-1
  else:
    s = mid+1
    ans = max(ans,val) 

print(ans)