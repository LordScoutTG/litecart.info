
# litecart.info autotests Selenium Java

Tiny project, that reproducec abilities of selenium Java in UI testing


## Deployment

To deploy this project run

```bash
  mvn clean test  
```

For allure results run

```bash
  mvn allure:serve
```
To deploy this project at jenkins pipeline use Jenkins file
```bash
  pipeline {
    agent any

    tools {
        jdk 'Java17'
        maven '3.9.4'
    }
    parameters{
        booleanParam(defaultValue: true, description: 'run duck tests', name: 'ducks')
    }

    stages {
        stage('duck tests') {
            when {
                expression { return params.ducks }
            }
            steps {
                bat 'mvn clean verify'
            }
        }
    }
    post {
        always {
            allure ([
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'target/allure-results']]
            ])
        }
    }
}
```

## Features


- Docker compose




## 🚀 About Me
I'm a Java/Python SDET


## 🛠 Skills
Java, Python, Kotlin, Selenium, Selenide, Docker, Jenkins, SQL, Git, Postman

