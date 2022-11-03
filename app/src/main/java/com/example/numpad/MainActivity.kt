package com.example.numpad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.numpad.ui.theme.NumPadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NumPadTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TransferPage ()
                }
            }
        }
    }
}


@Composable
fun TransferPage() {

    Row(horizontalArrangement = Arrangement.Center) {
        Text(text = "Send Money")
    }
    Column {

        Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier.weight(1f)) {

            MyNumPad(
                listOf("1", "2", "3", ""),
                listOf(0.25f, 0.25f, 0.25f, 0.25f)
            )
            MyNumPad(
                listOf("4", "5", "6", ""),
                listOf(0.25f, 0.25f, 0.25f, 0.25f)
            )
            MyNumPad(
                listOf("7", "8", "9", ""),
                listOf(0.25f, 0.25f, 0.25f, 0.25f)
            )
            MyNumPad(
                listOf("", "0", "<", ""),
                listOf(0.25f, 0.25f, 0.25f, 0.25f)
            )
        }
    }
}



@Composable
fun MyNumPad( texts: List<String>,  weights: List <Float> /*callback: (text: String) -> Any*/) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
    ) {
        Row(
            modifier= Modifier
                .fillMaxWidth()

        )
        {
            for (i in texts.indices) {
                MyButtons(
                    text = texts[i],
                    modifier = Modifier.weight(weights[i])
                    /*callback= callback*/
                )
            }
        }
    }
}

@Composable
fun MyButtons( text : String, modifier: Modifier = Modifier, /*callback: (text: String) -> Any*/
)
{
    OutlinedButton(modifier= modifier
        .padding(5.dp),
        onClick = {})
    {
        Text(text)
    }
}

