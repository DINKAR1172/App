package com.example.apps

import android.os.Build
import androidx.compose.runtime.MutableLongState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZoneId.systemDefault
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import java.util.SimpleTimeZone
import java.util.logging.SimpleFormatter

class MainViewModel:ViewModel() {
    private var _SelectedDate= mutableLongStateOf(0L)
    var SelectedDate:State<Long> =_SelectedDate
    private var _DisplayDate= mutableStateOf("")
    var DisplayDate:State<String> =_DisplayDate
    private var _DisplayDateTime= mutableStateOf("")
    var DisplayDateTime:State<String> =_DisplayDate
   private var _SelectedTime= mutableStateOf(0L)
    var SelectedTime:State<Long> =_SelectedTime
    private var _DisplayTime= mutableStateOf("")
    var DisplayTime:State<String> =_DisplayTime

    fun getTime(data:Long){
        _SelectedTime.value=data
    }

    fun TimeConverter(TimeStamp:Long){
        val formatter=SimpleDateFormat("HH:mm",Locale.getDefault())
        _DisplayTime.value=formatter.format(TimeStamp)

    }

   fun getDate(date:Long){
        _SelectedDate.value=date
    }

    fun ConvertDate(){
        val formatter= SimpleDateFormat("dd/MMM/yyyy", Locale.getDefault())
        if (_SelectedDate.value!=null){
            _DisplayDate.value= formatter.format(_SelectedDate.value)
        }


    }



}


