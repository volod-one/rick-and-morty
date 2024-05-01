package one.volod.rickandmorty.components.character

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import one.volod.core.network.models.domain.CharacterStatus
import one.volod.rickandmorty.ui.theme.RickandmortyTheme

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
fun CharacterDetailsNamePlateComponentPreviewAlive() {
    RickandmortyTheme {
        CharacterDetailsNamePlateComponent(
            name = "Rick Sanchez",
            status = CharacterStatus.Alive,
        )
    }
}

@Preview
@Composable
fun CharacterDetailsNamePlateComponentPreviewDead() {
    RickandmortyTheme {
        CharacterDetailsNamePlateComponent(
            name = "Rick Sanchez",
            status = CharacterStatus.Dead,
        )
    }
}


@Preview
@Composable
fun CharacterDetailsNamePlateComponentPreviewUnknown() {
    RickandmortyTheme {
        CharacterDetailsNamePlateComponent(
            name = "Rick Sanchez",
            status = CharacterStatus.Unknown,
        )
    }
}
