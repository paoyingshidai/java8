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
        }

      }
    }
  }
}