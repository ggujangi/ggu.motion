package com.ggu.motion.data

class Repository(private val localDataSource: LocalDataSource) {

    fun register(name: String) {
        localDataSource.register(name)
    }

    fun getName() = localDataSource.getName()

    fun isRegister() = !localDataSource.getName().isNullOrEmpty()
}

