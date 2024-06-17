import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.time.LocalDate

data class Email(
    val sender: String,
    val subject: String,
    val date: LocalDate
)

@Composable
fun CaixaEntrada(navController: NavController? = null) {
    // Dados de exemplo
    val emails = listOf(
        Email("KABUM", "Compra negada", LocalDate.of(2023, 6, 16)),
        Email("KABUM", "Compra aprovada", LocalDate.of(2023, 6, 15)),
        Email("KABUM", "Compra pendente", LocalDate.of(2023, 6, 14))
    ).sortedByDescending { it.date }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF024873))
            .fillMaxHeight()
            .padding(top = 2.dp)
    ) {

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.White,
                unfocusedBorderColor = Color.White,
                unfocusedLabelColor = Color.White,
                unfocusedLeadingIconColor = Color.White
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search, contentDescription = null
                )
            },
            value = "Digite o assunto do email",
            onValueChange = {},
        )

        emails.forEach { email ->
            EmailCard(email)
        }

        Column {
            Button(onClick = {
                navController?.navigate("calendario")
            }) {
                Text(text = "CALENDARIO")
            }
        }
    }
}

@Composable
fun EmailCard(email: Email) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp)
            .height(80.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0477BF)),
        shape = RoundedCornerShape(0.dp),
        border = BorderStroke(1.dp, Color(0xFF024873))
    ) {
        Column(modifier = Modifier.padding(horizontal = 5.dp)) {
            Text(
                text = email.sender,
                color = Color.White,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = email.subject,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = email.date.toString(),
                color = Color.White,
                fontSize = 12.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CaixaEntradaPreview() {
    CaixaEntrada()
}
