package com.example.cal3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

lateinit var a: EditText
lateinit var d: EditText
lateinit var n: EditText
lateinit var r:TextView
lateinit var button: Button

var Ap:Int=0

class ap : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ap)



        a=findViewById(R.id.a)
        d=findViewById(R.id.d)
        n=findViewById(R.id.n)
        result=findViewById(R.id.r)
        button=findViewById(R.id.button)

        button.setOnClickListener {
            var f=a.text.toString().toInt()
            var e= d.text.toString().toInt()
            var g=n.text.toString().toInt()
            Ap=(f+(g-1)*e)
            r.setText("$g"+" term of ap is "+Ap)
        }
    }
}