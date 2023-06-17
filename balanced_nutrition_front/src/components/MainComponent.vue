<template>
    <body>
        <h1>{{roleName}}</h1>
        <div class="container">
            <div class="row">
                <div class="col-8 gy-5 gx-5" >
                    <b-tabs>
                        <b-tab title="Плановое меню" @click="fetchRole">
                            <div>
  <b-card no-body>
    <b-tabs pills card vertical nav-wrapper-class="w-50">
      <b-tab title="Tab 1" active><b-card-text>Tab contents 1</b-card-text></b-tab>
      <b-tab title="Tab 2"><b-card-text>Tab contents 2</b-card-text></b-tab>
      <b-tab title="Tab 3"><b-card-text>Tab contents 3</b-card-text></b-tab>
    </b-tabs>
  </b-card>
</div>
                    <div class="" id="table">
                        <!-- <b-table hover :items="items1"></b-table> -->
                    </div>
                    </b-tab>
                       <b-tab title="Плановое меню"></b-tab>
                          <b-tab title="Плановое меню"></b-tab>
                          <b-tab title="Плановое меню"></b-tab>
                          <b-tab title="Плановое меню"></b-tab>
                          <b-tab title="Плановое меню"></b-tab>
                          <b-tab title="Плановое меню"></b-tab>
                          <b-tab title="Плановое меню"></b-tab>
                          <b-tab title="Плановое меню"></b-tab>
                    </b-tabs>
                </div>
                <div class="col-4 gy-5 gx-5">
                    <b-tabs>
                        <b-tab title="Питательные вещества">
                    <div class="" id="nutrients">
                        <b-table hover :items="items2"></b-table>
                        
                    </div>
                        </b-tab>
                        <b-tab title="Объёмы блюд">
                            <div class="" id="nutrients">
                                <!-- <b-table hover :items="items2"></b-table> -->
                        
                            </div>
                        </b-tab>
                    </b-tabs>
                </div>
            </div>
        </div>
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
        box-shadow: 0 5px 30px 0 rgba(0,0,0,0.2);
    }
    #nutrients{
        height: 450px;
        box-shadow: 0 5px 30px 0 rgba(0,0,0,0.2);
        margin-left:auto;
    }
    </style>