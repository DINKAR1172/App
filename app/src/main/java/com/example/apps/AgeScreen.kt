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
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar

@Composable
fun AgeScreen(context: Context){
Scaffold(topBar = { TopAppBar(title = { Text(text = "Age To Minutes Calculator")}, backgroundColor = Color.Yellow) }
) {
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
              clickDatePicker(context)
          }
          .padding(8.dp), backgroundColor = Color.White, elevation = 4.dp) {
Row(modifier = Modifier
    .fillMaxWidth()
    .padding(8.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
   Text(text = "Select Date", fontSize = 30.sp, color = Color.Gray)
}
      }
      Text(text = "11/07/2002", fontSize = 20.sp, color = Color.Black)
      Text(text = "Selected date", fontSize = 20.sp, color = Color.Gray)
      Spacer(modifier = Modifier.height(4.dp))
      Text(text = "1569780", fontSize = 20.sp, color = Color.Black)
      Text(text = "In Mintues Till Date", fontSize = 20.sp, color = Color.Gray)

   }
}
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun clickDatePicker(context: Context){
val  myCalendar= Calendar.getInstance()
    val year=myCalendar.get(Calendar.YEAR)
    val Month=myCalendar.get(Calendar.MONTH)
    val day=myCalendar.get(Calendar.DAY_OF_MONTH)
    DatePickerDialog(onDismissRequest = { /*TODO*/ }, confirmButton = { /*TODO*/ }) {
        
    }
}