        // VAlidação de Login e Senha
let a = document.querySelector('#btn');
a.addEventListener('click', validarLogin);

function validarLogin(event) {
    let login = document.querySelector('#login');
    let senha = document.querySelector('#senha');

    // Verifica se os campos estão vazios
    if (!login.value.trim() || !senha.value.trim()) {
        event.preventDefault(); // Previne o comportamento padrão do link
        alert("Preencha o Usuário e a Senha para continuar");
        return;
    }

    // Se todos os campos estiverem preenchidos, o link será seguido normalmente
}

