package com.example.sopt.feature.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.sopt.R
import com.example.sopt.feature.gitrepo.GitRepoAdapter
import kotlinx.android.synthetic.main.fragment_repo.view.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sopt.api.ServiceImpl
import com.example.sopt.data.GitRepoData
import com.example.sopt.feature.GitActivity
import com.example.sopt.feature.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_repo, container, false)

        repoFunction(view)
        return view
    }

    private fun repoFunction(view : View) {
        // 1. RecyclerView
        val rvAdapter = GitRepoAdapter(view.context)
        view.rvGitRepo.adapter = rvAdapter
        view.rvGitRepo.layoutManager = LinearLayoutManager(view.context)

        // 2. get data
        val call : Call<List<GitRepoData>> = ServiceImpl.service.getRepos((activity as GitActivity).gitId)

        call.enqueue(
            object : Callback<List<GitRepoData>> {
                override fun onFailure(call: Call<List<GitRepoData>>, t: Throwable) {
                    Log.e("TAG", "GitRepoActivity 서버통신불가")
                }

                override fun onResponse(
                    call: Call<List<GitRepoData>>,
                    response: Response<List<GitRepoData>>
                ) {
                    if (response.isSuccessful) {
                        rvAdapter.data = response.body()!!
                        rvAdapter.notifyDataSetChanged()
                    }
                }
            }
        )
    }
}