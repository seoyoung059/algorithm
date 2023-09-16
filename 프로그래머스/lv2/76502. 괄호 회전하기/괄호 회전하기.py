from collections import deque
def solution(s):
    answer = 0
    stack = deque()
    pair = {'[':']', '{':'}', '(':')'}
    correctStr = False
    for idx in range(len(s)):
        if correctStr:
            break
        correctStr = True
        answer = 0
        # print('new')
        for i in range(len(s)):
            # print(i)
            tmp = (idx+i)%len(s)
            # print(tmp, s[tmp])
            if s[tmp] in  ['[', '{', '(']:
                stack.append(s[tmp])
            elif stack and pair[stack[-1]]==s[tmp]:
                stack.pop()
                if len(stack)==0:
                    answer+=1
            else:
                answer = 0
                correctStr = False
                break
                
    return answer