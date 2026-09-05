pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', credentialsId: 'github-login', url: 'https://github.com/TuanLam123456/js-nextjs'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t lam141000/js_nextjs_image:latest .'
            }
        }

        stage('Login Docker') {
            steps {
                withCredentials([
                    usernamePassword(credentialsId: 'docker-login', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')
                ]){
                    sh '''
                        echo "${DOCKER_PASS}" | docker login -u "${DOCKER_USER}" --password-stdin
                    '''
                }
            }
        }

        stage('Push Image To Docker Hub') {
            steps {
                sh 'docker push lam141000/js_nextjs_image:latest'
            }
        }

        stage('Deploy') {
            steps {
                withCredentials([
                    sshUserPrivateKey(credentialsId: 'ssh-login', keyFileVariable: 'SSH_KEY', usernameVariable: 'SSH_USER'),
                    string(credentialsId: 'ip-server-run', variable: 'IP_SERVER_RUN')
                ]) {
                    sh '''
                        ssh -o StrictHostKeyChecking=no -i ${SSH_KEY} ${SSH_USER}@${IP_SERVER_RUN} "
                            cd /home/ubuntu/Devop-my-app/docker-compose
                            
                            docker compose pull js_nextjs
                            docker compose up -d --force-recreate js_nextjs
                            docker image prune -f
                        "
                    '''
                }
            }
        }
    }
}