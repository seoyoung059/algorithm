def solution(n):
    answer = 0
    if n==1: return 1
    for i in range(1,n):
        tmp = i*(i-1)//2
        if tmp >= n:
            break
        if (n-tmp)%i == 0:
            answer+=1
    return answer