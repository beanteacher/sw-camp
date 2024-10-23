import { defineStore } from 'pinia'
import { ref, computed } from "vue";

/* Option Store */

/* defineStore()의 반환값에 원하는 대로 이름을 지을 수 있지만,
'use'로 시작해 'Store'로 끝나는 이름을 사용하는 것이 규칙이다. (아래 코드는 테스트를 위해 숫자를 붙임)
첫 번째 인수는 애플리케이션 내 Store의 고유 ID이다.
Vue의 Options API와 유사하게, state, getters, actions 프로퍼티를 가진 Options 객체를 전달할 수 있다.
(data->state, computed->getters, methods-> actions)
 */
export const useCounterStore1 = defineStore('counter', {

    // state : 스토어의 상태를 정의하며 함수 형태로 작성한다.
    state: () => ({ count: 0 }),

    // getters : state의 데이터를 가공하여 컴포넌트에서 사용할 수 있도록 만드는 속성으로
    // state에 있는 값을 활용해 다른 계산된 값을 반환할 수 있다.
    getters: {
        // 첫 번째 인자로 state를 받아서 활용
        doubleCount: (state) => state.count * 2,
    },

    // actions : 상태를 변경하거나 로직을 처리하는 메서드이다.
    actions: {
        // 'this'를 사용하여 현재 스토어의 상태(count)를 변경한다.
        increment() {
            this.count++
        },
    },
})

/* Setup Store  */

/* Vue Composition API의 setup 함수와 유사하게, 반응형 프로퍼티와 메서드를 정의하는 함수를 전달하고,
노출하려는 프로퍼티와 메서드를 포함한 객체를 반환할 수 있다.
 */
export const useCounterStore2 = defineStore('counter', () => {
    // state: ref를 사용하여 상태 정의
    const count = ref(0)

    // state인 count를 활용해 계산된 값을 반환하는 computed 속성으로
    // getters와 유사한 역할을 하며, count 값이 변경될 때마다 자동으로 계산된다.
    const doubleCount = computed(() => count.value * 2)

    // actions: 상태 변경 메서드 정의
    function increment() {
        count.value++
    }

    // 반환할 값 : 상태와 액션을 반환하여 외부에서 사용할 수 있게 한다.
    return { count, doubleCount, increment }
})



