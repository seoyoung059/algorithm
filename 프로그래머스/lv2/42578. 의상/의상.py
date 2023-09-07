def solution(clothes):
    answer = 1
    closet = {}
    for c in clothes:
        if c[1] in closet.keys():
            closet[c[1]] +=1
        else:
            closet[c[1]] =1
    
    for item in closet.items():
        answer = (item[1]+1) * answer
    
    answer-=1
    return answer