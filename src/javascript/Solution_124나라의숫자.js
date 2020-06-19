function solution(n) {
    let numbers = ['0','1','2','4'];
    
    if(n<=3){
        return numbers[n];
    }
    let pre = Math.floor(n/3);
    let now = Math.floor(n%3);
    
    if(now===0){
        now = 3;
        pre--;
    }
    
    if(pre<=0){
        return numbers[now];
    }
    return solution(pre)+numbers[now];
}