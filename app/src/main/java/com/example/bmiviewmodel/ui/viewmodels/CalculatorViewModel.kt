package com.example.bmiviewmodel.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat

class CalculatorViewModel : ViewModel() {

    var heightInput by mutableStateOf("")
        private set

    var weightInput by mutableStateOf("")
        private set

    fun onHeightChange(s: String) { heightInput=s }
    fun onWeightChange(s: String) { weightInput=s }

    val height: Double get() = heightInput.toDoubleOrNull() ?: 0.0
    val weight: Double get() = weightInput.toDoubleOrNull() ?: 0.0

    val bmi: Double get() = if (weight > 0 && height > 0) weight / (height * height) else 0.0

    val bmiFormatted: String get() = DecimalFormat("0.00").format(bmi)

}