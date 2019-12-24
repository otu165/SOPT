package com.example.sopt.feature.gitrepo

import com.example.sopt.data.GitRepoItem

class GitRepoRepository {
    public fun getRepoList() : List<GitRepoItem> {
        return listOf(
            GitRepoItem(
                name = "A",
                age = 20,
                major = "컴퓨터공학과"
            ),
            GitRepoItem(
                name = "B",
                age = 21,
                major = "컴퓨터공학과"
            ),
            GitRepoItem(
                name = "C",
                age = 22,
                major = "컴퓨터공학과"
            ),
            GitRepoItem(
                name = "D",
                age = 23,
                major = "컴퓨터공학과"
            ),
            GitRepoItem(
                name = "E",
                age = 24,
                major = "컴퓨터공학과"
            )
        )
    }
}