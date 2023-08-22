function solution(msg) {
    let dict = [0] // 사전
    for (let i=0; i<26; i++) {
        dict.push(String.fromCharCode(65+i)); // 아스키코드 숫자를 문자로 변환해 사전에 추가
    }
    // console.log(dict)
    let answer = [];
    let start = 0;
    let end = 1;

    while (true) {
        let w = msg.slice(start, end);
        if (end === msg.length){ // 마지막 단어 처리
            const last = dict.indexOf(w);
            last !== -1 ? answer.push(last) : answer.push(dict.length)
            break;
        }
        let c = msg[end];
        if (dict.includes(w+c) === false) { // 사전에 단어가 없으면
            dict.push(w+c);
            answer.push(dict.indexOf(w));
            start = end;
            end = start + 1;
        } else { // 사전에 단어가 있으면
            end += 1;
        }
    }
    // console.log(answer)
    return answer
}