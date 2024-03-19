package com.kurowskiandrzej.sdk_demo.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.kurowskiandrzej.db.SdkDatabase
import com.kurowskiandrzej.sdk_demo.data.db.CalculationHistoryDataSourceImpl
import com.kurowskiandrzej.sdk_demo.data.db.CalculatorHistoryDataSource
import com.kurowskiandrzej.sdk_demo.data.repository.CalculatorHistoryRepositoryImpl
import com.kurowskiandrzej.sdk_demo.data.repository.ItemsListRepositoryImpl
import com.kurowskiandrzej.sdk_demo.domain.repository.CalculatorHistoryRepository
import com.kurowskiandrzej.sdk_demo.domain.repository.ItemsListRepository
import com.kurowskiandrzej.sdk_demo.domain.use_case.CalculateUseCase
import com.kurowskiandrzej.sdk_demo.domain.use_case.GetCalculatorHistoryUseCase
import com.kurowskiandrzej.sdk_demo.domain.use_case.GetItemsListUseCase
import com.kurowskiandrzej.sdk_demo.domain.use_case.GetListItemByIdUseCase
import com.kurowskiandrzej.sdk_demo.domain.use_case.InsertCalculationResultUseCase
import com.kurowskiandrzej.sdk_demo.presentation.screen.calculator.CalculatorViewModel
import com.kurowskiandrzej.sdk_demo.presentation.screen.history.HistoryViewModel
import com.kurowskiandrzej.sdk_demo.presentation.screen.item_detail.ItemDetailViewModel
import com.kurowskiandrzej.sdk_demo.presentation.screen.items_list.ItemsListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val sdkMainModule = module {

    single<SqlDriver> {
        AndroidSqliteDriver(
            schema = SdkDatabase.Schema,
            context = androidApplication(),
            name = "sdk.db"
        )
    }

    single {
        SdkDatabase(
            driver = get(),
        )
    }

    single<CalculatorHistoryDataSource> {
        CalculationHistoryDataSourceImpl(
            sdkDatabase = get(),
        )
    }

    single<CalculatorHistoryRepository> {
        CalculatorHistoryRepositoryImpl(
            calculatorHistoryDataSource = get(),
        )
    }

    single {
        InsertCalculationResultUseCase(
            calculatorHistoryRepository = get(),
        )
    }

    single {
        GetCalculatorHistoryUseCase(
            calculatorHistoryRepository = get(),
        )
    }

    single {
        CalculateUseCase()
    }

    single<ItemsListRepository> {
        ItemsListRepositoryImpl()
    }

    single {
        GetItemsListUseCase(
            itemsListRepository = get(),
        )
    }

    single {
        GetListItemByIdUseCase(
            itemsListRepository = get(),
        )
    }

    viewModel {
        CalculatorViewModel(
            calculateUseCase = get(),
            insertCalculationResultUseCase = get(),
        )
    }

    viewModel {
        HistoryViewModel(
            getCalculatorHistoryUseCase = get(),
        )
    }

    viewModel {
        ItemsListViewModel(
            getItemsListUseCase = get(),
        )
    }

    viewModel {
        ItemDetailViewModel(
            savedStateHandle = get(),
            getListItemByIdUseCase = get(),
        )
    }
}
