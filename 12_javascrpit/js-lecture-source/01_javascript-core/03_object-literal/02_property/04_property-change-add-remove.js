/* 프로퍼티 변경, 추가, 삭제 */
var dog = {
    name : "뽀삐"
};

dog.name = '두부'
dog.age = 3;
console.log(dog);

delete dog.age;

console.log(dog);

delete dog.something;