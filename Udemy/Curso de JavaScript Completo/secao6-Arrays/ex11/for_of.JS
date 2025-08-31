const arr = [1, 2, 3, 4, 5];
const obj = {
    nome: 'higor',
    idade: "20",
    email: "higor@sever.com"
}

for (let prop in obj) {
    console.log(prop, obj[prop]);
}

for (n of arr) {
    console.log(n);
}