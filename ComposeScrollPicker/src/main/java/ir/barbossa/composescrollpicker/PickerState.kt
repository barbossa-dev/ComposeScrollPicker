package ir.barbossa.composescrollpicker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class PickerState {
    var selectedItem = mutableStateOf("")
}

@Composable
fun rememberPickerState() = remember { PickerState() }