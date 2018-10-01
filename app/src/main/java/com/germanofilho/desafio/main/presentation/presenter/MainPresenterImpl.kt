package com.germanofilho.desafio.main.presentation.presenter

import com.germanofilho.desafio.core.presenter.BasePresenterImpl
import com.germanofilho.desafio.main.presentation.ui.MainView
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(var mView: MainView.Activity) : BasePresenterImpl(mView), MainPresenter