package ir.barbossa.scrollpicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.barbossa.composescrollpicker.rememberPickerState
import ir.barbossa.scrollpicker.ui.theme.ScrollPickerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val values = remember { (1..99).map { it.toString() } }
            val valuesPickerState = rememberPickerState()
            val units = remember { listOf("seconds", "minutes", "hours") }
            val unitsPickerState = rememberPickerState()
            ScrollPickerTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                        .padding(30.dp)
                )
                {
                    Column(
                        modifier = Modifier.align(Alignment.Center),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            modifier = Modifier
                                .padding(20.dp)
                                .fillMaxWidth()
                                .wrapContentHeight(),
                            painter = painterResource(R.drawable.ic_barbossa),
                            contentDescription = null,
                        )
                        Text(
                            text = "barbossa",
                            fontFamily = FontFamily(Font(R.font.font)),
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            color = Color.White
                        )
                        Text(text = "Example Picker", modifier = Modifier.padding(top = 16.dp))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            ScrollPicker(
                                state = valuesPickerState,
                                items = values,
                                visibleItemsCount = 3,
                                modifier = Modifier.weight(0.3f),
                                textStyle = TextStyle(fontSize = 32.sp, color = Color.White),
                                dividerColor = Color.Blue
                            )
                            ScrollPicker(
                                state = unitsPickerState,
                                items = units,
                                visibleItemsCount = 3,
                                modifier = Modifier.weight(0.7f),
                                textStyle = TextStyle(fontSize = 32.sp, color = Color.White),
                                dividerColor = Color.Blue
                            )
                        }

                        Text(
                            text = "Interval: ${valuesPickerState.selectedItem.value} ${unitsPickerState.selectedItem.value}",
                            modifier = Modifier.padding(vertical = 16.dp),
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}
