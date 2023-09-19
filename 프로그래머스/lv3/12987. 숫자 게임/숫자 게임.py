def solution(A, B):
    answer = 0
    A.sort(reverse=True)
    B.sort(reverse=True)
    
    b_idx = 0
    n = len(B)
    for a in A:
        if b_idx == n:
            break
        if a < B[b_idx]:
            answer+=1
            b_idx+=1
    return answer