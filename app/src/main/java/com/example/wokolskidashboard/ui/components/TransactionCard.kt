package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction

@Composable
fun TransactionCard(transaction: Transaction) {

    val color = if (transaction.isExpense) {
        MaterialTheme.colorScheme.error
    } else {
        MaterialTheme.colorScheme.primary
    }

    val sign = if (transaction.isExpense) "-" else "+"

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Text(text = transaction.name)

                Text(
                    text = transaction.category,
                    style = MaterialTheme.typography.bodySmall
                )

                if (transaction.isUnnecessary && transaction.isExpense) {
                    Text(
                        text = "Zbyteczny wydatek",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }

            Text(
                text = "$sign${transaction.amount}",
                color = color,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}