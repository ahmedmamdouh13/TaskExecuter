package com.luftborn.taskexecuterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luftborn.taskexecuterapp.data.model.OutputDataModel
import com.luftborn.taskexecuterapp.ui.logscreen.LogItem
import com.luftborn.taskexecuterapp.ui.logscreen.TaskItemList
import com.luftborn.taskexecuterapp.ui.theme.TOOLBAR_TITLE_COLOR
import com.luftborn.taskexecuterapp.ui.theme.TaskExecuterAppTheme
import com.luftborn.taskexecuterapp.util.DateUtil

class MainActivity : ComponentActivity() {
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        taskViewModel = TaskViewModel()



        setContent {
            TaskExecuterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    LogScreen()
                }
            }
        }
    }

    @Composable
    fun LogScreen() {


        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ToolbarItem()
            Spacer(modifier = Modifier.padding(58.dp))

            LogItem(model = taskViewModel.liveData.observeAsState(listOf()).value)

            Spacer(modifier = Modifier.padding(58.dp))

            TaskItemList(::onTaskClicked)
        }


    }

    private fun onTaskClicked(task: String) {
        taskViewModel.executeTask(task)
    }

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
                    modifier = Modifier.align(Alignment.BottomStart),
                    painter = painterResource(id = R.drawable.ic_baseline_menu_24),
                    contentDescription = "menu"
                )

                Text(
                    modifier = Modifier.align(Alignment.BottomCenter), text = "Task Executer App",
                    color = TOOLBAR_TITLE_COLOR, fontSize = 20.sp

                )


            }
        }


    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun DefaultPreview() {
        TaskExecuterAppTheme {
            LogScreen()
        }
    }
}
