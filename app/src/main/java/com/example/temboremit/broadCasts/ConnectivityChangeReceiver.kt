package com.example.temboremit.broadCasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.compose.runtime.MutableState
import com.example.temboremit.utils.checkInternetConnection

class ConnectivityChangeReceiver(private val isInternetConnected: MutableState<Boolean>) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == ConnectivityManager.CONNECTIVITY_ACTION) {
            val isInternetAvailable = context?.let { checkInternetConnection(it) }
            if (isInternetAvailable != null) {
                isInternetConnected.value = isInternetAvailable
            }
        }
    }
}