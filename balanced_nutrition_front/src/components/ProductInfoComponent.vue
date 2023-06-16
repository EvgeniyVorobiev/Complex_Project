<template>
<body>
    <b-breadcrumb>
        <b-breadcrumb-item active><a href="/" id="to">Главная</a></b-breadcrumb-item>
        <b-breadcrumb-item active><a id="to" href='/techCards'>Технологические карты</a></b-breadcrumb-item>
        <b-breadcrumb-item active><a id="to" href=''>Продукты</a></b-breadcrumb-item>
        <b-breadcrumb-item active style="color: #000;">Продукт</b-breadcrumb-item>
    </b-breadcrumb>

    <div class="col-8" id="dishCard">
    <b-card
        img-src="https://pbprog.ru/tk/img/tehnokarta/bluda/47_.jpg"
        img-alt="Image"
        img-top>
        <b-card-text class="productTitle"><h3>Продукт</h3></b-card-text>
        <b-card-text class="shelfLife">Срок хранения: </b-card-text>
        <b-card-text class="measure">Единица измерения: </b-card-text>
        <div class="row">
            <div class="col-2">Вес продукта</div>
            <div class="col-3"><b-form-input v-model="text" placeholder="100 г"></b-form-input></div>
            <div class="col-2"><b-button pill variant="outline-primary">пересчитать</b-button></div>
        </div>
        <b-card-text class="dishNutrients"><h5>Пищевая ценность, калорийность и химический состав продукта</h5></b-card-text>
        <b-table hover :items="nutrients"></b-table>
    </b-card>
    </div>

</body>
</template>

<script>
    export default{
        data(){
            return{
                name: 'productInfo',
                nutrients: [
                    {'Показатель': 'Белки, г', 'Содержание питательных веществ на 100 грамм продукта': 10},

                ]

            }
        }
    }
</script>

<style scoped>
.productTitle{
    text-align: center;
}
.shelfLife{
    padding-top: 30px;
}
.measure{
    padding-top: 30px;
}
.row{
    padding-top: 30px;
}
</style>