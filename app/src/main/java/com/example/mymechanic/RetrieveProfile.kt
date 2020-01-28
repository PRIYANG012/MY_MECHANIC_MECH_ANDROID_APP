package com.example.mymechanic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_retrieve_profile.*
import kotlinx.android.synthetic.main.activity_user_profile.*
import org.json.JSONObject

class RetrieveProfile : AppCompatActivity() {

    private lateinit var retrieveBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrieve_profile)

        retrieveBtn = findViewById(R.id.retrieve)

        retrieveBtn.setOnClickListener(){
            getUserProfile()
        }
    }

    private fun getUserProfile(){

        val db = FirebaseFirestore.getInstance()

        db.collection("Test").get()
            .addOnSuccessListener {

                for (dc in it){
                    userAgeText.text = dc.data.values.toString()
                   // var jsonObj = JSONObject()
                   // var tempUser = UserProfileData()

                    var tempStr = dc.data.values.toString()
                    userNameText.text = dc.data["user"].toString()
                    userAgeText.text = tempStr

                    tempStr = tempStr.substring(tempStr.indexOf("{"),tempStr.lastIndexOf("}")+1)

                    var jsonObj = JSONObject(tempStr)

                    var tempUser = UserProfileData()

                    tempUser.setName(jsonObj.getString("name"))
                    tempUser.setAge(jsonObj.getString("age"))
                    userNameText.text = tempUser.getName()
                    userAgeText.text = tempUser.getAge()

                }
            }
            .addOnFailureListener(OnFailureListener {
                userAgeText.text = "Failed"
            })

    }
}
