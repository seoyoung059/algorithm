import sys
input = sys.stdin.readline


pq=[None]*100000
size = 0


n = int(input())
for _ in range(n):
    x = int(input())

    if x == 0:
        if size==0:
            print(0)
        else:
            print(pq[1])
            ### priority queue의 pop 과정###
            pq[1] = pq[size]
            pq[size] = None
            size-=1
            current = 1
            while True:
                # 자식이 없을 때
                if size < current*2:
                    break
                # 왼쪽 자식만 있을 때
                elif current*2 <= size < current*2+1:
                    if pq[current]<pq[current*2]:
                        pq[current],pq[current*2]=pq[current*2],pq[current]
                        current = current*2
                    else:
                        break
                # 양쪽 자식 다 있을 때
                elif size >= current*2+1:
                    if pq[current*2]>pq[current*2+1]:
                        if pq[current] < pq[current*2]:
                          pq[current],pq[current*2]=pq[current*2],pq[current]
                          current = current*2
                        else:
                            break
                    else:
                        if pq[current] < pq[current*2+1]:
                          pq[current],pq[current*2+1]=pq[current*2+1],pq[current]
                          current = current*2+1
                        else:
                            break                    

    else:
        pq[size+1]=x
        if size > 0:
            current = size+1
            while True:
                parent = current//2
                if parent > 0:
                  if pq[parent] < pq[current]:
                    pq[parent],pq[current] = pq[current],pq[parent]
                    current = parent
                  else:
                      break
                else:
                    break
        size += 1
                        