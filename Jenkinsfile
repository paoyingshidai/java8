pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'echo "hello, this my first jenkinfile"'
        echo 'print message'
        timeout(time: 5, activity: true)
        retry(count: 2) {
          sleep 1
        }

      }
    }
  }
}