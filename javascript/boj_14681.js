const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin, //readable stream to listen to
  output: process.stdout //writable stream to write readline data to
});

rl.on('line', function(line) {
  console.log('hello !', line);
  rl.close(); //close the stream
}).on('close', function() {
  process.exit();
});