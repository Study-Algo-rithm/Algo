function solution(s) {
    let len = s.length;
    let answer = s.length;
    let arr = [];
    const str = s.split('');
    if(len%2!==0) return 0;

    for(let i=0;i<len;i++){
        let temp = str[0];
        str.shift();
        str.push(temp);
        const str2=[...str]; //얕은 복사
        for(let j=0;j<len;j++){
            if(arr.length!==0
                && ( (arr[arr.length-1]==='(' && str2[0]===')') || (arr[arr.length-1]==='{' && str2[0]==='}') || (arr[arr.length-1]==='[' && str2[0]===']') ) ){
                    arr.shift();
                    str2.shift();
            }else{
                temp = str2[0];
                arr.push(temp);
                str2.shift();
            }
        }
        if(arr.length!==0){
            answer--;
            arr=[];
        }
    }
    console.log(answer)
    return answer;
}
solution("}]()[{");