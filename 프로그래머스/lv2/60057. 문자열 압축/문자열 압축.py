def solution(s):
    answer = 0
    l = len(s)
    answer = len(s)
    for i in range(1,l):
        tmp = len(s)
        no = 1
        for j in range(i, l, i):
            # print(s[j-i:j],s[j:j+i])
            if s[j-i:j]==s[j:j+i]:
                tmp-=i
                no +=1
            else:
                # print(no)
                if no>1:
                    tmp+=len(str(no))
                no = 1
        # print(no)
        if no>1:
            tmp+=len(str(no))
        # print('tmp', tmp)
        # print(tmp)
        answer = min(tmp, answer)
    return answer