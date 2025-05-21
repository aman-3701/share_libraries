// def call(Map config = [:]) {
//     def imageName = config.imageName ?: error("Image name is required")
//     def imageTag = config.imageTag ?: 'latest'
//     def credentials = config.credentials ?: 'docker-hub-credentials'
    
//     echo "Pushing Docker image: ${imageName}:${imageTag}"
    
//     withCredentials([usernamePassword(
//         credentialsId: credentials,
//         usernameVariable: 'DOCKER_USERNAME',
//         passwordVariable: 'DOCKER_PASSWORD'
//     )]) {
//         sh """
//             echo "\$DOCKER_PASSWORD" | docker login -u "\$DOCKER_USERNAME" --password-stdin
//             docker push ${imageName}:${imageTag}
//             docker push ${imageName}:latest
//         """
//     }
// }


def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
      sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
