def solution(n):
    answer = 0
    dp = [0] * (n+1)
    dp = fibonacci(dp)
    answer = dp[-1]
    return answer

def fibonacci(dp):
    dp[1] = 1
    for i in range(2, len(dp)):
        dp[i] = (dp[i-2]+dp[i-1])%1234567
    return dp