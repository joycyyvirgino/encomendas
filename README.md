# Encomendas

Plataforma web para pequenos negócios que vendem sob encomenda (doces, marmitas, lanches) controlarem **pedidos, pagamentos e insumos** num só lugar.

O fluxo central: registrar o pedido → cobrar via PIX → confirmar o pagamento por webhook → mandar para produção → baixar os insumos da receita automaticamente, sem inconsistência.

## Stack

- Java 17 + Spring Boot 3.3
- PostgreSQL
- Spring Data JPA + Bean Validation
- Lombok
- Em andamento: JWT, Mercado Pago (sandbox), React com Vite, Docker

## Status

- [x] Enums e entidades JPA (Usuario, Produto, ItemReceita, Insumo, Pedido, ItemPedido, Pagamento)
- [x] DTOs de request e response (records com validação)
- [ ] Repositories e services
- [ ] Controllers e tratamento de erros (`@RestControllerAdvice`)
- [ ] Pagamento PIX (Mercado Pago sandbox) e webhook
- [ ] Autenticação JWT com perfis DONO e ATENDENTE
- [ ] Front-end React
- [ ] Testes, Flyway, Swagger e Docker completo

## Modelo de domínio

```
Usuario 1──* Pedido 1──* Pagamento
               │ (composição)
               └──* ItemPedido *──1 Produto
                                      │ (composição)
                                      └──* ItemReceita *──1 Insumo
```

Decisões de modelagem:

- **Preço congelado:** `ItemPedido.precoUnitario` guarda o preço no momento do pedido, então alterar o produto depois não mexe em pedidos antigos.
- **Idempotência do webhook:** `Pagamento.idExterno` (ID do Mercado Pago) é único.
- **Lock otimista:** `Insumo.version` (`@Version`) evita que dois pedidos sobrescrevam o mesmo estoque.
- **Dinheiro:** sempre `BigDecimal`.
- **Regras nos services:** as entidades só guardam dados; o comportamento fica na camada de service.

## Estrutura de pacotes

```
br.com.encomendas
├── dto/         request e response (records)
├── enums/       Perfil, StatusPedido, StatusPagamento, UnidadeMedida
├── model/       entidades JPA
└── EncomendasApplication.java
```

As demais camadas (controller, service, repository, gateway, security, exception, config) entram nas próximas semanas do cronograma.

## Como rodar

Pré-requisitos: Java 17, Maven e Docker.

```bash
# 1. Variáveis de ambiente
cp .env.example .env        # edite DB_PASSWORD e JWT_SECRET

# 2. Banco de dados
docker compose --env-file .env up -d

# 3. Aplicação (carrega as variáveis do .env)
export $(grep -v '^#' .env | xargs)
mvn spring-boot:run
```

> Segredos (senha do banco, JWT, tokens do Mercado Pago) ficam **somente** em variáveis de ambiente. O `.env` está no `.gitignore`.

## Próximos passos

Veja o cronograma completo no planejamento do projeto. O MVP é dividido em 8 semanas, com Mercado Pago na semana 4 e React nas semanas 6 e 7.
