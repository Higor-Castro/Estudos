let arr = [1,2,3,4,5,6,7,8,9,10]
let arr2 = arr.push(11,"Olá Mundo!!!")
console.log("Push: ",arr2)
console.log("Array: ",arr)

let ultimoItem = arr.pop() 
console.log("Pop: ",ultimoItem)
console.log("Array: ",arr)

let primeiroItem = arr.shift()
console.log("Shift: ",primeiroItem)
console.log("Array: ",arr)

arr2 = arr.unshift(0)
console.log("Unshift: ",arr2)
console.log("Array: ",arr)


let arr3 = arr.slice(1,5)
console.log("Slice: ",arr3)
console.log("Array: ",arr)

let arr4 = arr.splice(1,2, "Novo Item") 
console.log("Splice: ",arr4)
console.log("Array: ",arr)