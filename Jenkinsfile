pipeline {
  agent any
  // 定义超时时间
  triggers {
      // cron('0/10 * * * * ?')
      cron('H */4 * * 1-5')
  }
  options {
      timeout(time: 1, unit: 'SECONDS') 
  }
  environment { 
        CC = 'clang'
  }
  stages {
    stage('Build') {
       environment { 
           AN_ACCESS_KEY = 'my-prefined-secret-text' 
       }
      steps {
        sh 'echo "hello, this my first jenkinfile"'
        // 环境变量的引用
        echo "environment CC = ${env.CC}"
        echo "step environment AN_ACCESS_KEY = ${env.AN_ACCESS_KEY}"
        // 全局环境变量
        echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
      }
    }
    stage('Build2') {
      steps {
        retry(count: 3) {
          echo 'retry-----------'
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
        // sh '/usr/local/git/bin/git clone https://github.com/paoyingshidai/java8.git'
        git 'https://github.com/paoyingshidai/java8.git'
        // sh '/usr/local/maven3/bin/mvn -Dmaven.test.skip clean package'
      }
      // post 在构建中的各个阶段和状态的执行钩子
      post { 
        always { 
            echo 'always-------------'
        }
        changed {
            echo 'changed------------'
        }
        failure {
            echo 'failure------------'
        }
        success {
            echo 'success------------'
        }
        unstable {
            echo 'unstable------------'
        }
        aborted {
            echo 'aborted-------------'
        }    
      }
    }
    
  }
}
