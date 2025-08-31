const arr =  [0,1,2,"Olá Mundo!!", true]

let sohNumeros = arr.every(function(el){
    return true
})

sohNumeros = arr.some(function(el){
    return typeof el === 'number' 
})

let newArr = arr.filter(function(el,i,_arr){
    return true
})

arr.forEach(function(el,i,_arr){
    console.log("ForEach: ",_arr)
})

newArr = arr.map(function(el,i,_arr){
    return -el * el
})

console.log("Every: ",sohNumeros)
console.log("Some: ",arr)
console.log("Filter: ",newArr)
console.log("Map: ",newArr)