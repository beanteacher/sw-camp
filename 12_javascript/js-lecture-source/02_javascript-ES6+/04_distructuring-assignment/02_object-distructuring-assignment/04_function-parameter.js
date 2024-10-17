// 함수 매개변수
// 함수의 매개변수가 많거나 매개변수 기본 값이 필요한 경우에 활용한다.

function displayProduct(producer = "아무개", width = 0, height = 0, items = []) {
}
// 인수의 순서가 고정 되어 있어 순서가 바뀌면 안되고 기본 값을 활용하긴 하지만 undefined를 이용해서 인수를 자리 맞춰 넘겨 주어야만 한다.
displayProduct("신사임당", undefined, undefined, ["Coffee", "Donut"]);


function displayProduct2({producer = "아무개", width = 0, height = 0, items = []}) {
}

let exampleProduct = {items : ["Coffee", "Donut"], producer : '홍길동'};
// 인수의 순서도 상관이 없고 값을 넘기지 않아도 기본 값을 적용할 수 있다.
displayProduct2(exampleProduct);