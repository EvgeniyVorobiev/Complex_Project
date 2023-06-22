<template>
    <body>
        <b-breadcrumb>
            <b-breadcrumb-item active><router-link to="/" id="toMain">Главная</router-link></b-breadcrumb-item>
            <b-breadcrumb-item active><router-link to='/techCards' id="toTechCards">Технологические карты</router-link></b-breadcrumb-item>
            <b-breadcrumb-item active style="color: #000;">{{ this.dishCollection.name }}</b-breadcrumb-item>
        </b-breadcrumb>
        <h3>{{ this.dishCollection.name }}</h3>
    
        <div class="dishSetCards">
            <b-container class="container">
                <b-row class="row gy-5">
                    
                    <b-col cols="3" v-for="recipeBook in recipeBooks" :key="recipeBook.id">
                        <a class="cardSet" @click="showDishesForm">
                            <b-card
                            :img-src="recipeBook.imageLink"
                            img-alt="Image"
                            img-top
                            id="dishCardSet">
                                <div><b-card-text class="dishCardsTitle">{{recipeBook.name}}</b-card-text></div>
                            </b-card>
                        </a>
                    </b-col>
                    
    
                    <b-col cols="3" v-if="userIsAuthorised">
                        <a class="cardSet" @click="showRecipeBookCreation">
                            <b-card
                            id="dishCardSet">
                                <b-icon-plus style="height: 134px; width: 134px;" class="plus-icon"></b-icon-plus>
                                <div><b-card-text class="dishCardsTitle">Создать сборник рецептур</b-card-text></div>
                            </b-card>
                        </a>
                    </b-col>
                    
                </b-row>   
            </b-container>
        </div>
        <b-modal ref="dishes" hide-footer hide-header>
                                <div class="container" id="dishesForm">
                                    <div class="row">
                                            <div class="col-11">
                                                <h2>Блюда из вареных яиц</h2>
                                            </div>
                                            <div class="col-1" id="closeDiv">
                                            <b-icon class="close" icon="x-lg" @click="hideDishesForm"></b-icon>
                                            </div>
                                            <!-- <b-icon icon="x-lg" style="width: 30px; height: 30px; color:lightgray;"></b-icon> -->
    
                                    </div>
                                </div>
                                
                                        <b-card>
                                        <b-card-img src="https://pbprog.ru/tk/img/tehnokarta/bluda/1.jpg"
                                        img-alt="Image"
                                        img-top></b-card-img>
                                        <div class="col-6">
                                            kkk
                                        </div>
                                        <div class="col-6">
                                            kkk
                                        </div>
                                        </b-card>
    
    
                            </b-modal>
    
    
                            <b-modal ref="recipeBook-Creation" hide-footer hide-header>
                                <b-container class="container" id="recipeBook">
                                    <b-row align-h="center" class="row">
                                            <b-col cols="11">
                                                <h3>Создание сборника рецептур</h3>
                                            </b-col>
                                            <b-col cols="1" id="closeDiv">
                                            <b-icon class="close" icon="x-lg" @click="hideRecipeBookCreation"></b-icon>
                                            </b-col>
                                        
                                            <div class="recipeBookImage">
                                                <b-img :src=" this.selectedImage "></b-img>
                                            </div>
    
                                            <div>
                                                <b-button v-b-toggle.sidebar-1 class="slideBtn">Выбрать изображение</b-button>
                                                    <b-sidebar ref="slidebar" id="sidebar-1" title="Изображения" shadow>
                                                        <div class="px-3 py-2">
    
                                                            <b-row v-for="image in images" :key="image.image_id">
                                                                <div class="image">
                                                                    <b-img :src=" image.image_link " @click="clickImage(image.image_link)">
                                                                    </b-img>
                                                                </div>
                                                            </b-row>
    
                                                        </div>
                                                     </b-sidebar>
                                            </div>
    
                                        <b-col cols="10">
                                            <b-form-input v-model="recipeBookName" type="text" id="recipeBookName"
                                             placeholder="Введите название сборника рецептур" value=""></b-form-input>
                                        </b-col>
    
    
                                        <b-col cols="8">
                                            <b-button id="recipeBookCreateButton" block pill variant="primary" @click="createRecipeBook">Создать</b-button>
                                        </b-col>
                                    </b-row>
                                </b-container>
                            </b-modal>
    </body>
    </template>
    
    <script>
    import axios from 'axios';
    
    export default {
    
        data (){
        return {
            id: this.$route.params['id'],
            dishCollection: null,
            images: [],
            recipeBooks: [],
            selectedImage: null,
            image_link: null
            }
        },
        watch: {
                $route(toRoute){
                this.id - toRoute.params['id']
            }
    },
        props:{
            authorisedUser: null,
            userIsAuthorised: null,
            
        },
        methods: {
            imagesLoad(){
                for (let index = 1; index < 47; index++) {
                    this.images.push({image_id: index, image_link: 'https://pbprog.ru/tk/img/tehnokarta/bluda/'+ index +'.jpg'});
                }
                console.log(this.images);
            },
            showDishesForm(){
                this.$refs['dishes'].show()
            },
            hideDishesForm(){
                this.$refs['dishes'].hide()
            },
            showRecipeBookCreation(){
                this.selectedImage = null;
                this.$refs['recipeBook-Creation'].show()
            },
            hideRecipeBookCreation(){
                this.$refs['recipeBook-Creation'].hide()
            },
            clickImage(image){
                this.selectedImage = image;
                console.log(this.selectedImage);
                this.$refs['slidebar'].hide()
            },
            getAllRecipeBooks(){
                this.recipeBooks = [];
                axios.get("http://localhost:8080/recipeBook/AllRecipeBooks").
                then(response =>{
                    response.data.forEach(responseElement => {
                        this.recipeBooks.push(responseElement);
                    });
                })
                .catch(() =>{
                    this.makeToast('danger', 'Произошла ошибка при загрузке сборников рецептур')
                })
            },
            createRecipeBook(){
                if (this.selectedImage != null && this.recipeBookName != null){
                    axios.post("http://localhost:8080/recipeBook/create", {'name':this.recipeBookName, 'imageLink':this.selectedImage,
                    'idDishCollection':this.dishCollection})
                    .then(() =>{
                        this.makeToast('success', 'Сборник рецептур "' + this.recipeBookName + '" создан')
                        this.getAllRecipeBooks();
                        this.hideRecipeBookCreation();
                    })
                    .catch(() =>{
                        this.makeToast('danger', 'Произошла ошибка при создании сборника рецептур')
                    })
                }
                else{
                    this.makeToast('danger', 'Для создания сборника рецептур необходимо указать название сборника и выбрать изображение')
                }
            },
            makeToast(variant = null, text) {
                    this.$bvToast.toast(text, {
                    title: `Детский сад. Питание`,
                    variant: variant,
                    autoHideDelay: 5000,
                    solid: true
                })
            },
            dishCollectionInfoLoad(){
                axios.get("http://localhost:8080/dishCollection/" + this.id)
                .then(response => {
                    this.dishCollection = response.data;
                })
                .catch(() => {
                    this.makeToast('danger', 'Произошла ошибка при загрузке сборника блюд')
                })
            }
    },
    mounted(){
        this.dishCollectionInfoLoad();
        this.imagesLoad();
        this.getAllRecipeBooks();
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
    .dishSetCards{
        padding-top: 0px;
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
    .recipeBookImage{
        margin-top:30px;
        box-shadow: 0 5px 20px 0 rgba(0,0,0,0.2);
        border-radius: 5px;
        height:155px;
        width:278px;
    }
    .image{
        margin-top:30px;
        box-shadow: 0 5px 20px 0 rgba(0,0,0,0.2);
        border-radius: 5px;
        height:155px;
        width:278px;
        cursor: pointer;
    }
    .slideBtn{
        margin-top: 20px;
    }
    #recipeBookName{
        margin-top:40px;
    }
    #recipeBookCreateButton{
        margin-top:40px;
    }
    </style>