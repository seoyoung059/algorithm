def solution(k, tangerine):
    answer = 0
    gyul = {}
    for t in tangerine:
        if t in gyul.keys():
            gyul[t]+=1
        else:
            gyul[t]=1
    
    gyuls = sorted(gyul.items(), key = lambda x: x[1])
    
    idx = len(gyuls)-1
    while k > 0:
        k -= gyuls[idx][1]
        answer+=1
        idx-=1
        
    return answer