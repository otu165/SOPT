package com.example.sopt.feature

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sopt.R
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signUpFunction()
    }

    private fun signUpFunction() {
        //회원가입
        btnSignUpSignUp?.setOnClickListener {
            val name  = edtSignUpName.text.toString()
            val id = edtSignUpId.text.toString()
            val pwd = edtSignUpPwd.text.toString()
            val pwdChk = edtSignUpPwdChk.text.toString()

            //미입력 항목 존재
            if(name.isEmpty() || id.isEmpty() || pwd.isEmpty() || pwdChk.isEmpty()) {
                Toast.makeText(this, "모든 항목을 입력하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //비밀번호 불일치
            if(!pwd.equals(pwdChk)) {
                Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()

                edtSignUpPwdChk.text = null
                edtSignUpPwdChk.requestFocus()

                return@setOnClickListener
            }

            //정상 회원가입
            val intent = Intent(this@SignUpActivity, MainActivity::class.java)
                .putExtra("id", id)

            setResult(Activity.RESULT_OK, intent)
            this.finish()
        }
    }
}
