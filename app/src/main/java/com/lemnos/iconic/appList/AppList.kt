package com.lemnos.iconic.appList

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.pm.PackageManager.MATCH_ALL
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.ContentInfoCompat.Flags

@SuppressLint("WrongConstant")
@Composable
fun AppList(context: Context, modifier: Modifier) {
    val packageManager = context.packageManager
    val installedPackages = packageManager.getInstalledPackages(PackageManager.MATCH_SYSTEM_ONLY)

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
            .padding(horizontal = 20.dp)
    ) {
        installedPackages.forEach { it ->
            var formattedName = it.packageName.split(".").last().replaceFirstChar { it.uppercaseChar() }
            if(formattedName.length > 14) {
                formattedName = formattedName.take(12) + "..."
            }
            if(packageManager.getLaunchIntentForPackage(it.packageName) != null) {
                item {
                    AppItem(
                        appName = formattedName,
                        appIcon = packageManager.getApplicationIcon(it.applicationInfo)
                    )
                }
            }
        }
    }
}