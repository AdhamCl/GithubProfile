package com.rafikconsole.githubprofile.presentation.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.rafikconsole.githubprofile.presentation.theme.LARGE_HEIGHT
import com.rafikconsole.githubprofile.presentation.theme.TitleColor
@Composable
fun SectionHeader(title: String) {
    Text(
        text = title, // Display the section title
        fontWeight = FontWeight.Bold, // Set the font weight to bold
        style = MaterialTheme.typography.titleLarge, // Use the titleLarge typography style
        color = TitleColor // Set the text color
    )
    Spacer(modifier = Modifier.height(LARGE_HEIGHT)) // Add space below the title
}
