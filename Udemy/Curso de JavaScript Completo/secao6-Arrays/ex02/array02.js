let arr = [4,5,10,20,35,4,5]

console.log("indexOf: ", arr.indexOf(5))
console.log("lastIndexOf: ", arr.lastIndexOf(5))
console.log("includes: ", arr.includes(5))
console.log("find: ", arr.find(function (el) {
    return el > 10
}))
console.log("findIndex: ", arr.findIndex(function (el) {
    return el > 10
}))