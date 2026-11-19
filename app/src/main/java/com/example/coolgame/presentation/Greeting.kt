package com.example.coolgame.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.coolgame.R
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Greeting(
    onClickOne: () -> Unit,
    onClickTwo: () -> Unit,
    modifier: Modifier = Modifier
) {
    var hasBeenFed by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    var resetJob by remember { mutableStateOf<Job?>(null) }
    val namesList = listOf("Fluffy", "Whiskers", "Mittens", "Shadow", "Admiral snuggle pants III")
    var kittyName by remember { mutableStateOf(namesList[0]) }
    var isNameSection by remember { mutableStateOf(true) }

    Text(
        text = "Feed your kitty",
        style = MaterialTheme.typography.headlineLarge,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(24.dp),
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,

        ) {

        if (isNameSection) {

            Text(
                text = "name the cat"
            )

            Text(
                text = kittyName
            )

            Button(
                onClick = { kittyName = namesList.random() }
            ) {
                Text("New name")
            }

            Image(
                painter = painterResource(id = R.drawable.cat),
                contentDescription = "Kitty",
                //modifier = Modifier.align(alignment = Alignment.Center)
            )

            Button(
                onClick = { isNameSection = false }
            ) {
                Text("start the game")
            }
        } else {
            Image(
                painter = painterResource(id = R.drawable.cat),
                contentDescription = "Kitty",
                //modifier = Modifier.align(alignment = Alignment.Center)
            )

            Text(
                text = if (hasBeenFed) {
                    "Kitty has been fed!"
                } else ""
            )
            if (hasBeenFed) {
                return
            } else {

            Text("what would you feed your kitty with?")

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {

                    Button(
                        onClick = {
                            onClickOne()
                            hasBeenFed = true
                            resetJob?.cancel()
                            resetJob = scope.launch {
                                delay(3000)
                                hasBeenFed = false
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Cucumber")
                    }

                    Button(
                        onClick = {
                            onClickTwo()
                            hasBeenFed = true
                            resetJob?.cancel()
                            resetJob = scope.launch {
                                delay(3000)
                                hasBeenFed = false
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) { Text("Fish") }
                }
            }
        }
    }
}