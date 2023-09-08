def solution(s):
    answer = [0, 0]
    while s!="1":
        tmp = s.count("1")
        answer[1]+=len(s)-tmp
        s=str(bin(tmp))[2:]
        answer[0]+=1
    return answer