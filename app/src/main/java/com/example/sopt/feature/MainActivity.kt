package com.example.sopt.feature

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sopt.R
import com.example.sopt.feature.gitrepo.GitRepoActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val BACK_FROM_SIGN_UP_ACTIVITY = 1
    private var backKeyPressedTime : Long = 0


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
            val intent = Intent(this@MainActivity, GitRepoActivity::class.java)
            startActivity(intent)

            this.finish()
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

    //뒤로가기 2번 종료
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
}
