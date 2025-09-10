pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/sohel730/Book_Management_System_BE.git'
            }
        }

        stage('Build with Maven') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Success') {
            steps {
                echo "Build completed successfully on Windows!"
            }
        }
    }
}
