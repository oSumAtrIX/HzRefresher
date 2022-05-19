package app.osumatrix.hzrefresher.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import app.osumatrix.hzrefresher.ui.screens.destinations.NavGraphs
import app.osumatrix.hzrefresher.ui.screens.destinations.startAppDestination
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.utils.currentDestinationAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val controller = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        content = { innerPadding ->
            DestinationsNavHost(
                modifier = Modifier.padding(innerPadding),
                navController = controller,
                navGraph = NavGraphs.root,
            )
        },
        bottomBar = { BottomNavigationBar(controller) }
    )
}

@Composable
private fun TopBar() {
    LargeTopAppBar(
        title = {
            Column(
                content = {
                    Text(
                        "HzRefresher",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "Global refresh rate changer",
                        style = MaterialTheme.typography.titleMedium,
                    )
                }
            )
        }
    )
}

@Composable
private fun BottomNavigationBar(controller: NavController) {
    val currentDestination =
        controller.currentDestinationAsState().value ?: NavGraphs.root.startAppDestination

    NavigationBar(
        content = {
            Screens.values().forEach { screen ->
                NavigationBarItem(
                    selected = currentDestination.route == screen.direction.route,
                    onClick = {
                        if (currentDestination.route != screen.direction.route)
                            controller.navigate(
                                route = screen.direction.route,
                            ) {
                                popUpTo(controller.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                    },
                    icon = {
                        Icon(
                            imageVector = screen.icon,
                            contentDescription = screen.label
                        )
                    },
                    label = { Text(screen.label) }
                )
            }
        }
    )
}