package com.example.task1

import org.junit.Test
import kotlin.collections.*

import org.junit.Assert.*

class Task1Test {

    fun getPermutationsFromList(list: List<Any>): List<Any>{
        if (list.count() > 1) {
            val resultList = mutableListOf<Any>()
            list.forEach {
                val mutableGivenList = list.toMutableList()
                mutableGivenList.remove(it)

                val partialPermutationsList = getPermutationsFromList(mutableGivenList)

                val currentElement = it
                partialPermutationsList.forEach {
                    val singlePermutationList = mutableListOf<Any>(currentElement)
                    if (it is List<*>){
                        singlePermutationList.addAll(it as List<Any>)
                    }
                    else{
                        singlePermutationList.add(it)
                    }
                    resultList.add(singlePermutationList)
                }
            }
            return resultList
        }
        else
            return list
    }

    fun getPermutationsFromArray(array: Array<Any>): Array<Any>{
        val list = array.toList()
        val listOfPermutations = getPermutationsFromList(list).toMutableList()
        listOfPermutations.replaceAll{ (it as List<Any>).toTypedArray()}
        //print(listOfPermutations)
        return listOfPermutations.toTypedArray()
    }

    @Test
    fun getPermutationsArrayTest(){
        val array = arrayOf(1, "test", 3, "string")
        val resultArray = getPermutationsFromArray(array)
        resultArray.forEach { println((it as Array<Any>).contentDeepToString()) }
    }
}