package dk.alstroem.listnames_ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import dk.alstroem.theme.BookDemoTheme

@Composable
fun ListNames(navController: NavController) {
    Greeting(name = "Book demo")
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
