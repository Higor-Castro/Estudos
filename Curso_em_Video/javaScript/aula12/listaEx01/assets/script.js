var a = document.querySelector('body')
a = addEventListener('load', carregar)
function carregar(){
    var msg = document.querySelector('#msg')
    var img = document.querySelector('#imagens') 
    var data = new Date()
    var hora = data.getHours()
    msg.innerHTML = `<p>Agora são ${hora} horas.</p>`
    if ( hora >= 0 && hora < 12){
        document.body.style.background = 'rgb(242, 182, 122)'
        msg.innerHTML +=    `<p>Bom Dia</p>`
        img.src = 'assets/fotos/manha.jpg'
        
    }
    else if ( hora >= 12 && hora < 18){
        document.body.style.background = 'rgb(56, 86, 165)'
        msg.innerHTML +=    `<p>Boa Tarde</p>`
        img.src = 'assets/fotos/tarde.jpg'
    }
    else{
        document.body.style.background = 'rgb(63, 70, 90)'
        msg.innerHTML +=    `<p>Boa Noite</p>`
        img.src = 'assets/fotos/noite.jpg'
    }

}