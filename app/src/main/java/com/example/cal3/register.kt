package com.example.cal3

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.*

class register : AppCompatActivity() {

    lateinit var register: Button
    lateinit var email:EditText
    lateinit var ps:EditText
    lateinit var number:EditText
    lateinit var un:EditText
    lateinit var check:CheckBox

    lateinit var e:String
    lateinit var p:String
    lateinit var n:String
    lateinit var u:String

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val refTodo: DatabaseReference = database.reference.child("Todo")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        email = findViewById(R.id.email)
        un = findViewById(R.id.un)
        ps = findViewById(R.id.ps)
        number = findViewById(R.id.number)
        register = findViewById(R.id.R)

        register.setOnClickListener {
            u = un.text.toString()
            p = ps.text.toString()
            n = number.text.toString()
            e = email.text.toString()

            val token: String = refTodo.push().key.toString()
            val todo = model(e, u, p, n)
            // Insertion was in context to individual record/ child
            refTodo.child(token).setValue(todo).addOnCompleteListener { status ->
                if (status.isSuccessful) {
                    Toast.makeText(this, "Record inserted successfully", Toast.LENGTH_LONG).show()
                    un.setText("")
                    ps.setText("")
                    number.setText("")
                    email.setText("")

                } else {
                    Toast.makeText(this, "Record failed", Toast.LENGTH_LONG).show()
                }
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_bar, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.Home -> {
                var alert = AlertDialog.Builder(this)
                alert.setTitle("Home Page")
                alert.setMessage("Do You Want To Go On Home Page?")
                alert.setCancelable(false)
                alert.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                    val intent = Intent(this@register, MainActivity::class.java)
                    startActivity(intent)
                    //     Toast.makeText(this@MainActivity,"Register",Toast.LENGTH_LONG).show()
                })
                alert.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
                alert.create().show()
            }
            R.id.Login -> {
                var alert = AlertDialog.Builder(this)
                alert.setTitle("Login")
                alert.setMessage("Do You Want To Login?")
                alert.setCancelable(false)
                alert.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                    val intent = Intent(this@register, login::class.java)
                    startActivity(intent)
                })
                alert.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
                alert.create().show()
            }
            R.id.Register -> {
                Toast.makeText(this@register, "Already On Register Page", Toast.LENGTH_LONG).show()
            }

        }

        return true
    }


    }


