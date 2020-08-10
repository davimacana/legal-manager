# legal-manager
Projeto teste legal manager

## Frontend                                
                                                                  
Angular CLI: 9.1.12                                               
Node: 10.15.3                                                     
NG Bootstrap: 6.2.0

Para executar o projeto angular navegue até a raiz do projeto e execute os comandos abaixo:
```bash
npm install
ng serve
```

## Backend

Spring Boot incluindo as dependências do spring para desenvolvimento de rest api.

Banco: H2
Provedor JPA: Spring Data JPA com Hibernate.
Testes: Spring boot tester com JUnit.
Actuator: http://host:port/cop/actuator
    Ao realizar uma requisição GET no link do atuator a resposta será uma série de 
    recursos para monitoramento da API do aplicação.

Log:
    - Arquivo de log centralizado de nome legal.log
    - Configurações de log realizada no properties da aplicação.

Exceptions: 
    - Anotação @RestControllerAdvice para padronizar as respostas.
    - Dentro da msg de erro contém um atributo "codeErrorRandom" para facilitar a busca de erros no log.
    - Em caso de erro na api rest o projeto irá retornar msg em formato json padronizado, segue exemplo abaixo:
        {
            "timestamp": "yyy-MM-dd hh:mm:ss",
            "code": xxx,
            "status": "xxx",
            "error": "xxx",
            "codeErrorRandom": "xxx"
        }
        
        
Para executar o projeto spring boot navegue até a raiz do projeto e execute os comandos abaixo:
```bash
mvn spring-boot:run
```
