// def call(String SonarQubeAPI, String Projectname, String ProjectKey){
//   withSonarQubeEnv("${SonarQubeAPI}"){
//       sh "$SONAR_HOME/bin/sonar-scanner -Dsonar.projectName=${Projectname} -Dsonar.projectKey=${ProjectKey} -X"
//   }
// }

def call(String sonarQubeAPI, String projectName, String projectKey) {
    withSonarQubeEnv(sonarQubeAPI) {
        sh """
            sonar-scanner \
            -Dsonar.projectName=${projectName} \
            -Dsonar.projectKey=${projectKey} \
            -Dsonar.sources=. \
            -X
        """
    }
}

