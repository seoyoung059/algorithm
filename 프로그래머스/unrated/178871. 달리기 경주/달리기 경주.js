function solution(players, callings) {
    var answer = [];
    var idxDict = {};
    var nameDict = {};
    var len = players.length;
    players.map((p,idx)=>{
        idxDict[p] = idx;
        nameDict[idx] = p;
    });
    callings.forEach((c)=>{
        var nameIdx = idxDict[c];
        var old = nameDict[nameIdx-1];
        idxDict[c] -= 1;
        idxDict[old] += 1;
        nameDict[nameIdx] = old;
        nameDict[nameIdx-1] = c;
    });
    for (let i=0; i<len; i++){
        answer.push(nameDict[i]);
    };
    return answer;
}