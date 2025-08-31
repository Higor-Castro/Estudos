function sum (){
    const numbers = []
    // for(let i = 0; i < arguments.length; i++){
    //     number.push(arguments[i])
    // }

    Array.prototype.forEach.call(arguments, function (argument) {
        numbers.push(argument)
       
    })
    return numbers.reduce(function(sum, atual) {
        return sum + atual
    }, 0)
}


function avarege () {
    const soma = sum.apply(null, arguments)
    return soma / arguments.length

}

console.log(sum(1,2,3,4,5))
console.log(avarege(1,2,3,4,5))