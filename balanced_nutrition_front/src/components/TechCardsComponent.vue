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
            <b-col cols="4">
                <div class="p-3" id="dishCardSet">
                    <router-link to="/dishSetCards" class="cardSet">    
                        <p class="dishNumber">788</p>
                        <div><p class="dishCardsTitle">Блюд для ДОО, Москва</p></div>
                    </router-link>
                </div>
            </b-col>
            <b-col cols="4">
                <div class="p-3" id="dishCardSet">
                    <a class="cardSet" href="/dishSetCards">    
                        <p class="dishNumber">788</p>
                        <div><p class="dishCardsTitle">Блюд для ДОО, Москва</p></div>
                    </a>
                </div>
            </b-col>
            
            <b-col cols="4">
                <div class="p-3" id="dishCardSet">
                    <a class="cardSet" href="/dishSetCards">    
                        <p class="dishNumber"><b-icon-plus-lg style=""></b-icon-plus-lg></p>
                        <div><p class="dishCardsTitle">Создать сборник блюд</p></div>
                    </a>
                </div>
            </b-col>
        </b-row>
    </b-container>
    </div>
</body>
</template>

<script>
    export default{
        data(){
        return {
            name: 'TechCardsComponents',
            selectedDishProcessing: null,
            options: [
                { value: null, text: 'Не выбран' },
                { value: 'a', text: 'Варка' },
                { value: 'b', text: 'Жарка' },
            ]
            
        }
        
    },
    methods:{

    }

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


#dishCardSet{
    box-shadow: 0 5px 20px 0 rgba(0,0,0,0.2);
    border-radius: 5px;
    margin-top: 30px;
    /* column-width: auto;
    height: auto; */
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
</style>