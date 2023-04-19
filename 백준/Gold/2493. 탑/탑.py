# import sys
# input = sys.stdin.readline

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
    
    def peek(self):
        if self.length==0:
            return -1
        return self.stk[-1]
    
n=int(input())
towers = list(map(int,input().split()))
ans=[]
s=makeStack()       

for i in range(len(towers)):
    while s.length>0:
        if s.peek()[1] < towers[i]:
            s.pop()
        else:
            break
    
    if s.length==0:
        ans.append(0)
    else:
        ans.append(s.peek()[0])

    s.push([i+1,towers[i]])

for num in ans:
    print(num, end=" ")