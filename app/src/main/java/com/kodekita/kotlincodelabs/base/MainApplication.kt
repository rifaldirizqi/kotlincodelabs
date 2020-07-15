package com.kodekita.kotlincodelabs.base

import android.app.Application
import com.kodekita.kotlincodelabs.di.apiModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            getDefinedModule()
        }
    }

    private fun getDefinedModule(): List<Module> {
        return arrayListOf(
            apiModule
        )
    }
}