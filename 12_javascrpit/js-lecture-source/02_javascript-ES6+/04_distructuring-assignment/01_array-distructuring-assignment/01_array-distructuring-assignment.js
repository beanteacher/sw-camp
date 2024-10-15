/* 배열 구조 분해 할당
* 구조 분해 할당을 사용하면 배열이나 객체를 변수로 '분해'하여 연결할 수 있다. */
let nameArr = ['Gildong', 'Hong']
let [firstName, lastName] = nameArr;
console.log(firstName)
console.log(lastName);

let [firstName2, lastName2] = "Saimdang Shine".split(" ");
console.log(firstName2)
console.log(lastName2);

let arr = ["firstName", "middleName", "lastName"];
let[firstName3, lastName3] = arr;
console.log(firstName3)
console.log(lastName3);
