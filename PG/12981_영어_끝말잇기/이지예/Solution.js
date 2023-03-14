function solution(n, words) {
    let answer = [0,0];
    for(let i=0;i<words.length;i++){
        let word = words[i];
        let p=i%n+1;
        let turn = Math.ceil((i+1)/n);
        //ceil함수는 주어진 숫자보다 크거나 같은 숫자 중 가장 작은 숫자를 반환한다. 즉 반올림해서 반환한다는 뜻
        if(i>0){
            let last = words[i-1].split("").pop();

            if(i>words.indexOf(word)||words[i][0]!==last){
                answer = [p,turn];
                break;
            }
        }
    }
console.log(answer)
    return answer;
}
solution(3,["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]);