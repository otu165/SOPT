package com.example.sopt.feature

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sopt.R
import com.example.sopt.api.ServiceImpl
import com.example.sopt.data.GitUserData
import com.example.sopt.data.User
import com.example.sopt.feature.git.GitActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val BACK_FROM_SIGN_UP_ACTIVITY = 1
    private var backKeyPressedTime : Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainFunction()
    }

    private fun mainFunction() {
        // check sign in happened or not
        val id = User.getUser(this)
        if (!id.isNullOrEmpty()) {
            startGitActivity(id)
        }

        // sign in click event
        txtMainLogIn.setOnClickListener {
            if(isValidSignInRequest(edtMainId.text.toString())) {
                requestSignIn(edtMainId.text.toString())
            }
            else {
                Toast.makeText(this, "아이디를 입력하세요.", Toast.LENGTH_SHORT).show()
            }
        }

        // sign up click event
        txtMainSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivityForResult(intent, BACK_FROM_SIGN_UP_ACTIVITY)
        }
    }

    private fun requestSignIn(id : String) {
        val call = ServiceImpl.service.getUser(id)
        Log.d(TAG, "id : $id")

        call.enqueue(
            object : retrofit2.Callback<GitUserData> {
                override fun onResponse(call: Call<GitUserData>, response: Response<GitUserData>) {
                    if(response.isSuccessful) { // sign in success
                        User.setUser(this@MainActivity, id)
                        startGitActivity(id)
                    }
                    else { // status != 200
                        Toast.makeText(this@MainActivity, "존재하지 않는 사용자입니다.", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<GitUserData>, t: Throwable) {
                    Log.d(TAG, "requestSignIn onFailure")
                }
            }
        )
    }

    private fun isValidSignInRequest(id : String?) : Boolean {
        return !id.isNullOrEmpty()
    }

    private fun startGitActivity(id : String) {
        val intent = Intent(this@MainActivity, GitActivity::class.java)
            .putExtra("id", id)
        startActivity(intent)

        Toast.makeText(this@MainActivity, "${id}님 반갑습니다!", Toast.LENGTH_SHORT).show()
        this.finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            BACK_FROM_SIGN_UP_ACTIVITY -> {
                when(resultCode) {
                    Activity.RESULT_OK -> {
                        edtMainId.setText(data?.getStringExtra("id"))
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        val toast = Toast.makeText(this, "\'뒤로\'버튼을 한 번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT)

        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis()
            toast.show()
        } else if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            this.finish()
            toast.cancel()
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
