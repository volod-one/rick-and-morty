package one.volod.ui.common.components.character

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import one.volod.rickandmodry.core.models.domain.CharacterStatus
import one.volod.ui.common.components.theme.RickandmortyTheme

@Composable
fun CharacterStatusComponent(characterStatus: CharacterStatus) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .border(
                width = 1.dp,
                color = characterStatus.color,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 12.dp, vertical = 4.dp),
    ) {
        Text(
            text = "Status: ${characterStatus.displayName}",
            fontSize = 20.sp,
            color = Color.White // RickTextPrimary
        )
    }
}

@Preview
@Composable
private fun CharacterStatusComponentPreviewAlive() {
    RickandmortyTheme {
        CharacterStatusComponent(
            characterStatus = CharacterStatus.Alive
        )
    }
}

@Preview
@Composable
private fun CharacterStatusComponentPreviewDead() {
    RickandmortyTheme {
        CharacterStatusComponent(
            characterStatus = CharacterStatus.Dead
        )
    }
}

@Preview
@Composable
private fun CharacterStatusComponentPreviewUnknown() {
    RickandmortyTheme {
        CharacterStatusComponent(
            characterStatus = CharacterStatus.Unknown
        )
    }
}
