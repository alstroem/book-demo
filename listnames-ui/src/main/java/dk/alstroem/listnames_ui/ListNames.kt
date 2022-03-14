package dk.alstroem.listnames_ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dk.alstroem.lists_domain.model.ListNameResult
import dk.alstroem.lists_domain.model.UpdateFrequency
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
    val listNameItems by viewModel.listNameItems.observeAsState(initial = emptyList())
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        items(items = listNameItems) { listNameResult ->
            ListName(listNameResult = listNameResult)
        }
    }
}

@ExperimentalMaterial3Api
@Composable
private fun ListName(
    listNameResult: ListNameResult,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Box(
            modifier = Modifier
                .defaultMinSize(minHeight = 64.dp)
                .padding(8.dp)
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = listNameResult.displayName,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BookDemoTheme {
        ListName(
            listNameResult = ListNameResult(
                "Hardcover Fiction",
                "Hardcover Fiction",
                "hardcover-fiction",
                "2008-06-08",
                "2022-03-20",
                UpdateFrequency.WEEKLY
            )
        )
    }
}
