const list = ['기러기', '토마토', '스위스', '인도인', '별똥별', '우별림'];

list.forEach(item => console.log(palindrom(item)));

function palindrom(str) {
    // 코드 작성
    let reverseStrArr = str.split("").reverse();
    return str === reverseStrArr.join('');
}