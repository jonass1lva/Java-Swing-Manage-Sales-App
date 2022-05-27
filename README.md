# projetoES22

##### EM CASOS DE ERROS: 

###### Erro de Dependicia BCrypt: Exception in thread "main" java.lang.NoClassDefFoundError<br> - Adicionar a seguinde dependencia ao pom.xml<br> <dependencies>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-crypto</artifactId>
            <version>5.6.3</version>
        </dependency>
        <dependency>
            <groupId>commons-logging</groupId>
            <artifactId>commons-logging</artifactId>
            <version>1.2</version>
        </dependency>
    </dependencies>