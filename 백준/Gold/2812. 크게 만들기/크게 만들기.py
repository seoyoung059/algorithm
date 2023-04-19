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

n, k = map(int, input().split())
m = str(input())
s=makeStack()



idx=0
for i in range(len(m)):
    if s.length<1:
        s.push(m[i])
    else:
        while k>0 and s.length>0:
            in_num = int(s.peek())
            # print(in_num, int(m[i]))
            if in_num < int(m[i]):
                s.pop()
                k-=1
            else:
                break
        s.push(m[i])
for j in range(k):
    s.pop()

print(int(''.join(s.stk)))