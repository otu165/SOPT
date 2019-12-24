package com.example.sopt.feature.gitrepo

import com.example.sopt.data.GitRepoItem

class GitRepoList {
    fun getRepoList() : List<GitRepoItem> {
        return listOf(
            GitRepoItem(
                title = "제목1",
                info = "내용1",
                language = "언어1"
            ),
            GitRepoItem(
                title = "제목2",
                info = "내용2",
                language = "언어2"
            ),
            GitRepoItem(
                title = "제목3",
                info = "내용3",
                language = "언어3"
            ),
            GitRepoItem(
                title = "제목4",
                info = "내용4",
                language = "언어4"
            ),
            GitRepoItem(
                title = "제목5",
                info = "내용5",
                language = "언어5"
            ),
            GitRepoItem(
                title = "제목6",
                info = "내용6",
                language = "언어6"
            ),
            GitRepoItem(
                title = "제목7",
                info = "내용7",
                language = "언어7"
            )
        )
    }
}