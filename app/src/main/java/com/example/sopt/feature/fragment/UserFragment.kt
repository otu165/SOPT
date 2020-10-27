package com.example.sopt.feature.fragment

import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.sopt.R
import com.example.sopt.api.ServiceImpl
import com.example.sopt.data.GitUserData
import kotlinx.android.synthetic.main.fragment_user.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserFragment : Fragment() {
    lateinit var id : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_user, container, false)

        userFunction(view)
        return view
    }

    private fun userFunction(view : View) {
        id = arguments?.getString("id") !!

        // 1. 사용자의 id 로 view 구성
        requestUserData(view, id)

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