,
# java-crud-console

## Visão Geral 

Sistema de controle de inventário desenvolvido em Java, com operações CRUD e armazenamento de dados em arquivos CSV. O projeto aplica conceitos de Programação Orientada a Objetos para organização e manipulação de produtos.

## Funcionalidades
- LISTAR
  * Ver as informações de todos os itens presentes no estoque
- CADASTRAR
  * Incluir um novo item ao estoque
- DELETAR
  * Apagar um item presente no estoque
- ADICIONAR
  * Incluir certa quantidade de um produto do estoque
- RETIRAR
  * Retirar certa quantidade de um produto do estoque
- SAIR
  * Sair da aplicação e encerrar o processo

## Tecnologias Utilizadas
- Java JDK 21
- Console

## Estrutura do Projeto
```text
java-crud-console/
  ├─ README.md
  ├─ src/
  |    ├─ application/
  |    |    ├─ main/
  |    |    ├─ ui/
  |    |    ├─ services/
  |    |    └─ enums/
  |    └─ model/
  |        ├─ entities/
  |        ├─ services/
  |        └─ enums/
  └─ assets/
      ├─ imagens/
      |     ├─ uml_dominio.png
      |     └─ uml_implementacao.png
      └─ UMLPlantText/
            ├─ uml_dominio.puml
            └─ uml_implementacao.puml
```

### Diagrama de classes UML para domínio
![Diagrama de Classes do Projeto](assets/imagens/uml_dominio.png)

Um diagrama de classes para implementação pode ser econtrado em [Diagrama de Classes Implementação](assets/imagens/uml_implementacao.png)
