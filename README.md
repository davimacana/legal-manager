# legal-manager
Projeto teste legal manager

## Frontend                                
                                                                  
Angular CLI: 9.1.12                                               
Node: 10.15.3                                                     
OS: win32 x64                                                     
                                                                  
Angular: 9.1.12                                                   
... animations, cli, common, compiler, compiler-cli, core, forms  
... localize, platform-browser, platform-browser-dynamic, router  
Ivy Workspace: Yes                                                
                                                                  
Package                           Version                         
-----------------------------------------------------------       
@angular-devkit/architect         0.901.12                        
@angular-devkit/build-angular     0.901.12                        
@angular-devkit/build-optimizer   0.901.12                        
@angular-devkit/build-webpack     0.901.12                        
@angular-devkit/core              9.1.12                          
@angular-devkit/schematics        9.1.12                          
@ngtools/webpack                  9.1.12                          
@schematics/angular               9.1.12                          
@schematics/update                0.901.12                        
rxjs                              6.5.5                           
typescript                        3.8.3                           
webpack                           4.42.0            

Além das versões do Angular citadas acima, foi utilizado também o conjunto de componentes do "@ng-bootstrap/ng-bootstrap": "^6.2.0".

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
