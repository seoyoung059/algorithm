import sys
input = sys.stdin.readline
class makeStack:
    def __init__(self):
        self.stk=[]
        self.length=0

    def push(self,value):
        self.stk.append(value)
        self.length+=1

    def pop(self):
        if self.length==0:
            return -1
        self.stk.pop()
        self.length-=1
        return 0



n=int(input())
for _ in range(n):
    s=makeStack()
    good=1
    m = str(input())
    for i in m:
        if i=='(':
            s.push(i)
        elif i==')':
            a=s.pop()
            if a==-1:
                good=0
                break
    if good==1 and s.length==0:
        print('YES')
    else:
        print('NO')
    