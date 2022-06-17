package com.luftborn.taskexecuterapp.presentation.ui.logscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luftborn.taskexecuterapp.Constants.TOOLBAR_LOGSCREEN_TITLE
import com.luftborn.taskexecuterapp.R
import com.luftborn.taskexecuterapp.presentation.ui.theme.TOOLBAR_TITLE_COLOR


@Composable
fun ToolbarItem() {

    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Image(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .size(24.dp),
                painter = painterResource(id = R.drawable.ic_baseline_menu_24),
                contentDescription = "menu"
            )

            Text(
                modifier = Modifier.align(Alignment.BottomCenter), text = TOOLBAR_LOGSCREEN_TITLE,
                color = TOOLBAR_TITLE_COLOR, fontSize = 20.sp

            )


        }
    }


}