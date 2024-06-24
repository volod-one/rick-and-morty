package one.volod.ui.common.components.character

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import one.volod.rickandmorty.core.domain.models.domain.CharacterStatus
import one.volod.ui.common.components.theme.RickandmortyTheme

@Composable
fun CharacterDetailsNamePlateComponent(
    name: String,
    status: CharacterStatus,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        CharacterStatusComponent(characterStatus = status)

        Text(
            text = name,
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Cyan // RickAction
        )
    }
}

@Preview
@Composable
private fun CharacterDetailsNamePlateComponentPreviewAlive() {
    RickandmortyTheme {
        CharacterDetailsNamePlateComponent(
            name = "Rick Sanchez",
            status = CharacterStatus.Alive,
        )
    }
}

@Preview
@Composable
private fun CharacterDetailsNamePlateComponentPreviewDead() {
    RickandmortyTheme {
        CharacterDetailsNamePlateComponent(
            name = "Rick Sanchez",
            status = CharacterStatus.Dead,
        )
    }
}


@Preview
@Composable
private fun CharacterDetailsNamePlateComponentPreviewUnknown() {
    RickandmortyTheme {
        CharacterDetailsNamePlateComponent(
            name = "Rick Sanchez",
            status = CharacterStatus.Unknown,
        )
    }
}
