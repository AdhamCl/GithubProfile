package com.rafikconsole.githubprofile.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.rafikconsole.githubprofile.presentation.theme.TextColor
import com.rafikconsole.githubprofile.presentation.theme.TitleColor


@Composable
fun StatisticItem(
    label: String, // The label for the statistic
    count: Int, // The numeric count to display
    onClick: () -> Unit // Callback function to handle click events
) {
    Column(
        modifier = Modifier.clickable(onClick = onClick), // Make the entire column clickable
        horizontalAlignment = Alignment.CenterHorizontally, // Center content horizontally
    ) {
        Text(
            text = "$count", // Display the count
            fontWeight = FontWeight.Bold, // Set font weight to bold
            style = MaterialTheme.typography.titleMedium, // Use medium title typography style
            color = TitleColor, // Set the text color
        )
        Text(
            text = label, // Display the label
            color = TextColor, // Set the label text color
            style = MaterialTheme.typography.bodyMedium // Use medium body typography style
        )
    }
}
