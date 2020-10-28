package com.example.sopt.feature.git.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.sopt.R
import com.example.sopt.api.ServiceImpl
import com.example.sopt.data.GitUserData
import com.example.sopt.data.User
import com.example.sopt.feature.git.GitActivity
import com.example.sopt.feature.MainActivity
import kotlinx.android.synthetic.main.fragment_user.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_user, container, false)

        userFunction(view)
        return view
    }

    private fun userFunction(view : View) {
        if(isMainUser()) {
            makeSignOutVisible(view)
        }

        // paint view
        requestUserData(view, if(isMainUser()) User.getUser(requireContext()) else User.getFollower(requireContext()))

    }

    private fun isMainUser() : Boolean {
        return User.getFollower(requireContext()).isNullOrEmpty()
    }

    private fun makeSignOutVisible(view : View) {
        view.txtGitSignOut.isVisible = true

        // handle click event
        view.txtGitSignOut.setOnClickListener {
            User.clearUser(requireContext())

            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
            (activity as GitActivity).finish()
        }
    }

    private fun requestUserData(view : View, id : String) {
        val call = ServiceImpl.service.getUser(id)
        call.enqueue(object : Callback<GitUserData> {
            override fun onResponse(call: Call<GitUserData>, response: Response<GitUserData>) {
                if(response.isSuccessful) {
                    val data = response.body()!!
                    paintView(view, data.image, data.description, data.id)
                }
            }

            override fun onFailure(call: Call<GitUserData>, t: Throwable) {
                Log.d(TAG, "requestUserData_onFailure")
            }
        })
    }

    private fun paintView(view : View, image : String?, des : String?, id : String) {
        Glide.with(requireContext()).load(image).into(view.imgGitUser)
        view.txtGitId.text = id
        view.txtGitDescription.text = des
    }

    companion object {
        private const val TAG = "UserFragment"
    }
}