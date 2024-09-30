function salvar() {
    // Captura os dados do formulário
    const name = document.getElementById('task-name').value;
    const description = document.getElementById('task-desc').value;
    const taskType = document.getElementById('task-type').value;
    const initialDate = document.getElementById('task-initial-date').value;
    const limiteDate = document.getElementById('task-limit-date').value;

    // Cria o objeto com os dados da tarefa
    const taskData = {
        name: name,
        description: description,
        taskType: taskType,
        initialDate: initialDate,
        limiteDate: limiteDate
    };

    // Faz a requisição POST ao endpoint /task
    fetch('/task', {
        method: 'POST', // Método HTTP
        headers: {
            'Content-Type': 'application/json' // Tipo de conteúdo JSON
        },
        body: JSON.stringify(taskData) // Converte o objeto taskData em JSON
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao salvar a tarefa');
        }
        return response.json(); // Converte a resposta para JSON
    })
    .then(data => {
        // Exibe a mensagem de sucesso ou o dado retornado
        document.getElementById('resultado').innerText = 'Tarefa salva com sucesso!';
    })
    .catch(error => {
        console.error('Erro:', error);
        document.getElementById('resultado').innerText = 'Erro ao salvar a tarefa.';
    });
}
