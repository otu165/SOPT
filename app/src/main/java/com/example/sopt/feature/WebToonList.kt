package com.example.sopt.feature

import com.example.sopt.data.WebToonItem

class WebToonList {
    fun getWebToonList() : List<WebToonItem> {
        return listOf(
            WebToonItem(
                title = "유미의 세포들",
                rate = "9.96",
                author = "이동건"
            ),
            WebToonItem(
                title = "복학왕",
                rate = "9.2",
                author = "기안84"
            ),
            WebToonItem(
                title = "연놈",
                rate = "9.92",
                author = "상하"
            ),
            WebToonItem(
                title = "세상은 돈과 권력",
                rate = "9.87",
                author = "한동우/이도희"
            ),
            WebToonItem(
                title = "헬퍼 2 : 킬베로스",
                rate = "9.91",
                author = "삭"
            ),WebToonItem(
                title = "이츠마인",
                rate = "9.97",
                author = "럭스"
            ),WebToonItem(
                title = "그래서 나는 안티팬...",
                rate = "9.94",
                author = "재림"
            ),WebToonItem(
                title = "갓물주",
                rate = "9.92",
                author = "HD3"
            ),WebToonItem(
                title = "개장수",
                rate = "9.98",
                author = "김규삼"
            )




        )
    }
}