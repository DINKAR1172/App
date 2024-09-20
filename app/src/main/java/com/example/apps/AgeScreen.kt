package com.example.apps

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalTime
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgeScreen(context: Context,viewModel: MainViewModel){
Scaffold(topBar = { TopAppBar(title = { Text(text = "Age To Minutes Calculator")}, backgroundColor = Color.Yellow) }
) {
    var Alert = remember{ mutableStateOf(false) }
   Column(modifier = Modifier
       .fillMaxSize()
       .background(colorResource(id = R.color.Back))
       .padding(it), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
       Text(text = "Calculte Your", fontSize = 40.sp, color = Color.Black)
      Box(modifier = Modifier
          .width(80.dp)
          .height(60.dp)
          .padding(4.dp)
          .background(Color.Cyan)) {
         Text(text = "Age", color = Color.White, fontSize = 40.sp)
      }
      Text(text = "In Minutes", fontSize = 40.sp, color = Color.Black)
      Card(modifier = Modifier
          .fillMaxWidth()
          .clickable {
              Alert.value = true
          }
          .padding(8.dp), backgroundColor = Color.White, elevation = 4.dp) {
Row(modifier = Modifier
    .fillMaxWidth()
    .padding(8.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
   Text(text = "Select Date", fontSize = 30.sp, color = Color.Gray)
}
      }
      Text(text = "${viewModel.DisplayDate.value}", fontSize = 20.sp, color = Color.Black)
      Text(text = "Selected date", fontSize = 20.sp, color = Color.Gray)
      Spacer(modifier = Modifier.height(4.dp))
      Text(text = viewModel.DisplayDateTime.value, fontSize = 20.sp, color = Color.Black)
      Text(text = "In Mintues Till Date", fontSize = 20.sp, color = Color.Gray)
       if(Alert.value==true){
           clickDatePicker(context = context, Alert =Alert,viewModel )
       }

       var TimeState= rememberTimePickerState()
       viewModel.TimeConverter(TimeState.)
       Text(text = "${viewModel.DisplayTime.value}")
       TimePicker(state =TimeState)




   }
}
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun clickDatePicker(context: Context,Alert:MutableState<Boolean>,viewModel: MainViewModel){
    var dateState= rememberDatePickerState(yearRange = 2002..2024)
    DatePickerDialog(onDismissRequest = {Alert.value=false }, confirmButton = { Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Button(onClick = {Alert.value=false}, modifier = Modifier.background(Color.Red)) {
            Text(text = "Delete", color = Color.White)
        }
        Button(onClick = {Alert.value=false}, modifier = Modifier.background(Color.Green)) {
            if (dateState.selectedDateMillis!= null){
                viewModel.getDate(dateState.selectedDateMillis!!
                )
                viewModel.ConvertDate()
            }
            Text(text = "Confirm", color = Color.White)
        }
    }}) {
DatePicker(state =dateState)
    }
}