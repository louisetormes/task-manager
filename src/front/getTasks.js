function buscar() {
    // Pegue o valor do campo de pesquisa
    const pesquisa = document.getElementById('campo-pesquisa').value;

    // Realize a requisição GET à API Java
    fetch('/task/all')
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao buscar tarefas');
            }
            return response.json(); // Converta a resposta para JSON
        })
        .then(tarefas => {
            // Exiba as tarefas no campo de resultado
            const resultado = document.getElementById('resultado');
            resultado.innerHTML = ''; // Limpe o campo antes de exibir novos resultados

            if (tarefas.length === 0) {
                resultado.innerHTML = 'Nenhuma tarefa encontrada.';
                return;
            }

            // Crie uma lista com as tarefas
            const lista = document.createElement('ul');
            tarefas.forEach(tarefa => {
                const item = document.createElement('li');
                item.textContent = `Nome: ${tarefa.name}, Descrição: ${tarefa.description}`;
                lista.appendChild(item);
            });

            resultado.appendChild(lista);
        })
        .catch(error => {
            console.error('Erro:', error);
            document.getElementById('resultado').innerHTML = 'Erro ao buscar tarefas.';
        });
}