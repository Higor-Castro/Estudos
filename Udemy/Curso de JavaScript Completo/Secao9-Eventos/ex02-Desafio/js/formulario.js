(function (){
    'use strict';

    const txtTitulo = document.getElementById("txtTitulo")
    const btn = document.getElementById("btn")
    const formCadastro = document.querySelector(".formCadastro")
    
    // btn.addEventListener("click", function(event){
    // })

    formCadastro.addEventListener("submit",function(event){
        if(! txtTitulo.value){
            showErrorMessage(`Preencha todos os campos`, function(){
                txtTitulo.focus();
            });
            event.preventDefault();
            
            
        }
    } )

    const feedbackMessage = document.getElementById("feedbackMessage")
    const feedbackMessageCloseBtn = feedbackMessage.getElementsByTagName("button")[0]

    function showErrorMessage(msg, cb){
        feedbackMessage.classList.add("show")
        feedbackMessage.getElementsByTagName("p")[0].textContent = msg

        feedbackMessageCloseBtn.focus()

        function hideErrorMessage(){
            feedbackMessage.classList.remove("show")
            feedbackMessageCloseBtn.removeEventListener("click", hideErrorMessage)
            feedbackMessageCloseBtn.removeEventListener("keyup",  pressedKeyOnBtn)

            if(typeof cb === "function"){
            cb();
            }
        }

        function pressedKeyOnBtn(e){
            if(e.keyCode === 27){
                hideErrorMessage()
            }
        }

        feedbackMessageCloseBtn.addEventListener("click", hideErrorMessage)

        feedbackMessageCloseBtn.addEventListener("keyup",  pressedKeyOnBtn)

    }



    const txtDescricao = document.getElementById("txtDescricao")
    const contadorContainer = document.getElementById("contador")
    const resta = contadorContainer.getElementsByTagName("span")[0]
    const maxima = txtDescricao.maxLength
    mostrarNumero(maxima)

    // contadorContainer.removeAttribute("style")
    contadorContainer.style.display="block"

    function checkLenght (){
        let numeroLetrasDigitadas = this.value.length
        let caractersRestantes = parseInt(maxima) - parseInt(numeroLetrasDigitadas);
        mostrarNumero(caractersRestantes)
       
        }
    function mostrarNumero(n){
         resta.textContent = n

    }
    txtDescricao.addEventListener("input", checkLenght)

    btn.disabled = true
    const chkAceito = document.getElementById("chkAceito")
    chkAceito.addEventListener("change", function(){
        btn.disabled = !this.checked
    })



})();