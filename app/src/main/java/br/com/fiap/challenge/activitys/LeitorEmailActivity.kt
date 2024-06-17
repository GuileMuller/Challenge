package br.com.fiap.challenge.activitys

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.challenge.activitys.ui.theme.ChallengeTheme

class LeitorEmailActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            br.com.fiap.challenge.ui.theme.ChallengeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TituloEmail()
                }
            }
        }
    }
}

@Composable
fun TituloEmail() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212)) // Fundo escuro
            .padding(16.dp)
    ) {
        Text(
            text = "Agenda da Reunião",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White, // Cor do texto para fundo escuro
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "De: João",
            fontSize = 20.sp,
            color = Color.White, // Cor do texto para fundo escuro
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Mensagem:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White, // Cor do texto para fundo escuro
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color(0xFF1E1E1E),
                    shape = RoundedCornerShape(8.dp)
                ) // Fundo da mensagem
                .padding(16.dp)
        ) {
            Text(
                text = "Próxima reunião dia 15/06/24",
                fontSize = 18.sp,
                color = Color.White // Cor do texto para fundo escuro
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MeuComponentePreview() {
    TituloEmail()
}