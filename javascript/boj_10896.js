var fs = require("fs")

var input = fs
    .readFileSync("/dev/stdin")
    .toString()
    .split(" ")
    .map(function(a){
      return +a
    })

console.log(input[0]+input[1])
console.log(input[0]-input[1])
console.log(input[0]*input[1])
console.log(parseInt(input[0]/input[1])) //자바스크립트는 몫만 구하는 연산자 없졍
console.log(input[0]%input[1])