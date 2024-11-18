package com.example.a1118

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.reflect.Modifier

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class Game(val scope: CoroutineScope) {
    var counter = 0
    val state = MutableStateFlow(0)

    fun Play(){
        scope.launch {
            counter = 0
            while (counter<1920) {
                delay(5)
                counter++
                state.emit(counter)
            }
        }
    }
}
