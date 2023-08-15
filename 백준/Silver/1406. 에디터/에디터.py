from collections import deque

left = deque(input())
right = deque([])

n = int(input())

for i in range(n):
    c = list(input().split())
    if c[0]=='L' and len(left) > 0:
        right.append(left.pop())
    elif c[0]=='D' and len(right) > 0:
        left.append(right.pop())
    elif c[0]=='B' and len(left)>0:
        left.pop()
    elif c[0]=='P':
        left.append(c[1])


while len(right)>0:
    left.append(right.pop())
    
print(''.join(left))