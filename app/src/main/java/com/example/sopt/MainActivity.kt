package com.example.sopt

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class MainActivity : AppCompatActivity() {

    private val BACK_FROM_SIGN_UP_ACTIVITY = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainFunction()
    }

    private fun mainFunction() {
        //로그인
        btnMainLogIn?.setOnClickListener {
            val id = edtMainId.text.toString()
            val pwd = edtMainPwd.text.toString()

            //미기입 항목 존재
            if(id.isEmpty()) {
                Toast.makeText(this, "아이디를 입력하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if(pwd.isEmpty()) {
                Toast.makeText(this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //정상 로그인
            Toast.makeText(this, "로그인 완료", Toast.LENGTH_SHORT).show()
        }

        //회원가입
        btnMainSignUp?.setOnClickListener {
            val intent = Intent(this@MainActivity, SignUpActivity::class.java)
                .putExtra("id", edtMainId.text.toString())
                .putExtra("pwd", edtMainPwd.text.toString())

            startActivityForResult(intent, BACK_FROM_SIGN_UP_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            BACK_FROM_SIGN_UP_ACTIVITY -> {
                when(resultCode) {
                    Activity.RESULT_OK -> {
                        edtMainId.setText(data?.getStringExtra("id"))
                        edtMainPwd.setText(data?.getStringExtra("pwd"))
                    }
                }
            }
        }
    }
}
