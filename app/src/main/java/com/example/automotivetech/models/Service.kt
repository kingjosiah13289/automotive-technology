package com.example.automotivetech.models

class Service {
    var serviceName:String = ""
    var serviceDesc:String = ""
    var serviceId:String = ""

    constructor(serviceName: String, serviceDesc: String, serviceId: String) {
        this.serviceName = serviceName
        this.serviceDesc = serviceDesc
        this.serviceId = serviceId
    }
    constructor()
}