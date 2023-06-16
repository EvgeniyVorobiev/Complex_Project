<template>
<body>
    <b-breadcrumb>
        <b-breadcrumb-item active><a href="/" id="toMain">Главная</a></b-breadcrumb-item>
        <b-breadcrumb-item active><a id="toTechCards" href='/techCards'>Технологические карты</a></b-breadcrumb-item>
        <b-breadcrumb-item active style="color: #000;">788 Блюд для ДОО, Москва</b-breadcrumb-item>
    </b-breadcrumb>
    <h3>788 Блюд для ДОО, Москва</h3>

    <div class="dishSetCards">
        <div class="container">
            <div class="row gy-5">
                <div class="col-xs-12 col-sm-6 col-md-3">
                    <a class="cardSet" @click="showDishesForm">
                        <b-card
                        img-src="https://pbprog.ru/tk/img/tehnokarta/bluda/1.jpg"
                        img-alt="Image"
                        img-top
                        id="dishCardSet">
                            <div><b-card-text class="dishCardsTitle">Блюда из вареных яиц</b-card-text></div>
                        </b-card>
                    </a>
                </div>
                
                <div class="col-xs-12 col-sm-6 col-md-3">
                    <a class="cardSet" href="">
                        <b-card
                        img-src="https://pbprog.ru/tk/img/tehnokarta/bluda/1.jpg"
                        img-alt="Image"
                        img-top
                        id="dishCardSet">
                            <div><b-card-text class="dishCardsTitle">Блюда из вареных яиц</b-card-text></div>
                        </b-card>
                    </a>
                </div>  
            </div>   
        </div>
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
</body>
</template>

<script>
export default {

data (){
return {

};
},
methods: {
showDishesForm(){
    this.$refs['dishes'].show()
},
hideDishesForm(){
    this.$refs['dishes'].hide()
},

}
}
</script>

<style scoped>

#closeDiv{
    position: absolute;
    left: 100%;
}
:hover .closeDiv{
    color:whitesmoke;
}
.close{
    /* top: -2%; */
    cursor: pointer;
    /* width: 60px; 
    height: 60px;  */
    color:lightgray;
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
    padding-top: 30px;
}
.cardSet{
    text-decoration: none;
    color: black;
    cursor: pointer;
}
</style>