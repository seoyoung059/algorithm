n,k = map(int, input().split())
coin=[int(input()) for _ in range(n)]

dp = [0]*(k+1)
dp[0]=1
for j in coin:
    for i in range(1,k+1):  
        if i - j >=0:
            dp[i]+=dp[i-j]
            
print(dp[-1])