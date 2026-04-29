package com.example.wokolskidashboard.ui

import IncomeForm
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.ui.components.*

@Composable
fun MainScreen() {

    val transactions = remember { mutableStateListOf<Transaction>() }

    var expenseName by remember { mutableStateOf("") }
    var expenseAmount by remember { mutableStateOf("") }
    var expenseCategory by remember { mutableStateOf("") }
    var isUnnecessary by remember { mutableStateOf(false) }

    var incomeName by remember { mutableStateOf("") }
    var incomeAmount by remember { mutableStateOf("") }

    val balance = transactions.sumOf { if (it.isExpense) -it.amount else it.amount }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        BalanceHeader(balance = balance)


        Spacer(modifier = Modifier.height(16.dp))

        IncomeForm(
            onAddIncome = { name, amount ->
                transactions.add(
                    Transaction(
                        name = name,
                        amount = amount,
                        isExpense = false,
                        category = "Income"
                    )
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        ExpenseForm(
            name = expenseName,
            amount = expenseAmount,
            category = expenseCategory,
            isUnnecessary = isUnnecessary,

            onNameChange = { expenseName = it },
            onAmountChange = { expenseAmount = it },
            onCategoryChange = { expenseCategory = it },
            onUnnecessaryChange = { isUnnecessary = it },

            onAddExpense = {
                val amount = expenseAmount.toDoubleOrNull()

                if (amount != null && expenseName.isNotBlank()) {
                    transactions.add(
                        Transaction(
                            name = expenseName,
                            amount = amount,
                            isExpense = true,
                            category = expenseCategory
                        )
                    )

                    expenseName = ""
                    expenseAmount = ""
                    expenseCategory = ""
                    isUnnecessary = false
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))


    }
}