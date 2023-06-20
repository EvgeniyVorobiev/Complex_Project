<template>
<body>
    <b-breadcrumb>
        <b-breadcrumb-item active><router-link to="/" id="to">Главная</router-link></b-breadcrumb-item>
        <b-breadcrumb-item active><router-link to="/techCards" id="to">Технологические карты</router-link></b-breadcrumb-item>
        <b-breadcrumb-item active><router-link to="/dishSetCards" id="to">788 Блюд для ДОО, Москва</router-link></b-breadcrumb-item>
        <b-breadcrumb-item active style="color: #000;">Блюдо</b-breadcrumb-item>
    </b-breadcrumb>

    <b-col cols="10" id="dishCard">
    <b-card
        img-src="https://pbprog.ru/tk/img/tehnokarta/bluda/50_.jpg"
        img-alt="Image"
        img-top>
        <b-card-text class="dishTitle"><h3>Блюдо</h3></b-card-text>
        <b-row class="row">
            <b-col cols="2">Вес блюда</b-col>
            <b-col cols="3"><b-form-input v-model="text" placeholder="100 г"></b-form-input></b-col>
            <b-col cols="2"><b-button pill variant="outline-primary">пересчитать</b-button></b-col>
        </b-row>
        <b-card-text>Вид обработки: </b-card-text>
        <b-card-text class="dishProducts"><h5>Рецептура (раскладка продуктов) на 100 грамм нетто блюда</h5></b-card-text>
        <b-table hover :items="products">
            <template #cell(Продукт)="data">
                <span v-html="data.value"></span>
            </template>
        </b-table>
        <b-card-text class="dishTechnology"><h5>Технология приготовления</h5></b-card-text>
        <b-card-text>...</b-card-text>
        <b-card-text class="dishCharacteristic"><h5>Характеристика блюда на выходе</h5></b-card-text>
        <b-card-text>...</b-card-text>
        <b-card-text class="dishNutrients"><h5>Пищевая ценность, калорийность и химический состав блюда</h5></b-card-text>
        <b-table hover :items="nutrients"></b-table>
    </b-card>
    </b-col>

    <!-- <div class="container">
        <div class="row">
            <b-card>
                <div style="width: 100%; height: min-content;">
                    <b-card-img src="https://pbprog.ru/tk/img/tehnokarta/bluda/48_.jpg"
                        alt="Image"
                        top></b-card-img>
                </div>
            </b-card>
        </div>
    </div> -->
</body>
</template>

<script>
    export default{
        data(){
            return{
                name: 'dishInfo',
                products: [
                    {Продукт: '<router-link to="/productInfo" class="product">продукт</router-link>', 'Брутто, г': '100', 'Нетто, г': '100'}
                ],
                nutrients: [
                    {'Показатель': 'Белки, г', 'Содержание питательных веществ на 100 грамм блюда': 10},

                ]

            }
        }
    }
</script>

<style :scoped>
#to{
    color:gray;
    text-decoration: none;
}
.dishTitle{
    text-align: center;
}
#dishCard{
    padding-top: 30px;
    margin-left: auto;
    margin-right: auto;
}
.dishProducts{
    padding-top: 40px;
}
.product{
    cursor: pointer;
    text-decoration: none;
    color:black;
}

.dishTechnology{
    padding-top: 40px;
}
.dishCharacteristic{
    padding-top: 40px;
}
.dishNutrients{
    padding-top: 40px;
}
</style>