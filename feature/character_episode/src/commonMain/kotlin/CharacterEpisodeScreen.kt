import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CharacterEpisodeScreen(
//    characterId: Int,
//    viewModel: CharacterEpisodeViewModel = hiltViewModel(),
) {
    Text(text = "CharacterEpisodeScreen")

//    val characterState by viewModel.characterState.collectAsState()
//    val episodesState by viewModel.episodesState.collectAsState()
//
//    LaunchedEffect(key1 = Unit, block = {
//        viewModel.onLoadData(characterId = characterId)
//    })
//
//    characterState?.let { character ->
//        MainScreen(character = character, episodes = episodesState)
//    } ?: LoadingState()
//}
//
//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//private fun MainScreen(character: Character, episodes: List<Episode>) {
//    val episodeBySeasonMap = episodes.groupBy { it.seasonNumber }
//
//    LazyColumn(contentPadding = PaddingValues(all = 16.dp)) {
//        item { CharacterNameComponent(name = character.name) }
//        item { Spacer(modifier = Modifier.height(16.dp)) }
//        item {
//            LazyRow {
//                episodeBySeasonMap.forEach { mapEntry ->
//                    val title = "Season ${mapEntry.key}"
//                    val description = "${mapEntry.value.size} ep"
//                    item {
//                        DataPointComponent(
//                            dataPoint = DataPoint(
//                                title = title,
//                                description = description
//                            )
//                        )
//                    }
//                    item { Spacer(modifier = Modifier.width(16.dp)) }
//                }
//            }
//        }
//        item { Spacer(modifier = Modifier.height(16.dp)) }
//        item { CharacterImage(imageUrl = character.imageUrl) }
//        item { Spacer(modifier = Modifier.height(32.dp)) }
//
//        episodeBySeasonMap.forEach { mapEntry ->
//            stickyHeader { SeasonHeader(seasonNumber = mapEntry.key) }
//            item { Spacer(modifier = Modifier.height(16.dp)) }
//            items(mapEntry.value) { episode ->
//                EpisodeRowComponent(episode = episode)
//                Spacer(modifier = Modifier.height(16.dp))
//            }
//        }
//    }
//}
//
//@Composable
//private fun SeasonHeader(seasonNumber: Int) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(color = MaterialTheme.colorScheme.background)
//            .padding(top = 8.dp, bottom = 16.dp)
//    ) {
//        Text(
//            text = "Season $seasonNumber",
//            color = Color.White, // RickTextPrimary
//            fontSize = 32.sp,
//            lineHeight = 32.sp,
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .fillMaxWidth()
//                .border(
//                    width = 1.dp,
//                    color = Color.White, // RickTextPrimary
//                    shape = RoundedCornerShape(8.dp)
//                )
//                .padding(vertical = 4.dp)
//        )
//    }
}
