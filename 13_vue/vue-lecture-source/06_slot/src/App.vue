<!--
  해당 컴포넌트에 적용할 setup 함수 안의 내용(반응형 변수, 반응형 변수에 변화를 주는 함수, 라이프 사이클 훅)을
  작성하며 view model의 개념을 작성하는 영역이다.
-->
<script setup>

import MyComponent from "@/components/01_component/MyComponent.vue";
import SlotParent from "@/components/02_soltintro/SlotParent.vue";
import NamedParent from "@/components/03_namedslot/NamedParent.vue";
import DynamicParent from "@/components/04_dynamicslot/DynamicParent.vue";
</script>

<!--
  template
  사용자 화면에 보여지는 부분을 내보낼 때 작성하며 다른 엘리먼트 요소를 감싸주는 역할을 수행한다.
  화면에 렌더링이 될 때는 제거되며 컴포넌트 단위의 html이 이 위치에 작성된다고 볼 수 있다.
-->
<template>
  <header>
    <p>Hello!</p>
    <MyComponent/>
  </header>

  <main>
    <SlotParent/>

    <NamedParent/>

    <DynamicParent/>

  </main>
</template>

<!--
  style scoped
  현재 컴포넌트에서만 적용되는 스타일을 작성한다. (범위 CSS)
-->
<style scoped>

</style>
