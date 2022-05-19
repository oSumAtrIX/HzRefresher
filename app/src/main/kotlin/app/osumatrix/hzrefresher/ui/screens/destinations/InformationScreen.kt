package app.osumatrix.hzrefresher.ui.screens.destinations

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun InformationScreen() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(10),
        content = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                content = {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(16.dp, 32.dp)
                            .size(48.dp),
                        imageVector = Icons.Default.Info,
                        contentDescription = "Information",
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .fillMaxWidth(),
                        content = {
                            Text(
                                text = "Disclaimer",
                                style = MaterialTheme.typography.titleLarge,
                            )
                            Text(
                                text = "This application was intended to run on OxygenOS or ColorOS running Android 12.\nOther devices running Android versions below Android 12 might not apply the settings",
                                style = MaterialTheme.typography.titleSmall,
                            )
                        }
                    )

                }
            )
        },
    )
}