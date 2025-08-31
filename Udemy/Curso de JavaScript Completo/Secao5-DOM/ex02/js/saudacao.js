(function(){
    const nomeUsuario = "Higor"
    if(nomeUsuario){
        const topBarElemento = document.createElement("div")
        topBarElemento.className = "top-bar"
        topBarElemento.innerHTML = `<p>Olá, <b> ${nomeUsuario}! </b> </p>`


        const elementoPai = document.querySelector(".hero")
        // Insere 'topBarElemento' como o primeiro filho de 'elementoPai'
        elementoPai.insertBefore(topBarElemento, elementoPai.firstElementChild)
    }     

})()