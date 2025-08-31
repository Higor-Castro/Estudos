const arr = [1,2,3]
function sum(){
    console.log(arguments)
    console.log(arguments.length)
}
sum(1,2,3)
sum(arr)
sum([1,2,3])


sum(...[1,2,3])
sum(...arr)

const arr2 = [4,5,6]
const arr3 = [...arr, ...arr2]
console.log(arr3)