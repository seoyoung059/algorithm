import sys

class MakeQueue:
    def __init__(self):
        self.que=[None]*2000000
        self.f = 0
        self.r = 0
        self.length=0

    def push(self, value):
        self.que[self.r]=value
        self.r+=1
        self.length += 1

    def pop(self):
        if self.length <1:
            print(-1)
        else:
          a = self.que[self.f]
          self.f += 1
          self.length -=1
          print(a)

    def size(self):
        print(self.length)
    
    def empty(self):
        if self.length < 1:
            print(1)
        else:
            print(0)

    def front(self):
        if self.length < 1:
            print(-1)
        else:
            print(self.que[self.f])

    def back(self):
        if self.length < 1:
            print(-1)
        else:
            print(self.que[self.r-1])

                
                
n = int(sys.stdin.readline())
q = MakeQueue()
for _ in range(n):
    c = list(map(str,sys.stdin.readline().rstrip().split()))
    if c[0] =='push':
        q.push(int(c[1]))
    elif c[0] == 'pop':
        q.pop()
    elif c[0]=='size':
        q.size()
    elif c[0] == 'empty':
        q.empty()
    elif c[0] == 'front':
        q.front()
    elif c[0]=='back':
        q.back()