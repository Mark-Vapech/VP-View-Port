package app.vp.base.textCustom

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextFieldCustom(value: String, label: String, onValueChange: (String) -> Unit) {

    TextField(
        modifier = Modifier
            .border(
                width = 2.dp,
                color = Color.Red,
                shape = RoundedCornerShape(10.dp)
            ),
        value = value,
        onValueChange = onValueChange,
    )

}

@Composable
fun OutlinedTextFieldCustom(value: String, label: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier
            .border(
                width = 2.dp,
                color = Color.Red,
                shape = RoundedCornerShape(10.dp)
            )
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(10.dp)
            ),
        value = value,
        onValueChange = onValueChange,
        visualTransformation = if (value == "password") PasswordVisualTransformation() else {
            VisualTransformation.None
        },
        keyboardOptions = if (value == "password") KeyboardOptions(keyboardType = KeyboardType.Password) else {
            KeyboardOptions.Default
        },
    )
}

@Composable
fun BasicTextFieldCustom(name: String, value: String, onValueChange: (String) -> Unit) {

    Column(modifier =  Modifier.padding(horizontal = 16.dp)) {
        Text(text = name)
        Spacer(modifier = Modifier.height(10.dp))
        BasicTextField(
            modifier = Modifier
            .border(
                width = 2.dp,
                color = Color.Red,
                shape = RoundedCornerShape(10.dp)
            ),
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
            keyboardOptions = KeyboardOptions(),
            keyboardActions = KeyboardActions(),
            readOnly = false,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .height(42.dp)
                    .background(color = Color.Transparent),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 10.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    it.invoke()
                }
            }
        }
    }
}