package com.example.sopt.feature.git.fragment.gitrepo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sopt.R
import com.example.sopt.feature.git.fragment.gitrepo.GitRepoAdapter
import kotlinx.android.synthetic.main.fragment_repo.view.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sopt.api.ServiceImpl
import com.example.sopt.data.GitRepoData
import com.example.sopt.data.User
import com.example.sopt.feature.git.GitActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_repo, container, false)

        repoFunction(view)
        return view
    }

    private fun repoFunction(view : View) {
        // make RecyclerView
        val rvAdapter = GitRepoAdapter(view.context)
        view.rvGitRepo.adapter = rvAdapter
        view.rvGitRepo.layoutManager = LinearLayoutManager(view.context)
        requestRepoData(rvAdapter, if(isMainUser()) User.getUser(requireContext()) else User.getFollower(requireContext()))
    }

    private fun isMainUser() : Boolean {
        return User.getFollower(requireContext()).isNullOrEmpty()
    }

    private fun requestRepoData(rvAdapter : GitRepoAdapter, id : String) {
        val call : Call<List<GitRepoData>> = ServiceImpl.service.getRepos(id)

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