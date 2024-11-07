# CoinNect

**CoinNect** é uma plataforma que conecta **Prestadores de Serviço** a um público em tempo real, facilitando a negociação de preços, contratação de serviços e gerenciamento de pagamentos. A plataforma foi desenvolvida com **Java** e **Spring Boot**, usando tecnologias para garantir segurança, escalabilidade e uma experiência de usuário eficiente.

## Índice

- [Objetivo](#objetivo)
- [Funcionalidades](#funcionalidades)
- [Requisitos](#requisitos)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Como Executar o Projeto](#como-executar-o-projeto)
- [Arquitetura e Design](#arquitetura-e-design)
- [Futuras Implementações](#futuras-implementações)

---

## Objetivo

CoinNect visa proporcionar uma plataforma onde clientes podem:
- Encontrar prestadores de serviços em tempo real
- Negociar e contratar serviços
- Realizar pagamentos de forma segura

## Funcionalidades

### Principais Funcionalidades

1. **Cadastro e Autenticação de Usuários**  
   - Cadastro de usuários com roles específicas (Cliente, Prestador de Serviço).
   - Autenticação via JWT.

2. **Gerenciamento de Serviços**
   - **Prestadores de Serviço** podem cadastrar e gerenciar os serviços oferecidos.
   - **Clientes** podem buscar prestadores próximos com base em geolocalização.

3. **Contratação e Criação de Contratos**
   - Clientes podem contratar prestadores e criar contratos com termos específicos (tipo de serviço, preço, prazo).
   - Prestadores podem aceitar ou recusar as propostas de contrato.

4. **Pagamentos e Wallet**
   - Processamento seguro de pagamentos e integração com um gateway de pagamento.
   - Registro de transações e histórico financeiro do cliente e do prestador.

5. **Notificações em Tempo Real**
   - Notificações via WebSocket para informar sobre status de contratos, atualizações de serviço, etc.

6. **Geolocalização**
   - Integração com Google Distance Matrix API para calcular a distância entre clientes e prestadores de serviços.

### Futuras Implementações

- **Sistema de Avaliações**: Clientes poderão avaliar os prestadores após o término do serviço.
- **Dashboard para Prestadores**: Relatórios e estatísticas sobre contratos, faturamento, avaliações.
- **Suporte para Contratos Recorrentes**: Possibilidade de contratação de serviços recorrentes.

## Requisitos

- **Java 17+**
- **Spring Boot 3.3.0**
- **Banco de Dados**: MySQL/PostgreSQL
- **API de Geolocalização**: Google Distance Matrix API
- **WebSocket**: Para notificações em tempo real
- **Gateway de Pagamento**: (Especificar conforme implementado)

## Tecnologias Utilizadas

- **Spring Boot**: Para criação da API RESTful.
- **Spring Security & JWT**: Para autenticação e autorização.
- **WebSocket**: Para notificações em tempo real.
- **Google Distance Matrix API**: Para calcular proximidade entre usuários.
- **Banco de Dados Relacional**: MySQL/PostgreSQL.

## Como Executar o Projeto

1. Clone este repositório:

   ```bash
   git clone https://github.com/seu-usuario/CoinNect.git
   cd CoinNect
