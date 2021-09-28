## Monitora COVID-19

### Desenvolvimento
Apache Maven 3.8.2
Apache Netbeans 12.4
Java version: 1.8.0_292
Default locale: pt_BR, platform encoding: UTF-8

### Maven
Linux e MACOS: https://formulae.brew.sh/formula/maven
Windows: https://dicasdejava.com.br/como-instalar-o-maven-no-windows/

### Passo a Passo usando executavel (Utilizando Servidor hospedado no Heroku)

- 1 Como o server está rodando no heroku, então não há necessidade em executar o projeto ```Server```.

- 2 Execute ```java -jar medico-1.0-SNAPSHOT-jar-with-dependencies.jar``` para interface do médico
- 3 Execute ```java -jar client-1.0-SNAPSHOT-jar-with-dependencies.jar``` para interface de simulação dos sensores


### Passo a Passo para execução (Servidor localmente)
- 1 Abra o projeto Serve e execute ```mvn clean install ``` 
- 2 Execute o arquivo ```java -jar target/main-1.0-SNAPSHOT.jar ```
- 3 Abra os projetos ```Medico e Paciente``` e altere o arquivo view/Login. No atríbuto ```baseUrl``` altere  ```https://pblredes.herokuapp.com/``` para ```http://127.0.0.1:8000/
- 4 Execute na raiz dos projetos ```Medico e Paciente```:  ```mvn clean install```
- 5 Execute o arquivo ```java -jar target/${nome-projeto}.jar```

