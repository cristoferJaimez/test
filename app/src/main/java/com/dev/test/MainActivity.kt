package com.dev.test


import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.test.ui.theme.TestTheme


private val messages: List<MyMessage> = listOf(
    MyMessage("hola, primera interacción", "primeros pasos en la aplicación de jetpack Composer, primeros pasos en la aplicación de jetpack Composer, primeros pasos en la aplicación de jetpack Composer"),
    MyMessage("hola, primera interacción", "primeros pasos en la aplicación de jetpack Composer"),
    MyMessage("hola, primera interacción", "primeros pasos en la aplicación de jetpack Composer"),
    MyMessage("hola, primera interacción", "primeros pasos en la aplicación de jetpack Composer"),
    MyMessage("hola, primera interacción", "primeros pasos en la aplicación de jetpack Composer"),
    MyMessage("hola, primera interacción", "primeros pasos en la aplicación de jetpack Composer"),
    MyMessage("hola, primera interacción", "primeros pasos en la aplicación de jetpack Composer"),
    MyMessage("hola, primera interacción", "primeros pasos en la aplicación de jetpack Composer"),
    MyMessage("hola, primera interacción", "primeros pasos en la aplicación de jetpack Composer"),
    MyMessage("hola, primera interacción", "primeros pasos en la aplicación de jetpack Composer, primeros pasos en la aplicación de jetpack Composer , primeros pasos en la aplicación de jetpack Composer"),
    MyMessage("hola, primera interacción", "primeros pasos en la aplicación de jetpack Composer"),
    MyMessage("hola, primera interacción", "primeros pasos en la aplicación de jetpack Composer"),
    MyMessage("hola, primera interacción", "primeros pasos en la aplicación de jetpack Composer")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            TestTheme {
                MyMessages(messages)
            }
        }
    }

}


data class MyMessage(val title: String, val body : String)

@Composable
fun MyMessages(messages: List<MyMessage>){
    LazyColumn {
        items(messages) { message ->
            MyComponent(message)
        }
    }
}


@Composable
fun MyComponent(message: MyMessage){
    Row(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .padding(8.dp)){
        MyImage()
        MyTexts(message)
    }
}

@Composable
fun MyImage(){
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "my images for test",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .size(64.dp)
    )
}



@Composable
fun MyTexts(message: MyMessage){

    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .padding(start = 8.dp)
        .clickable {
            expanded = !expanded
        }) {
        MyText(message.title,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyMedium

        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(message.body,
        MaterialTheme.colorScheme.onBackground,
        MaterialTheme.typography.bodySmall,
        if(expanded) Int.MAX_VALUE else 1
        )
    }
}


@Composable
fun MyText( text: String, color : Color, style: TextStyle, lines: Int = Int.MAX_VALUE){
    Text(text, color = color, style = style, maxLines = lines)
}



@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun PreviewText(){
    TestTheme {
        MyMessages(messages)
    }
}


