package com.example.education

import org.koin.dsl.module

@JvmField
val appModule = module {
    factory {"Hello String "}
}