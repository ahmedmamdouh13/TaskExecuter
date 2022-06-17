package com.luftborn.taskexecuterapp.data.tasks

import com.luftborn.taskexecuterapp.data.model.OutputDataModel
import com.luftborn.taskexecuterapp.util.DateUtil

abstract class Task()  {


    abstract suspend fun execute(): OutputDataModel

    fun getDataModel(taskTitle: String): OutputDataModel =
        OutputDataModel(DateUtil.getDisplayableDate(), taskTitle)

}