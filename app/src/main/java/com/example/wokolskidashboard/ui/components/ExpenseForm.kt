package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ExpenseForm(
    name: String,
    amount: String,
    category: String,
    isUnnecessary: Boolean,

    onNameChange: (String) -> Unit,
    onAmountChange: (String) -> Unit,
    onCategoryChange: (String) -> Unit,
    onUnnecessaryChange: (Boolean) -> Unit,

    onAddExpense: () -> Unit
) {
    var nameError by remember { mutableStateOf(false) }
    var amountError by remember { mutableStateOf(false) }
    var categoryError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text(
            text = "💸 Wydatki Wokulskiego",
            style = MaterialTheme.typography.titleMedium
        )

        WokulskiTextField(
            value = name,
            onValueChange = {
                onNameChange(it)
                nameError = false
            },
            label = "Cel wydatku",
            modifier = Modifier.fillMaxWidth()
        )
        if (nameError) Text("Nazwa nie może być pusta", color = MaterialTheme.colorScheme.error)

        WokulskiTextField(
            value = amount,
            onValueChange = {
                onAmountChange(it)
                amountError = false
            },
            label = "Kwota (Rubel)",
            modifier = Modifier.fillMaxWidth()
        )
        if (amountError) Text("Podaj prawidłową kwotę większą od zera", color = MaterialTheme.colorScheme.error)

        WokulskiTextField(
            value = category,
            onValueChange = {
                onCategoryChange(it)
                categoryError = false
            },
            label = "Kategoria (np. Sklep, Osobiste)",
            modifier = Modifier.fillMaxWidth()
        )
        if (categoryError) Text("Kategoria nie może być pusta", color = MaterialTheme.colorScheme.error)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Wydatek zbyteczny")
            Switch(
                checked = isUnnecessary,
                onCheckedChange = onUnnecessaryChange
            )
        }

        WokulskiButton(
            text = "Zapisz wydatek",
            onClick = {
                val amountParsed = amount.toDoubleOrNull()

                nameError = name.isBlank()
                amountError = amountParsed == null || amountParsed <= 0
                categoryError = category.isBlank()

                if (!nameError && !amountError && !categoryError) {
                    onAddExpense()
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = name.isNotBlank() && amount.isNotBlank() && category.isNotBlank()
        )
    }
}

@Preview
@Composable
fun ExpenseFormPreview() {
    ExpenseForm(
        name = "Perfumy dla Izabeli",
        amount = "150.00",
        category = "Osobiste",
        isUnnecessary = true,
        onNameChange = {},
        onAmountChange = {},
        onCategoryChange = {},
        onUnnecessaryChange = {},
        onAddExpense = {}
    )
}