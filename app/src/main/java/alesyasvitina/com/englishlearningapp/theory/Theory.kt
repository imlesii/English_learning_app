package a.svitina.english_learning_for_developers.theory

import a.svitina.english_learning_for_developers.theory.WhereToGo.Back
import a.svitina.english_learning_for_developers.theory.WhereToGo.Forward
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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
        Header("Почему важно знать английский")
        Text("Для разработчиков из России важно знать английский язык по нескольким причинам:")
        SubHeader("1. Понимание документации и ресурсов")
        Text(
            """
            Многие языки программирования, фреймворки и инструменты имеют обширную документацию и ресурсы на английском языке. 
            Знание английского языка позволяет российским разработчикам получить доступ к этим ресурсам и лучше понять, как 
            эффективно использовать инструменты.
        """.trimIndent()
        )
        SubHeader("2. Общение с иностранными коллегами и клиентами")
        Text(
            """
            В условиях современной глобальной экономики многие разработчики работают с коллегами и клиентами из разных стран. 
            Английский язык часто используется в качестве общего языка в таких ситуациях, и умение эффективно общаться на английском 
            языке может помочь российским разработчикам более слаженно работать со своими зарубежными коллегами.
        """.trimIndent()
        )
        SubHeader("3. Стандартизация и последовательность в коде")
        Text(
            """
            Английский язык широко используется как язык технологий и программирования, и многие языки программирования и фреймворки 
            имеют соглашения для именования объектов и сервисов на английском языке. Используя английские соглашения об именовании в 
            своем коде, российские разработчики могут помочь обеспечить последовательность и стандартизацию своего кода, что может 
            облегчить понимание и работу с кодом другим разработчикам.
        """.trimIndent()
        )
        SubHeader("4. Доступ к возможностям трудоустройства")
        Text(
            """
            Исходя из вышеописанных причин, многие технологические компании требуют от своих разработчиков хотя бы базового знания 
            английского языка, особенно если они работают над международными проектами или сотрудничают с коллегами из других стран. 
            Знание английского языка может помочь российским разработчикам получить больше возможностей для трудоустройства и 
            продвинуться по карьерной лестнице в технологической отрасли.
        """.trimIndent()
        )
        Text(
            """
            В целом, знание английского языка может помочь разработчикам из России писать более понятный код, обеспечивая 
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
            Используйте существительные единственного числа для имен классов: Классы сущностей обычно представляют один объект или
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
            Используйте описательные имена: Выбирайте имена, которые точно описывают назначение сущности в вашем приложении.
            Так, например, в зависимости от контекста, сущность “Продажа” может быть переведена несколькими способами:
        """.trimIndent()
        )
        Text(
            """
            —"Sale" - Это наиболее распространенный перевод слова "Продажа", который используется в контексте коммерции или
            бизнеса, где товары или услуги продаются клиентам.
        """.trimIndent()
        )
        Text(
            """
            —"Selling" - Это еще один возможный перевод слова "Продажа", который может использоваться в контексте процесса
            или стратегии продаж.Например, "Улучшение процесса продажи" ("SellingProcessImproving").
        """.trimIndent()
        )
        Text(
            """
            —"Deal" - "Продажа" также может быть переведена как "Сделка", что означает сделку или соглашение
            между двумя сторонами.Так же, например, слово “Товар” может быть переведён как:
        """.trimIndent()
        )

        Text(
            """
            —"Goods" - относится именно к перевозимым или отправляемым товарам.Это может быть использовано
            в контексте логистики или управления цепочками поставок.
        """.trimIndent()
        )
        Text(
            """
            —"Product" - используется в контексте коммерции или бизнеса, где товары или услуги продаются клиентам.
        """.trimIndent()
        )
        Text(
            """
            —"Item" - относится к физическому объекту или предмету . Это может быть использовано в контексте управления
            запасами или каталогов продукции .
        """.trimIndent()
        )
    }

    @Composable
    fun RulesForComplexEntities() {
        Header("Именования сущностей, состоящих из нескольких слов")
        Text(
            """
            Часто бывает, что помимо основной сущности требуется создать дополнительные-как бы вспомогательные.
            Например есть заказ - "Order" - и есть его описание -"Detail".Когда требуется дать сущности наименование -
            наименование основной сущности ставится впереди, а остальное-сзади. Так например, сущность “Детали заказа”
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
            Если же нужно перевести что - то более сложное, например “"Документ рекомендаций по разработке цен"”, то здесь
            стоит более детально подойти к наименованию сущности, ибо вероятность совершить ошибку-больше, а ошибки, могут
            приводить к недопонимаю.Так, например, можно перевести сущность как "DocumentRecomendationForDevelopmentPrice" однако, это будет неверное
            наименование, ибо обратный перевод будет таким-"Рекомендация документа по цене разработки". Правильное же
            наименование будет следующим - "RecomendationDocumentForPriceDevelopment" либо, если опустить "For"-
            "PriceDevelopmentRecomendationDocument" - то есть, у нас есть Документ рекомендаций-"RecomendationDocument"
            для разработки цен - "PriceDevelopment", где разработка цен является главной сущностью по отношению к документу рекомендаций.
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
        // TODO: Убрать MD, заменить на обычные компоненты
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