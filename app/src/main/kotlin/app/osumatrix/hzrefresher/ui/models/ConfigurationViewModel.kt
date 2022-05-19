package app.osumatrix.hzrefresher.ui.models

import android.content.ContentValues
import android.content.Context
import androidx.lifecycle.ViewModel
import app.osumatrix.hzrefresher.ui.Constants

class ConfigurationViewModel : ViewModel() {


    fun updateRefreshRate(context: Context, enabled: Boolean) {
        for (setting in Constants.settings) {
            val values = ContentValues()
            values.put("name", setting)
            values.put("value", if (enabled) "59.0" else "120.0")
            context.contentResolver.insert(
                Constants.settingsUri, values
            )
        }
    }
}
