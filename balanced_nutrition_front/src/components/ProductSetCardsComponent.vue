<template>
    <body>
        <b-breadcrumb>
            <b-breadcrumb-item active><router-link to="/" id="toMain">Главная</router-link></b-breadcrumb-item>
            <b-breadcrumb-item active><router-link to='/techCards' id="toTechCards">Технологические карты</router-link></b-breadcrumb-item>
            <b-breadcrumb-item active style="color: #000;">Продукты</b-breadcrumb-item>
        </b-breadcrumb>
        <h3></h3>
    
        <div class="productSetCards">
            <b-container class="container">
                <b-row class="row gy-5">
                    <b-col cols="3">
                        <a class="cardSet" @click="showDishesForm">
                            <b-card
                            img-src="https://pbprog.ru/tk/img/tehnokarta/bluda/1.jpg"
                            img-alt="Image"
                            img-top
                            id="productCardSet">
                                <div><b-card-text class="dishCardsTitle">Продукты</b-card-text></div>
                            </b-card>
                        </a>
                    </b-col>
                    

                    
                    <b-col cols="3">
                        <a class="cardSet" @click="showDishesForm">
                            <b-card
                            id="dishCardSet">
                                <b-icon-plus style="height: 134px; width: 134px;" class="plus-icon"></b-icon-plus>
                                <div><b-card-text class="dishCardsTitle">Создать сборник продуктов</b-card-text></div>
                            </b-card>
                        </a>
                    </b-col>
                    
                </b-row>   
            </b-container>
        </div>
        <b-modal ref="dishes" hide-footer hide-header>
                                <div class="container" id="productsForm">
                                    <div class="row">
                                            <div class="col-11">
                                                <h2>Продукты</h2>
                                            </div>
                                            <div class="col-1" id="closeDiv">
                                            <b-icon class="close" icon="x-lg" @click="hideProductsForm"></b-icon>
                                            </div>
                                            <!-- <b-icon icon="x-lg" style="width: 30px; height: 30px; color:lightgray;"></b-icon> -->
    
                                    </div>
                                </div>
                                        <b-card>
                                        <b-card-img src="https://pbprog.ru/tk/img/tehnokarta/bluda/1.jpg"
                                        img-alt="Image"
                                        img-top></b-card-img>
                                        <div class="col-6">
                                            продукт1
                                        </div>
                                        <div class="col-6">
                                            продукт2
                                        </div>
                                        </b-card>
    
    
                            </b-modal>
    </body>
    </template>
    
    <script>
    export default {
    
    data (){
    return {
    
    };
    },
    methods: {
    showProductsForm(){
        this.$refs['dishes'].show()
    },
    hideProductsForm(){
        this.$refs['dishes'].hide()
    },
    
    }
    }
    </script>
    
    <style scoped>
    
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
    
    #toMain{
        color:grey;
        text-decoration: none;
    }
    #toTechCards{
        color:gray;
        text-decoration: none;
    }
    .productSetCards{
        padding-top: 30px;
        padding-bottom: 100px;
    }
    .card{
        margin-top: 30px;
    }
    .cardSet{
        text-decoration: none;
        color: black;
        cursor: pointer;
    }
    .plus-icon{
        text-align: center; 
        color: grey;
    }
    .cardSet:hover .plus-icon{
        color:black ;
    }
    </style>