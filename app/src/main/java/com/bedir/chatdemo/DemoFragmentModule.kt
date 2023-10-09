package com.bedir.chatdemo

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
open class DemoFragmentModule {

    @FragmentScoped
    @Provides
    fun provideEventListener(fragment: Fragment): EventListener {
        return fragment as DemoFragment<*>
    }
}