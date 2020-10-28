package com.example.sopt.feature.git

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sopt.R
import com.example.sopt.data.User
import com.example.sopt.feature.git.fragment.ListFragment
import com.example.sopt.feature.git.fragment.UserFragment

class GitActivity : AppCompatActivity() {
    private var backKeyPressedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git)

        gitFunction()
    }

    private fun gitFunction() {
        composeFragment()
    }

    private fun composeFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.frameGitTop, UserFragment())
            .add(R.id.frameGitBelow, ListFragment())
            .commit()
    }

    override fun onBackPressed() {
        if(intent.getStringExtra("id") == User.getUser(this@GitActivity)) { // case of main user
            val toast = Toast.makeText(this, "\'뒤로\'버튼을 한 번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT)

            if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
                backKeyPressedTime = System.currentTimeMillis()
                toast.show()
            } else if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
                User.clearFollower(this@GitActivity)

                this.finish()
                toast.cancel()
            }
        }
        else { // case of followers
            super.onBackPressed()
        }
    }
}