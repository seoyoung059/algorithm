import sys
input = sys.stdin.readline

t=int(input())

for _ in range(t):
  n=int(input())
  coin = [0]+list(map(int,input().split()))
  m=int(input())

  ans=[[0]*(m+1)]*(n+1)
  for c in range(1,n+1):
      for i in range(coin[c],m+1):
          if i==coin[c]:
              ans[c][i]=ans[c-1][i]+1
          else:
            ans[c][i] = ans[c-1][i]+ans[c][i-coin[c]]
  print(ans[-1][-1])