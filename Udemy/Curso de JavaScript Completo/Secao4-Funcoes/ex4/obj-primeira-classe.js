// Exemplo 1 de CallBack
function fn (cb){
    console.log("Exemplo 1 de CallBack")
    console.log("executar ação de callback")
    console.log(typeof cb)
    typeof cb === "function" && cb()
    
}

fn( function(){
    console.log("Função passada com parametro")
})


// Exemplo 2 de CallBack
function passarVl(n1 = 0, n2 = 0, callback){
    somar = n1+n2
    callback(somar)
    
}

function receberVl(vl){
    console.log("Exemplo 2 de CallBack")
    console.log(`O valor da soma passado por CallBack é: ${vl}` )
}

passarVl(1,1,receberVl)


// Exemplo 3 de callBack

function callback(){
    console.log("Exemplo 3 de CallBack")
    console.log("Função passada por parametro")
}

const obj = {
    callback
}

obj.callback()

// Objeto de primeira classe

function fn3(){
        fn3.count++
        return function _fn3(){
            console.log("Exemplo 4")
            console.log("função retornada por parametro")
        }
}

fn3.count = 0

const funcao3 = fn3()
funcao3()
console.log (fn3.count)