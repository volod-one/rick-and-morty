package one.volod.ui.common.components.character

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import one.volod.rickandmorty.core.domain.models.domain.CharacterStatus


@Composable
fun CharacterStatusCircle(status: CharacterStatus, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                brush = Brush.radialGradient(listOf(Color.Black, Color.Transparent)),
                shape = CircleShape,
            )
            .size(20.dp),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .background(
                    color = status.color,
                    shape = CircleShape
                ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CharacterStatusCirclePreviewAlive() {
    CharacterStatusCircle(status = CharacterStatus.Alive)
}

@Preview(showBackground = true)
@Composable
private fun CharacterStatusCirclePreviewDead() {
    CharacterStatusCircle(status = CharacterStatus.Dead)
}

@Preview(showBackground = true)
@Composable
private fun CharacterStatusCirclePreviewUnknown() {
    CharacterStatusCircle(status = CharacterStatus.Unknown)
}
