var a = document.querySelector('#verrifica')
a.addEventListener('click',verrificar)
function verrificar (){
    var data = new Date()
    var anoAtual = data.getFullYear()
    var anoNascimento = document.querySelector('#txtano')
    var res= document.querySelector('#res')
    if(anoNascimento.value.length == 0 || Number(anoNascimento.value)
 > anoAtual){
        alert('[ERRO] Verifique os dados e tente novamente')
    }
    else{
        var sexo = document.getElementsByName('radsex')
        var idade = anoAtual - Number(anoNascimento.value)
        var genero = ''
        var foto = document.createElement('img')
        foto.setAttribute('id','foto')
        if( sexo[0].checked){
            genero = 'Homem'
            if(idade < 10 ){
                foto.setAttribute('src', 'assets/fotos/criancaHomem.jpg')
            }
            else if (idade < 21){
                foto.setAttribute('src', 'assets/fotos/jovemHomem.jpg')

            }
            
            else if ( idade < 50){
                foto.setAttribute('src', 'assets/fotos/adultoHomem.jpg')
            }
            else{
                foto.setAttribute('src', 'assets/fotos/idosoHomem.jpg')
            }
        }
        else if(sexo[1].checked){
            genero = 'Mulher'
            if(idade >= 0 && idade < 10 ){
                foto.setAttribute('src', 'assets/fotos/criancaMulher.jpg')
            }
            else if ( idade < 21){
                foto.setAttribute('src', 'assets/fotos/jovemMulher.jpg')
            }
            
            else if ( idade < 50){
                foto.setAttribute('src', 'assets/fotos/adultoMulher.jpg')
            }
            else{
                foto.setAttribute('src', 'assets/fotos/idosoMulher.jpg')
            }
        }
        res.style.textAlign = 'center'
        res.innerHTML = `Detectamos ${genero} com ${idade} anos`
        res.appendChild(foto)
    
    }

     
}