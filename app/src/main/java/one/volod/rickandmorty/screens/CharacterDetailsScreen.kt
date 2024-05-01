package one.volod.rickandmorty.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import one.volod.core.network.KtorClient
import one.volod.core.network.models.domain.Character
import one.volod.rickandmorty.components.character.CharacterDetailsNamePlateComponent

@Composable
fun CharacterDetailsScreen(
    ktorClient: KtorClient,
    characterId: Int,
) {
    var character by remember { mutableStateOf<Character?>(null) }

    val characterDataPoints: List<DataPoint> by remember {
        derivedStateOf {
            buildList {
                character?.let { character ->
                    add(
                        DataPoint(
                            title = "Last known location",
                            description = character.location.name
                        )
                    )
                    add(
                        DataPoint(
                            title = "Species",
                            description = character.species
                        )
                    )
                    add(
                        DataPoint(
                            title = "Gender",
                            description = character.gender.displayName
                        )
                    )
                    character.type.takeIf { it.isNotEmpty() }?.let { type ->
                        add(DataPoint(title = "Type", description = type))
                    }
                    add(
                        DataPoint(
                            title = "Origin",
                            description = character.origin.name
                        )
                    )
                    add(
                        DataPoint(
                            title = "Episode count",
                            description = character.episodeUrls.size.toString()
                        )
                    )
                }
            }
        }
    }

    LaunchedEffect(key1 = Unit, block = {
        delay(500)
        character = ktorClient.getCharacter(characterId)
    })

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        if (character == null) {
            item {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    CircularProgressIndicator(modifier = Modifier.size(72.dp))
                }
            }
            return@LazyColumn
        }

        // Name plate
        item {
            CharacterDetailsNamePlateComponent(
                name = character!!.name,
                status = character!!.status,
            )
        }

        item { Spacer(modifier = Modifier.height(8.dp)) }

        // Image
        item {
            // TODO
        }

        // Data points
        items(characterDataPoints) {
            Spacer(modifier = Modifier.height(32.dp))
            DataPointComponent(dataPoint = it)
        }

        item { Spacer(modifier = Modifier.height(32.dp)) }

        // Button
        item {
            Text(
                text = "View all episodes",
                color = Color.Cyan, // RickAction
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Cyan, // RickAction
                        shape = RoundedCornerShape(12.dp),
                    )
                    .clip(RoundedCornerShape(12.dp))
                    .clickable {
                        // TODO
                    }
                    .padding(vertical = 8.dp),
            )
        }

        item { Spacer(modifier = Modifier.height(64.dp)) }
    }
}

data class DataPoint(
    val title: String,
    val description: String,
)

@Composable
fun DataPointComponent(dataPoint: DataPoint) {
    Column {
        Text(
            text = dataPoint.title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Cyan//RickAction,
        )
        Text(
            text = dataPoint.description,
            fontSize = 24.sp,
            color = Color.White // RickTextPrimary,
        )
    }
}
