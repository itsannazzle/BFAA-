package com.example.githubuser

object object_data {
    private val repo_title = arrayOf(
            "Dicoding submission 1",
            "Ducoding submission 2",
            "The N Restaurant"
    )

    private val repo_desc = arrayOf(
            "This is my submission in BMAA class",
            "This is my submission in BFAA class",
            "This is my personal design project"
    )

    private val repo_lang = arrayOf(
            "Java",
            "Kotlin",
            "Kotlin"
    )
/*This will casting of i don't know how to say it but the data above will be inserted to the repo data class
* by this getter */
    val user_repo : ArrayList<repo>
    get() {
        val l =  arrayListOf<repo>()
        /*this arraylistof is turunan from ArrayList its like opening a box inside a box to
        * get the thing inside it*/
        for (i in repo_title.indices){
            val j = repo()
            /*this J, is the thing that i meant*/
            j.user_repo = repo_title[i]
            j.user_repo_des = repo_desc[i]
            j.user_repo_lang = repo_lang[i]
            l.add(j)
            /*this l.add means l now has gotten data from the object data*/
        }
        return l
        /*this is returning the value that have been inserted from the for iteration*/
    }
}