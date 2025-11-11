# Sistema de Gestão de Condomínio

Sistema web desenvolvido em Spring Boot para gerenciamento de apartamentos e proprietários de condomínios. A aplicação oferece uma interface moderna e intuitiva com design responsivo em tons de azul.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.7**
- **Spring Data JPA**
- **Thymeleaf** (templates HTML)
- **H2 Database** (banco de dados em memória)
- **Lombok** (redução de boilerplate)
- **Maven** (gerenciamento de dependências)

## 📋 Funcionalidades

### Cadastro de Proprietários
- Cadastro de novos proprietários com nome e telefone
- Visualização de todos os proprietários cadastrados
- Relacionamento com apartamentos

### Cadastro de Apartamentos
- Cadastro de apartamentos com:
  - Número da porta
  - Quantidade de quartos
  - Tipo de ocupação (Proprietário, Inquilino ou Vazio)
  - Vinculação com proprietário
- Visualização de todos os apartamentos cadastrados
- Relatório completo com informações do proprietário

## 🎨 Interface

A aplicação possui uma interface moderna e responsiva com:
- Design em tons de azul
- Gradientes e efeitos de hover
- Formulários estilizados com feedback visual
- Tabelas organizadas e legíveis
- Navegação intuitiva entre páginas
- Layout responsivo para dispositivos móveis

## 📦 Pré-requisitos

Antes de executar a aplicação, certifique-se de ter instalado:

- **Java 21** ou superior
- **Maven 3.6+** (ou use o Maven Wrapper incluído no projeto)

## 🔧 Instalação e Execução

### 1. Clone o repositório (se aplicável)
```bash
git clone <url-do-repositorio>
cd mvc-arthur
```

### 2. Navegue até o diretório do projeto
```bash
cd arthur
```

### 3. Execute a aplicação

**Usando Maven Wrapper (recomendado):**
```bash
# Windows
.\mvnw.cmd spring-boot:run

# Linux/Mac
./mvnw spring-boot:run
```

**Ou usando Maven instalado:**
```bash
mvn spring-boot:run
```

### 4. Acesse a aplicação

Após a inicialização, a aplicação estará disponível em:

- **URL Principal:** http://localhost:8080/
- **Console H2 Database:** http://localhost:8080/h2-console

## 🌐 Rotas da Aplicação

| Rota | Descrição |
|------|-----------|
| `/` | Página inicial - Formulário de cadastro de apartamento |
| `/cad-apto` | Formulário de cadastro de apartamento |
| `/cad-prop` | Formulário de cadastro de proprietário |
| `/rel-apto` | Relatório de apartamentos cadastrados |
| `/rel-prop` | Relatório de proprietários cadastrados |
| `/h2-console` | Console do banco de dados H2 |

## 🗄️ Banco de Dados

A aplicação utiliza o banco de dados **H2**, que é criado automaticamente na pasta `data/` do projeto.

### Configuração do H2 Console

Para acessar o console do H2:

1. Acesse: http://localhost:8080/h2-console
2. Use as seguintes credenciais:
   - **JDBC URL:** `jdbc:h2:file:./data/condominio`
   - **User Name:** `sa`
   - **Password:** (deixe em branco)

### Estrutura do Banco

**Tabela: `proprietario`**
- `id_proprietario` (PK)
- `nome`
- `telefone`

**Tabela: `apartamento`**
- `id_apartamento` (PK)
- `numero_porta`
- `quantidade_quartos`
- `tipo_ocupacao`
- `proprietario_id` (FK)

## 📁 Estrutura do Projeto

```
arthur/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── avaliacao/arthur/
│   │   │       ├── ArthurApplication.java
│   │   │       ├── controller/
│   │   │       │   ├── ApartamentoController.java
│   │   │       │   └── ProprietarioController.java
│   │   │       ├── model/
│   │   │       │   ├── Apartamento.java
│   │   │       │   └── Proprietario.java
│   │   │       └── repository/
│   │   │           ├── ApartamentoRepository.java
│   │   │           └── ProprietarioRepository.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       │   └── style.css
│   │       └── templates/
│   │           ├── form_apto.html
│   │           ├── form_prop.html
│   │           ├── rel_apto.html
│   │           └── rel_prop.html
│   └── test/
├── data/
│   └── condominio.mv.db
├── pom.xml
└── mvnw / mvnw.cmd
```

## 🎯 Como Usar

### Cadastrar um Proprietário

1. Acesse http://localhost:8080/cad-prop
2. Preencha o nome e telefone
3. Clique em "Salvar"
4. Você será redirecionado para o relatório de proprietários

### Cadastrar um Apartamento

1. Acesse http://localhost:8080/cad-apto
2. Preencha:
   - Número da porta
   - Quantidade de quartos
   - Tipo de ocupação
   - Selecione o proprietário
3. Clique em "Salvar"
4. Você será redirecionado para o relatório de apartamentos

### Visualizar Relatórios

- **Relatório de Proprietários:** http://localhost:8080/rel-prop
- **Relatório de Apartamentos:** http://localhost:8080/rel-apto

## 🛠️ Desenvolvimento

### Hot Reload

A aplicação está configurada com Spring DevTools para hot reload automático. Alterações em:
- Templates HTML (`src/main/resources/templates/`)
- Arquivos estáticos (`src/main/resources/static/`)

Serão aplicadas automaticamente após salvar o arquivo.

### Compilar o Projeto

```bash
mvn clean package
```

O arquivo JAR será gerado em `target/arthur-0.0.1-SNAPSHOT.jar`

### Executar o JAR

```bash
java -jar target/arthur-0.0.1-SNAPSHOT.jar
```

## 📝 Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👤 Autor

**Arthur Santana Cavichioli**

---

## 📞 Suporte

Para dúvidas ou problemas, abra uma issue no repositório do projeto.

