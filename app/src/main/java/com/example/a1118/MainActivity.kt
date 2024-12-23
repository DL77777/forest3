package com.example.a1118

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import com.example.a1118.ui.theme._1118Theme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.offset



class MainActivity : ComponentActivity() {
    private fun setRequestedDrientation(screenOrientationLandscape: Int) {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _1118Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val game = Game(GlobalScope)

                    setRequestedDrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
                    val screenW = resources.displayMetrics.widthPixels
                    val screenH = resources.displayMetrics.heightPixels

                    Start(m = Modifier.padding(innerPadding),game,screenW)

                }
            }
        }
    }
}

@Composable

fun Start(m: Modifier,game:Game,screenW:Int){

    var counter2 by remember { mutableStateOf(0) }
    val counter by game.state.collectAsState()
    var x by remember {(mutableStateOf(0))}
    x++
    if(counter>screenW){
        x=0

    }
    Image(
        painter = painterResource(id = R.drawable.forest),
        contentDescription = "背景圖",
        contentScale = ContentScale.FillBounds,  //縮放符合螢幕寬度
        modifier = Modifier
            .offset { IntOffset(-counter,0) }
    )
    Image(
        painter = painterResource(id = R.drawable.forest),
        contentDescription = "背景圖2",
        contentScale = ContentScale.FillBounds,  //縮放符合螢幕寬度
        modifier = Modifier
            .offset { IntOffset(-counter+screenW, 0) }
    )


    Row {
        Button(
            onClick = {
                game.Play()
            },
                modifier = m
        ){
            Text(text = "開始")

            Text(text = counter.toString(),modifier = m)
        }


        Text(text = counter.toString(), modifier = m)

        Button(
            onClick = {
                if (counter2<40){
                    counter2 ++
                }
            }
        ) {
            Text(text = "加1")
        }

        Text(text = counter2.toString(), modifier = m)
    }

}

