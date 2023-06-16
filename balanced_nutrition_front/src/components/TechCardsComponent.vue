<template>
<body>
    <b-breadcrumb>
        <b-breadcrumb-item active><a href="/" id="toMain">Главная</a></b-breadcrumb-item>
        <b-breadcrumb-item active style="color: black;">Технологические карты</b-breadcrumb-item>
    </b-breadcrumb>
    <h3>Технологические карты блюд</h3>
    <div class="searchDishes">
        <div class="container">
            <div class="row">
                <div class="col-xs-11 col-sm-11 col-md-11">
                    <b-form-input type="text" placeholder="Введите название блюда" value=""></b-form-input>
                </div>
                <div class="col-xs-1 col-sm-1 col-md-1">
                    <b-button pill variant="light"><b-icon icon="search"></b-icon></b-button>
                </div>
            </div>
            <div class="row" id="filter">
                <div class="col-xs-1 col-sm-2 col-md-2">Способ приготовления:</div>
                <div class="col-xs-2 col-sm-3 col-md-3"><b-form-select class="form-select" v-model="selectedDishProcessing" :options="options"></b-form-select></div>
                <div class="col-xs-1 col-sm-2 col-md-2" style="text-align: center;">Вес блюда от </div>
                <div class="col-xs-1 col-sm-1 col-md-1"><b-form-input v-model="text"></b-form-input></div>
                <div class="col-xs-1 col-sm-1 col-md-1" style="text-align: center;">до</div>
                <div class="col-xs-1 col-sm-1 col-md-1"><b-form-input v-model="text"></b-form-input></div>
            </div>
            <div class="row gy-5" id="dishes">
                <div class="col-xs-12 col-sm-6 col-md-3">
                    <a class="dish" href="/dishInfo">
                        <b-card
                        img-src="https://pbprog.ru/tk/img/tehnokarta/bluda/1.jpg"
                        img-alt="Image"
                        img-top
                        id="dish">
                            <div><b-card-text class="dishCardsTitle">Блюдо</b-card-text></div>
                        </b-card>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <h3 class="dishSets">Сборники блюд</h3>
    <div class="dishCards">
    <div class="container">
        <div class="row gy-5">
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="p-3" id="dishCardSet">
                    <a class="cardSet" href="/dishSetCards">    
                        <p class="dishNumber">788</p>
                        <div><p class="dishCardsTitle">Блюд для ДОО, Москва</p></div>
                    </a>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="p-3" id="dishCardSet">
                    <a class="cardSet" href="/dishSetCards">    
                        <p class="dishNumber">788</p>
                        <div><p class="dishCardsTitle">Блюд для ДОО, Москва</p></div>
                    </a>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="p-3" id="dishCardSet">
                    <a class="cardSet" href="/dishSetCards">    
                        <p class="dishNumber">788</p>
                        <div><p class="dishCardsTitle">Блюд для ДОО, Москва</p></div>
                    </a>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="p-3" id="dishCardSet">
                    <a class="cardSet" href="/dishSetCards">    
                        <p class="dishNumber">788</p>
                        <div><p class="dishCardsTitle">Блюд для ДОО, Москва</p></div>
                    </a>
                </div>
            </div>
        </div>
    </div>
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
    padding-top: 30px;
    
}


#dishCardSet{
    box-shadow: 0 5px 20px 0 rgba(0,0,0,0.2);
    border-radius: 5px;
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