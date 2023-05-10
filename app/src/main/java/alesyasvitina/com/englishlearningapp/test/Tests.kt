package a.svitina.english_learning_for_developers.test
import alesyasvitina.com.englishlearningapp.statistic.Statistic
import alesyasvitina.com.englishlearningapp.statistic.StatisticRepository
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.*
import androidx.navigation.*
import androidx.navigation.compose.*
import java.time.LocalDateTime
import java.time.ZoneId
private val TESTS = listOf(
    Test(
        question = "Как правильно называется сущность “Заказ” в контексте приложения для интернет-магазинов, где пользователь может добавлять или удалять товары из корзины до завершения покупки?",
        answers = listOf(
            Answer("Order", true),
            Answer("Request"),
            Answer("Purchase"),
            Answer("Transaction"),
            Answer("Inquiry")
        ),
        rightAnswerDescription = """
            "Order" (Заказ) - это наиболее часто используемое название для сущности, представляющей заказ
             клиента на платформе интернет-магазинов. Другие варианты, такие как "Request" (Запрос), "Purchase" 
             (Покупка), "Transaction" (Транзакция) и "Inquiry" (Запрос), также могут быть уместны в определенных 
             контекстах, но не передают того же смысла, что и "Order" (Заказ).
        """.trimIndent()
    ),
    Test(
        question = "Как правильно называется объект \"Клиент\" в контексте системы купли-продажи товаров," +
                " в которой бизнес отслеживает взаимодействие с клиентами и историю продаж?",
        answers = listOf(
            Answer("Client"),
            Answer("Customer", true),
            Answer("Consumer"),
            Answer("Patron"),
            Answer("Member")
        ),
        rightAnswerDescription = """
            "Customer" (Клиент) - более часто используемый термин в контексте продаж каких-либо товаров. 
            “Client” (Клиент) - используется, когда речь идет о продаже каких-либо услуг. Остальные 
            варианты менее применимы в контексте приложения купли-продажи товаров.
        """.trimIndent()
    ),
    Test(
        question = "Как правильно называется сущность \"Категория\" в контексте платформы электронной" +
                " коммерции, где товары группируются по общим атрибутам или характеристикам?",
        answers = listOf(
            Answer("Group"),
            Answer("Classification"),
            Answer("Division"),
            Answer("Category", true),
            Answer("Type")
        ),
        rightAnswerDescription = """
            "Category" (Категория) является наиболее распространенным термином, используемым в 
            платформах электронной коммерции для обозначения группировки товаров. Остальные варианты 
            также могут быть уместны, но "Категория" является наиболее подходящим и широко используемым.
        """.trimIndent()
    ),
    Test(
        question = "Как правильно называется объект \"Склад\" в контексте управления запасами, когда" +
                " предприятие отслеживает перемещение и хранение продукции?",
        answers = listOf(
            Answer("Warehouse", true),
            Answer("Depot"),
            Answer("Stockroom"),
            Answer("Repository"),
            Answer("Inventory")
        ),
        rightAnswerDescription = """
            “Warehouse” (Склад) является наиболее часто используемым термином для 
            обозначения объекта, представляющего складское помещение в управлении запасами.
        """.trimIndent()
    ),
    Test(
        question = """
            Как правильно называется организация "Поставщик" в контексте системы управления
            цепочкой поставок, в которой осуществляется управление компаниями или лицами,
            предоставляющими товары или услуги?
        """.trimIndent(),
        answers = listOf(
            Answer("Supplier", true),
            Answer("Vendor"),
            Answer("Provider"),
            Answer("Distributor"),
            Answer("Seller")
        ),
        rightAnswerDescription = """
            "Supplier" (Поставщик) точно представляет компанию или физическое лицо, которое предоставляет
             товары или услуги в контексте системы управления цепочкой поставок. Поскольку имеется ввиду
             именно цепочка поставок, ответ "Vendor" (Поставщик) является неправильным, поскольку вендоры
             обычно продают товар конечному пользователю, а не другим компаниям.
        """.trimIndent()
    ),
    Test(
        question = """
            Как правильно называется сущность "Скидка" в контексте системы ценообразования и промо-акций,
            где снижение цены применяется к товарам или услугам?
        """.trimIndent(),
        answers = listOf(
            Answer("Discount", true),
            Answer("Sale"),
            Answer("Promotion"),
            Answer("Offer"),
            Answer("Bargain")
        ),
        rightAnswerDescription = """
            "Скидка" означает снижение цены, что соответствует контексту системы ценообразования и продвижения.
            Остальные варианты менее точно отражают смысл "Скидки".
        """.trimIndent()
    ),
    Test(
        question = "Каков правильный порядок слов в названии организации \"Статья на блоге\"?",
        answers = listOf(
            Answer("PostBlog"),
            Answer("BlogPost", true)
        ),
        rightAnswerDescription = "Пост является частью Блога, поэтому Блог является главной сущностью"
    ),
    Test(
        question = "Каков правильный порядок слов в названии организации \"Форма регистрации\"?",
        answers = listOf(
            Answer("RegistrationForm", true),
            Answer("FormRegistration")
        ),
        rightAnswerDescription = "Форма относится к одному из элементов Регистрации, поэтому Регистрация является главной сущнностью"
    ),
    Test(
        question = "Каков правильный порядок слов в названии организации \"Курс валюты\"?",
        answers = listOf(
            Answer("CurrencyRate", true),
            Answer("RateCurrency")
        ),
        rightAnswerDescription = "Валюта является главной частью, курс - второстепенной. Курс является параметром Валюты"
    ),
    Test(
        question = "Каков правильный порядок слов в названии организации \"Доставка заказа\"?",
        answers = listOf(
            Answer("DeliveryOrder"),
            Answer("OrderDelivery", true)
        ),
        rightAnswerDescription = "Осуществляется Доставка (чего?) Заказа. Заказ - главная часть, Доставка - второстепенная"
    ),
    Test(
        question = "Каков правильный порядок слов в названии сущности \"Время выполнения задачи\"?",
        answers = listOf(
            Answer("TaskCompletionTime", true),
            Answer("CompletionTaskTime"),
            Answer("TimeTaskCompletion"),
            Answer("TaskTimeCompletion")
        ),
        rightAnswerDescription = "Время (чего?) Выполнения (CompletionTime)" +
                " + Выполнения (чего?) Задачи (TaskCompletion) = TaskCompletionTime"
    ),
    Test(
        question = "Каков правильный порядок слов в названии сущности \"Тип исполнительного документа\"?",
        answers = listOf(
            Answer("DocumentExecutiveType"),
            Answer("TypeExecutiveDocument"),
            Answer("ExecutiveDocumentType", true),
            Answer("DocumentTypeExecutive")
        ),
        rightAnswerDescription = "Тип (чего?) Документа (DocumentType)" +
                " + Документ (какой?) Исполнительный (ExecutiveDocument) = ExecutiveDocumentType"
    ),
    Test(
        question = "Каков правильный порядок слов в имени сущности \"Контактные данные клиента\"?",
        answers = listOf(
            Answer("ContactClientData"),
            Answer("ClientContactData", true),
            Answer("ContactDataClient"),
            Answer("DataClientContact")
        ),
        rightAnswerDescription = "Данные (чьи?) Клиента (ClientData)" +
                " + Данные (какие?) Контактные (ContactData) = ClientContactData"
    ),
    Test(
        question = "Каков правильный порядок слов в имени сущности \"Статус заказа покупателя\"?",
        answers = listOf(
            Answer("OrderCustomerStatus"),
            Answer("StatusOrderCustomer"),
            Answer("StatusCustomerOrder"),
            Answer("CustomerOrderStatus", true)
        ),
        rightAnswerDescription = "Статус (чего?) Заказа (OrderStatus)" +
                " + Заказ (чей?) Покупателя (CustomerOrder) = CustomerOrderStatus"
    )
)

