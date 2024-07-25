package com.example.foodRecipes.presentation.theme.components.listitem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodRecipes.domain.model.IngredientModel
import com.inconceptlabs.designsystem.components.core.Text
import com.inconceptlabs.designsystem.theme.AppTheme

@Composable
fun IngredientItem(
    item: IngredientModel,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = item.name,
            style = AppTheme.typography.P4,
            modifier = Modifier
                .weight(1f)
        )

        Text(
            text = item.quantity,
            style = AppTheme.typography.P4,
            modifier = Modifier
                .weight(1f)
        )
    }
}