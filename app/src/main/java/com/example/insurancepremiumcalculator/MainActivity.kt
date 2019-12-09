package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val reset : Button = findViewById(R.id.buttonReset)
        val calculateInsurance : Button = findViewById(R.id.buttonCalculate)
        calculateInsurance.setOnClickListener{calculateInsurance()}
        reset.setOnClickListener{reset()}
    }

    fun calculateInsurance(){
        val ages : Spinner = findViewById(R.id.spinnerAge)
        val gender : RadioGroup = findViewById(R.id.radioGroupGender)
        val smoke : CheckBox = findViewById(R.id.checkBoxSmoker)
        val displayTotal : TextView = findViewById(R.id.textViewPremium)
        val selectedId : Int = gender.checkedRadioButtonId
        val radioButton :RadioButton = findViewById(selectedId)
        var premiumPrice : Int = 0
        var premiumPrice2 : Int = 0
        var premiumPrice3 : Int = 0

        if(ages.selectedItem.toString().equals("Less than 17", ignoreCase = true)){
            premiumPrice = 60
            if(radioButton.getText().toString().equals("Male",ignoreCase = true)){
                premiumPrice2 = 60
                if(smoke.getText().toString().equals("Yes",ignoreCase = true)){
                    premiumPrice3 = 60
                }
            }
        }else if(ages.selectedItem.toString().equals("17 - 25", ignoreCase = true)){
            premiumPrice = 70
            if(radioButton.getText().toString().equals("Male",ignoreCase = true)){
                premiumPrice2 = 50 * premiumPrice
                if(smoke.getText().toString().equals("Yes",ignoreCase = true)){
                    premiumPrice3 = 100 * premiumPrice2
                }
            }
        }else if(ages.selectedItem.toString().equals("26 - 30", ignoreCase = true)){
            premiumPrice = 90
            if(radioButton.getText().toString().equals("Male",ignoreCase = true)){
                premiumPrice2 = 100 * premiumPrice
                if(smoke.getText().toString().equals("Yes",ignoreCase = true)){
                    premiumPrice3 = 150 * premiumPrice2
                }
            }
        }else if(ages.selectedItem.toString().equals("31 - 40", ignoreCase = true)){
            premiumPrice = 120
            if(radioButton.getText().toString().equals("Male",ignoreCase = true)){
                premiumPrice2 = 150 * premiumPrice
                if(smoke.getText().toString().equals("Yes",ignoreCase = true)){
                    premiumPrice3 = 200 * premiumPrice2
                }
            }
        }else if(ages.selectedItem.toString().equals("41 - 55", ignoreCase = true)){
            premiumPrice = 150
            if(radioButton.getText().toString().equals("Male",ignoreCase = true)){
                premiumPrice2 = 200 * premiumPrice
                if(smoke.getText().toString().equals("Yes",ignoreCase = true)){
                    premiumPrice3 = 250 * premiumPrice2
                }
            }
        }else if(ages.selectedItem.toString().equals("More than 55", ignoreCase = true)){
            premiumPrice = 150
            if(radioButton.getText().toString().equals("Male",ignoreCase = true)){
                premiumPrice2 = 200 * premiumPrice
                if(smoke.getText().toString().equals("Yes",ignoreCase = true)){
                    premiumPrice3 = 300 * premiumPrice2
                }
            }
        }else{
            displayTotal.setText("Error")
        }

        displayTotal.setText(premiumPrice3)
    }

    fun reset(){
        val ages : Spinner = findViewById(R.id.spinnerAge)
        val gender : RadioGroup = findViewById(R.id.radioGroupGender)
        val smoke : CheckBox = findViewById(R.id.checkBoxSmoker)
        ages.setSelection(0)
        gender.clearCheck()
        if(smoke.isChecked()){smoke.setChecked(false)}
    }
}
