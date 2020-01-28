package com.example.mymechanic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var signBtn:Button
    private lateinit var profileBtn:Button
    private lateinit var retrieveBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signBtn = findViewById(R.id.Sign_In)
        profileBtn = findViewById(R.id.profileBtn)
        retrieveBtn = findViewById(R.id.retrieveData)

        signBtn.setOnClickListener(){
            openSignUp()
        }
        profileBtn.setOnClickListener(){
            openProfile()
        }
        retrieveBtn.setOnClickListener(){
            openRetrieve()
        }
    }

    private fun openSignUp(){
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
    }

    private fun openProfile(){
        val intent = Intent(this, UserProfile::class.java)
        startActivity(intent)
    }

    private fun openRetrieve(){
        val intent = Intent(this, RetrieveProfile::class.java)
        startActivity(intent)
    }
}
