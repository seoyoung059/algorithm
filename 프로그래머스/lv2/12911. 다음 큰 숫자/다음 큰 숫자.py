def solution(n):
    answer = 0
    binary_n = str(bin(n))[2:]
    cnt_n = binary_n.count('1')
    # print(binary_n, binary_n.count('1'))
    
    for i in range(n+1, 1000000):
        tmp_i = str(bin(i))[2:]
        if cnt_n == tmp_i.count('1'):
            answer = i
            break
    
        
    return answer