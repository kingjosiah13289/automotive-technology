package com.example.automotivetech.models

class Sparepart {
    var sparepart: String = ""
    var sparename: String = ""
    var spareprice: String = ""
    var spareId : String = ""
    constructor(sparepart: String, sparename: String, spareprice: String, spareId: String){
        this.sparepart = sparepart
        this.sparename = sparename
        this.spareprice = spareprice
        this.spareId = spareId
    }
    constructor()
}