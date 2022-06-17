package com.luftborn.taskexecuterapp.ui.logscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luftborn.taskexecuterapp.data.model.OutputDataModel
import com.luftborn.taskexecuterapp.ui.theme.BORDER_COLOR
import kotlin.math.log

@Composable
fun LogItem(model: List<OutputDataModel>){

    Box(modifier = Modifier
        .width(300.dp)
        .height(325.dp)
        .background(
            Color.White,
            RoundedCornerShape(7.5.dp)
        )
        .border(
            width = 1.dp, BORDER_COLOR,
            RoundedCornerShape(7.5.dp)
        )
    ) {

        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 18.dp), reverseLayout = true) {


            items(model.asReversed()){
                val displayableDate = it.displayableDate
                val taskTitle = it.taskTitle

                Row(modifier = Modifier.padding(vertical = 5.dp, horizontal = 18.dp)) {
                    Text(text = displayableDate, fontSize = 14.sp)
                    Spacer(modifier = Modifier.padding(start = 4.dp))
                    Text(text = taskTitle, fontWeight = Bold, fontSize = 14.sp)
                }
            }

        }
    }

}

fun getLogText(it: OutputDataModel): String {
    return "${it.displayableDate} ${it.taskTitle}"
}
