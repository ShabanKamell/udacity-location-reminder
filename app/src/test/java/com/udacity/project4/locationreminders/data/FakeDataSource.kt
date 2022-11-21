package com.udacity.project4.locationreminders.data

import com.udacity.project4.locationreminders.data.dto.ReminderDTO
import com.udacity.project4.locationreminders.data.dto.Result

class FakeDataSource(var remindersList: MutableList<ReminderDTO> = mutableListOf()) :
    ReminderDataSource {

    private var shouldReturnError = false

    fun setReturnError(value: Boolean) {
        shouldReturnError = value
    }

    override suspend fun getReminders(): Result<List<ReminderDTO>> {
        if (shouldReturnError) return Result.Error("Error getting reminders")
        return Result.Success(remindersList)
    }

    override suspend fun saveReminder(reminder: ReminderDTO) {
        remindersList.add(reminder)
    }

    override suspend fun getReminder(id: String): Result<ReminderDTO> {
        val reminder = remindersList.find { reminderDTO ->
            reminderDTO.id == id
        }

        if (shouldReturnError) return Result.Error("Reminder not found!")
        return if (reminder == null)
            Result.Error("Reminder not found!") else
            Result.Success(reminder)
    }

    override suspend fun deleteAllReminders() {
        remindersList.clear()
    }

}