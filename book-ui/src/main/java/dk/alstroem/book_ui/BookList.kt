package dk.alstroem.book_ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import dk.alstroem.book_domain.model.Book
import dk.alstroem.best_sellers_ui.items

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

    LazyVerticalGrid(
        modifier = modifier,
        cells = GridCells.Adaptive(minSize = 160.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
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
    Card {
        AsyncImage(model = book.bookImage, contentDescription = "Book image", modifier = modifier
            .fillMaxWidth()
            .aspectRatio(0.66f))
    }
}
