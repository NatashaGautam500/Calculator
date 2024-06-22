package com.natasha.calculator

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {
    lateinit var button1: android.widget.Button
    lateinit var button2: android.widget.Button
    lateinit var button3: android.widget.Button
    lateinit var button4: android.widget.Button
    lateinit var button5: android.widget.Button
    lateinit var button6: android.widget.Button
    lateinit var button7: android.widget.Button
    lateinit var button8: android.widget.Button
    lateinit var button9: android.widget.Button
    lateinit var button0: android.widget.Button
    lateinit var button00: android.widget.Button
    lateinit var buttonPercent: android.widget.Button
    lateinit var buttonClear: android.widget.Button
    lateinit var buttonDot: android.widget.Button
    lateinit var buttonEqual: android.widget.Button
    lateinit var buttonAdd: android.widget.Button
    lateinit var buttonMinus: android.widget.Button
    lateinit var buttonMul: android.widget.Button
    lateinit var buttonDivide: android.widget.Button
    lateinit var buttonBackspace: android.widget.Button
    lateinit var inputText: EditText
    lateinit var resultText: EditText
    var check=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        button0 = findViewById(R.id.btn0)
        button1 = findViewById(R.id.btn1)
        button2 = findViewById(R.id.btn2)
        button3 = findViewById(R.id.btn3)
        button4 = findViewById(R.id.btn4)
        button5 = findViewById(R.id.btn5)
        button6 = findViewById(R.id.btn6)
        button7 = findViewById(R.id.btn7)
        button8 = findViewById(R.id.btn8)
        button9 = findViewById(R.id.btn9)
        button00 = findViewById(R.id.btn00)
        buttonPercent = findViewById(R.id.btnPercent)
        buttonClear = findViewById(R.id.btnClear)
        buttonDot = findViewById(R.id.btnDot)
        buttonEqual = findViewById(R.id.btnEqual)
        buttonAdd = findViewById(R.id.btnAdd)
        buttonMinus = findViewById(R.id.btnMinus)
        buttonMul = findViewById(R.id.btnMultiply)
        buttonDivide = findViewById(R.id.btnDivide)
        buttonBackspace = findViewById(R.id.btnBackspace)
        resultText = findViewById(R.id.result)
        inputText = findViewById(R.id.inputNumber)
        inputText.movementMethod = ScrollingMovementMethod()
        inputText.setActivated(true)
        inputText.setPressed(true)

        var text: String

        button1.setOnClickListener {
            text = inputText.text.toString()+"1"
            inputText.setText(text)
            result(text)
        }

        button2.setOnClickListener {
            text = inputText.text.toString()+"2"
            inputText.setText(text)
            result(text)
        }

        button3.setOnClickListener {
            text = inputText.text.toString()+"3"
            inputText.setText(text)
            result(text)
        }

        button4.setOnClickListener {
            text = inputText.text.toString()+"4"
            inputText.setText(text)
            result(text)
        }

        button5.setOnClickListener {
            text = inputText.text.toString()+"5"
            inputText.setText(text)
            result(text)
        }

        button6.setOnClickListener {
            text = inputText.text.toString()+"6"
            inputText.setText(text)
            result(text)
        }

        button7.setOnClickListener {
            text = inputText.text.toString()+"7"
            inputText.setText(text)
            result(text)
        }

        button8.setOnClickListener {
            text = inputText.text.toString()+"8"
            inputText.setText(text)
            result(text)
        }

        button9.setOnClickListener {
            text = inputText.text.toString()+"9"
            inputText.setText(text)
            result(text)
        }

        button0.setOnClickListener {
            text = inputText.text.toString()+"0"
            inputText.setText(text)
            result(text)
        }

        button00.setOnClickListener {
            text = inputText.text.toString()+"00"
            inputText.setText(text)
            result(text)
        }

        buttonDot.setOnClickListener {
            text = inputText.text.toString()+"."
            inputText.setText(text)
            result(text)
        }

        buttonAdd.setOnClickListener {
            text = inputText.text.toString()+"+"
            inputText.setText(text)
            check = check+1
        }

        buttonMinus.setOnClickListener {
            text = inputText.text.toString()+"-"
            inputText.setText(text)
            check = check+1
        }

        buttonMul.setOnClickListener {
            text = inputText.text.toString()+"*"
            inputText.setText(text)
            check = check+1
        }

        buttonDivide.setOnClickListener {
            text = inputText.text.toString()+"/"
            inputText.setText(text)
            check = check+1
        }

        buttonPercent.setOnClickListener {
            text = inputText.text.toString()+"%"
            inputText.setText(text)
            check = check+1
        }

        buttonEqual.setOnClickListener {
            text = resultText.text.toString()
            inputText.setText(text)
            resultText.setText(null)
        }

        buttonClear.setOnClickListener {
            inputText.setText(null)
            resultText.setText(null)
        }

        buttonBackspace.setOnClickListener {
            var BackSpace: String?=null
            if(inputText.text.length>0)
            {
                val stringBuilder: StringBuilder = java.lang.StringBuilder(inputText.text)
                val find = inputText.text.toString()
                val find2 = find.last()
                if(find2.equals('+')||find2.equals('-')||find2.equals('*')||find2.equals('/')||find2.equals('%'))
                {
                    check= check-1
                }
                stringBuilder.deleteCharAt(inputText.text.length-1)
                BackSpace = stringBuilder.toString()
                inputText.setText(BackSpace)
                result(BackSpace)
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun result(text: String) {
        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try {
            val result: Any=engine.eval(text)
            var mainr= result.toString()
            if(check==0)
            {
                resultText.setText(null)
            }
            else{
                resultText.setText(mainr)
            }
        }
        catch (e: ScriptException)
        {
            Log.d("TAG", "ERROR")
        }
    }
}