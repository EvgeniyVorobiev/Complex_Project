<template>
<body>
    <b-breadcrumb>
        <b-breadcrumb-item active><router-link to="/" id="toMain">Главная</router-link></b-breadcrumb-item>
        <b-breadcrumb-item active style="color: black;">Технологические карты</b-breadcrumb-item>
    </b-breadcrumb>
    <h3>Технологические карты блюд</h3>
    <div class="searchDishes">
        <b-container class="container">
            <b-row class="row">
                <b-col cols="11">
                    <b-form-input type="text" placeholder="Введите название блюда" value=""></b-form-input>
                </b-col>
                <b-col cols="1">
                    <b-button pill variant="light"><b-icon icon="search"></b-icon></b-button>
                </b-col>
            </b-row>
            <b-row class="row" id="filter">
                <b-col cols="2">Способ приготовления:</b-col>
                <b-col cols="3"><b-form-select class="form-select" v-model="selectedDishProcessing" :options="options"></b-form-select></b-col>
                <b-col cols="2" style="text-align: center;">Вес блюда от </b-col>
                <b-col cols="1"><b-form-input v-model="text"></b-form-input></b-col>
                <b-col cols="1"><p> г.</p></b-col>
                <b-col cols="1" style="text-align: center;">до</b-col>
                <b-col cols="1"><b-form-input v-model="text"></b-form-input></b-col>
                <b-col cols="1"><p> г.</p></b-col>
            </b-row>
            <b-row class="row gy-5" id="dishes">
                <b-col cols="3">
                    <router-link to="/dishInfo" class="dish">
                        <b-card
                        img-src="https://pbprog.ru/tk/img/tehnokarta/bluda/1.jpg"
                        img-alt="Image"
                        img-top
                        id="dish">
                            <div><b-card-text class="dishCardsTitle">Блюдо</b-card-text></div>
                        </b-card>
                    </router-link>
                </b-col>
            </b-row>
        </b-container>
    </div>
    <h3 class="dishSets">Сборники блюд</h3>
    <div class="dishCards">
    <b-container class="container">
        <b-row class="row gy-5">
            
            <b-col cols="4" v-for="dishCollection in this.dishCollections" :key="dishCollection.dishCollection.id">
                <div class="p-3" id="dishCardSet">
                    <router-link to="/dishSetCards" class="cardSet">    
                        <p class="dishNumber">{{dishCollection.numberOfDishes}}</p>
                        <div><p class="dishCardsTitle">{{dishCollection.dishCollection.name}}</p></div>
                    </router-link>
                </div>
            </b-col>

            
            <b-col cols="4" v-if="userIsAuthorised">
                <div class="p-3" id="dishCardSet">
                    <a class="cardSet" @click="showDishCollectionCreation">    
                        <p class="dishNumber"><b-icon-plus-lg style=""></b-icon-plus-lg></p>
                        <div><p class="dishCardsTitle">Создать сборник блюд</p></div>
                    </a>
                </div>
            </b-col>

        </b-row>
    </b-container>
    </div>
    <div class="modal">
        <b-modal ref="dishCollection-Creation" hide-footer hide-header>
                            <b-container class="container" id="loginForm">
                                <b-row align-h="center" class="row">
                                        <b-col cols="11">
                                            <h3>Создание сборника блюд</h3>
                                        </b-col>
                                    
                                        <b-col cols="1" id="closeDiv">
                                        <b-icon class="close" icon="x-lg" @click="hideDishCollectionCreation"></b-icon>
                                        </b-col>


                                    <b-col cols="10">
                                        <b-form-input v-model="dishCollectionName" type="text" id="dishCollectionName"
                                         placeholder="Введите название сборника блюд" value=""></b-form-input>
                                    </b-col>


                                    <b-col cols="8">
                                        <b-button id="dishCollectionCreateButton" block pill variant="primary" @click="createDishCollection">Создать</b-button>
                                    </b-col>
                                </b-row>
                            </b-container>
                        </b-modal>

    </div>
</body>
</template>

<script>
import axios from 'axios';
    export default{
        data(){
        return {
            name: 'TechCardsComponents',
            selectedDishProcessing: null,
            options: [],
            dishCollections: [],
            
        }
        
    },
    props:{
        authorisedUser: null,
        userIsAuthorised: null,
    },
    methods:{
        makeToast(variant = null, text) {
                this.$bvToast.toast(text, {
                title: `Детский сад. Питание`,
                variant: variant,
                autoHideDelay: 5000,
                solid: true
            })
        },
        showDishCollectionCreation(){
            this.$refs['dishCollection-Creation'].show();
        },
        hideDishCollectionCreation(){
            this.$refs['dishCollection-Creation'].hide();
        },
        createDishCollection(){
            if (this.dishCollectionName != null){
                console.log(this.dishCollectionName);
                axios.post('http://localhost:8080/dishCollection/create', {'name':this.dishCollectionName, 'idUser': this.authorisedUser})
                .catch();
                this.hideDishCollectionCreation();
                this.makeToast('success', 'Сборник блюд ' +this.dishCollectionName + ' создан');
                this.$router.push('Main');
                this.$router.push('techCards');
            }
            else{
                this.makeToast('danger', 'Пожалуйста, укажите название для сборника блюд');
            }
        },
        getAllDishCollections(){
            this.dishCollections = [];
            var dishNumber = null;
            axios.get('http://localhost:8080/dishCollection/AllDishCollections')
            .then(response => {
                response.data.forEach(responseElement => {
                    //console.log(responseElement);
                    axios.get('http://localhost:8080/dishCollection/numberOfDishes/' + responseElement.id)
                    .then(response2 => {
                        //console.log(response2.data);
                        dishNumber = response2.data;
                        this.dishCollections.push({dishCollection: responseElement, numberOfDishes:  dishNumber});  
                    });
                })
                console.log(this.dishCollections);    
            })
            .catch(() =>{
                this.makeToast('danger', 'Произошла ошибка при загрузке сборников блюд')
            })
        }
    },
    mounted() {
        this.getAllDishCollections()
    },

    }
</script>

<style scoped>
#toMain{
    color:grey;
    text-decoration: none;
}
.searchDishes{
    padding-top: 15px;
}

#filter{
    margin-top: 30px;
}
#dishes{
    padding-top: 30px;
}
.dish{

    /* display: none; */
    text-decoration: none;
    color: black;
}
.dishSets{
    padding-top: 60px;
}
.dishCards{
    padding-top: 20px;
    padding-bottom: 100px;
    
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

#dishCardSet{
    box-shadow: 0 5px 20px 0 rgba(0,0,0,0.2);
    border-radius: 5px;
    margin-top: 30px;
    cursor: pointer;
}
.cardSet{
    text-decoration: none;
}
#dishCardSet:hover {
    background-color:#2a5fcb;
}
#dishCardSet:hover .dishNumber{
    color:white;
}
#dishCardSet:hover .dishCardsTitle{
    color: white;
}
.dishNumber{
    font-size:72px;
    color:#2a5fcb;
}
.dishCardsTitle{
    font-size: 15px;
    font-weight:350;
    color: black;
}

#dishCollectionName{
    margin-top:30px;
}
#dishCollectionCreateButton{
    margin-top:40px;
}
</style>