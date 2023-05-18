package com.example.automotivetech.models

class Mechanics {
    var mechname: String = ""
    var mechlocation: String = ""
    var mechphone: String = ""
    var mechId: String = ""

    constructor(mechname: String, mechlocation: String, mechphone: String, mechId: String) {
        this.mechname = mechname
        this.mechlocation = mechlocation
        this.mechphone = mechphone
        this.mechId = mechId
    }

    constructor()
}