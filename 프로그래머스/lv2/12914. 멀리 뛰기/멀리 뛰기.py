def solution(n):
    answer = 0
    dp = [1]*(n+1)
    
    for i in range(2, len(dp)):
        dp[i] = (dp[i-1]+dp[i-2])%1234567
    answer = dp[-1]
    return answer