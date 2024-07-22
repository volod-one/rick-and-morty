import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CharacterDetailsScreen(
//    characterId: Int,
//    viewModel: CharacterDetailsViewModel = hiltViewModel(),
//    onEpisodeClicked: (Int) -> Unit,
) {
    Text(text = "CharacterDetailsScreen")
//    LaunchedEffect(key1 = Unit) { viewModel.fetchCharacter(characterId) }
//
//    val state by viewModel.stateFlow.collectAsState()
//
//    LazyColumn(
//        modifier = Modifier.fillMaxSize(),
//        contentPadding = PaddingValues(16.dp)
//    ) {
//
//        when (val viewState = state) {
//            CharacterDetailsViewState.Loading -> {
//                item { LoadingState() }
//                return@LazyColumn
//            }
//
//            is CharacterDetailsViewState.Error -> {}
//            is CharacterDetailsViewState.Success -> {
//                val character = viewState.character
//
//                // Name plate
//                item {
//                    CharacterDetailsNamePlateComponent(
//                        name = character.name,
//                        status = character.status,
//                    )
//                }
//
//                item { Spacer(modifier = Modifier.height(8.dp)) }
//
//                // Image
//                item {
//                    CharacterImage(imageUrl = character.imageUrl)
//                }
//
//                // Data points
//                items(viewState.characterDataPoints) {
//                    Spacer(modifier = Modifier.height(32.dp))
//                    DataPointComponent(dataPoint = it)
//                }
//
//                item { Spacer(modifier = Modifier.height(32.dp)) }
//
//                // Button
//                item {
//                    Text(
//                        text = "View all episodes",
//                        color = Color.Cyan, // RickAction
//                        fontSize = 18.sp,
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier
//                            .padding(horizontal = 32.dp)
//                            .fillMaxWidth()
//                            .border(
//                                width = 1.dp,
//                                color = Color.Cyan, // RickAction
//                                shape = RoundedCornerShape(12.dp),
//                            )
//                            .clip(RoundedCornerShape(12.dp))
//                            .clickable {
//                                onEpisodeClicked(characterId)
//                            }
//                            .padding(vertical = 8.dp),
//                    )
//                }
//
//                item { Spacer(modifier = Modifier.height(64.dp)) }
//            }
//        }
//    }
}
