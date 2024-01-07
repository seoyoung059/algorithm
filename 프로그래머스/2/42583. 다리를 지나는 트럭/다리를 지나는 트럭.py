from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    cnt = 0
    bridge = deque()
    bridge_weight = 0
    truck_weights = deque(truck_weights)
    
    while bridge or truck_weights:
        if bridge and bridge[0][1] + bridge_length <= cnt:
            tmp = bridge.popleft()
            bridge_weight-=tmp[0]
        if truck_weights and bridge_weight + truck_weights[0] <= weight and len(bridge) < bridge_length:
            new_truck = truck_weights.popleft()
            bridge_weight += new_truck
            bridge.append((new_truck, cnt))
        cnt+=1
    print(cnt)
    return cnt