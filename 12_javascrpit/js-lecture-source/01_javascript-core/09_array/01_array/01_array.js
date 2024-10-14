/* 배열 생성
* 1. 리터럴로 생성 */
const arr = ['바나나', '복숭아', '키위']
console.log(arr)

/* 2. 배열 생성자 함수 */
const arr2 = new Array('복숭아','','','');
console.log(arr2);

/* 3. Array.of 메소드 */
console.log(Array.of(10))
console.log(Array.of(1,2,3))
console.log(Array.of("hello","js"))

console.log(arr[0]);

/* 배열의 요소의 개수, 즉 배열의 길이를 나타내는 length 프로퍼티를 갖는다. */
console.log(arr.length);


/* for 문을 통한 요소 순회 */
for(let i = 0; i < arr.length; i++) {
    console.log(arr[i]);
}

console.log(typeof arr);
