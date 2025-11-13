💱 Conversor de Moedas — Java

Um projeto em Java orientado a objetos que realiza conversões de moedas em tempo real utilizando uma API de cotações, com registro histórico das conversões em arquivo JSON.

O sistema foi desenvolvido com foco em boas práticas de programação, separação de responsabilidades e persistência de dados em formato leve e legível.

🎯 Problema Resolvido

Converter moedas manualmente é demorado e sujeito a erros — especialmente com valores variando a todo instante.
Este projeto resolve isso permitindo ao usuário:

Consultar automaticamente a cotação atualizada entre duas moedas.

Inserir o valor desejado para conversão.

Armazenar o histórico das conversões realizadas em um arquivo Cotacoes.json, de forma cumulativa.

Assim, o usuário obtém resultados instantâneos, formatados e organizados para consulta posterior.

🧠 Tecnologias Utilizadas

Java 17+

Gson — para serialização e desserialização de objetos em JSON

API HTTP (Java.net.HttpClient) — para integração com o serviço de cotação

Paradigma Orientado a Objetos (POO) — modularização em pacotes:

model — representa entidades como Historical

services — lida com requisições, conversões e persistência

config — configurações centrais como GsonConfig e ScannerConfig

⚙️ Estrutura do Projeto
br.com.joaovitor.conversor
 ├── main
 │    └── Main.java
 ├── model
 │    └── Historical.java
 ├── services
 │    ├── Converter.java
 │    ├── RequestApi.java
 │    └── LoadJson.java
 └── config
      ├── GsonConfig.java
      └── ScannerConfig.java

🚀 Como Executar

Clone o repositório:

git clone https://github.com/seu-usuario/conversor-de-moedas.git


Abra o projeto na sua IDE Java (como IntelliJ IDEA ou Eclipse).

Verifique o JDK:
Certifique-se de que o JDK 17 (ou superior) esteja configurado.

Compile e execute o programa:

javac -d out src/br/com/joaovitor/conversor/main/Main.java
java -cp out br.com.joaovitor.conversor.main.Main


Interaja pelo terminal:

Escolha as moedas de origem e destino.

Digite o valor a ser convertido.

Veja o resultado e o histórico sendo salvo no arquivo Cotacoes.json.

🧾 Exemplo de Saída
Digite o valor em USD que deseja cotar:
100
A cotação ficou: R$ 567.45


E o arquivo Cotacoes.json armazenará algo como:

[
  {
    "originCoin": "USD",
    "destinationCoin": "BRL",
    "valueConverter": 100.0,
    "result": 567.45
  }
]

📈 Resultados

Persistência confiável das conversões realizadas.

Organização modular e reutilizável de código.

Integração bem-sucedida com API externa.

Uso prático de JSON no fluxo de dados em Java.

👨‍💻 Autor

João Vitor Machado
Desenvolvedor Java em formação | Foco em Back-End 
