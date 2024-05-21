package com.ph32395.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import duyndph34554.fpoly.lab_4.ui.theme.Lab_4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab_4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginCompose()

                }
            }
        }
    }
}



@Composable
fun LoginCompose() {

    val context = LocalContext.current
    var userName by remember { mutableStateOf("") }
    var passWord by remember { mutableStateOf("") }

    Column (modifier = Modifier
        .padding(12.dp)
        .fillMaxWidth()
        .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
//    Anh logo
        Image(
            painter = painterResource(id = R.drawable.anh_nhom_que),
            contentDescription = "Anh que",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(130.dp)
                .height(130.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(30.dp))

//      Text userName
        OutlinedTextField(value = userName, onValueChange = {userName = it},
            label = { Text(text = "UserName")})

        Spacer(modifier = Modifier.height(10.dp))

//       TextField PassWord
        OutlinedTextField(value = passWord, onValueChange = {passWord = it},
//            giong vowi plandehoder
            label = { Text(text = "PassWord")},
            //Mat khau sang dinh dang dau cham
            visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(20.dp))

//        Button
        Button(onClick = {
            if (userName.isNotBlank() && passWord.isNotBlank()) {
                Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Please enter userName and passWord", Toast.LENGTH_SHORT).show()
            }
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Cyan,
                contentColor = Color.Red
            )) {
            Text(text = "Login")
        }



    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Lab_4Theme {
        LoginCompose()

    }
}