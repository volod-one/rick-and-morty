import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(
    onGoToScreen2Click: () -> Unit,
    onGoToScreen3Click: () -> Unit,
//    onCharacterSelected: (Int) -> Unit,
//    viewModel: HomeScreenViewModel = hiltViewModel(),
) {
    // TODO: TEST CODE
    Column() {
        Button(onClick = onGoToScreen2Click) {
            Text(text = "GO TO SCREEN 2")
        }
        Button(onClick = onGoToScreen3Click) {
            Text(text = "GO TO SCREEN 3")
        }
    }

//    val viewState by viewModel.viewState.collectAsState()
//
//    LaunchedEffect(key1 = viewModel) { viewModel.fetchInitialPage() }
//
//    val scrollState = rememberLazyGridState()
//    val fetchNextPage: Boolean by remember {
//        derivedStateOf {
//            val currentCharacterCount =
//                (viewState as? HomeScreenViewState.GridDisplay)?.characters?.size
//                    ?: return@derivedStateOf false
//            val lastDisplayedIndex = scrollState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
//                ?: return@derivedStateOf false
//            return@derivedStateOf lastDisplayedIndex >= currentCharacterCount - 10
//        }
//    }
//
//    LaunchedEffect(key1 = fetchNextPage) {
//        if (fetchNextPage) {
//            viewModel.fetchNextPage()
//        }
//    }

//    when (val state = viewState) {
//        HomeScreenViewState.Loading -> LoadingState()
//        is HomeScreenViewState.GridDisplay -> {
//            LazyVerticalGrid(
//                state = scrollState,
//                contentPadding = PaddingValues(16.dp),
//                verticalArrangement = Arrangement.spacedBy(8.dp),
//                horizontalArrangement = Arrangement.spacedBy(8.dp),
//                columns = GridCells.Fixed(2),
//                content = {
//                    items(
//                        items = state.characters,
//                        key = { it.id },
//                    ) { character ->
//                        CharacterGridItem(
//                            modifier = Modifier,
//                            character = character,
//                            onClick = {
//                                onCharacterSelected(character.id)
//                            }
//                        )
//                    }
//                }
//            )
//        }
//
//        is HomeScreenViewState.Error -> {
//             TODO
//        }
//    }
}
