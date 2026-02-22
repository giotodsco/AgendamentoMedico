🏥 MedAgenda — API de Agendamento Médico

API REST para gerenciamento de agendamentos médicos, desenvolvida com Spring Boot e MySQL.

---

📋 Sobre o Projeto

O MedAgenda é um sistema de agendamento de consultas médicas que permite cadastrar pacientes e médicos, gerenciar horários disponíveis e realizar agendamentos com validações de negócio reais.

---

🚀 Tecnologias

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA / Hibernate**
- **MySQL**
- **Lombok**

---

## 📁 Estrutura do Projeto

```
src/
├── controller/       # Endpoints da API
├── service/          # Regras de negócio
├── repository/       # Acesso ao banco de dados
├── model/            # Entidades JPA
├── dto/
│   ├── request/      # DTOs de entrada
│   └── response/     # DTOs de saída
└── enums/            # Especialidade, StatusConsulta
```

---

## 🗃️ Entidades

- **Paciente** — nome, documento, idade
- **Medico** — nome, especialidade, CRM
- **HorariosMedico** — data, horário, disponível, médico
- **Consulta** — paciente, médico, horário, status

---

## 🔗 Endpoints

### 👤 Paciente
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/paciente` | Cadastrar paciente |
| GET | `/paciente` | Listar pacientes |
| DELETE | `/paciente/{id}` | Deletar paciente |

### 🩺 Médico
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/medico` | Cadastrar médico |
| GET | `/medico` | Listar médicos |
| GET | `/medico/especialidade/{especialidade}` | Listar por especialidade |
| DELETE | `/medico/{id}` | Deletar médico |

### 🕐 Horários
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/horario/medico/{idMedico}` | Adicionar horário ao médico |

### 📋 Consulta
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/consulta/{idPaciente}/{idMedico}/{idHorario}` | Agendar consulta |
| GET | `/consulta` | Listar consultas |
| PATCH | `/consulta/alterar/{idConsulta}/horario/{idHorario}` | Alterar horário |
| DELETE | `/consulta/{id}` | Cancelar consulta |

---

## 📨 Exemplos de Requisição

### Criar Paciente
```json
POST /paciente
{
    "name": "João Silva",
    "document": "12345678901",
    "idade": 30
}
```

### Criar Médico
```json
POST /medico
{
    "name": "Dr. Carlos",
    "especialidade": "CARDIO",
    "crm": "123-45-6789"
}
```

### Adicionar Horário
```json
POST /horario/medico/1
{
    "data": "25/03/2026",
    "horario": "09:30"
}
```

### Agendar Consulta
```
POST /consulta/1/1/1
```
_(idPaciente / idMedico / idHorario)_

---

## ✅ Validações de Negócio

- Médico não pode ter dois horários iguais no mesmo dia
- Horários passados não são aceitos
- Horário deve pertencer ao médico informado na consulta
- Horário deve estar disponível para ser agendado
- Ao remarcar, o horário anterior é liberado automaticamente

---

## ⚙️ Como Rodar

1. Clone o repositório
```bash
git clone https://github.com/giotodsco/AgendamentoMedico
```

2. Configure o banco de dados no `application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/agendamento
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

3. Rode o projeto
```bash
./mvnw spring-boot:run
```

4. Acesse a API em `http://localhost:8080`

---

## 👨‍💻 Autor

Desenvolvido por **giotodsco**
