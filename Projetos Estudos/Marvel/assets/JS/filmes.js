        // Carrosel dos cards
const carousel = document.querySelector('.cards'); // Seleciona o carrossel
const prev = document.getElementById('prev'); // Botão anterior
const next = document.getElementById('next'); // Botão próximo
const scrollAmount = 350; // Define a distância de rolagem

// Evento para o botão "Anterior"
prev.addEventListener('click', () => {
    // Se o scroll atual for igual a 0, vai para o final
    if (carousel.scrollLeft === 0) {
        carousel.scrollLeft = carousel.scrollWidth - carousel.clientWidth;
    } else {
        carousel.scrollLeft -= scrollAmount;
    }
});

// Evento para o botão "Próximo"
next.addEventListener('click', () => {
    // Se estiver no final, volta para o início
    if (carousel.scrollLeft + carousel.clientWidth >= carousel.scrollWidth - 1) {
        carousel.scrollLeft = 0;
    } else {
        carousel.scrollLeft += scrollAmount;
    }
});



            // Detalhes
// Pega todos os elementos .details e .card-details
const detailsList = document.querySelectorAll('.details');
const cardDetailsList = document.querySelectorAll('.card-details');

// Adiciona o evento de clique para cada .details
detailsList.forEach((details, index) => {
    // Verifica se o índice existe em cardDetailsList antes de adicionar o evento
    if (cardDetailsList[index]) {
    details.addEventListener('click', () => rating(index));
    }
});

function rating(index) {
    // Verifica se o cardDetailsList contém um elemento no índice
    if (cardDetailsList[index]) {
    // Alterna a visibilidade do card correspondente
    if (cardDetailsList[index].style.display === "none" || cardDetailsList[index].style.display === "") {
        cardDetailsList[index].style.display = "flex"; // Exibe o card

    }

    }
}


        // Sair Detalhes
// Pega todos os elementos .details e .card-details
const exitList = document.querySelectorAll('.exit');

// Adiciona o evento de clique para cada .details
exitList.forEach((exit, index) => {
    // Verifica se o índice existe em cardDetailsList antes de adicionar o evento
    if (cardDetailsList[index]) {
    exit.addEventListener('click', () => exit_rating(index));
    }
});

function exit_rating(index) {
    // Verifica se o cardDetailsList contém um elemento no índice
    if (cardDetailsList[index]) {
    // Alterna a visibilidade do card correspondente
    if (cardDetailsList[index].style.display === "flex") {
        cardDetailsList[index].style.display = "none"; // Oculta o card
    }
    }
}

        // Filtro
// Seleciona o elemento menu de seleção pelo ID
const filterSelect = document.getElementById('filter-select');
// Seleciona o cards pelo ID
const cardsContainer = document.getElementById('carousel');

// Define uma função chamada filterCards, que recebe como parâmetro o critério de ordenação (criteria)
function filterCards(criteria) {
    // Converte os cards em um array para manipulá-los facilmente
    const cards = Array.from(cardsContainer.children);

    // Ordena os cards com base no valor do atributo "data-[criteria]" (pode ser "data-lancamento" ou "data-cronologia")
    cards.sort((a, b) => a.dataset[criteria] - b.dataset[criteria]);

    // Reorganiza os cards no container, inserindo-os na nova ordem
    cards.forEach(card => cardsContainer.appendChild(card));
}

// Adiciona um evento de mudança (change) ao dropdown
filterSelect.addEventListener('change', () => {
    // Verifica se a opção selecionada não é a padrão ("default")
    if (filterSelect.value !== 'default') {
        // Chama a função filterCards passando o valor selecionado como critério (ex.: "lancamento" ou "cronologia")
        filterCards(filterSelect.value);
    }
});
