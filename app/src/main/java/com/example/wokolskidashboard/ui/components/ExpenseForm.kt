package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wokulskidashboard.ui.components.IncomeForm

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

        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Cel wydatku") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = amount,
            onValueChange = onAmountChange,
            label = { Text("Kwota (Rubel)") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = category,
            onValueChange = onCategoryChange,
            label = { Text("Kategoria (np. Sklep, Osobiste)") },
            modifier = Modifier.fillMaxWidth()
        )

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
        Button(
            onClick = onAddExpense,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Zapisz wydatek")
        }
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