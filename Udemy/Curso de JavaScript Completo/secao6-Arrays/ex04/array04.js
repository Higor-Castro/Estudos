let arr1 = ["a, b", "c", "d"]
let arr2 = arr1

arr2[arr2.length] = "e"
console.log(arr1) 

let arr3 = [].concat(arr1) // cria uma copia da array arr1
arr3[arr3.length] = "f"
console.log(arr1) // arr1 continua com os mesmo valores
console.log(arr3) // arr3 tem os valores de arr1 + "f"