pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/sohel730/Book_Management_System_BE.git'
            }
        }

        stage('Build with Maven') {
            steps {
                // clean & package Spring Boot app
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Success') {
            steps {
                echo "✅ Spring Boot project built successfully!"
            }
        }
    }
}
