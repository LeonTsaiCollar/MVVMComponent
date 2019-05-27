package com.leontsai.start.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.leontsai.start.MainViewModel;
import com.leontsai.start.StartViewModelFactory;
import com.leontsai.start.di.annotation.ViewModelKey;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;


@Module
public abstract class StartModule {


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    public abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);


    @Binds
    public abstract ViewModelProvider.Factory bindFactory(StartViewModelFactory startViewModelFactory);

}
