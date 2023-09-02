N = int(input())
k = int(input())



def lower_count(num, N):
    cnt = 0
    for row in range(1, N+1):
        cnt += min(N, (num-1)//row)
    return cnt

def solution(N, k):
    start = 1
    end = N ** 2
    while start <= end:
        mid = (start+end)//2
        if lower_count(mid,N) < k:
            start = mid+1
        else:
            end = mid-1
    print(end) 

solution(N, k)