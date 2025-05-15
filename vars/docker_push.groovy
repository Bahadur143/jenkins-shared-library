def call(String ProjectName, String ImageTag, String DockerHubUser){
withCredentials([usernamePassword(credentialsId:"dockerHubCred",
                passwordVariable:"dockerHubPass",usernameVariable:"dockerHubUser")]){
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                    sh "docker image tag online-shop:latest ${env.dockerHubUser}/online-shop:latest"
                    sh "docker push ${env.dockerHubUser}/online-shop:latest"
                }
            }
