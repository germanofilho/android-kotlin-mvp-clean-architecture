package com.germanofilho.desafio.core.util

import java.util.*

abstract class UserUtil{
    companion object {
        fun generateUserKey() : String{
            return UUID.randomUUID().toString()
        }
    }

}