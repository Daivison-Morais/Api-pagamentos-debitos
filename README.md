# API Pagamentos de Debitos

Este projeto é um desafio técnico que propõe o desenvolvimento de uma API que permite a recepção e pagamentos de débitos, tanto de pessoa física como de pessoa jurídica.


## Features

- Cadastrar um pagamento.
- Atualizar o pagamento de pendente para Sucesso ou Falha.
- Listar todos os pagamentos.
- Filtrar pagamentos por CPF/CPNJ, Código do Débito ou Status do pagamento.

</br>

## API Referência

### Cadastre um pagamento.

```http
POST /api/pagamento
```

#### Request:

| Body              | Type     | Description                            |
| :---------------- | :------- | :------------------------------------- |
| `codigoDebito`    | `String` | **Required**. Código do débito a ser pago |
| `tipoDocPagador`  | `String` | **Required**. CPF ou CNPJ      |
| `metodoPagamento` | `ENUM (BOLETO, PIX, CARTAO_CREDITO, CARTAO_DEBITO` | **Required**. Opções para pagamento |
| `numeroCartao`        | `String Cartao do credito/debito válido` | **Requaired** se o pagamento for com cartão.             |
| `valorPagamento` | `String` | **Required**. Valor do débito a ser pago |

#### Response:

```json
{
  "data": "Pagamento",
  "httpStatus": "CREATED",
  "message": "Pagamento cadastrado com sucesso!"
}
```

#

### Atualizar o status de um pagamento

```http
PUT /api/processamento
```

#### Request:

| body              | Type     | Description                            |
| :---------------- | :------- | :------------------------------------- |
| `id`           | `Long` | **Required**. ID do pagamento a ser atualizado               |
| `statusPagamento`        | `String` | **Required**. Aceita somente (PENDENTE, SUCESSO, FALHA)            |


</br>

#### Response:

```json
{
  "data": "Pagamento",
  "httpStatus": "OK",
  "message": "Pagamento atualizado com sucesso!"
}
```

### Listar todos os pagamentos.

```http
GET /api/pagamento
```

#### Response:

```json
{
  "data": ["pagamentos"],
  "httpStatus": "OK",
  "message": "Todos os pagamentos listados com sucesso!"
}
```

### Filtar pagamentos por Código do débito.

```http
GET /api/pagamento/filtro-codigoDebito/{codigoDebito}
```

#### Request:

| PATH PARAM              | Type     | Description                            |
| :---------------- | :------- | :------------------------------------- |
| `codigoDebito`    | `String` | **Required**. Código do débito a ser filtrado |


#### Response:

```json
{
  "data": "pagamentos filtrados",
  "httpStatus": "OK",
  "message": "Pagamentos filtrados com sucesso"
}
```

#

### Filtrar pagamentos por CPF/CNPJ.

```http
GET /api/pagamento/filtro-cpfCnpj/{CpfCnpj}
```

#### Request:

| PATH PARAM              | Type     | Description                            |
| :---------------- | :------- | :------------------------------------- |
| `cpfCnpj`    | `String` | **Required**. CPF/CNPJ a ser filtrado |


#### Response:

```json
{
  "data": "Array de pagamentos filtrados",
  "httpStatus": "OK",
  "message": "Pagamentos filtrados com sucesso"
}
```

#

### Filtrar pagamentos por status.

```http
GET /api/pagamento/filtro-status/{status}
```

#### Request:

| PATH PARAM              | Type     | Description                            |
| :---------------- | :------- | :------------------------------------- |
| `status`    | `String` | **Required**. Status dos pagamentos a serem filtrados |

`status precisa ser uma String do tipo 'PENDENTE' , 'SUCESSO' ou 'FALHA'`

#### Response:

```json
{
  "data": "Array de pagamentos filtrados",
  "httpStatus": "OK",
  "message": "Pagamentos filtrados com sucesso"
}
```

#


## Rode Localmente

Clone o projeto

```bash
  git clone https://github.com/Daivison-Morais/Api-pagamentos-debitos.git
```

Navegue até o Diretório do Projeto

```bash
  cd Api-pagamentos-debitos/
```


