<template>
<div>
    <div class="flex justify-end pt-7">
        <button
            @click="editBtndHandler()"
            class="block text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
            수정
        </button>
    </div>

        <div
        :class="`modal ${
        !open && 'opacity-0 pointer-events-none'
        } z-50 fixed w-full h-full top-0 left-0 flex items-center justify-center`">
            <div
            @click="open = false"
            class="absolute w-full h-full bg-gray-900 opacity-50 modal-overlay">
            </div>

        <div class="z-50 w-11/12 mx-auto overflow-y-auto bg-white rounded shadow-lg modal-container md:max-w-3xl">
        <div class="px-6 py-4 text-left modal-content">
            <!--Title-->
            <div class="flex items-center justify-between pb-3">
            <p class="text-2xl font-bold mt-2">질문 수정</p>
            <div class="z-50 cursor-pointer modal-close" @click="open = false">
                <svg
                class="text-black fill-current"
                xmlns="http://www.w3.org/2000/svg"
                width="18"
                height="18"
                viewBox="0 0 18 18">
                <path d="M14.53 4.53l-1.06-1.06L9 7.94 4.53 3.47 3.47 4.53 7.94 9l-4.47 4.47 1.06 1.06L9 10.06l4.47 4.47 1.06-1.06L10.06 9z" />
                </svg>
            </div>
            </div>

            <!--Body-->
            <div>
                <div class="mt-3">
                    <div class="grid grid-rows-2">
                        <label class="text-gray-700 ml-2">
                            순번
                        </label>
                        <input
                            class="block w-1/2 p-2 my-1 border border-gray-300 rounded hover:border-gray-400 focus:outline-none focus:border-gray-400"
                            type="text"
                            v-model="question.id"/>
                        
                        <label class="text-gray-700 ml-2">
                            조회수
                        </label>
                        <input
                            class="block w-1/2 p-2 my-1 border border-gray-300 rounded hover:border-gray-400 focus:outline-none focus:border-gray-400"
                            type="text"
                            v-model="question.views"/>
                    </div>
                    
 
                    <label class="text-gray-700 ml-2">
                        작성 일시
                    </label>
                    <input
                        class="block w-full p-2 my-1 border border-gray-300 rounded hover:border-gray-400 focus:outline-none focus:border-gray-400"
                        type="text"
                        v-model="question.id"/>

                    <label class="text-gray-700 ml-2">
                        작성자
                    </label>
                    <input
                        class="block w-full p-2 my-1 border border-gray-300 rounded hover:border-gray-400 focus:outline-none focus:border-gray-400"
                        type="text"
                        v-model="question.writer"/>

                    <label class="text-gray-700 ml-2">
                        제목
                    </label>
                    <input
                        class="block w-full p-2 my-1 border border-gray-300 rounded hover:border-gray-400 focus:outline-none focus:border-gray-400"
                        type="text"
                        v-model="question.title"/>

                    <label class="text-gray-700 ml-2">
                        내용
                    </label>
                    <textarea id="message" rows="10"
                    v-model="question.contents"
                    class="block p-2.5 w-full text-sm text-gray-900 rounded-md border border-gray-300 hover:border-gray-400 focus:outline-none focus:border-gray-400"></textarea>

                    <label class="text-gray-700 ml-2">
                        첨부
                    </label>
                    <input
                        class="block w-full p-2 my-1 border border-gray-300 rounded hover:border-gray-400 focus:outline-none focus:border-gray-400"
                        type="text"
                        v-model="question.files"/>

                    <label class="text-gray-700 ml-2">
                        비밀번호 (4자리 숫자)
                    </label>
                    <input
                        class="block w-full p-2 my-1 border border-gray-300 rounded hover:border-gray-400 focus:outline-none focus:border-gray-400"
                        type="password"
                        v-model="question.password"/>

                    <input class="ml-2 border border-gray-300"
                        type="checkbox"
                        v-model="question.checked"/>
                    <label class="text-gray-700 ml-2">
                        조회 보안
                    </label>
                </div>
                
            </div>

            <!--Footer-->
            <div class="flex justify-end pt-7">
                <button
                    @click="itemsCheck()"
                    class="px-6 py-3 text-white bg-blue-700 hover:bg-blue-600 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                    수정
                </button>
                <button
                    @click="open = false"
                    class="px-6 py-3 mx-2 text-blue-700 bg-transparent rounded-lg hover:bg-gray-100 hover:text-blue-600 focus:outline-none">
                    취소
                </button>
            </div>
        </div>
        </div>
    </div>
</div>
</template>

<script>
import deleteBoard from '../modal/DeleteBoard.vue';

export default {
    name: "editQuestion",
    components: { 
        deleteBoard
    },
    data() {
        return {
            open: false,
            question: {
                id: "",
                views: "",
                date: "",
                writer: "",
                title: "",
                contents: "",
                files: "",
                password: "",
                checked: "",
            }
        };
    },
    methods: {
        itemsCheck() {
            alert("질문 수정이 완료되었습니다.");
            this.$router.go;
            this.open = false;
        },
        editBtndHandler() {
            this.open = true;
        }
    },
    
}
</script>
<style>
</style>