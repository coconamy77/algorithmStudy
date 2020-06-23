function solution(cacheSize, cities) {
    var answer = 0;
    if(cacheSize===0){
        return cities.length*5;
    }
    
    let list = [];
    
    cities.forEach(function(city){
        city = city.toLowerCase();
        if(list.includes(city)){
            list.splice(list.indexOf(city),1);
            answer += 1;
        }else{
            if(list.length===cacheSize){
                list.splice(0,1);
            }
            answer += 5;
        }
        list.push(city);
    })
    return answer;
}