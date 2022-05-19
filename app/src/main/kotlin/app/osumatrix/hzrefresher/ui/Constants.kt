package app.osumatrix.hzrefresher.ui

import android.net.Uri

class Constants {
    companion object {
        const val homepage = "https://osumatrix.me"
        val settingsUri = Uri.parse("content://settings/system")
        val settings = arrayOf("min_fresh_rate", "peak_refresh_rate")
    }
}