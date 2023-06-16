<template>
  <body>
    <div id="app">
        <header>
            <nav>
                <div class="container">
                    <div class="row">
                        <div class="col-4"><a href="/" id="programName">Детский сад. Питание</a></div>
                        <div class="col-2" id="menuCreateButton"><a @click="showMenuCreation">Составить меню</a></div>
                        <div class="col-2"><a href="/techCards"  id="techCards">Технологические карты</a></div>
                        <div class="col-2"><a href="/tariffs" id="tariffs">Покупка тарифа</a></div>
                        <div class="col-2"><a id="loginButton" @click="showLoginModal">Вход <b-icon icon="person"></b-icon></a></div>



                        <b-modal ref="menu-creation" hide-footer hide-header>
                            <div class="container" id="loginForm">
                                <div class="row">
                                        <div class="col-11">
                                            <h3>Создание меню</h3>
                                        </div>
                                    <div v-b-hover="handleHover" class="col-1 mx-auto d-block" id="close" block @click="hideMenuCreation">
                                        <b-icon v-if="isHovered" icon="x-lg" variant="dark"></b-icon>
                                        <b-icon v-else icon="x-lg" variant="secondary"></b-icon>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-12 gy-4">
                                        <b-form-input type="text" id="group" placeholder="Группа"
                                        name="USER_LOGIN" value=""></b-form-input>
                                    </div>
                                    <div class="col-12 gy-3">
                                        <b-form-datepicker id="example-datepicker" placeholder="Дата начала" v-model="value" class="mb-2"></b-form-datepicker>
                                    </div>
                                    <div class="col-12 gy-4">
                                        <b-button id="button" pill variant="primary">Создать</b-button>
                                    </div>
                                </div>
                            </div>
                        </b-modal>

                        <b-modal ref="login-modal" hide-footer hide-header>
                            <div class="container" id="loginForm">
                                <div class="row">
                                    <div class="col-11">
                                <h3>Вход в личный кабинет</h3>
                            </div>
                            <div v-b-hover="handleHover" class="col-1 mx-auto d-block" id="close" block @click="hideLoginModal">
                                <b-icon v-if="isHovered" icon="x-lg" variant="dark"></b-icon>
                                <b-icon v-else icon="x-lg" variant="secondary"></b-icon>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12 gy-4">
                                <b-form-input type="text" id="login" placeholder="Логин"
                                name="USER_LOGIN" value=""></b-form-input>
                            </div>

                            <div class="col-12 gy-3">
                                <b-form-input type="text" id="password" placeholder="Пароль"
                                name="USER_PASSWORD" value=""></b-form-input>
                            </div>

                            <div class="col-12 gy-4">
                                <b-button id="button" pill variant="primary" href="/main">Войти</b-button>
                            </div>

                            <div class="col-12 gy-3">
                                <p>Впервые в приложении?</p>
                            </div>

                            <div class="col-12">
                                <b-button id="registerButton" pill variant="outline-primary" @click="showRegisterModal">Зарегистрироваться</b-button>
                            </div>
                        </div>
                    </div>
                </b-modal>
                <b-modal ref="register-modal" hide-footer hide-header>
                    <div class="container" id="registerForm">
                        <div class="row">
                            <div class="col-11">
                                <h3>Регистрация</h3>
                            </div>
                            <div v-b-hover="handleHover" class="col-1 mx-auto d-block" id="close" block @click="hideRegisterModal">
                                <b-icon v-if="isHovered" icon="x-lg" variant="dark"></b-icon>
                                <b-icon v-else icon="x-lg" variant="secondary"></b-icon>
                            </div>
                        
                
                        <div class="row">
                            <div class="col-12 gy-4">
                                <b-form-input type="text" id="login" placeholder="Логин" maxlength="30"
                                name="USER_LOGIN" value=""></b-form-input>
                            </div>
                            <div class="col-12 gy-3">
                                <b-form-input type="text" id="password" placeholder="Пароль" maxlength="30"
                                name="USER_PASSWORD" value=""></b-form-input>
                            </div>
                            <div class="col-12 gy-3">
                                <b-form-input type="text" id="password" placeholder="Повторите пароль" maxlength="30"
                                name="USER_PASSWORD" value=""></b-form-input>
                            </div>
                                <div class="col-12 gy-4">
                                    <b-button pill variant="primary" @click="hideRegisterModal">Зарегистрироваться</b-button>
                                </div>
                            </div>
                        </div>
                    </div>
                </b-modal>
                    </div>
                </div>
            </nav>
        </header>
        <div id="content">
            <div class="container">
                <RouterView></RouterView>
            </div>
        </div> 
    </div>
  </body>
</template>

<script>
import { RouterView } from 'vue-router'
//import { LoginModalComponent } from '@/components/LoginModalComponent.vue'

    export default {

            name: "App",
    data (){
        return {
            isModalVisible: false
        };
    },
    methods: {
        showMenuCreation(){
                this.$refs['menu-creation'].show()
            },
            hideMenuCreation(){
                this.$refs['menu-creation'].hide()
            },
            showLoginModal() {
                this.$refs['login-modal'].show()
            },
            hideLoginModal() {
                this.$refs['login-modal'].hide()
            },
            showRegisterModal(){
                this.$refs['login-modal'].hide(),
                this.$refs['register-modal'].show()
            },
            hideRegisterModal(){
                this.$refs['register-modal'].hide(),
                this.$refs['login-modal'].show()
            },
            handleHover(hovered) {
                this.isHovered = hovered
            }
    },
    components: { RouterView, }
}
</script>

<style scoped>
header {
    padding-top: 40px;
    padding-bottom: 40px;
    text-align: center;
    background-color:white;
    border-color: black;
    box-shadow: 0 0 0 1px rgba(0, 0, 0, .1)
}
#programName{
    font-size: large;
    font-weight:500;
    cursor: pointer;
    text-decoration: none;
    color:black;
}
#menuCreateButton{
    cursor: pointer;
}
#techCards{
    text-decoration: none;
    color:black;
}
#tariffs{
    text-decoration: none;
    color:black;
}
#loginButton{
    cursor: pointer;
}
#close{
    cursor: pointer;
}
#loginForm{
    text-align: center;
    align-items: center;
}
#registerForm{
    text-align: center;
    align-items: center;
}
#content{
    padding-top: 10px;
}
</style>
