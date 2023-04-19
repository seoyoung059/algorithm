import sys
input = sys.stdin.readline

class makeStack:
    def __init__(self):
        self.stk=[]

    def push(self,value):
        self.stk.append(value)

    def pop(self):
        self.stk.pop()

s=makeStack()
n=int(input())
for _ in range(n):
    m = int(input())
    if m==0:
        s.pop()
    else:
        s.push(m)
print(sum(s.stk))