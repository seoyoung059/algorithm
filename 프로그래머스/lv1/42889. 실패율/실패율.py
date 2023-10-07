def solution(N, stages):
    answer = []
    users = len(stages)
    
    dict={}
    n=users
    
    for i in range(1,N+1):
        m=stages.count(i)
        if n == 0:
            dict[i]=0
        else: 
            dict[i]=m/n
        n-=m
    
    sorted_dict=sorted(dict.items(), reverse=True, key=lambda item:item[1])
    print(sorted_dict)
    answer=[i[0] for i in sorted_dict]
    
            
    return answer