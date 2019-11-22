pipeline {
  environment {
    registry = "ajayk333/samedaydelivery"
    registryCredential = 'docker-hub'
    dockerImage = ''
     EMAIL_TO = 'akhetan@nisum.com'
  }
  agent any

  stages {
    stage('Cloning Git') {
      steps {

        git([
                url: "https://github.com/AjayKhetan297/springboot-dockerdemo-master.git",
                poll: true
            ])
     }
    }
    

    stage('Gradle Build') {
   		steps{
   			script{
        	  bat 'gradlew.bat clean build'
    		  }
    		}
    		
}
    stage('Building image') {
      steps{
        script {
          dockerImage =  docker.build registry
        }
      }
    }
    stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
          }
        }
      }  
    }
    
stage('deploy App') {
     steps{
        script {
            kubernetesDeploy(configs:"myconfig.yaml",kubeconfigId:"mycubconfig")

        }
     }
    }
  }
      

}