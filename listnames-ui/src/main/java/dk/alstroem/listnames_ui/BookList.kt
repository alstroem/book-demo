package dk.alstroem.listnames_ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyGridScope
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.AsyncImage
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

    LazyVerticalGrid(
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

@ExperimentalFoundationApi
fun <T: Any> LazyGridScope.items(
    lazyPagingItems: LazyPagingItems<T>,
    itemContent: @Composable LazyItemScope.(value: T?) -> Unit
) {
    items(lazyPagingItems.itemCount) { index ->
        itemContent(lazyPagingItems[index])
    }
}
