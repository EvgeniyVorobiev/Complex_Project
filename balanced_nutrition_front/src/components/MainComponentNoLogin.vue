<template>

<body>
    <header>
        <div class="container">

            <div class="row align-items-end">
                <div class="col-md-4"><a href="#/main" id="programName">Детский сад. Питание</a></div>
                <div class="col-md-2" id="menuCreateButton"><a @click="showMenuCreation">Составить меню</a></div>
                <div class="col-md-2"><a href="#/techCards" id="techCards">Технлогические карты</a></div>
                <div class="col-md-2"><a href="#/tariffs" id="tariffs">Покупка тарифа</a></div>
                <div class="col-md-2"><a id="loginButton" @click="showLoginModal">Вход <b-icon icon="person"></b-icon></a></div>
                
            </div>

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
                                <b-form-input type="text" id="startDate" placeholder="Дата начала"
                                name="USER_PASSWORD" value=""></b-form-input>
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
    </header>
    <!-- <h1 style="margin-top: 15%; text-align: center;" @click="showLoginModal">
        Здесь вы могли бы составить меню, нужно только войти в приложение</h1> -->
    <div class="container">
        <div class="row">
            <div class="col-9 gy-5" id="table">
                <h6 style="margin-top: 20%; text-align: center;">
                Здесь вы могли бы составить меню, нужно только</h6>
                <!-- <h6 style=" text-align: center;">нужно только</h6> -->
                <h6 style="text-align: center; color:blue; cursor: pointer;" @click="showLoginModal">войти</h6>
                <h6 style="text-align: center;">в приложение</h6>
            </div>
            <div class="col-2 gy-5" id="nutrients">
                
            </div>
        </div>
    </div>
    <!-- <div class="container">
        <b-table id="menuTable" striped hover :items="items"></b-table>
    </div> -->
</body>
</template>

<script>

    export default {
        
        data(){
            return {
            name: 'MainComponentNoLogin',
            isHovered: false,
                items: [
                { "15.05.23": 'завтрак', "16.05.23": 'завтрак', "17.05.23": 'завтрак', "18.05.23": 'завтрак', "19.05.23": 'завтрак'},
                { "15.05.23": 'dish1', "16.05.23": 'dish2', "17.05.23": 'dish3', "18.05.23": 'dish4', "19.05.23": 'dish5'},
                { "15.05.23": '', "16.05.23": '', "17.05.23": '', "18.05.23": 'dish7', "19.05.23": ''},]
            }
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
        }
    }
</script>

<style scoped>
body{
    background-color:rgb(255, 255, 255);
}
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
#button{
    width:50%;
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
#menuTable{
    margin-top: 40px;
}

#table{
    background:whitesmoke;
    /* color: aliceblue; */
    
    /* width:min-content; */
    height: 500px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, .2);
}
#nutrients{
    background-color:whitesmoke;
    box-shadow: 0 4px 8px rgba(0, 0, 0, .2);
    margin-left:auto;
}
</style>