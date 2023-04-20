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
        val = self.stk.pop()
        self.length-=1
        return val
    
n=int(input())
s=makeStack()
for _ in range(n):
    l= int(input())
    s.push(l)

length=0
cnt=0
while s.length>0:
    stick = s.pop()
    if stick > length:
        cnt+=1
        length=stick

print(cnt)