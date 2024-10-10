var dog = {
    name : "뽀삐",
    eat : function (food) {
        console.log(`${this.name}은 ${food}를 맛있게 먹어요.`)
    }
}

var dog2 = {
    name : "뽀삐",
    eat(food) {
        console.log(`${this.name}은 ${food}를 맛있게 먹어요.`);
    }
}