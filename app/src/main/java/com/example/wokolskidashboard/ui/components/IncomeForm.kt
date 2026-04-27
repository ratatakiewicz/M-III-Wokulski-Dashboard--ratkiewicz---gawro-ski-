package com.example.wokulskidashboard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun IncomeForm(
    onIncomeAdded: (name: String, amount: Double) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var amountText by remember { mutableStateOf("") }
    var nameError by remember { mutableStateOf(false) }
    var amountError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Przychody",
            style = MaterialTheme.typography.titleMedium
        )

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
                nameError = false
            },
            label = { Text("Nazwa towaru") },
            placeholder = { Text("np. Paryskie rękawiczki") },
            isError = nameError,
            supportingText = {
                if (nameError) Text("Nazwa nie może być pusta")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = amountText,
            onValueChange = {
                amountText = it
                amountError = false
            },
            label = { Text("Kwota (Ruble)") },
            placeholder = { Text("np. 15.00") },
            isError = amountError,
            supportingText = {
                if (amountError) Text("Podaj prawidłową kwotę większą od zera")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Button(
            onClick = {
                val amount = amountText.toDoubleOrNull()
                nameError = name.isBlank()
                amountError = amount == null || amount <= 0

                if (!nameError && !amountError) {
                    onIncomeAdded(name.trim(), amount!!)
                    name = ""
                    amountText = ""
                }
            },

            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Zapisz przychód")
        }
    }
}

@Preview
@Composable
fun IncomeFormPreview(){
    IncomeForm(onIncomeAdded = { _, _ -> })
}