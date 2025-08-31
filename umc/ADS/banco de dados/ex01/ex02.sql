# Mencionando o Banco para uso
use universidae;

#adicionar uma nova coluna
alter table aluno
	add column celular varchar(20);

# modificar o nome de uma coluna e o tipo 
alter table aluno
	change column nome mome_completo varchar(255);

# Adicionar uma restrição a uma coluna e alterar o tippo
 alter table discipliona
	modify column nome text not null;

    
