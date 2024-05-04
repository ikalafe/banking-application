package com.example.jcuiapp3.data

import com.example.jcuiapp3.model.Transaction

class MockData {

    companion object {
        private val trxList = listOf<Transaction>(
            Transaction("App UI","13,06,2022",+1200),
            Transaction("App Design","16,06,2022",+700),
            Transaction("DevOps","25,06,2022",+300),
            Transaction("Payment Gateway","02,07,2022",-180),
            Transaction("Host & Domain","09,07,2022",-600),
            Transaction("App UI","15,07,2022",+500)
        )
        fun getDataList(): List<Transaction> {
            return trxList
        }

        fun get(index:Int): Transaction {
            return trxList[index]
        }
    }
}