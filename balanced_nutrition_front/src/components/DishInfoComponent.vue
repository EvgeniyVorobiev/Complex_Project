<template>
<body>
    <b-breadcrumb>
        <b-breadcrumb-item active><a href="/" id="to">Главная</a></b-breadcrumb-item>
        <b-breadcrumb-item active><a id="to" href='/techCards'>Технологические карты</a></b-breadcrumb-item>
        <b-breadcrumb-item active><a id="to" href='/dishSetCards'>788 Блюд для ДОО, Москва</a></b-breadcrumb-item>
        <b-breadcrumb-item active style="color: #000;">Блюдо</b-breadcrumb-item>
    </b-breadcrumb>

    <div class="col-8" id="dishCard">
    <b-card
        img-src="https://pbprog.ru/tk/img/tehnokarta/bluda/50_.jpg"
        img-alt="Image"
        img-top>
        <b-card-text class="dishTitle"><h3>Блюдо</h3></b-card-text>
        <div class="row">
            <div class="col-2">Вес блюда</div>
            <div class="col-3"><b-form-input v-model="text" placeholder="100 г"></b-form-input></div>
            <div class="col-2"><b-button pill variant="outline-primary">пересчитать</b-button></div>
        </div>
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
    </div>

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
                    {Продукт: '<a class="product" href="/productInfo">продукт</a>', 'Брутто, г': '100', 'Нетто, г': '100'}
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