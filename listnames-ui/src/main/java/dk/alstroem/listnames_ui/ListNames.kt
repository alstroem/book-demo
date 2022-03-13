package dk.alstroem.listnames_ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import dk.alstroem.theme.BookDemoTheme

@Composable
fun ListNames(
    navController: NavController,
    viewModel: ListNamesViewModel
) {
    ListNamesScreen(viewModel = viewModel)
}

@Composable
private fun ListNamesScreen(
    viewModel: ListNamesViewModel,
    modifier: Modifier = Modifier
) {
    val listNameItems by viewModel.listNames.observeAsState(initial = emptyList())
    
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(listNameItems) { listName ->
            Greeting(name = listName.displayName)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BookDemoTheme {
        Greeting("Android")
    }
}
