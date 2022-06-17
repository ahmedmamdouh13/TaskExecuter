package com.luftborn.taskexecuterapp.data.tasks

import com.luftborn.taskexecuterapp.Constants.ENDPOINT_DELAY
import com.luftborn.taskexecuterapp.Constants.TASK_2
import com.luftborn.taskexecuterapp.data.model.OutputDataModel
import kotlinx.coroutines.delay

class Task2() : Task() {

    override suspend fun execute(): OutputDataModel {
        delay(ENDPOINT_DELAY)
        return getDataModel(TASK_2)
    }

}