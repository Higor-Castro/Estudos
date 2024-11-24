const alunos = [];


function cadastrarAluno() {

    const nome = document.getElementById('nome').value;

    const idade = parseInt(document.getElementById('idade').value);

    const altura = parseFloat(document.getElementById('altura').value);

    const peso = parseFloat(document.getElementById('peso').value);


    const aluno = {

        nome,

        idade,

        altura,

        peso

    };


    alunos.push(aluno);

    atualizarListaAlunos();

    limparCampos();

}


function atualizarListaAlunos() {

    const ul = document.getElementById('alunos-ul');

    ul.innerHTML = '';


    alunos.forEach((aluno, index) => {

        const li = document.createElement('li');

        li.innerHTML = `

            <span>${aluno.nome}</span>

            <button onclick="exibirDetalhes(${index})">Detalhes</button>

        `;

        ul.appendChild(li);

    });

}


function exibirDetalhes(index) {

    const aluno = alunos[index];

    const alunoDetails = document.getElementById('aluno-details');

    const alunoInfo = document.getElementById('aluno-info');


    alunoInfo.textContent = `

        Nome: ${aluno.nome}

        Idade: ${aluno.idade}

        Altura: ${aluno.altura} m

        Peso: ${aluno.peso} kg

    `;


    alunoDetails.style.display = 'block';

}


function excluirAluno() {

    const alunoDetails = document.getElementById('aluno-details');

    alunoDetails.style.display = 'none';


    if (confirm('Deseja realmente excluir este aluno?')) {

        alunos.splice(index, 1);

        atualizarListaAlunos();

    }

}


function limparCampos() {

    document.getElementById('nome').value = '';

    document.getElementById('idade').value = '';

    document.getElementById('altura').value = '';

    document.getElementById('peso').value = '';

}
