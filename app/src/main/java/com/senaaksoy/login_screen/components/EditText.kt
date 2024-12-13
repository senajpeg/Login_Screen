package com.senaaksoy.login_screen.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextField(
    value : String,
    onValueChange: (String)->Unit,
    @StringRes label :Int,
    keyboardOptions: KeyboardOptions,
    visualTransformation: VisualTransformation=VisualTransformation.None,
    @StringRes supportingtext:Int?=null
){
    TextField(
        value = value,
        onValueChange = onValueChange,
        label= {Text(text = stringResource(id=label))},
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        supportingText = supportingtext?.let {
            {
                Text(
                    text = stringResource(id = it),
                    color = Color.Red
                )
            }
        },
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFF5F99B6))
    )
    }