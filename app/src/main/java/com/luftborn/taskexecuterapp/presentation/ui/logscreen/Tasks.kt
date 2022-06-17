package com.luftborn.taskexecuterapp.presentation.ui.logscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luftborn.taskexecuterapp.Constants.TASK_1
import com.luftborn.taskexecuterapp.Constants.TASK_2
import com.luftborn.taskexecuterapp.Constants.TASK_3
import com.luftborn.taskexecuterapp.Constants.TASK_4
import com.luftborn.taskexecuterapp.presentation.ui.theme.BORDER_COLOR


val task1ButtonState = mutableStateOf(false)
val task2ButtonState = mutableStateOf(false)
val task3ButtonState = mutableStateOf(false)
val task4ButtonState = mutableStateOf(false)

const val taskTitle1 = TASK_1
const val taskTitle2 = TASK_2
const val taskTitle3 = TASK_3
const val taskTitle4 = TASK_4

@Composable
fun TaskItem(title: String, isSelected: Boolean, onClick: (String) -> Unit) {

    val backgroundColor = if (!isSelected) Color.White else Color.Black
    val textColor = if (isSelected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(
                backgroundColor,
                RoundedCornerShape(7.5.dp)
            )
            .clickable {
                onClick(title)
            },
        Alignment.Center
    ) {

        Text(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp), text = title,
            textAlign = TextAlign.Center,
            fontSize = 14.sp, fontWeight = Bold,
            color = textColor
        )
    }


}

@Composable
fun TaskItemList(onClick: (String) -> Unit) {

    Row(
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth(unbounded = true)
            .border(width = 1.dp, BORDER_COLOR, RoundedCornerShape(7.5.dp))
            .background(
                Color.White,
                RoundedCornerShape(7.5.dp)
            ),
        horizontalArrangement = Arrangement.Center,

        ) {
        TaskItem(title = taskTitle1, isSelected = task1ButtonState.value) {
            onClick(it)
            onStateChange(it)
        }

        TaskItem(title = taskTitle2, isSelected = task2ButtonState.value) {
            onClick(it)
            onStateChange(it)
        }

        TaskItem(title = taskTitle3, isSelected = task3ButtonState.value) {
            onClick(it)
            onStateChange(it)
        }

        TaskItem(title = taskTitle4, isSelected = task4ButtonState.value) {
            onClick(it)
            onStateChange(it)
        }
    }

}

private fun onStateChange(it: String) {
    task1ButtonState.value = it == taskTitle1
    task2ButtonState.value = it == taskTitle2
    task3ButtonState.value = it == taskTitle3
    task4ButtonState.value = it == taskTitle4
}

@Preview(showSystemUi = true)
@Composable
fun displayTaskItem() {

    TaskItemList({})
//    TaskItem(title = "Task 1", true)
}