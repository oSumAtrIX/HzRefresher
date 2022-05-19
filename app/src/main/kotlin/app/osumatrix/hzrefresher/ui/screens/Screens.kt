package app.osumatrix.hzrefresher.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import app.osumatrix.hzrefresher.ui.screens.destinations.destinations.ConfigurationScreenDestination
import app.osumatrix.hzrefresher.ui.screens.destinations.destinations.InformationScreenDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

enum class Screens(
    val direction: DirectionDestinationSpec,
    val label: String,
    val icon: ImageVector
) {
    ConfigurationScreen(
        direction = ConfigurationScreenDestination,
        icon = Icons.Default.Settings,
        label = "Configuration"
    ),
    InformationScreen(
        direction = InformationScreenDestination,
        icon = Icons.Default.Info,
        label = "Information"
    )
}