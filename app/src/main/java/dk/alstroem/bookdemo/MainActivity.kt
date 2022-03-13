package dk.alstroem.bookdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import dk.alstroem.theme.BookDemoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookDemoTheme {
                val systemUiController = rememberSystemUiController()
                val statusBarColor = MaterialTheme.colorScheme.primary

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = statusBarColor
                    )
                }

                val navController = rememberNavController()
                BookNavGraph(
                    navController = navController
                )
            }
        }
    }
}
