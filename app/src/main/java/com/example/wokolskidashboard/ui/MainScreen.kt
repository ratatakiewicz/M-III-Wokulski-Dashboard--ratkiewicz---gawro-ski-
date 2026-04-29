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
}