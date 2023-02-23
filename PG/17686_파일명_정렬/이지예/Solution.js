function solution(files) {
    return files.sort((a,b)=>{
        const headerA = a.match(/^\D+/)[0].toLowerCase();
        const headerB = b.match(/^\D+/)[0].toLowerCase();
				//숫자로 시작하지 않는, 글자뭉텅이를 소문자로 변환한다.
        if(headerA>headerB) return 1;
				//글자를 비교 했을 때, 기준값보다 글자가 크므로 a는b뒤에 온다.
        if(headerA<headerB) return -1;
				//기준값보다 글자가 작으므로 a는 b 앞에 온다.
        const numberA = a.match(/\d+/)[0].replace(/^0+/,"");
        const numberB = b.match(/\d+/)[0].replace(/^0+/,"");
		    //숫자뭉텅이의 첫번째 뭉텅이에서 맨앞에 오는 0들을 지운다.
				return numberA-numberB;
				//숫자 a,b를 비교해서 양수면 위치 바꾸고, 아니면 둔다??
    })
}