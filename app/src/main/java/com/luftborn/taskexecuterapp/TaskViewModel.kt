package com.luftborn.taskexecuterapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luftborn.taskexecuterapp.Constants.TASK_1
import com.luftborn.taskexecuterapp.Constants.TASK_2
import com.luftborn.taskexecuterapp.Constants.TASK_3
import com.luftborn.taskexecuterapp.Constants.TASK_4
import com.luftborn.taskexecuterapp.Constants.USER_TOUCH_DELAY
import com.luftborn.taskexecuterapp.data.model.OutputDataModel
import com.luftborn.taskexecuterapp.data.tasks.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TaskViewModel() : ViewModel() {



    private val listOfOutPuts = mutableStateListOf<OutputDataModel>()

    private val taskQueue = arrayListOf<Task>()
    val liveData = MutableLiveData<List<OutputDataModel>>()

    private fun executeTask1() {
        execute(Task1())
    }

    private fun executeTask2() {
        execute(Task2())
    }

    private fun executeTask3() {
        execute(Task3())
    }

    private fun executeTask4() {
        execute(Task4())
    }

    private fun execute(task: Task) {
        taskQueue.add(task)
        viewModelScope.launch {

            delay(USER_TOUCH_DELAY)

            launchParallelTasks()

            taskQueue.clear() // clear executed tasks
        }
    }

    private fun launchParallelTasks() {
        taskQueue.forEach { task ->
            viewModelScope.launch {
                val output = task.execute()
                listOfOutPuts.add(output)
                liveData.value = listOfOutPuts
            }
        }
    }


    fun executeTask(task: String) {
        when (task) {
            TASK_1 -> executeTask1()
            TASK_2 -> executeTask2()
            TASK_3 -> executeTask3()
            TASK_4 -> executeTask4()
        }
    }


}