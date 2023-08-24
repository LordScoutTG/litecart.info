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