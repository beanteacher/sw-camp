import { defineStore } from "pinia";
import { ref } from "vue";

export const useUserStore = defineStore('user', () => {

    const name = ref('Guest');

    const setName = (newName) => {
        name.value = newName;
    };

    return {
        name,
        setName,
    };
});