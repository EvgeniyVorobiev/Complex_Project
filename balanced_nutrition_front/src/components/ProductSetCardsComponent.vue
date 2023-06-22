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
                    <b-col cols="3" v-for="productCollection in productCollections" :key="productCollection.id">
                        <a class="cardSet" @click="showProductsForm">
                            <b-card
                            :img-src="productCollection.imageLink"
                            img-alt="Image"
                            img-top
                            id="productCardSet">
                                <div><b-card-text class="dishCardsTitle">{{productCollection.name}}</b-card-text></div>
                            </b-card>
                        </a>
                    </b-col>
                    

                    
                    <b-col cols="3" v-if="userIsAuthorised">
                        <a class="cardSet" @click="showProductCollectionCreation">
                            <b-card
                            id="dishCardSet">
                                <b-icon-plus style="height: 134px; width: 134px;" class="plus-icon"></b-icon-plus>
                                <div><b-card-text class="productCardsTitle">Создать сборник продуктов</b-card-text></div>
                            </b-card>
                        </a>
                    </b-col>
                    
                </b-row>   
            </b-container>
        </div>
        <b-modal ref="products" hide-footer hide-header>
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

                                        <div class="col-6">
                                            продукт1
                                        </div>
                                        <div class="col-6">
                                            продукт2
                                        </div>
                                        </b-card>
    
    
                            </b-modal>



                            <b-modal ref="productCollection-Creation" hide-footer hide-header>
                                <b-container class="container" id="productCollection">
                                    <b-row align-h="center" class="row">
                                            <b-col cols="11">
                                                <h3>Создание сборника продуктов</h3>
                                            </b-col>
                                            <b-col cols="1" id="closeDiv">
                                            <b-icon class="close" icon="x-lg" @click="hideProductCollectionCreation"></b-icon>
                                            </b-col>
                                        
                                            <div class="productCollectionImage">
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
                                            <b-form-input v-model="productCollectionName" type="text" id="productCollectionName"
                                             placeholder="Введите название сборника продуктов" value=""></b-form-input>
                                        </b-col>
    
    
                                        <b-col cols="8">
                                            <b-button id="productCollectionCreateButton" block pill variant="primary" @click="createProductCollection">Создать</b-button>
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
        images: [],
        productCollections: [],
        selectedImage: null,
        image_link: null
    };
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
            getProductCollections(){
                this.productCollections = [];
                axios.get("http://localhost:8080/productCollection/AllProductCollections").
                then(response =>{
                    response.data.forEach(responseElement => {
                        this.productCollections.push(responseElement);
                    });
                })
                .catch(() =>{
                    this.makeToast('danger', 'Произошла ошибка при загрузке сборников продуктов')
                })
            },
            createProductCollection(){
                if (this.selectedImage != null && this.productCollectionName != null){
                    axios.post("http://localhost:8080/productCollection/create", {'name':this.productCollectionName, 'imageLink':this.selectedImage,
                    'idUser':this.authorisedUser})
                    .then(() =>{
                        this.makeToast('success', 'Сборник продуктов "' + this.productCollectionName + '" создан')
                        this.getProductCollections();
                        this.hideProductCollectionCreation();
                    })
                    .catch(() =>{
                        this.makeToast('danger', 'Произошла ошибка при создании сборника продуктов');
                    })
                }
                else{
                    this.makeToast('danger', 'Для создания сборника продуктов необходимо указать название сборника и выбрать изображение')
                }
            },
            clickImage(image){
                this.selectedImage = image;
                console.log(this.selectedImage);
                this.$refs['slidebar'].hide()
            },
            makeToast(variant = null, text) {
                    this.$bvToast.toast(text, {
                    title: `Детский сад. Питание`,
                    variant: variant,
                    autoHideDelay: 2500,
                    solid: true
                })
            },
            showProductsForm(){
                this.$refs['products'].show()
            },
            hideProductsForm(){
                this.$refs['products'].hide()
            },
            showProductCollectionCreation(){
                this.$refs['productCollection-Creation'].show()
            },
            hideProductCollectionCreation(){
                this.$refs['productCollection-Creation'].hide()
            },
    },
    mounted(){
        this.imagesLoad();
        this.getProductCollections();
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
    .productCollectionImage{
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
    #productCollectionName{
        margin-top:40px;
    }
    #productCollectionCreateButton{
        margin-top:40px;
    }
    </style>