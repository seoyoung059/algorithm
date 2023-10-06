from collections import deque

def correct(w):
    cnt = 0
    for i in range(len(w)):
        if w[i]=='(':
            cnt+=1
        else:
            cnt-=1
        if cnt < 0:
            return False
    return True

def shortest_balanced(w):
    open_cnt = 0
    close_cnt = 0
    for i in range(len(w)):
        if w[i]=='(':
            open_cnt+=1
        else:
            close_cnt+=1
        if open_cnt==close_cnt:
            break
    return [w[:i+1], w[i+1:]]

def reverse(u):
    answer = ''
    for k in u[1:-1]:
        if k=='(':
            answer+=')'
        else:
            answer+='('
    return answer

def sol(w):
    if w=='':
        return ''
    u, v = shortest_balanced(w)
    if correct(u):
        v = sol(v)
        return u+v
    else:
        tmp = '('
        tmp += sol(v)+')'+reverse(u)
        return tmp

def solution(p):
    answer = ''
    answer = sol(p)
    return answer

