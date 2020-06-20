function solution(n) {
    let numbers = ['1','2','4'];
    n--;
    if(n<=2){
        return numbers[n];
    }
    let pre = Math.floor(n/3);
    let now = Math.floor(n%3);
    
    if(pre<=0){
        return numbers[now];
    }
    return solution(pre)+numbers[now];
}