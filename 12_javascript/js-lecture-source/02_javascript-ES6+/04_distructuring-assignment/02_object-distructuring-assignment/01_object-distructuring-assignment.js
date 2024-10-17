// 객체 구조 분해 할당
let pants = {
    productName : '배기팬츠',
    color : '검정색',
    price : 30000
};

let { productName, color, price } = pants;
console.log(productName);
console.log(color);
console.log(price);

// 각 변수의 서술 순서는 무관하며 { 객체 프로퍼티 : 목표 변수 } 형식으로 작성하여 변수명을 설정할 수 도 있다.
let { productName : pn, price : pr, color : co } = pants;
console.log(pn);
console.log(pr);
console.log(co);



