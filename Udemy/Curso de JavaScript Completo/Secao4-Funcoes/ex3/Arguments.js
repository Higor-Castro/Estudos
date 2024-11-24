function somar1 (){
    console.log(arguments)

    let total = 0
    let i = 0
    while(i<arguments.length){
        total +=arguments[i]
        i++
    }
    return total
}

const somar2 = function somar2 (){
    console.log(arguments)

    let total = 0
    let i = 0
    while(i<arguments.length){
        total +=arguments[i]
        i++
    }
    return total
}

//      arrow function não funciona com "arguments"
const somar3 = () =>{
    console.log(arguments)

    let total = 0
    let i = 0
    while(i<arguments.length){
        total +=arguments[i]
        i++
    }
    return total
}

console.log(somar1(12,189,156,789))
console.log(somar2(12,189,156,789))
console.log(somar3(12,189,156,789))