package com.cat.myapplication

class Note {
    var amount = 0
    var type = "income"
    var purse = "main"
    var description = "description"

    constructor(amount: Int, type: String, purse: String, description: String){
        this.amount = amount
        this.type = type
        this.purse = purse
        this.description = description
    }
}