import heapq

def dijkstra(graph, start):
    distances = [float('inf')]*(V+1)
    distances[start] = 0
    
    hq = []
    heapq.heappush(hq, [distances[start], start])
    
    while hq:
        curr_distance, curr_destination = heapq.heappop(hq)
        
        if distances[curr_destination] < curr_distance:
            continue
        
        for new_destination, new_distance in graph[curr_destination].items():
            distance = curr_distance+new_distance
            
            if distance < distances[new_destination]:
                distances[new_destination] = distance
                heapq.heappush(hq, [distance, new_destination])
    return distances

V,E = map(int, input().split())
start = int(input())

graph = {i:{} for i in range(V+1)}
for i in range(E):
    u, v, w = map(int, input().split())
    if v in graph[u].keys():
        graph[u][v] = min(graph[u][v], w)
    else:
        graph[u][v]=w
    
ans = dijkstra(graph, start)
for i in range(1, V+1):
    if ans[i]==float('inf'):
        print('INF')
    else:
        print(ans[i])
    
