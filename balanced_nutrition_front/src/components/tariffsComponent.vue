<template>
    <body>
    <b-breadcrumb>
        <b-breadcrumb-item active><a href="/" id="toMain">Главная</a></b-breadcrumb-item>
        <b-breadcrumb-item active style="color: black;">Тарифы</b-breadcrumb-item>
    </b-breadcrumb>
    <h3>Тарифы</h3>
    <div class="tariffs">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-6 col-md-4 mx-auto my-0" id="tariff">
                        <h4>Безлимит</h4>
                        <div class="text">
                        <p>Использование технологических карт без ограничения (разглашается только содержимое карт,
                            добавленных в меню).</p>
                        <p>Добавление своих технологических карт.</p>
                        </div>
                        <!-- <b-button variant="primary" class="button">Купить</b-button> -->
                </div>
                <div class="col-xs-12 col-sm-6 col-md-4 mx-auto" id="tariff">
                        <h4>Люкс Безлимит</h4>
                        <div class="text">
                        <p>Использование технологических карт без ограничения (разглашается только содержимое карт,
                            добавленных в меню).</p>
                        <p>Добавление своих технологических карт.</p>
                        <p>Распечатка отчетов по шаблонам пользователей (метки в файле docx).</p>
                        </div>
                        <!-- <b-button variant="primary" class="button">Купить</b-button> -->
                </div>
            </div>
        </div>
    </div>
</body>
</template>

<script>

</script>

<style scoped>
#toMain{
    color:grey;
    text-decoration: none;
}
#tariff{
    box-shadow: 0 5px 30px 0 rgba(0,0,0,0.2);
    border-radius: 10px;
    /* text-align: center; */
}
/* .button{
    margin-bottom: 100px;

}
.text{
    margin-top: 25px;
    text-align:start;
}
.row{
    padding-top: 15px;
} */
</style>