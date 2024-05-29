package com.example.schoolshub

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun AIBotScreen() {
    var userInput by remember { mutableStateOf("") }
    val chatHistory = remember { mutableStateListOf<Pair<String, String>>() }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Title
        Text(
            text = "How can I assist you regarding your child's education and schools?",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        // Chat History
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(chatHistory) { (prompt, response) ->
                Column {
                    Text(text = "You: $prompt", style = MaterialTheme.typography.bodyLarge)
                    Text(text = "Bot: $response", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }

        // Input area
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = userInput,
                onValueChange = { userInput = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
                    .height(56.dp)
                    .border(1.dp, MaterialTheme.colorScheme.primary)
                    .padding(16.dp)
            )

            Button(
                onClick = {
                    coroutineScope.launch {
                        val response = generateResponse(userInput) // Replace with actual AI response generation logic
                        chatHistory.add(userInput to response)
                        userInput = ""
                    }
                }
            ) {
                Text(text = "Send")
            }
        }
    }
}


suspend fun generateResponse(prompt: String): String {

    return "This is a response to your query about '$prompt'."
}
