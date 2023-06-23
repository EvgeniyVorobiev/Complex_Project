<template>
    <body>

        <b-row>
            <b-col cols="8">
                <b-tabs>
                    <b-tab title="23.06.2023">
                        <b-card no-body>
                            <b-tabs pills card vertical nav-wrapper-class="w-8">
                                <b-tab title="Завтрак" active><b-card-text>
                                    <b-row>
                                        <b-col cols="6">
                                            <div class="dish">
                                                Блюдо
                                            </div>
                                        </b-col>
                                        <b-col cols="3">
                                            <b-button class="dishInfo" variant="info">
                                                Информация о блюде
                                            </b-button>
                                        </b-col>
                                        <b-col cols="3">
                                            <b-button class="deleteDish" variant="danger">
                                                Удалить блюдо
                                            </b-button>
                                        </b-col>
                                        
                                        <b-col cols="6">
                                            <div class="dish">
                                                Блюдо
                                            </div>
                                        </b-col>
                                        <b-col cols="3">
                                            <b-button class="dishInfo" variant="info">
                                                Информация о блюде
                                            </b-button>
                                        </b-col>
                                        <b-col cols="3">
                                            <b-button class="deleteDish" variant="danger">
                                                Удалить блюдо
                                            </b-button>
                                        </b-col>

                                        <b-col cols="12">
                                            <b-button class="addDish" pill variant="outline-primary">
                                                Добавить блюдо в меню
                                            </b-button>
                                        </b-col>
                                    </b-row>
                                </b-card-text></b-tab>
                                <b-tab title="Обед"><b-card-text>
                                    <b-col cols="12">
                                            <b-button class="addDish" pill variant="outline-primary">
                                                Добавить блюдо в меню
                                            </b-button>
                                        </b-col>
                                </b-card-text></b-tab>
                                <b-tab title="Полдник">
                                    <b-col cols="12">
                                            <b-button class="addDish" pill variant="outline-primary">
                                                Добавить блюдо в меню
                                            </b-button>
                                        </b-col>
                                </b-tab>
                            </b-tabs>
                        </b-card>
                    </b-tab>
                    <b-tab title="24.06.2023">
                        <b-card no-body class="menu">
                            <b-tabs pills card vertical nav-wrapper-class="w-8">
                                <b-tab title="Завтрак" active><b-card-text>Tab contents 1</b-card-text></b-tab>
                                <b-tab title="Обед"><b-card-text>Tab contents 2</b-card-text></b-tab>
                                <b-tab title="Полдник"><b-card-text>Tab contents 3</b-card-text></b-tab>
                            </b-tabs>
                        </b-card>
                    </b-tab>
                    <b-tab title="25.06.2023">
                        <b-card no-body class="menu">
                            <b-tabs pills card vertical nav-wrapper-class="w-8">
                                <b-tab title="Завтрак" active><b-card-text>Tab contents 1</b-card-text></b-tab>
                                <b-tab title="Обед"><b-card-text>Tab contents 2</b-card-text></b-tab>
                                <b-tab title="Полдник"><b-card-text>Tab contents 3</b-card-text></b-tab>
                            </b-tabs>
                        </b-card>
                    </b-tab>
                    <b-tab title="26.06.2023">
                        <b-card no-body class="menu">
                            <b-tabs pills card vertical nav-wrapper-class="w-8">
                                <b-tab title="Завтрак" active><b-card-text>Tab contents 1</b-card-text></b-tab>
                                <b-tab title="Обед"><b-card-text>Tab contents 2</b-card-text></b-tab>
                                <b-tab title="Полдник"><b-card-text>Tab contents 3</b-card-text></b-tab>
                            </b-tabs>
                        </b-card>
                    </b-tab>
                    <b-tab title="27.06.2023">
                        <b-card no-body class="menu">
                            <b-tabs pills card vertical nav-wrapper-class="w-8">
                                <b-tab title="Завтрак" active><b-card-text>Tab contents 1</b-card-text></b-tab>
                                <b-tab title="Обед"><b-card-text>Tab contents 2</b-card-text></b-tab>
                                <b-tab title="Полдник"><b-card-text>Tab contents 3</b-card-text></b-tab>
                            </b-tabs>
                        </b-card>
                    </b-tab>
                </b-tabs>
            </b-col>


            <b-col cols="12">
                <b-tab title="Показатели питательности">
                        <b-card no-body class="menu">
                            <b-tabs pills card vertical nav-wrapper-class="w-8">
                                <b-tab title="Завтрак" active><b-card-text>Tab contents 1</b-card-text></b-tab>
                                <b-tab title="Обед"><b-card-text>Tab contents 2</b-card-text></b-tab>
                                <b-tab title="Полдник"><b-card-text>Tab contents 3</b-card-text></b-tab>
                            </b-tabs>
                        </b-card>
                    </b-tab>
            </b-col>

        </b-row>
 


    </body>
    </template>
    
    <script>
        //import roleService from '../components/services/roleService.js'
        import axios from 'axios';

        export default{
            data(){
            return {
                roleName : "dsf",
                name: 'MainComponent',
                items1: [
                    {'Дата': '26.05.23', 'Приём пищи': 'Завтрак', 'Блюдо': 'Суп овощной', 'Действие':'Удалить'},
                    {'Дата': '26.05.23', 'Приём пищи': 'Завтрак', 'Блюдо': 'Салат', 'Действие':'Удалить'},
                    {'Дата': '26.05.23', 'Приём пищи': 'Завтрак', 'Блюдо': 'Компот из сухофруктов', 'Действие':'Удалить'},
                    {'Действие': 'Добавить', _rowVariant: ''}
                ],
                items2: [
                    {'Дата': '26.05.23', 'Показатель': 'Белки', 'Содержание': '55 г', 'Норма': '54 г'},
                    {'Дата': '26.05.23', 'Показатель': 'Жиры', 'Содержание': '32 г', 'Норма': '60 г', _rowVariant: 'danger'},
                    {'Дата': '26.05.23', 'Показатель': 'Углеводы', 'Содержание': '265 г', 'Норма': '261 г'},
                ]
            }
            
        },
        methods:{
            showLoginModal() {
                    this.$refs['login-modal'].show()
                },
            async fetchRole(){
            try {
            const response = await axios.get('http://localhost:8080/role/1');
            this.roleName = response.data.name;
            
            } catch (error) {
                console.log(error);
            }
        }
            
        }
    
        }
    </script>
    
    <style scoped>
    #table{
    
        height: 450px;
        box-shadow: 0 5px 10px 0 rgba(0,0,0,0.1);
    }
    #nutrients{
        height: 450px;
        box-shadow: 0 5px 30px 0 rgba(0,0,0,0.2);
        margin-left:auto;
    }
    .dish{
        margin-top: 20px;
        box-shadow: 0 5px 15px 0 rgba(0,0,0,0.2);
        border-radius: 5px;
        text-align: center;
        align-items:center;
        display: grid;
        height: 60px;
    }
    .dishInfo{
        margin-top: 20px;
    }
    .deleteDish{
        margin-top: 20px;
    }
    .addDish{
        text-align: center;
        align-items: center;
        margin-top: 20px;
    }
    .menu{
        height: max-content;
    }
    </style>