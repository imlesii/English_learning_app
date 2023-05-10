package a.svitina.english_learning_for_developers.theory
import a.svitina.english_learning_for_developers.theory.WhereToGo.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import androidx.navigation.*
import androidx.navigation.compose.*
private val LINKS = object {
    val whyItIsImportant = "why-it-is-important"
    val simple = "simple-examples"
    val complex = "complex-examples"
}
@Composable
private fun Header(text: String) {
    Text(text = text, fontSize = 32.sp, fontWeight = FontWeight.Bold)
}
@Composable
private fun SubHeader(text: String) {
    Text(text = text, fontSize = 20.sp, fontWeight = FontWeight.Bold);
}
private val CONTENT = object {
    @Composable
    fun WhyItIsImportant() {
        Header("Почему так важно знать английский программисту?")
        Text("Для программистов из России важно знать английский язык по нескольким причинам:")
        SubHeader("1. Понимание документации и ресурсов")
        Text(
            """
            Многие языки программирования, фреймворки и инструменты имеют обширную документацию и ресурсы на английском языке. 
            Знание английского языка позволяет российским программистам получить доступ к этим ресурсам и лучше понять, как 
            эффективно использовать инструменты.
        """.trimIndent()
        )
        SubHeader("2. Общение с иностранными коллегами и клиентами")
        Text(
            """
            В условиях современной глобальной экономики многие программисты работают с коллегами и клиентами из разных стран. 
            Английский язык часто используется в качестве общего языка в таких ситуациях, и умение эффективно общаться на английском 
            языке может помочь российским программистам более слаженно работать со своими зарубежными коллегами.
        """.trimIndent()
        )
        SubHeader("3. Стандартизация и последовательность в коде")
        Text(
            """
            Английский язык широко используется как язык технологий и программирования, и многие языки программирования и фреймворки 
            имеют соглашения для именования объектов и сервисов на английском языке. Используя английские соглашения об именовании в 
            своем коде, российские разработчики могут помочь обеспечить последовательность и стандартизацию своего кода, что может 
            облегчить понимание и работу с кодом другим программистам.
        """.trimIndent()
        )
        SubHeader("4. Доступ к возможностям трудоустройства")
        Text(
            """
            Исходя из вышеописанных причин, многие технологические компании требуют от своих программистов хотя бы базового знания 
            английского языка, особенно если они работают над международными проектами или сотрудничают с коллегами из других стран. 
            Знание английского языка может помочь российским программистам получить больше возможностей для трудоустройства и 
            продвинуться по карьерной лестнице в технологической отрасли.
        """.trimIndent()
        )
        Text(
            """
            В целом, знание английского языка может помочь программистам из России писать более понятный код, обеспечивая 
            стандартизацию, ясность, доступ к документации и лучшее сотрудничество с зарубежными коллегами. В рамках данного 
            приложения мы расскажем вам о более правильном наименовании классов, сущностей и сервисом в вашем коде. При этом 
            подразумевается, что вы уже знакомы с понятием сущностей и сервисов.
        """.trimIndent()
        )
    }
    @Composable
    fun RulesForSimpleEntities() {

        Header("Правила именования сущностей")
        Text(
            """
            При именовании классов сущностей важно использовать описательные имена, которые точно отражают назначение класса. Вот 
            несколько лучших практик, которым следует следовать при именовании классов сущностей:
        """.trimIndent()
        )
        Text(
            """
            Используйте существительные единственного числа для имен классов: классы сущностей обычно представляют один объект или
            сущность, поэтому для названия класса лучше использовать существительное в единственном числе. Например, используйте
            "Customer" вместо "Customers"
        """.trimIndent()
        )
        Text(
            """
            Не стоит использовать аббревиатуры, которые не являются общепринятыми. Так, например, стоит написать "CustomerAddress"
            вместо "CustomerAddr".
        """.trimIndent()
        )
        Text(
            """
            Используйте описательные имена: выбирайте имена, которые точно описывают назначение сущности в вашем приложении.
            Так, например, в зависимости от контекста, сущность "продажа" может быть переведена несколькими способами:
        """.trimIndent()
        )
        Text(
            """
            — "Sale" - это наиболее распространенный перевод слова "продажа", который используется в контексте коммерции или
            бизнеса, где товары или услуги продаются клиентам.
        """.trimIndent()
        )
        Text(
            """
            — "Selling" - это ещё один возможный перевод слова "продажа", который может использоваться в контексте процесса
            или стратегии продаж. Например, "улучшение процесса продажи" ("SellingProcessImproving").
        """.trimIndent()
        )
        Text(
            """
            — "Deal" - "продажа" также может быть переведена как "сделка", что означает сделку или соглашение
            между двумя сторонами. Так же, например, слово "товар" может быть переведён как:
        """.trimIndent()
        )

        Text(
            """
            — "Goods" относится именно к перевозимым или отправляемым товарам. Это может быть использовано
            в контексте логистики или управления цепочками поставок.
        """.trimIndent()
        )
        Text(
            """
            — "Product" используется в контексте коммерции или бизнеса, где товары или услуги продаются клиентам.
        """.trimIndent()
        )
        Text(
            """
            — "Item" относится к физическому объекту или предмету. Это может быть использовано в контексте управления
            запасами или каталогов продукции.
        """.trimIndent()
        )
    }
    @Composable
    fun RulesForComplexEntities() {
        Header("Именования сущностей, состоящих из нескольких слов")
        Text(
            """
            Часто бывает, что помимо основной сущности требуется создать дополнительные-как бы вспомогательные.
            Например есть заказ - "Order" - и есть его описание - "Detail". Когда требуется дать сущности наименование -
            наименование основной сущности ставится впереди, а остальное - сзади. Так например, сущность “Детали заказа”
            лучше перевести как "OrderDetail", а не как "DetailOrder".
        """.trimIndent()
        )
        Text(
            """
            По началу может быть полезно пользоваться переводчиком - переводить английские наименования на русский
            и проверять, как они будут переведены. Так, "Order detail" переводится как "Детали заказа",
            а "Detail Order" переводится как "Детальный заказ"
        """.trimIndent()
        )
        Text(
            """
            Если же нужно перевести что-то более сложное, например "Документ рекомендаций по разработке цен", то здесь
            стоит более детально подойти к наименованию сущности, ибо вероятность совершить ошибку больше, а ошибки могут
            приводить к недопонимаю. Так, например, можно перевести сущность как "DocumentRecomendationForDevelopmentPrice" однако, это будет неверное
            наименование, ибо обратный перевод будет таким: "Рекомендация документа по цене разработки". Правильное же
            наименование будет следующим - "RecomendationDocumentForPriceDevelopment" либо, если опустить "For", -
            "PriceDevelopmentRecomendationDocument". Так, у нас есть "Документ рекомендаций" как "RecomendationDocument"
            для разработки цен "PriceDevelopment", где разработка цен является главной сущностью по отношению к документу рекомендаций.
            Даже если отдельной сущности "PriceDevelopment" в нашей программе нет, если она была бы, она являлась бы главной.
        """.trimIndent()
        )
    }
}
@Composable
fun Theory(navGoToRoot: () -> Unit, navGoToTests: () -> Unit) {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = LINKS.whyItIsImportant) {
        composable(LINKS.whyItIsImportant) {
            TheoryPage(
                prevBtn = {
                    Button(onClick = navGoToRoot) {
                        Text(text = "В меню")
                    }
                },
                nextBtn = {
                    BtnGo(Forward, nav, LINKS.simple)
                },
                content = { CONTENT.WhyItIsImportant() }
            )
        }
        composable(LINKS.simple) {
            TheoryPage(
                prevBtn = {
                    BtnGo(Back, nav, LINKS.whyItIsImportant)
                },
                nextBtn = {
                    BtnGo(Forward, nav, LINKS.complex)
                },
                content = { CONTENT.RulesForSimpleEntities() }
            )
        }
        composable(LINKS.complex) {
            TheoryPage(
                prevBtn = {
                    BtnGo(Back, nav, LINKS.simple)
                },
                nextBtn = {
                    Button(onClick = navGoToTests) {
                        Text(text = "К тестам!")
                    }
                },
                content = { CONTENT.RulesForComplexEntities() }
            )
        }
    }
}
private enum class WhereToGo {
    Back, Forward
}
@Composable
private fun BtnGo(whereToGo: WhereToGo, nav: NavHostController, route: String) {
    Button(onClick = { nav.navigate(route) }) {
        Icon(
            imageVector = when (whereToGo) {
                Back -> Icons.Outlined.KeyboardArrowLeft
                Forward -> Icons.Outlined.KeyboardArrowRight
            },
            contentDescription = route
        )
    }
}
@Composable
private fun TheoryPage(
    prevBtn: (@Composable () -> Unit)? = null,
    nextBtn: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        content()
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            if (prevBtn != null) {
                prevBtn()
            }
            Box {}
            if (nextBtn != null) {
                nextBtn()
            }
        }
    }
}