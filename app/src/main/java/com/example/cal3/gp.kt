package com.example.cal3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

lateinit var A:EditText
lateinit var D:EditText
lateinit var N:EditText
lateinit var Result:TextView
lateinit var Button: Button

var G:Int=1
var Gp:Int=0


class gp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gp)

        A=findViewById(R.id.a)
        D=findViewById(R.id.d)
        N=findViewById(R.id.n)
        Result =findViewById(R.id.result)
        Button=findViewById(R.id.button)

        button.setOnClickListener {
            var f=A.text.toString().toInt()
            var e= D.text.toString().toInt()
            var g=N.text.toString().toInt()
            for (a in 1.. g-1){
                G=G*e
            }
            Gp=f*G
            G=1
            Result.setText("$G"+" term of Gp is "+Gp)
        }
    }
}