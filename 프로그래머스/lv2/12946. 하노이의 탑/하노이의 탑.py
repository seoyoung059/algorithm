def solution(n):
    answer = []
    hanoii(1,2,3,n,answer)
    return answer


def hanoii(s,m,e, n,answer):
    if n==1:
        answer.append([s,e])
    else:
        hanoii(s,e,m,n-1,answer)
        hanoii(s,m,e,1,answer)
        hanoii(m,s,e, n-1,answer)