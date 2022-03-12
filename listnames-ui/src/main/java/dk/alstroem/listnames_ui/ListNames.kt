package dk.alstroem.listnames_ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import dk.alstroem.theme.BookDemoTheme

@Composable
fun ListNames(navController: NavController) {
    ListNamesScreen()
}

@Composable
private fun ListNamesScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        item {
            Greeting(name = "Book Demo")
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
