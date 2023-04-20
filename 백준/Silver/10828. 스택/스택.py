import sys
input = sys.stdin.readline



class fixedStack:
    def __init__(self):
        self.stk=[]
        self.length=0

    def push(self,value):
        self.stk.append(value)
        self.length+=1
    
    def pop(self):
        if self.length==0:
            print(-1)
        else:
            print(self.stk.pop())
            self.length-=1

    def size(self):
        print(self.length)

    def empty(self):
        if self.length>0:
            print(0)
        else:
            print(1)

    def top(self):
        if self.length<=0:
            print(-1)
        else:
            print(self.stk[-1])
            
            
n=int(input())
stack = fixedStack()

for _ in range(n):
    command=list(map(str,input().split()))

    if command[0] == 'push':
        stack.push(int(command[1]))
    elif command[0] == 'pop':
        stack.pop()
    elif command[0]=='size':
        stack.size()
    elif command[0]=='empty':
        stack.empty()
    elif command[0]=='top':
        stack.top()