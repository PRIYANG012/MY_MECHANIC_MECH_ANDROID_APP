package com.example.mymechanic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_user_profile.*
import org.json.JSONObject

class UserProfile : AppCompatActivity() {

    private lateinit var saveDataBtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        saveDataBtn = findViewById(R.id.enterData)

        saveDataBtn.setOnClickListener(){
            storeProfile()
        }
    }

    fun storeProfile(){

        val mFirestore = FirebaseFirestore.getInstance()

        var temp1 = user_Name.text.toString()
        var temp2 = user_age.text.toString()

        val user = UserProfileData()

        user.setName(temp1)
        user.setAge(temp2)

        var jsonObj = JSONObject()

        jsonObj.put("name", user.getName())
        jsonObj.put("age", user.getAge())

        var uMap = HashMap<String, String>()

        uMap.put("user", jsonObj.toString())
/*
        var tempObj = jsonObj
        var tempUser = UserProfileData()

        tempUser.setName(tempObj.getString("name"))
        tempUser.setAge(tempObj.getString("age"))
        tempText.text = tempUser.getName() + tempUser.getAge()
*/
        mFirestore.collection("Test").add(uMap)
            .addOnSuccessListener {
                val t = Toast.makeText(this@UserProfile, "Success", Toast.LENGTH_LONG)
                t.show()
            }
            .addOnFailureListener(OnFailureListener {
                val t = Toast.makeText(this@UserProfile, ("Failed"), Toast.LENGTH_LONG)
                t.show()
            })
    }
}
