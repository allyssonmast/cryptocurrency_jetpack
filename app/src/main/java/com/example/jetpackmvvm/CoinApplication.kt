package com.example.jetpackmvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp //give hilt accss to know about application.. generete context if necessary
class CoinApplication :Application()