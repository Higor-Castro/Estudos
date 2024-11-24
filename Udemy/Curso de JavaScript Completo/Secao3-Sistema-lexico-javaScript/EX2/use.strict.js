// "use strict" deixa o ja mais seguro
//"use strict"
//let x = 10

let y = 10

function foo (){
    "use strict" // so servira para esta função!!
    let x = 20
}

foo()
console.log(y)


//function dobrar (n1, n1){
//   "use strict"
//    console.log(n1,)
//    return n1 * n1
//}
//console.log(dobrar(12, 10))

/*function Teste (){
    "use strict"
    console.log(this)
    this.a = "a"
}
Teste()*/

let msg = "uma String "
msg.count = 0
console.log(msg)