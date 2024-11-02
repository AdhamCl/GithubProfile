package com.rafikconsole.githubprofile.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.rafikconsole.githubprofile.R
import com.rafikconsole.githubprofile.utils.formatDate

@Composable
fun CreatedAndUpdatedDates(createdAt: String, updatedAt: String) {
    Column {
        InformationRow(
            icon = painterResource(R.drawable.created),
            label = stringResource(R.string.createdAt),
            value = formatDate(createdAt) // Formats the created date
        )
        InformationRow(
            icon = painterResource(R.drawable.update),
            label = stringResource(R.string.lastUpdated),
            value = formatDate(updatedAt) // Formats the updated date
        )
    }
}
