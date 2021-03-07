# cart_microservices
Sistema simples para demonstração do uso da arquitetura de microserviços.

O sistema é composto por 6 microserviços:
  - **auth**: provê autenticação via Spring Security
  - **ui**: interface
  - **zip**: busca de endereço por cep
  - **server**: gateway para requisições
  - **mail**: Envio de emails
  - **cart**: serviço simples de gerencimaento


#### Tecnologias
  - Spring Boot 2.3.9
  - Docker
  - Kafka
  - Zuul para o Gateway
  - Eureka para gerenciamento de serviços.
  - Feign para acesso REST

#### Fluxo
Como o sistema é apenas para estudos, só existem alguns testes possíves:

##### Busca CEP
O serviço ZIP possui um controlador que utilizado o Feign Client para buscar endereços pelo número do CEP da API viacep.com.

##### Busca de informações em Cart
O serviço Cart possui uma classe chamada Cart, onde é possível armazenar nome, email e endereço.

O preenchimento dos dados de endereço é feito por uma chamada ao serviço Zip, retornando um objeto do tipo Address.

Ao mesmo tempo, essa busca utiliza um Producer para produzir uma mensagem no Kafka.

##### Mensageria
O serviço Mail recebe a mensagem produzida no Kafka e faz o envio de emails.
