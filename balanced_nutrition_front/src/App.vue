<template>
  <body>
    <div id="app">
        <header>
            <nav>
                <b-container class="container">
                    <b-row class="row">
                        <b-col cols="4"><a href="/" id="programName">Детский сад. Питание</a></b-col>


                        <b-col cols="2"><b-dropdown  variant="link" no-caret toggle-class="text-decoration-none">
                            <template #button-content>
                            <p style="text-decoration: none;
                        color: black; margin-top: -5px;" class="menuCreateButton">Составление меню</p>
                            </template>
                            <b-dropdown-item @click="showMenuCreation">Создать меню</b-dropdown-item>
                            <b-dropdown-item >Открыть меню</b-dropdown-item>
                        </b-dropdown></b-col>


                        <b-col cols="4"><a href="/techCards"  id="techCards">Технологические карты</a></b-col>
                        <!-- <div class="col-1"><a href="/tariffs" id="tariffs">Тариф</a></div> -->


                        <b-col cols="2"><a id="loginButton" @click="showLoginModal">Вход <b-icon icon="person"></b-icon></a></b-col>
                        
                        
                        <!-- <b-col cols="2"><b-dropdown  variant="link" no-caret toggle-class="text-decoration-none">
                            <template #button-content>
                            <p style="text-decoration: none; color: black
                            ; margin-top: -5px;"><a id="loginButton">Evgeniy <b-icon icon="person"></b-icon></a></p>
                            </template>
                            <b-dropdown-item>Выход</b-dropdown-item>
                        </b-dropdown></b-col> -->



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
                                        <b-form-input v-model="groupNameCr" type="text" id="group"
                                         placeholder="Группа" value=""></b-form-input>
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
                                <h3>Вход в личный кабинет</h3>
                            </b-col>
                            <b-col cols="1" id="closeDiv">
                                    <b-icon class="close" icon="x-lg" @click="hideLoginModal"></b-icon>
                            </b-col>

                            <b-col cols="10">
                                <b-form-input type="text" v-model="loginLog" class="loginInput" id="login" placeholder="Логин"
                                name="USER_LOGIN" value=""></b-form-input>
                            </b-col>

                            <b-col cols="10">
                                <b-form-input type="text" v-model="passwordLog" class="password" id="password" placeholder="Пароль"
                                name="USER_PASSWORD" value=""></b-form-input>
                            </b-col>

                            <b-col cols="7">
                                <b-button class="loginButton" block pill variant="primary" href="/main">Войти</b-button>
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
//import { LoginModalComponent } from '@/components/LoginModalComponent.vue'
class UserCp{
    constructor(login, password, email, role_id){
        this.login = login;
        this.password = password;
        this.email = email;
        this.role_id = role_id;
        }
    //constructor(){

    //}    
}

// class Role{
//     constructor(id_role, name){
//         this.id_role = id_role;
//         this.name = name;}
//     }
//let FormRegistration = document.querySelector("#registerForm");
//FormRegistration.addEventListener()


    export default {
            name: "App",
    
    data (){
        return {

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
                    //this.roleName = response.data.name;
                    return response;
                } 
                catch (error) {
                    console.log(error);
                }
            },
            async findUserBylogin(login){
                const response = await axios.get('http://localhost:8080/user/getByLogin/' + login)
                return response;
            },
            // async findRoleById(id_role){
            //     const response = await axios.get('http://localhost:8080/role/' + id_role);
            //     this.role = new Role(response.id, response.name);
            // },

            registerUser(){
                
                // this.user.login = this.loginInput;
                // this.user.password = this.password1Input;
                // this.user.email = this.emailInput;
                // this.findRoleById(2);
                try{
                if (this.loginInputReg != null && this.emailInput != null && this.password1Input != null && this.password2Input != null ){
                    if (this.findUserBylogin(this.loginInputReg) == null){
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
                        this.makeToast('danger', 'Пользователь с таким логином уже есть');
                    }
                }
                else{
                    this.makeToast('danger', 'Проверьте правильность введенных данных');
                }
                }
                catch{
                    this.makeToast('danger', 'Произошла ошибка при регистрации');
                }
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
