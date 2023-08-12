pipeline {
    agent any

    tools {
        maven "3.9.4"
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
                sh "mvn verify"
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