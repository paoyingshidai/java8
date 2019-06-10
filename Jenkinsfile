pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'echo "hello, this my first jenkinfile"'
        echo 'print message'
        retry(count: 2) {
          echo 'retry message ......'
        }

      }
    }
    stage('Build2') {
      steps {
        retry(count: 3) {
          echo 'retry-----------'
          echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
        }
      }
      post { 
        always { 
            echo 'I will always say Hello again!'
        }
      }
    }
    
    stage('Build3') {
      steps {
        sh 'git clone https://github.com/paoyingshidai/java8.git'
        sh 'mvn -Dmaven.test.skip clean package'
      }
    }
    
  }
}
