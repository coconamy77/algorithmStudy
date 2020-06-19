function getNum(n){
    switch(n){
        case 1:
            return '1';
        case 2:
            return '2';
        case 3:
            return '4';
    }
}

function getAns(n){
    if(n<=3){
        return getNum(n);
    }
    let pre = Math.floor(n/3);
    let now = Math.floor(n%3);
    
    if(now===0){
        now = 3;
        pre--;
    }
    
    if(pre<=0){
        return getNum(now);
    }
    return getAns(pre)+getNum(now);
}

function solution(n) {
    return getAns(n);
}