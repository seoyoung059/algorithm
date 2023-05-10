import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
  n=int(input())
  arr = list(map(int,input().split()))
  max=arr[-1]
  profit=0
  for i in range(n-2,-1,-1):
      if max > arr[i]:
          profit+=max-arr[i]
      else:
          max = arr[i]

  print(profit)