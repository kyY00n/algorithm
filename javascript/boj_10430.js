var fs = require("fs")
var input = fs
    .readFileSync("dev/stdin")
    .toString()
    .split(" ")
    .map(function(a){
      return +a
    })
var a = input[0], b = input[1], c = input[2]
console.log((a+b)%c)
console.log(((a%c)+(b%c))%c)
console.log((a*b)%c)
console.log(((a%c)*(b%c))%c)