function getNum(oper, num, N){
    switch(oper){
        case 0:
            return num+N;
        case 1:
            if (num<=N){
                return N;
            }
            return num-N;
        case 2:
            return Math.ceil(num/N);
        case 3:
            return num*N;
    }
}

function solution(N, number) {
    var answer = -1;
    let dp = new Array(100000000);
    
    let nn=N;
    let getCount = 1;
    let count = 1;
    dp[N] = count;
    dp[0] = 0;
    let q = [];
    q.push(N);
    while(count<8 && answer===-1){
        let now = q.shift();
        count = dp[now]+1;
        if(getCount!=count){
            getCount = count;
            nn = nn*10+N;
            if(nn===number){
                answer = getCount;
                break;
            }
            if(!dp[nn]){
                dp[nn] = count;
                q.push(nn);
            }
        }
        for(let i = 0; i<4; i++){
            let num = getNum(i, now, N);
            if(num===number){
                answer = count;
                break;
            }
            if(!dp[num]){
                dp[num] = count;
                q.push(num);
            }
        }
    }
    
    return answer;
}