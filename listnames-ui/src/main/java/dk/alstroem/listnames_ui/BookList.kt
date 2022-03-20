package dk.alstroem.listnames_ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import dk.alstroem.lists_domain.model.Book

@Composable
fun BookList(
    navController: NavController,
    viewModel: BookListViewModel,
    encodedName: String
) {
    BookListScreen(
        viewModel = viewModel,
        encodedName = encodedName
    )
}

@Composable
private fun BookListScreen(
    viewModel: BookListViewModel,
    encodedName: String,
    modifier: Modifier = Modifier
) {
    val bookItems = remember {
        viewModel.getPageFlow(encodedName)
    }.collectAsLazyPagingItems()

    LazyColumn {
        items(bookItems) { book ->
            if (book != null) {
                BookItem(book = book)
            }
        }
    }
}

@Composable
fun BookItem(
    book: Book,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Text(text = book.title)
    }
}
