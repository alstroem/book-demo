package dk.alstroem.listnames_ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.stringResource
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
    ListNamesScreen(viewModel = viewModel) {
        // TODO: Add navigation
    }
}

@Composable
private fun ListNamesScreen(
    viewModel: ListNamesViewModel,
    modifier: Modifier = Modifier,
    onClick: (ListNameResult) -> Unit
) {
    val listNameItems by viewModel.listNameItems.observeAsState(initial = emptyList())
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        item { ListsNamesTitle() }

        items(items = listNameItems) { listNameResult ->
            ListName(listNameResult = listNameResult) {
                onClick(listNameResult)
            }
        }
    }
}

@Composable
private fun ListsNamesTitle(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.list_names_lbl),
        style = MaterialTheme.typography.headlineLarge,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = modifier.padding(bottom = 8.dp)
    )
}

@ExperimentalMaterial3Api
@Composable
private fun ListName(
    listNameResult: ListNameResult,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        onClick = onClick
    ) {
        Box(
            modifier = Modifier.padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column {
                ListNameTitle(title = listNameResult.displayName)
                Spacer(modifier = Modifier.height(2.dp))
                ListNamePublished(published = listNameResult.newestPublishedDate)
            }
        }
    }
}

@Composable
private fun ListNameTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}

@Composable
private fun ListNamePublished(published: String) {
    Row {
        Text(
            text = stringResource(id = R.string.list_name_newest_published_lbl),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = published,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
        )
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
        ) {}
    }
}
