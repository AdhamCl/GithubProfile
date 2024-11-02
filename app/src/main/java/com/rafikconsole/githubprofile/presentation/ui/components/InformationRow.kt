package com.rafikconsole.githubprofile.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.rafikconsole.githubprofile.presentation.theme.ImageBackgroundColor
import com.rafikconsole.githubprofile.presentation.theme.ICON_SIZE
import com.rafikconsole.githubprofile.presentation.theme.TextColor
import com.rafikconsole.githubprofile.presentation.theme.TitleColor

@Composable
fun InformationRow(
    icon: Painter, // Icon to display on the left
    label: String, // Label text to display
    value: String,  // Value text to display next to the label
    isLink: Boolean = false, // Flag to make the row clickable, default is false
    onClick: () -> Unit = {}, // Callback to handle click events
    valueColor: Color = TextColor // Color for the value text, defaults to TextColor
) {
    Row(
        verticalAlignment = Alignment.CenterVertically, // Align items vertically in the center
        modifier = Modifier
            .fillMaxWidth()  // Make the row fill the maximum width
            .clickable(enabled = isLink) { onClick() } // Make the row clickable if isLink is true
            .padding(vertical = 4.dp)  // Add vertical padding for spacing
    ) {

        Image(
            painter = icon, // Load the provided icon
            contentDescription = label, // Description for accessibility
            modifier = Modifier
                .size(ICON_SIZE) // Set the size for the icon
                .clip(CircleShape) // Clip the icon to a circle
                .background(ImageBackgroundColor.copy(alpha = 0.2f)), // Add a background with some transparency
            contentScale = ContentScale.Crop  // Crop the image to fit the bounds
        )

        Spacer(modifier = Modifier.width(8.dp))  // Add space between the icon and text

        Text(
            text = "$label: ", // Display the label followed by a colon
            fontWeight = FontWeight.Bold, // Make the label text bold
            color = TitleColor, // Set the color for the label text
            style = MaterialTheme.typography.bodyLarge  // Use bodyLarge style for the label
        )

        Text(
            text = value,  // Display the value text
            color = valueColor, // Set the color for the value text
            modifier = Modifier.weight(1f), // Allow the value text to expand and take remaining space
            style = MaterialTheme.typography.bodyLarge,  // Use bodyLarge style for the value
            maxLines = 1, // Limit the value text to one line
            overflow = TextOverflow.Ellipsis  // Show ellipsis if text overflows
        )
    }
}
