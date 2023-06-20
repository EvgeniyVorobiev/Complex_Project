<template>
  <body>
    <div id="app">
        <header>
            <nav>
                <b-container class="container">
                    <b-row class="row">
                        <b-col cols="4"><router-link to="/" id="programName">Детский сад. Питание</router-link></b-col>


                        <b-col cols="2"><b-dropdown  variant="link" no-caret toggle-class="text-decoration-none">
                            <template #button-content>
                            <p style="text-decoration: none;
                        color: black; margin-top: -5px;" class="menuCreateButton">Составление меню</p>
                            </template>
                            <b-dropdown-item @click="showMenuCreation">Создать меню</b-dropdown-item>
                            <b-dropdown-item >Открыть меню</b-dropdown-item>
                        </b-dropdown></b-col>


                        <b-col cols="4"><router-link to="/techCards"  id="techCards">Технологические карты</router-link></b-col>
                        <!-- <div class="col-1"><a href="/tariffs" id="tariffs">Тариф</a></div> -->
                        <b-col cols="2" v-if="loginVisability"><a id="loginButton" @click="showLoginModal">Вход <b-icon icon="person"></b-icon></a></b-col>
                        
                        <b-col cols="2" v-if="userVisability"><b-dropdown  variant="link" no-caret toggle-class="text-decoration-none">
                            <template #button-content>
                            <p style="text-decoration: none;
                        color: black; margin-top: -5px;" class="menuCreateButton">{{authorisedUser.login}} <b-icon icon="person"></b-icon></p>
                            </template>
                            <b-dropdown-item @click="outUser" href="/">Выход</b-dropdown-item>
                        </b-dropdown></b-col>

                        <b-modal ref="menu-creation" hide-footer hide-header>
                            <b-container class="container" id="loginForm">
                                <b-row align-h="center" class="row">
                                        <b-col cols="11">
                                            <h3>Создание меню</h3>
                                        </b-col>
                                    
                                        <b-col cols="1" id="closeDiv">
                                        <b-icon class="close" icon="x-lg" @click="hideMenuCreation"></b-icon>
                                        </b-col>


                                    <b-col cols="10">
                                        <b-form-input v-model="menuNameCr" type="text" id="menuName"
                                         placeholder="Название меню" value=""></b-form-input>
                                    </b-col>

                                    <b-col cols="10">
                                        <b-form-select v-model="groupNameCr" :options="groups" type="text" id="group"
                                         placeholder="Группа" value=""></b-form-select>
                                    </b-col>
                                    <b-col cols="10">
                                        <b-form-datepicker v-model="beginDateCr" id="datepicker"
                                         placeholder="Дата начала" value="" class="mb-2"></b-form-datepicker>
                                    </b-col>
                                    <b-col cols="10">
                                        <b-form-input v-model="daysNumberCr" type="text" id="daysNumber"
                                         placeholder="Количество дней" value=""></b-form-input>
                                    </b-col>
                                    <b-col cols="8">
                                        <b-button id="button" block pill variant="primary">Создать</b-button>
                                    </b-col>
                                </b-row>
                            </b-container>
                        </b-modal>

                        <b-modal ref="login-modal" hide-footer hide-header>
                            <b-container class="container" id="loginForm">
                                <b-row align-h="center" class="row">
                                    <b-col cols="11">
                                <h3>Авторизация</h3>
                            </b-col>
                            <b-col cols="1" id="closeDiv">
                                    <b-icon class="close" icon="x-lg" @click="hideLoginModal"></b-icon>
                            </b-col>

                            <b-col cols="10">
                                <b-form-input type="text" v-model="loginLog" class="loginInput" id="login" placeholder="Логин"
                                name="USER_LOGIN" value=""></b-form-input>
                            </b-col>

                            <b-col cols="10">
                                <b-form-input type="password" v-model="passwordLog" class="password" id="password" placeholder="Пароль"
                                name="USER_PASSWORD" value=""></b-form-input>
                            </b-col>

                            <b-col cols="7">
                                <b-button class="loginButton" block pill variant="primary" @click="authUser">Войти</b-button>
                            </b-col>

                            <b-col cols="10">
                                <p style="margin-top: 20px;">Впервые в приложении?</p>
                            </b-col>

                            <b-col cols="7">
                                <b-button block pill variant="outline-primary" @click="showRegisterModal">Зарегистрироваться</b-button>
                            </b-col>
                        </b-row>
                    </b-container>
                </b-modal>
                <b-modal ref="register-modal" hide-footer hide-header>
                    <b-container class="container" id="registerForm">
                        <b-row align-h="center">
                            <b-col cols="11">
                                <h3>Регистрация</h3>
                            </b-col>
                            <b-col cols="1" id="closeDiv">
                                        <b-icon class="close" icon="x-lg" @click="hideRegisterModal"></b-icon>
                            </b-col>

                            <b-col cols="10">
                                <b-form-input v-model="loginInputReg" type="login" class="loginInput" id="login" placeholder="Логин" maxlength="30"
                                name="USER_LOGIN" value=""></b-form-input>
                            </b-col>
                            <b-col cols="10">
                                <b-form-input v-model="emailInput" type="email" class="emailInput" id="email" placeholder="Электронная почта" maxlength="30"
                                name="USER_EMAIL" value=""></b-form-input>
                            </b-col>
                            <b-col cols="10">
                                <b-form-input v-model="password1Input" type="password" class="password" id="password1" placeholder="Пароль" maxlength="30"
                                name="USER_PASSWORD1" value=""></b-form-input>
                            </b-col>
                            <b-col cols="10">
                                <b-form-input v-model="password2Input" type="password" class="password" id="password2" placeholder="Повторите пароль" maxlength="30"
                                name="USER_PASSWORD2" value=""></b-form-input>
                            </b-col>
                                <b-col cols="10">
                                    <b-button class="registerButton" pill variant="primary" @click="registerUser">Зарегистрироваться</b-button>
                                </b-col>
                        </b-row>
                    </b-container>
                </b-modal>
                    </b-row>
                </b-container>
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
import axios from 'axios';
class UserCp{
    constructor(login, password, email, role_id){
        this.login = login;
        this.password = password;
        this.email = email;
        this.role_id = role_id;
        }
}
// var authorisedUser;


    export default {
            name: "App",
            
    data (){
        return {
            authorisedUser: null,
            userVisability: false,
            loginVisability: true,
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
            hideUserVisability(){
                this.userVisability = false
            },
            showUserVisability(){
                this.userVisability = true
            },
            hideLoginVisability(){
                this.loginVisability = false
            },
            showLoginVisability(){
                this.loginVisability = true
            },
            makeToast(variant = null, text) {
                this.$bvToast.toast(text, {
                title: `Детский сад. Питание`,
                variant: variant,
                autoHideDelay: 5000,
                solid: true
            })
            },
            
            async register(user){
                try {
                    const response = await axios.post('http://localhost:8080/user/register', user);
                    return response;
                } 
                catch (error) {
                    console.log(error);
                }
            },
            outUser(){
                this.authorisedUser = null;
                this.hideUserVisability();
                this.showLoginVisability();
            },
            authUser(){
                if (this.loginLog != null && this.passwordLog != null){
                    axios.get('http://localhost:8080/user/getByLoginAndPassword/' + this.loginLog + '/' + this.passwordLog)
                    .then(response => {
                        this.authorisedUser = response.data;
                        this.hideLoginModal();
                        console.log(this.authorisedUser);
                        this.makeToast('success', 'Авторизация прошла успешно');
                        this.hideLoginVisability();
                        this.showUserVisability();
                    })
                    .catch(() => {
                        this.makeToast('danger', 'Неверно указан логин или пароль')
                    })
                }
                else{
                    this.makeToast('danger', 'Пожалуйста, заполните все поля');
                }
            },
            registerUser(){
                var userIsAdded;
                const response = axios.get('http://localhost:8080/user/getByLogin/' + this.loginInputReg)
                    .then(() => {
                        this.makeToast('danger', 'Пользователь с таким логином уже есть');
                    })
                    .catch(() => {
                        if (this.loginInputReg != null && this.emailInput != null && this.password1Input != null && this.password2Input != null ){
                        
                        if (this.password1Input == this.password2Input){
                            this.register(new UserCp(this.loginInputReg, this.password1Input, this.emailInput, 2));
                            this.hideRegisterModal();
                            this.makeToast('success', 'Регистрация прошла успешно');
                            this.loginInputReg = null;
                            this.password1Input = null;
                            this.password2Input = null;
                            this.emailInput = null;
                        }
                        else {
                            this.makeToast('danger', 'Пароли не совпадают');
                        }
                        
                    }
                    else{
                        this.makeToast('danger', 'Проверьте правильность введенных данных');
                    }
                    });
                console.log(userIsAdded);
                console.log(response);
                }
    },
    components: { RouterView, },
}
</script>

<style scoped>
header {
    padding-top: 40px;
    padding-bottom: 20px;
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
.menuCreateButton{
    text-decoration: none;
    cursor: pointer;
}
:hover menuCreateButton{
    text-decoration: none;
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
#closeDiv{
    position: absolute;
    left: 105%;
}
:hover .close{
    color:white;
}
.close{
    top: -2%;
    cursor: pointer;
    width: 40px; 
    height: 40px; 
    color:whitesmoke;
}
#loginForm{
    text-align: center;
    align-items: center;
}
.loginInput{
    margin-top: 20px;
}
.emailInput{
    margin-top: 20px;
}
.password{
    margin-top: 20px;
}

#registerForm{
    text-align: center;
    align-items: center;
}
.loginButton{
    margin-top: 30px;
}
.registerButton{
    margin-top: 20px;
}
#content{
    padding-top: 40px;
}
</style>
