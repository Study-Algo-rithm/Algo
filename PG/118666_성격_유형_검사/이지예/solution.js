function solution(survey, choices) {
    let len = choices.length;
    let answer='';
    const defaultChoices = [0,0,0,0]; //RCJA
    const defaultChar = ["R","C","J","A"];
    const oppositeChar = ["T","F","M","N"];
    for(let i=0;i<len;i++){
        if(survey[i].includes("R")){
            if(survey[i][0]===defaultChar[0]){
                defaultChoices[0]+=((choices[i]-4)*-1)
            }else{
                defaultChoices[0]+=(choices[i]-4)
            }
        }else if(survey[i].includes("C")){
            if(survey[i][0]===defaultChar[1]){
                defaultChoices[1]+=((choices[i]-4)*-1)
            }else{
                defaultChoices[1]+=(choices[i]-4)
            }
        }else if(survey[i].includes("J")){
            if(survey[i][0]===defaultChar[2]){
                defaultChoices[2]+=((choices[i]-4)*-1)
            }else{
                defaultChoices[2]+=(choices[i]-4)
            }
        }else{
            if(survey[i][0]===defaultChar[3]){
                defaultChoices[3]+=((choices[i]-4)*-1)
            }else{
                defaultChoices[3]+=(choices[i]-4)
            }
        }
    }
    for(let i=0;i<4;i++){
        if(defaultChoices[i]<0){
            answer+=oppositeChar[i];
        }else
        answer+=defaultChar[i];
    }
    console.log(answer);
    console.log(defaultChoices)
    return answer;
}
solution(["AN", "CF", "MJ", "RT", "NA"],[5, 3, 2, 7, 5])
solution(["TR", "RT", "TR"],[7, 1, 3])