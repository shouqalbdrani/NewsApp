package com.example.newsapptrack

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NewsDetailScreen(
    title: String,
    content: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp, end = 20.dp, start = 20.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = content,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
