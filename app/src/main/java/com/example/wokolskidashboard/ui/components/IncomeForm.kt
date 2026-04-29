import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import com.example.wokolskidashboard.ui.components.WokulskiButton
import com.example.wokolskidashboard.ui.components.WokulskiTextField


@Composable
fun IncomeForm(
    onAddIncome: (name: String, amount: Double) -> Unit
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

        WokulskiTextField(
            value = name,
            onValueChange = {
                name = it
                nameError = false
            },
            label = "Nazwa towaru",
            modifier = Modifier.fillMaxWidth()
        )
        if (nameError) Text("Nazwa nie może być pusta", color = MaterialTheme.colorScheme.error)

        WokulskiTextField(
            value = amountText,
            onValueChange = {
                amountText = it
                amountError = false
            },
            label = "Kwota (Ruble)",
            modifier = Modifier.fillMaxWidth()
        )
        if (amountError) Text("Podaj prawidłową kwotę większą od zera", color = MaterialTheme.colorScheme.error)

        WokulskiButton(
            text = "Zapisz przychód",
            onClick = {
                val amount = amountText.toDoubleOrNull()
                nameError = name.isBlank()
                amountError = amount == null || amount <= 0

                if (!nameError && !amountError) {
                    onAddIncome(name.trim(), amount!!)
                    name = ""
                    amountText = ""
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = name.isNotBlank() && amountText.isNotBlank()
        )
    }
}

@Preview
@Composable
fun IncomeFormPreview(){
    IncomeForm(onAddIncome = { _, _ -> })
}