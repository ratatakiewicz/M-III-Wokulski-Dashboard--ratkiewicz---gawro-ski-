package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BalanceHeader(balance: Double) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Saldo",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "$balance Rubli",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}