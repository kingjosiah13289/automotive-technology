package com.example.automotivetech.models

class Users {
    var jina:String = ""
    var simu:String = ""
    var gari:String = ""
    var namba:String = ""
    var id:String = ""

    constructor(name: String, email: String, idNumber: String, namba:String, id: String) {
        this.jina = name
        this.simu = email
        this.gari = idNumber
        this.namba = namba
        this.id = id
    }
    constructor()
}