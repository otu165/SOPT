package com.example.sopt.feature

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sopt.R
import com.example.sopt.api.SignUpServiceImpl
import com.example.sopt.data.SignUpData
import com.example.sopt.data.SignUpServerMsg
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initialEditText()
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
            requestSignUp(name, id, pwd)

        }
    }

    private fun requestSignUp(name : String, id : String, pwd : String) {
        val call : Call<SignUpServerMsg> = SignUpServiceImpl.service.requestSignUp(SignUpData(name, id, pwd))

        call.enqueue(
            object : Callback<SignUpServerMsg> {
                override fun onFailure(call: Call<SignUpServerMsg>, t: Throwable) {
                    Log.e("TAG", "SignUpActivity 서버 통신 불가")
                }

                override fun onResponse(
                    call: Call<SignUpServerMsg>,
                    response: Response<SignUpServerMsg>
                ) {
                    if(response.isSuccessful) {
                        Toast.makeText(applicationContext, "회원가입 성공", Toast.LENGTH_SHORT).show()

                        val intent = Intent(this@SignUpActivity, MainActivity::class.java)
                            .putExtra("id", id)
                            .putExtra("pwd", pwd)

                        setResult(Activity.RESULT_OK, intent)
                        finish()
                    }
                    else {
                        val message = response.body().toString()
                        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        )
    }

    //EditText 초기화
    private fun initialEditText() {
        edtSignUpId.setText(intent.getStringExtra("id"))
        edtSignUpPwd.setText(intent.getStringExtra("pwd"))
    }
}
