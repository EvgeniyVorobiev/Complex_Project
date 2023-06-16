<template>
    <div>
    <a id="loginButton" @click="showLoginModal">Вход <b-icon icon="person"></b-icon></a>
    <b-modal id="loginModal" hide-footer hide-header>
                    
        <div class="container" id="loginForm">
            <div class="row">
                <div class="col-11">
                    <h3>Вход в личный кабинет</h3>
                </div>
                <div v-b-hover="handleHover" class="col-1 mx-auto d-block" id="close" block @click="close">
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
                    <b-button id="button" pill variant="primary">Войти</b-button>
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
    </div>
</template>

<script>
    export default{
        name: 'LoginModalComponent',
        methods:{
            hideLoginModal(){
                this.$refs['loginModal'].hide()
            },
            showLoginModal(){
                this.$refs['loginModal'].show()
            },
            close() {
                this.$emit('close');
            }
        }
    }
</script>

<style>

</style>