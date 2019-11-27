package com.example.allleagues.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.allleagues.data.AllLeagues
import com.example.allleagues.data.League
import com.example.allleagues.data.repository.LeagueRepositoryImpl
import io.reactivex.Single
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LeagueViewModelTest {

    @Rule
    @JvmField
    var rule: TestRule = InstantTaskExecutorRule() // enable components operate in the mainthread


    //declare the object/class under test and any other variable
    lateinit var leagueViewModel: LeagueViewModel
    private var league = mutableListOf<League>()

    //mock the object in the constructor of the class under test
    //Enable the option to mock final classes. To do this, you’ll need to create a file
    //in the test/resources/mockito-extensions folder called org.mockito.plugins.MockMaker.
    //It’s a simple text file, in which you have to write: mock-maker-inline.
    //You will not have this problem if you make the class type interface type.
    @Mock
    lateinit var leagueRepositoryImpl: LeagueRepositoryImpl

    //initialize all objects and variables required for each test
    @Before
    fun setUp() {
       leagueViewModel = LeagueViewModel(leagueRepositoryImpl)
       league.add(League("test","name", "name2", "sport"))
    }

    //write each test case
    @Test
    fun showResultReturnedSuccess(){

        //create the object expected to be returned
        val allLeagues = AllLeagues(league)

        //make a call from the repo and check the return object
        `when`(leagueRepositoryImpl.getLeagues()).thenReturn(Single.just(allLeagues))

        //make a call from the class under test
        leagueViewModel.getLeagues()

        //verify the returned object
        verify(leagueRepositoryImpl, atLeast(1)).getLeagues()
    }

    @After
    fun tearDown() {
    }
}