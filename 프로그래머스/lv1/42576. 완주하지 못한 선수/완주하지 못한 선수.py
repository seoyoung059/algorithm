def solution(participant, completion):
    answer = ''
    c_dict=dict()
    for c in completion:
        if c in c_dict.keys():
            c_dict[c]+=1
        else:
            c_dict[c] = 1

    for p in participant:
        if p in c_dict.keys():
            if c_dict[p]==1:
                del(c_dict[p])
            else:
                c_dict[p]-=1
        else:
            answer=p    
    return answer