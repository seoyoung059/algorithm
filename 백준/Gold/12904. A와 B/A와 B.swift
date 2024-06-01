import Foundation

var (aa, ab, ba, bb) = (0,0,0,0)

var a = readLine()!.map{String($0)}
// B
// ABBA
var b = readLine()!.map{ a -> String in
    let ctos = String(a)
    ba += ctos == "A" ? 1 : 0;
    bb += ctos == "B" ? 1 : 0;
    return String(a)
}

var q = [[String]]()
q.append(b)

while (!q.isEmpty) {
    let this = q.removeLast()
    if this == a {
        print(1)
        exit(0)
    }
    if this.count == 0 { continue }
    
    if this.last! == "A" {
        q.append(Array(this[0..<this.count-1]))
    }
    if this.last! == "B" {
        q.append(Array(this[0..<this.count-1]).reversed())
    }
}

print(0)