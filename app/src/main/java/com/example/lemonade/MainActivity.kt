package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeCard()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeTheme {
        LemonadeCard()
    }
}

@Composable
fun LemonadeCard() {
    Surface(
        Modifier
            .fillMaxSize(),
        color = Color.White
    ) {
        var result by remember { mutableStateOf(1) }
        val contentResource = when (result) {
            1 -> R.string.lemon_tree
            2 -> R.string.lemon_squeeze
            3 -> R.string.lemon_drink
            else -> R.string.lemon_restart
        }
        val imageResource = when (result) {
            1 -> R.drawable.lemon_tree
            2 -> R.drawable.lemon_squeeze
            3 -> R.drawable.lemon_drink
            else -> R.drawable.lemon_restart
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(stringResource(contentResource))
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(imageResource),
                contentDescription = "lemon_tree",
                modifier = Modifier.clickable { result++; if (result == 5) result = 1 }
            )
        }
    }
}
