def solution(want, number, discount):
    answer = 1
    toBuy={want[i]:number[i] for i in range(len(want))}
    
    # 첫째날
    for i in range(10):
        if discount[i] in toBuy.keys():
            toBuy[discount[i]]-=1
    
    tmp = toBuy.values()
    for t in tmp:
        if t >0:
            answer = 0
            break
        
    # 둘째날부터
    for i in range(1,len(discount)):
        if discount[i-1] in toBuy.keys():
            toBuy[discount[i-1]]+=1
        if i+9 < len(discount):
            if discount[i+9] in toBuy.keys():
                toBuy[discount[i+9]]-=1
            
        found=True
        tmp = toBuy.values()
        for t in tmp:
            if t >0:
                found=False
                break
        if found:
            answer+=1
        

        
        
    return answer