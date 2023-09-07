import math

def solution(n, times):
    answer = 0
    times.sort()
    start = 0
    end = n*times[0]
    # print(end)
    while start <= end:
        mid = (start+end)//2
        tmp_arr = [mid//t for t in times]
        sum_arr = sum(tmp_arr)
        if sum_arr >= n:
            end = mid-1
        else:
            start = mid+1
        print(start, mid, end)
    answer = start
    
    return answer