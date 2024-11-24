document.addEventListener('DOMContentLoaded', () => {
    const apiUrl = 'https://my-json-server.typicode.com/EnkiGroup/DesafioReactFrontendJunior2024/todos';
    const newTodoInput = document.querySelector('.new-todo');
    const todoList = document.querySelector('.todo-list');
    const toggleAllInput = document.querySelector('#toggle-all');
    const todoCount = document.querySelector('.todo-count strong');
    const clearCompletedButton = document.querySelector('.clear-completed');
    const filters = document.querySelectorAll('.filters a');

    let todos = [];

    async function fetchTodos() {
        try {
            const response = await fetch(apiUrl);
            todos = await response.json();
            render();
        } catch (error) {
            console.error('Error fetching todos:', error);
        }
    }

    function addTodo(title) {
        const newTodo = {
            id: Date.now(),
            title,
            completed: false,
        };
        todos.unshift(newTodo);
        newTodoInput.value = '';  
        render(); 
        
    }

    function toggleTodoCompletion(id) {
        const todo = todos.find(todo => todo.id === id);
        if (todo) {
            todo.completed = !todo.completed;
        }
        render();
    }

    function deleteTodo(id) {
        todos = todos.filter(todo => todo.id !== id);
        render();
    }

    function editTodo(id, newTitle) {
        const todo = todos.find(todo => todo.id === id);
        if (todo) {
            todo.title = newTitle;
        }
        render();
    }

    function toggleAllTodos() {
        const allCompleted = todos.every(todo => todo.completed);
        todos.forEach(todo => todo.completed = !allCompleted);
        render();
    }

    function clearCompletedTodos() {
        todos = todos.filter(todo => !todo.completed);
        render();
    }

    function render() {
        const filter = window.location.hash.replace('#/', '') || 'all';
        const filteredTodos = todos.filter(todo => {
            if (filter === 'active') return !todo.completed;
            if (filter === 'completed') return todo.completed;
            return true;
        });

        todoList.innerHTML = filteredTodos.map(todo => `
            <li class="${todo.completed ? 'completed' : ''}" data-id="${todo.id}">
                <div class="view">
                    <input class="toggle" type="checkbox" ${todo.completed ? 'checked' : ''}>
                    <label>${todo.title}</label>
                    <button class="destroy"></button>
                </div>
                <input class="edit" value="${todo.title}">
            </li>
        `).join('');

        todoCount.textContent = todos.filter(todo => !todo.completed).length;
        clearCompletedButton.textContent = `Limpar completos (${todos.filter(todo => todo.completed).length})`;

        filters.forEach(filter => filter.classList.remove('selected'));
        document.querySelector(`.filters a[href="#/${filter}"]`).classList.add('selected');
    }

    newTodoInput.addEventListener('keypress', (event) => {
        if (event.key === 'Enter' && newTodoInput.value.trim() !== '') {
            addTodo(newTodoInput.value.trim());
            newTodoInput.value = ''; 
        }
    });

    todoList.addEventListener('change', (event) => {
        if (event.target.classList.contains('toggle')) {
            const id = Number(event.target.closest('li').dataset.id);
            toggleTodoCompletion(id);
        }
    });

    todoList.addEventListener('click', (event) => {
        if (event.target.classList.contains('destroy')) {
            const id = Number(event.target.closest('li').dataset.id);
            deleteTodo(id);
        }
    });

    todoList.addEventListener('dblclick', (event) => {
        if (event.target.tagName === 'LABEL') {
            const listItem = event.target.closest('li');
            listItem.classList.add('editing');
            const editInput = listItem.querySelector('.edit');
            editInput.focus();
            editInput.setSelectionRange(editInput.value.length, editInput.value.length);
        }
    });

    todoList.addEventListener('keypress', (event) => {
        if (event.key === 'Enter' && event.target.classList.contains('edit')) {
            const listItem = event.target.closest('li');
            const id = Number(listItem.dataset.id);
            editTodo(id, event.target.value.trim());
            listItem.classList.remove('editing');
        }
    });

    toggleAllInput.addEventListener('change', toggleAllTodos);
    clearCompletedButton.addEventListener('click', clearCompletedTodos);

    window.addEventListener('hashchange', render);
});
