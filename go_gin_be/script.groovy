pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', credentialsId: '', url: 'https://github.com/TuanLam123456/Devop-my-app.git'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t go_gin_be_image ./go_gin_be'
            }
        }
        // stage('Deploy Container') {
        //     steps {
        //         sh '''
        //             docker rm go_gin_be -f || true
        //             docker run --name go_gin_be -d -p 8002:8080 go_gin_be_image
        //         '''
        //     }
        // }
        stage('Deploy Container') {
            steps {
                // sử dụng plugin ssh agent
                sh '''
                    docker rm go_gin_be -f || true
                    docker run --name go_gin_be -d -p 8002:8080 go_gin_be_image
                '''
            }
        }
    }
}