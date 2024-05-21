package com.example.myapplication6.models

class Upload {
    var name:String = ""
    var telephone:String=""
    var description:String=""
    var imageUrl:String=""
    var id:String=""
    constructor(name:String,telephone:String,description:String,imageUrl:String,
                id:String){
        this.name=name
        this.telephone=telephone
        this.description=description
        this.imageUrl=imageUrl
        this.id=id

    }
    constructor()
}