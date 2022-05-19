package app.osumatrix.hzrefresher.ui.screens.destinations

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import app.osumatrix.hzrefresher.ui.models.ConfigurationViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@RootNavGraph(start = true)
@Composable
fun ConfigurationScreen(
    viewModel: ConfigurationViewModel = ConfigurationViewModel()
) {
    val currentContext = LocalContext.current

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        content = {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20),
                content = {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        content = {
                            Column(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically),
                                content = {
                                    Text(
                                        text = "Global Refresh Rate",
                                        style = MaterialTheme.typography.titleLarge,
                                    )
                                    Text(
                                        text = "Enable or disable 120 hz refresh rate",
                                        style = MaterialTheme.typography.titleSmall,
                                    )
                                }
                            )
                            Switch(
                                checked = false,

                                onCheckedChange = { enabled ->
                                    viewModel.updateRefreshRate(currentContext, enabled)
                                },
                            )
                        },
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                }
            )

        },
    )
}