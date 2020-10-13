fs = require("fs")
var input = fs.readFileSync("/dev/stdin").toString().split(' ').map(a => +a)

let a = input[0], b = input[1]
if (a > b) console.log('>')
else if (a < b) console.log('<')
else console.log('==')