private val LINKS = object {
    val startPage = "startPage"
    val result = "result"
    val question = TESTS.indices.map { "question-$it" }
}
@Composable
fun Tests(onExit: () -> Unit) {
    val statisticRepository = StatisticRepository(LocalContext.current)
    val startTime = LocalDateTime.now()
    val nav = rememberNavController()
    val testAnswers: List<MutableState<Answer?>> = remember {
        TESTS.map { mutableStateOf(null) }
    }
    NavHost(
        modifier = Modifier.padding(8.dp),
        navController = nav,
        startDestination = LINKS.startPage
    ) {
        composable(LINKS.startPage) {
            StartPage(nav)
        }
        for (i in TESTS.indices) {
            composable(LINKS.question[i]) {
                TestQuestion(
                    test = TESTS[i],
                    answer = testAnswers[i].value,
                    onAnswer = {
                        testAnswers[i].value = it
                        if (i < TESTS.size - 1) {
                            nav.navigate(LINKS.question[i + 1])
                        } else {
                            val endTime = LocalDateTime.now()
                            val endTimeMilli = endTime.atZone(ZoneId.systemDefault())
                                .toInstant()
                                .toEpochMilli()
                            val startTimeMilli = startTime.atZone(ZoneId.systemDefault())
                                .toInstant()
                                .toEpochMilli()
                            val diff = endTimeMilli - startTimeMilli
                            val rightAnswersCount = testAnswers.count { x -> x.value != null && x.value!!.right }.toLong()
                            val statistic = Statistic(
                                datetime = startTime,
                                timeSpentInSeconds = diff / 1000,
                                resultInPercent = (100L * rightAnswersCount) / TESTS.size
                            )
                            statisticRepository.saveNew(statistic)
                            nav.navigate(LINKS.result)
                        }
                    },
                    onGoBack = {
                        if (i > 0) {
                            nav.navigate(LINKS.question[i - 1])
                        } else {
                            onExit()
                        }
                    }
                )
            }
        }
        composable(LINKS.result) {
            ResultPage(
                testAnswers = testAnswers.map { it.value!! },
                onExit = onExit
            )
        }
    }
}
@Composable
private fun StartPage(nav: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = """
                Тест состоит из ${TESTS.size} вопросов. Среди предоставленных вариантов ответа Вам
                нужно будет выбрать один и подтвердить свой выбор. После выполнения теста Вы сможете
                ознакомиться с результатом и, при наличии ошибок, их разобрать. Не переживайте, 
                мы поможем!
            """.trimIndent(),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        Button(onClick = { nav.navigate(LINKS.question[0]) }) {
            Text("Поехали!")
        }
    }
}
@Composable
private fun TestQuestion(
    test: Test,
    answer: Answer?,
    onAnswer: (Answer) -> Unit,
    onGoBack: () -> Unit
) {
    var selected by remember { mutableStateOf(answer) }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = test.question,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 12.dp),
                textAlign = TextAlign.Justify
            )
            test.answers.forEach {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selected == it,
                        onClick = { selected = it },
                    )
                    Text(
                        modifier = Modifier.clickable { selected = it },
                        text = it.content
                    )
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = onGoBack) {
                Text("Назад")
            }
            Button(
                enabled = selected != null,
                onClick = { onAnswer(selected!!) }
            ) {
                Text("Подтвердить выбор")
            }
        }
    }
}
@Composable
private fun ResultPage(testAnswers: List<Answer>, onExit: () -> Unit) {
    val errors: MutableList<Int> = ArrayList()
    for (i in TESTS.indices) {
        if (!testAnswers[i].right) {
            errors.add(i)
        }
    }
    if (errors.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Ошибок нет!",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = onExit) {
                    Text("В главное меню")
                }
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Ошибок: ${errors.size}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
                errors.forEach { i ->
                    val t = TESTS[i]
                    Column(modifier = Modifier.padding(vertical = 12.dp)) {
                        Text(
                            modifier = Modifier.padding(bottom = 8.dp),
                            text = "${i + 1}. ${t.question}"
                        )
                        Text(
                            text = "Выбранный ответ: ${testAnswers[i].content}",
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Правильный ответ: ${t.rightAnswer}",
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            modifier = Modifier.padding(top = 8.dp),
                            text = t.rightAnswerDescription
                        )
                    }
                    if (i != errors.last()) {
                        Divider(thickness = 1.dp)
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = onExit) {
                    Text("В меню")
                }
            }
        }
    }
}
private data class Test(
    val question: String,
    val answers: List<Answer>,
    val rightAnswerDescription: String
) {
    val rightAnswer: String
        get() {
            return answers.first { it.right }.content
        }
}
private data class Answer(
    val content: String,
    val right: Boolean
) {
    constructor(content: String) : this(content, false)
}