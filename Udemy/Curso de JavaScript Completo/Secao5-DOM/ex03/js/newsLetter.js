const btnCadastrar = document.getElementById('btn')
const msgFeedback = document.getElementById('newsletterFeedback')
btnCadastrar.addEventListener('click', cadastrarEmail)
function cadastrarEmail() {
    let email = txtEmail.value
    if(email === ''){
        msgFeedback.innerHTML = `<p> Por favor, preencha o campo de e-mail </p>`
    }
    else{
        msgFeedback.innerHTML = `<p> E-mail ${email} cadastrado com sucesso! </p>`
    }
}