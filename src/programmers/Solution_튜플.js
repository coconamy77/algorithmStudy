function solution(s) {
    var answer = [];
    
    let arr = [];
    let tuple = [];
    let flag = false;
    let tmp  = "";
    let length = 1;
    for(let i = 1; i<s.length-1; i++){
        let c = s.charAt(i);
        switch(c){
            case '{':
                flag = true;
                arr = [];
                break;
            case '}':
                arr.push(Number(tmp));
                tmp = "";
                flag = false;
                tuple.push(arr);
                break;
            case ',':
                if(flag){
                    arr.push(Number(tmp));
                    tmp = "";
                }
                break;
            default:
                tmp += c;
        }
    }
    
    tuple.sort(function(a,b){
        return a.length-b.length;
    })
    
    tuple.forEach(function(t){
        t.forEach(function(n){
            if(!answer.includes(n)){
                answer.push(n);
            }
        })
    })
    
    return answer;
}