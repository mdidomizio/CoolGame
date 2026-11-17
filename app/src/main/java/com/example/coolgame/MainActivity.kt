package com.example.coolgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.coolgame.ui.theme.CoolGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoolGameTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        onClickOne = {},
                        onClickTwo = {},
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    onClickOne: () -> Unit,
    onClickTwo: () -> Unit,
    modifier: Modifier = Modifier
) {
    var hasBeefed: Boolean = false /*remember { Boolean(false) }*/
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,

    ) {
        Text(
            text = "Feed your kitty",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 16.dp)
            )
        Text(
            text = "placeholder: add small pic of a kitty here",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp))


        Text(
            text = if (hasBeefed) {
                "Kitty has been feed!"
            } else ""
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),

        ) {
            Button(
                onClick = {
                    onClickOne()
                    hasBeefed = true
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Cucumber")
            }

            Button(
                onClick = {
                    onClickTwo()
                hasBeefed = true
                },
                modifier = Modifier.weight(1f)
            ) { Text("Fish") }
        }

    }

}

