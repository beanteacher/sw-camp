let Tutor = class {
    teach() {
        console.log("이해하셨나요?");
    }
}
new Tutor().teach();

let Tutee = class MyTutee {
    learn() {
        console.log('와와 ~ 이해했어용 ~');
    }
}

new Tutee().learn();

let SecondTutee = makeTutee("10점 만점에 10점~");
new SecondTutee().feedback();

function makeTutee(msg) {
    return class {
        feedback() {
            console.log(msg);
        }
    }
}

/* => 클래스 표현식 정의가 가능하다는 것은 함수처럼 클래스도 "일급 객체"이며
* 다른 표현식 내부에서 정의, 전달, 번환, 할당이 가능하다는 것이다. */