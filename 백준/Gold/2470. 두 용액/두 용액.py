import sys
input = sys.stdin.readline

n = int(input())
liq = list(map(int,input().split()))
liq.sort()
ans1,ans2=0,0

min_sum=10**10


def search(find,s,e,li):
  res=n
  while s <= e:
    mid = (s+e)//2
    if li[mid]>=find:
      res=mid
      e=mid-1
    else:
      s=mid+1
  return res

for i in range(n):
  find=(-1)*liq[i]
  res = search(find,i+1,n-1,liq)

  if i < res-1 < n and abs(liq[i]+liq[res-1]) < min_sum:
    min_sum = abs(liq[i]+liq[res-1])
    ans1,ans2 = i,res-1
  
  if i < res < n and abs(liq[i]+liq[res])<min_sum:
    min_sum = abs(liq[i]+liq[res])
    ans1,ans2 = i,res

print(liq[ans1],liq[ans2])