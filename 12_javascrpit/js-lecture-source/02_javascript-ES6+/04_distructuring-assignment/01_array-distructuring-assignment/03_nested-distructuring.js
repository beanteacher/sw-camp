let product = {
    size : {
        width : 10,
        height : 30
    },
    items : ['doll', 'robot']
}
// 중첩 구조 분해 시 코드를 여러 줄에 걸쳐 작성하여 의도하는 바를 명확히 드러낸다.
let {
    size : {
        width,
        height
    },
    items: [item1, item2],
    procedure = "홍길동"
} = product;

console.log(width);
console.log(height);
console.log(item1);
console.log(item2);
console.log(procedure);