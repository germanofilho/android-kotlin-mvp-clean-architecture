package com.germanofilho.desafio.core.presenter

import com.germanofilho.desafio.core.view.ui.BaseView
import javax.inject.Inject

open class BaseActivityPresenterImpl @Inject constructor(private val baseViewActivity: BaseView.Activity) : BasePresenterImpl(baseViewActivity), BasePresenter