package com.example.education

import org.koin.dsl.module

@JvmField
val appModule = module {
    single {  }
    factory {"Hello String "}
}